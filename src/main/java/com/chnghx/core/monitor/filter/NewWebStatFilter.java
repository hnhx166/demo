/*
 * Copyright 1999-2011 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chnghx.core.monitor.filter;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.stat.DruidStatService;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.http.stat.WebRequestStat;
import com.alibaba.druid.support.http.stat.WebSessionStat;
import com.alibaba.druid.support.http.stat.WebURIStat;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.druid.support.profile.ProfileEntryKey;
import com.alibaba.druid.support.profile.ProfileEntryReqStat;
import com.alibaba.druid.support.profile.Profiler;
import com.chnghx.core.mq.bo.Monitor;
import com.chnghx.core.mq.bo.MqEntity;
import com.chnghx.core.mq.publics.MqPublicInfo;
import com.chnghx.core.shiro.token.TokenManager;
import com.chnghx.core.utils.IPUtils;
import com.chnghx.web.common.config.Config;
import com.chnghx.web.common.utils.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 用于配置Web和Druid数据源之间的管理关联监控统计
 * 
 * @author @author tongchuanwei
 */
public class NewWebStatFilter extends WebStatFilter {

	private final static Log LOG = LogFactory.getLog(NewWebStatFilter.class);
	protected static String referer;
	protected static String userIP; 

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.debug("web监控现在开始..............................");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		referer=httpRequest.getHeader("referer");
		userIP=IPUtils.getIP(httpRequest);
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		StatHttpServletResponseWrapper responseWrapper = new StatHttpServletResponseWrapper(httpResponse);

		String requestURI = getRequestURI(httpRequest);
		// 监控拦截的URL
		if (isExclusion(requestURI)) {
			chain.doFilter(request, response);
			return;
		}

		long startNano = System.nanoTime();
		long startMillis = System.currentTimeMillis();

		WebRequestStat requestStat = new WebRequestStat(startNano, startMillis);
		WebRequestStat.set(requestStat);

		WebSessionStat sessionStat = getSessionStat(httpRequest);
		webAppStat.beforeInvoke();

		WebURIStat uriStat = webAppStat.getURIStat(requestURI, false);

		if (uriStat == null) {
			int index = requestURI.indexOf(";jsessionid=");
			if (index != -1) {
				requestURI = requestURI.substring(0, index);
				uriStat = webAppStat.getURIStat(requestURI, false);
			}
		}

		if (isProfileEnable()) {
			Profiler.initLocal();
			Profiler.enter(requestURI, Profiler.PROFILE_TYPE_WEB);
		}

		// 第一次访问时，uriStat这里为null，是为了防止404攻击。
		if (uriStat != null) {
			uriStat.beforeInvoke();
		}

		// 第一次访问时，sessionId为null，如果缺省sessionCreate=false，sessionStat就为null。
		if (sessionStat != null) {
			sessionStat.beforeInvoke();
		}

		Throwable error = null;
		try {
			chain.doFilter(request, responseWrapper);
		} catch (IOException e) {
			error = e;
			throw e;
		} catch (ServletException e) {
			error = e;
			throw e;
		} catch (RuntimeException e) {
			error = e;
			throw e;
		} catch (Error e) {
			error = e;
			throw e;
		} finally {
			long endNano = System.nanoTime();
			requestStat.setEndNano(endNano);

			long nanos = endNano - startNano;
			webAppStat.afterInvoke(error, nanos);

			if (sessionStat == null) {
				sessionStat = getSessionStat(httpRequest);
				if (sessionStat != null) {
					sessionStat.beforeInvoke(); // 补偿
				}
			}

			if (sessionStat != null) {
				sessionStat.afterInvoke(error, nanos);
				sessionStat.setPrincipal(getPrincipal(httpRequest));
			}

			if (uriStat == null) {
				int status = responseWrapper.getStatus();
				if (status == HttpServletResponse.SC_NOT_FOUND) {
					String errorUrl = contextPath + "error_" + status;
					uriStat = webAppStat.getURIStat(errorUrl, true);
				} else {
					uriStat = webAppStat.getURIStat(requestURI, true);
				}

				if (uriStat != null) {
					uriStat.beforeInvoke(); // 补偿调用
				}
			}

			if (uriStat != null) {
				uriStat.afterInvoke(error, nanos);
			}

			WebRequestStat.set(null);

			if (isProfileEnable()) {
				Profiler.release(nanos);

				Map<ProfileEntryKey, ProfileEntryReqStat> requestStatsMap = Profiler.getStatsMap();
				if (uriStat != null) {
					uriStat.getProfiletat().record(requestStatsMap);
				}
				Profiler.removeLocal();
			}
		}
		// 获取与推送监控数据
		try {
			getMonitorData();
		} catch (Exception e) {
			//e.printStackTrace();
			LOG.debug("sql监控出现异常，不影响业务执行..............................");
		}
		LOG.debug("web监控现在结束..............................");
	}
	
	// 获取监控数据
	public static void getMonitorData() {
		LOG.debug("sql监控现在结束..............................");
		String basic = DruidStatService.getInstance().service("/basic.json");
		pushMonitorData("basic", basic);

		String datasource = DruidStatService.getInstance().service("/datasource.json");
		pushMonitorData("datasource", datasource);


		LOG.debug("web监控现在结束..............................");
		String webapp = DruidStatService.getInstance().service("/webapp.json");
		pushMonitorData("webapp", webapp);
		
		String sql = DruidStatService.getInstance().service("/sql.json");
		JSONObject sqlJson = StringUtils.isJSONObject(sql);
		String sqlContent = sqlJson.optString("Content");
		if (StringUtils.isNotBlank(sqlContent)) {
			JSONArray sqlArray = StringUtils.isJSONArray(sqlContent);
			for (Object object : sqlArray) {
				JSONObject json = StringUtils.isJSONObject(object);
				String idValue = json.optString("ID");
				String sqlDetail = DruidStatService.getInstance().service("/sql-" + idValue + ".json");
				pushMonitorData("sql", json.toString(),sqlDetail);
			}
		}
		
		String weburi = DruidStatService.getInstance().service("/weburi.json");
		JSONObject urlJson = StringUtils.isJSONObject(weburi);
		String urlContent = urlJson.optString("Content");
		if (StringUtils.isNotBlank(urlContent)) {
			JSONArray urlArray = StringUtils.isJSONArray(urlContent);
			for (Object object : urlArray) {
				JSONObject json = StringUtils.isJSONObject(object);
				String urlValue = json.optString("URI");
				String weburiDetail = DruidStatService.getInstance().service("/weburi-" + urlValue + ".json");
				pushURLData("weburi", json.toString(),weburiDetail);
			}
		}

		String websession = DruidStatService.getInstance().service("/websession.json");
		JSONObject sessionJson = StringUtils.isJSONObject(websession);
		String sessionContent = sessionJson.optString("Content");
		if (StringUtils.isNotBlank(sessionContent)) {
			JSONArray sessionArray = StringUtils.isJSONArray(sessionContent);
			for (Object object : sessionArray) {
				JSONObject json = StringUtils.isJSONObject(object);
				String sessionValue = json.optString("SESSIONID");
				String websessionDetail = DruidStatService.getInstance().service("/websession-" + sessionValue + ".json");
				pushMonitorData("websession",json.toString(),websessionDetail);
			}
		}

		LOG.debug("重置监控数据..............................");
		DruidStatService.getInstance().service("/reset-all.json");
	}

	// 推送监控数据到MQ
	private static void pushMonitorData(String type, String data) {

		MqEntity<Monitor> mq = new MqEntity<Monitor>();
		Monitor monitor = new Monitor();
		monitor.setTimestamp(new Date().getTime());
		monitor.setMetrics(type);
		monitor.setResult(data);

		Map<String, Object> tags = new HashMap<String, Object>();
		String ip = null;// 获得本机IP;
		try {
			if (StringUtils.isNotBlank(InetAddress.getLocalHost())) {
				ip = InetAddress.getLocalHost().getHostAddress().toString();
			}
		} catch (UnknownHostException e) {
			LOG.error("推送监控数据获取IP异常，不影响业务执行..............................");
		}
		String domain = Config.getProperty("domain").replaceAll("http://", ""); // 获取本机域名
		tags.put("ip", ip);
		tags.put("domain", domain);
		monitor.setTags(tags);

		mq.setObject(monitor);
		mq.setType(type);

		MqPublicInfo.producerMsg(mq, "monitor");
	}
	
	// 推送监控数据到MQ
	private static void pushMonitorData(String type, String data,String detail) {

		MqEntity<Monitor> mq = new MqEntity<Monitor>();
		Monitor monitor = new Monitor();
		monitor.setTimestamp(new Date().getTime());
		monitor.setMetrics(type);
		monitor.setResult(data);
		monitor.setDetail(detail);

		Map<String, Object> tags = new HashMap<String, Object>();
		String ip = null;// 获得本机IP;
		try {
			if (StringUtils.isNotBlank(InetAddress.getLocalHost())) {
				ip = InetAddress.getLocalHost().getHostAddress().toString();
			}
		} catch (UnknownHostException e) {
			LOG.error("推送监控数据获取IP异常，不影响业务执行..............................");
		}
		String domain = Config.getProperty("domain").replaceAll("http://", ""); // 获取本机域名
		tags.put("ip", ip);
		tags.put("domain", domain);
		
		if (TokenManager.isLogin()) {
			String userName = StringUtils.checkNullToConvert(TokenManager.getUserName());
			tags.put("username", userName);
			String userId = StringUtils.checkNullToConvert(TokenManager.getUserId());
			tags.put("userid", userId);
		} else {
			tags.put("username", "未登录");
			tags.put("userid", 0);
		}
		monitor.setTags(tags);

		mq.setObject(monitor);
		mq.setType(type);

		MqPublicInfo.producerMsg(mq, "monitor");
	}
	
	// 推送监控数据到MQ
	private static void pushURLData(String type, String data,String detail) {

		MqEntity<Monitor> mq = new MqEntity<Monitor>();
		Monitor monitor = new Monitor();
		monitor.setTimestamp(new Date().getTime());
		monitor.setMetrics(type);
		monitor.setResult(data);
		monitor.setDetail(detail);

		Map<String, Object> tags = new HashMap<String, Object>();
		String ip = null;// 获得本机IP;
		try {
			if (StringUtils.isNotBlank(InetAddress.getLocalHost())) {
				ip = InetAddress.getLocalHost().getHostAddress().toString();
			}
		} catch (UnknownHostException e) {
			LOG.error("推送监控数据获取IP异常，不影响业务执行..............................");
		}
		String domain = Config.getProperty("domain").replaceAll("http://", ""); // 获取本机域名
		tags.put("ip", ip);
		tags.put("domain", domain);
		tags.put("referer", referer);
		tags.put("userIP", userIP);
		if (TokenManager.isLogin()) {
			String userName = StringUtils.checkNullToConvert(TokenManager.getUserName());
			tags.put("username", userName);
			String userId = StringUtils.checkNullToConvert(TokenManager.getUserId());
			tags.put("userid", userId);
		} else {
			tags.put("username", "未登录");
			tags.put("userid", 0);
		}
		monitor.setTags(tags);

		mq.setObject(monitor);
		mq.setType(type);

		MqPublicInfo.producerMsg(mq, "monitor");
	}
}

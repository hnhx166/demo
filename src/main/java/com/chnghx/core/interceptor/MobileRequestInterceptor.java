package com.chnghx.core.interceptor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.utils.APIServiceLogUitls;
import com.chnghx.web.common.utils.DomainUtil;
import com.chnghx.web.common.utils.StringUtils;

/**
 * 移动端应用拦截器
 * @author ghx
 *
 */
public class MobileRequestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		APIServiceLog apiLog = new APIServiceLog();
		Map<String, Object> clientHead = new HashMap<String, Object>();
		String systemType = "移动端应用";
		clientHead.put("systemType", systemType);
		//请求应用端
		apiLog.setClientApplication(systemType);

		//请求开始时间
		apiLog.setClientStartTime(System.currentTimeMillis());
		//客户端请求头参数
		apiLog.setClientHead(clientHead);
		//请求的URL
		apiLog.setClientUrl(request.getRequestURL().toString());
		//客户端请求host
		String clientHost = DomainUtil.getRemoteHost(request);
		apiLog.setClientHost(clientHost);
		//客户端请求参数MAP
		Map<String, Object> clientParam = request.getParameterMap();
		if(StringUtils.isNotBlank(clientParam)){
			Map<String, Object> param = new HashMap<String, Object>();
			Set<String> keySet = clientParam.keySet();
			Iterator<String> iterator = keySet.iterator();
			while(iterator.hasNext()){
				String key = iterator.next();
				param.put(key, request.getParameter(key));
			}
			apiLog.setClientParam(param);
		}
		//接口中心处理请求方式(sync：同步处理, cache:同步加缓存处理,async：异步处理 )
		apiLog.setProcessMode("sync");
		//本机IP
		 String ip = request.getLocalAddr();
		 apiLog.setApiHost(ip);
		request.setAttribute("api_log", apiLog);
		return super.preHandle(request, response, handler);
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//请求处理完成写入结束数据
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		log.setClientEndTime(System.currentTimeMillis());
		APIServiceLogUitls.info(log);
		super.afterCompletion(request, response, handler, ex);
	}
}
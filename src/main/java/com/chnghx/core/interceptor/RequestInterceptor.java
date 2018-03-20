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
import com.chnghx.web.common.statics.SystemType;
import com.chnghx.web.common.utils.APIServiceLogUitls;
import com.chnghx.web.common.utils.DomainUtil;
import com.chnghx.web.common.utils.StringUtils;

public class RequestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		APIServiceLog apiLog = new APIServiceLog();
		Map<String, Object> clientHead = new HashMap<String, Object>();
		//系统类型，不传，或者不存在都拒绝访问
		String systemType = request.getHeader("systemType");
		if(StringUtils.isBlank(systemType)){//没有传系统类型
			response.sendRedirect("/common/refused.html");
			return false;
		}
		if(!SystemType.SYSTEM_MAP.containsKey(systemType)){//系统没有就拒绝访问
			response.sendRedirect("/common/refused.html");
			return false;
		}
		clientHead.put("systemType", systemType);
		//请求应用端
		apiLog.setClientApplication(systemType);

		//请求开始时间
		String clientStartTime = request.getHeader("rd");
		if(StringUtils.isNotBlank(clientStartTime)){
			apiLog.setClientStartTime(Long.valueOf(clientStartTime));
		}
		clientHead.put("rd", clientStartTime);
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
		
		//解析并设置请求ProccessModule
		//接口中心处理请求方式(sync：同步处理, cache:同步加缓存处理,async：异步处理 )
		String sync = request.getParameter("sync");
		if (StringUtils.isNotBlank(sync) && SystemType.CACHE_MAP.containsKey(sync)) {
			apiLog.setProcessMode(sync);
		}else{//默认走缓存，缓存时间由接口本身决定
			apiLog.setProcessMode(SystemType.API_PROCESS_CACHE);
		}
		
		//设置回调客户端地址
		String notifyUrl = request.getParameter("notifyUrl");
		if(StringUtils.isNotBlank(notifyUrl)){
			apiLog.setNotifyUrl(notifyUrl);
		}
		
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
		if(!"async".equals(log.getProcessMode())){
			log.setClientEndTime(System.currentTimeMillis());
			APIServiceLogUitls.info(log);
		}
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
		
	}

}
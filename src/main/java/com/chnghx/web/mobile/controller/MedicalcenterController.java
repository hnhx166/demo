package com.chnghx.web.mobile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.config.mobile.MobileConfig;
import com.chnghx.web.mobile.MobileCommonManager;

@Controller
@Scope("prototype")
@RequestMapping("medicalcenter")
public class MedicalcenterController extends BaseController{

	@RequestMapping(value = "app/getAppHelperHistory" , method = RequestMethod.POST)
	public void getAppHelperHistory(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.medicalcenter.vitapollo.getAppHelperHistory");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立app已经反馈列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "app/getAppFeekDetail" , method = RequestMethod.POST)
	public void getAppFeekDetail(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.medicalcenter.vitapollo.getAppFeekDetail");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立app已经反馈的详细信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "FeedBack/getFeedBack" , method = RequestMethod.POST)
	public void getFeedBack(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.medicalcenter.vitapollo.getFeedBack");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立app从历史分析进入评价页面";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "app/getAppHelperDetail" , method = RequestMethod.POST)
	public void getAppHelperDetail(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.medicalcenter.vitapollo.getAppHelperDetail");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立app历史分析详情";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "FeedBack/nocount" , method = RequestMethod.POST)
	public void nocount(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.medicalcenter.vitapollo.nocount");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立app获取未反馈的个数";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "FeedBack/setFeedBack" , method = RequestMethod.POST)
	public void setFeedBack(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.medicalcenter.vitapollo.setFeedBack");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立app反馈提交";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
}

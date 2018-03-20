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
@RequestMapping("vinuxcare")
public class VinuxCareController extends BaseController  {

	@RequestMapping(value = "customerInfo/getCustomerDetails" , method = RequestMethod.POST)
	public void getCustomerDetails(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getCustomerDetails");
		log.setServerUrl(serverUrl);
		
		String clientModule = "确认登录用户有无基金服务";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "council/currCouncilMembers" , method = RequestMethod.POST)
	public void currCouncilMembers(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.currCouncilMembers");
		log.setServerUrl(serverUrl);
		
		String clientModule = "查询当届理事会成员";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "council/applyMember" , method = RequestMethod.POST)
	public void applyMember(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.applyMember");
		log.setServerUrl(serverUrl);
		
		String clientModule = "申请成为社区理事会(只能申请为下一届理事会成员)";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "customerRate/getRate" , method = RequestMethod.POST)
	public void getRate(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getRate");
		log.setServerUrl(serverUrl);
		
		String clientModule = "加载用户现有樱桃特权指数";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "council/nextCouncilMembers" , method = RequestMethod.POST)
	public void nextCouncilMembers(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.nextCouncilMembers");
		log.setServerUrl(serverUrl);
		
		String clientModule = "查询下届理事会备选成员    ";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "council/executeVote" , method = RequestMethod.POST)
	public void executeVote(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.executeVote");
		log.setServerUrl(serverUrl);
		
		String clientModule = "为下一届理事会成员投票 ";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "groupInfo/getGroupTotalInfo" , method = RequestMethod.POST)
	public void getGroupTotalInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getGroupTotalInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "基金池总数据";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "groupInfo/getOutList" , method = RequestMethod.POST)
	public void getOutList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getOutList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "审核报销成员列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "outInfo/customerVote" , method = RequestMethod.POST)
	public void customerVote(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.customerVote");
		log.setServerUrl(serverUrl);
		
		String clientModule = "投票接口";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "applyReimbursement/getWaitListInfo" , method = RequestMethod.POST)
	public void getWaitListInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getWaitListInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "当前社区报销排队状态";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "outInfo/getOutDetails" , method = RequestMethod.POST)
	public void getOutDetails(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getOutDetails");
		log.setServerUrl(serverUrl);
		
		String clientModule = "详情接口";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "groupInfo/getCustomerList" , method = RequestMethod.POST)
	public void getCustomerList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getCustomerList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "社区成员报销比例排行";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "customerInfo/getCustomerOrderList" , method = RequestMethod.POST)
	public void getCustomerOrderList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getCustomerOrderList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "个人基金缴纳明细";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "customerInfo/getCustomerDynamict" , method = RequestMethod.POST)
	public void getCustomerDynamict(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getCustomerDynamict");
		log.setServerUrl(serverUrl);
		
		String clientModule = "樱桃特权指数动态";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "customerInfo/getCustomerCurrentCycle" , method = RequestMethod.POST)
	public void getCustomerCurrentCycle(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getCustomerCurrentCycle");
		log.setServerUrl(serverUrl);
		
		String clientModule = "周期数据";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "customerInfo/getCustomerCycleInfo" , method = RequestMethod.POST)
	public void getCustomerCycleInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getCustomerCycleInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "上周期";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "customerInfo/getCustomerRate" , method = RequestMethod.POST)
	public void getCustomerRate(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getCustomerRate");
		log.setServerUrl(serverUrl);
		
		String clientModule = "报销比例计算公式";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "groupInfo/getGroupMonthlyStatisticsInfo" , method = RequestMethod.POST)
	public void getGroupMonthlyStatisticsInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.getGroupMonthlyStatisticsInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "基金 groupInfo/getGroupMonthlyStatisticsInfo";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value={"council/position"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public void position(HttpServletRequest request, HttpServletResponse response)
	  {
	    APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
	    
	    String serverUrl = MobileConfig.getProperty("mobile.open.vinuxcare.position");
	    log.setServerUrl(serverUrl);
	    
	    String clientModule = "社区理事会当前职务";
	    Object res = MobileCommonManager.exec(request, clientModule);
	    displayJSON(res, response);
	  }
	
}

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
@RequestMapping("vip")
public class VipController extends BaseController{

	@RequestMapping(value = "open/app/orderQuery" , method = RequestMethod.POST)
	public void orderQuery(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.orderQuery");
		log.setServerUrl(serverUrl);
		
		String clientModule = "个人中心查询订单";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/app/cancelOrderNoPay" , method = RequestMethod.POST)
	public void cancelOrderNoPay(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.cancelOrderNoPay");
		log.setServerUrl(serverUrl);
		
		String clientModule = "个人中心取消订单支付";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/app/toPay" , method = RequestMethod.POST)
	public void toPay(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.toPay");
		log.setServerUrl(serverUrl);
		
		String clientModule = "个人中心支付订单";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/app/confirmOrder" , method = RequestMethod.POST)
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.confirmOrder");
		log.setServerUrl(serverUrl);
		
		String clientModule = "个人中心确认收货";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/app/cashCoupon" , method = RequestMethod.POST)
	public void cashCoupon(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.cashCoupon");
		log.setServerUrl(serverUrl);
		
		String clientModule = "个人中心用户代金券列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "commentController/getQueryCommentList", method = RequestMethod.POST)
	public void getQueryCommentList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.getQueryCommentList");
		log.setServerUrl(serverUrl);

		String clientModule = "评论列表接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "receive/getReceiveAddressList", method = RequestMethod.POST)
	public void getReceiveAddressList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.getReceiveAddressList");
		log.setServerUrl(serverUrl);

		String clientModule = "用户最近下单地址";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "receive/address", method = RequestMethod.POST)
	public void address(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.address");
		log.setServerUrl(serverUrl);

		String clientModule = "保存用户新增地址";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "receive/getBaseData", method = RequestMethod.POST)
	public void getBaseData(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.getBaseData");
		log.setServerUrl(serverUrl);

		String clientModule = "查询用户地址";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value={"commentController/getCountScore"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public void getCountScore(HttpServletRequest request, HttpServletResponse response)
	  {
	    APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
	    
	    String serverUrl = MobileConfig.getProperty("mobile.vip.vinuxpost.getCountScore");
	    log.setServerUrl(serverUrl);
	    
	    String clientModule = "获取商品评论条数";
	    Object res = MobileCommonManager.exec(request, clientModule);
	    
	    displayJSON(res, response);
	  }
	
}

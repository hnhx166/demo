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
@RequestMapping("vinuxcart")
public class VinuxCartController extends BaseController{

	@RequestMapping(value = "open/api/express/findPostofficeAPP" , method = RequestMethod.POST)
	public void findPostofficeAPP(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vinuxcart.findPostofficeAPP");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取用户社区信息的url";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayString(res, response);
	}

	@RequestMapping(value = "open/api/express/addNewAddress" , method = RequestMethod.POST)
	public void addNewAddress(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vinuxcart.addNewAddress");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保存新加用户地址url";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/express/deleteAddress" , method = RequestMethod.POST)
	public void deleteAddress(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vinuxcart.deleteAddress");
		log.setServerUrl(serverUrl);
		
		String clientModule = "删除已存在地址url";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/express/findSellerPrice" , method = RequestMethod.POST)
	public void findSellerPrice(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxcart.findSellerPrice");
		log.setServerUrl(serverUrl);
		
		String clientModule = "查询配送费";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/app/appDelCart" , method = RequestMethod.POST)
	public void appDelCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxcart.appDelCart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "删除商品";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/app/appCartToOrder" , method = RequestMethod.POST)
	public void appCartToOrder(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxcart.appCartToOrder");
		log.setServerUrl(serverUrl);
		
		String clientModule = "去支付";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/app/appFindCart" , method = RequestMethod.POST)
	public void appFindCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxcart.appFindCart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "商品列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/express" , method = RequestMethod.POST)
	public void express(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxcart.express");
		log.setServerUrl(serverUrl);
		
		String clientModule = "邮局";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/app/appOrderToPay" , method = RequestMethod.POST)
	public void appOrderToPay(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxcart.appOrderToPay");
		log.setServerUrl(serverUrl);
		
		String clientModule = "去支付";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/api/app/addCash" , method = RequestMethod.POST)
	public void addCash(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxcart.addCash");
		log.setServerUrl(serverUrl);
		
		String clientModule = "添加代金券";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/cart/updateCart" , method = RequestMethod.POST)
	public void updateCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vinuxcart.updateCart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "购物车更新数量";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayString(res, response);
	}
	
	@RequestMapping(value = "open/cart/getCartLength" , method = RequestMethod.POST)
	public void getCartLength(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
	    
	    String serverUrl = MobileConfig.getProperty("mobile.admin.vinuxcart.getCartLength");
	    log.setServerUrl(serverUrl);
	    
	    String clientModule = "购物车总商品数量接口";
	    Object res = MobileCommonManager.exec(request, clientModule);
	    displayString(res, response);
	}
	
	
	
}

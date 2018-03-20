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

/**
 * 手机充值      
 * @author ghx
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("mobilevinuxpost")
public class MobileVinuxPostController extends BaseController {

	@RequestMapping(value = "MobileOpen/denominationList" , method = RequestMethod.POST)
	public void denominationList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxpost.denominationList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "手机充值金额列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "MobileOpen/pushMobileOrderToCart" , method = RequestMethod.POST)
	public void pushMobileOrderToCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxpost.pushMobileOrderToCart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "充值加入购物车";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "MobileOpen/querymobile" , method = RequestMethod.POST)
	public void querymobile(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxpost.querymobile");
		log.setServerUrl(serverUrl);
		
		String clientModule = "查询手机号";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "MobileOpen/getbili" , method = RequestMethod.POST)
	public void getbili(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxpost.getbili");
		log.setServerUrl(serverUrl);
		
		String clientModule = "查询缴纳手机费的特权指数";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value={"MobileOpen/validateMobile"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public void validateMobile(HttpServletRequest request, HttpServletResponse response)
	  {
	    APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
	    
	    String serverUrl = MobileConfig.getProperty("mobile.mobile.vinuxpost.validateMobile");
	    log.setServerUrl(serverUrl);
	    
	    String clientModule = "手机充值 查询手机归属地";
	    Object res = MobileCommonManager.exec(request, clientModule);
	    
	    displayJSON(res, response);
	  }
}

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
@RequestMapping("vinuxbuy")
public class VinuxbuyController extends BaseController {

	@RequestMapping(value = "app/recommend", method = RequestMethod.POST)
	public void recommend(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxbuy.recommend");
		log.setServerUrl(serverUrl);

		String clientModule = "海外购首页推荐的url";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "app/country", method = RequestMethod.POST)
	public void country(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxbuy.country");
		log.setServerUrl(serverUrl);

		String clientModule = "国家馆";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "app/list", method = RequestMethod.POST)
	public void list(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxbuy.list");
		log.setServerUrl(serverUrl);

		String clientModule = "搜索";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "app/category", method = RequestMethod.POST)
	public void category(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxbuy.category");
		log.setServerUrl(serverUrl);

		String clientModule = "商品分类";
		Object res = MobileCommonManager.exec(request, clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "app/buy", method = RequestMethod.POST)
	public void buy(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxbuy.buy");
		log.setServerUrl(serverUrl);

		String clientModule = "加入购物车";
		Object res = MobileCommonManager.exec(request, clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "ios/detail", method = RequestMethod.POST)
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxbuy.detail");
		log.setServerUrl(serverUrl);

		String clientModule = "详情页面";
		Object res = MobileCommonManager.exec(request, clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value={"app/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public void app_detail(HttpServletRequest request, HttpServletResponse response)
	  {
	    APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
	    
	    String serverUrl = MobileConfig.getProperty("mobile.vinuxbuy.app.detail");
	    log.setServerUrl(serverUrl);
	    
	    String clientModule = "android获取商品详情";
	    Object res = MobileCommonManager.exec(request, clientModule);
	    displayJSON(res, response);
	  }
}

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
@RequestMapping("mobilemall")
public class MobilemallController extends BaseController {

	@RequestMapping(value = "open/request/dologin", method = RequestMethod.POST)
	public void dologin(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.dologin");
		log.setServerUrl(serverUrl);

		String clientModule = "移动商城登录接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/queryCarouselInfoByMediaId", method = RequestMethod.POST)
	public void queryCarouselInfoByMediaId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.queryCarouselInfoByMediaId");
		log.setServerUrl(serverUrl);

		String clientModule = "商城首页轮播图接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/queryFloorInfo", method = RequestMethod.POST)
	public void queryFloorInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.queryFloorInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "商城首页楼层接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/detail", method = RequestMethod.POST)
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.detail");
		log.setServerUrl(serverUrl);

		String clientModule = "商品详情接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/pushCart", method = RequestMethod.POST)
	public void pushCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.pushCart");
		log.setServerUrl(serverUrl);

		String clientModule = "加入购物车接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/queryProList", method = RequestMethod.POST)
	public void queryProList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.queryProList");
		log.setServerUrl(serverUrl);

		String clientModule = "搜索商品接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/getProDesInfo", method = RequestMethod.POST)
	public void getProDesInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.getProDesInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "商品图文详情接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/checkLimitSaleNums", method = RequestMethod.POST)
	public void checkLimitSaleNums(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.checkLimitSaleNums");
		log.setServerUrl(serverUrl);

		String clientModule = "查询限时购商品是否购买过接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/getCatalogInfo", method = RequestMethod.POST)
	public void getCatalogInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.getCatalogInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "获取商品列表接口";
		Object res = MobileCommonManager.exec(request, clientModule);
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/getStockInfo", method = RequestMethod.POST)
	public void getStockInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.getStockInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "获取商品仓库id接口";
		Object res = MobileCommonManager.exec(request, clientModule);
		displayJSON(res, response);
	}
	@RequestMapping(value = "app/version", method = RequestMethod.POST)
	public void version(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.aap.android.version");
		log.setServerUrl(serverUrl);

		String clientModule = "获取APP版本号";
		Object res = MobileCommonManager.exec(request, clientModule);
		displayJSON(res, response);
	}
	
	
	@RequestMapping(value = "app/android/download", method = RequestMethod.POST)
	public void download(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mobilemall.aap.android.download");
		log.setServerUrl(serverUrl);

		String clientModule = "下载当前版本APP";
		Object res = MobileCommonManager.exec(request, clientModule);
		displayJSON(res, response);
	}
}

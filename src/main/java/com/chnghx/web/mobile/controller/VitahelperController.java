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
@RequestMapping("vitahelper")
public class VitahelperController extends BaseController{

	@RequestMapping(value = "api/plan/genPlan" , method = RequestMethod.POST)
	public void genPlan(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.genPlan");
		log.setServerUrl(serverUrl);
		
		String clientModule = "维他答题";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/goioscart" , method = RequestMethod.POST)
	public void goioscart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.goioscart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "购买药品";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/disease/diseaseList" , method = RequestMethod.POST)
	public void diseaseList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.diseaseList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "正在获取疾病信息列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/confirmFoodCart" , method = RequestMethod.POST)
	public void confirmFoodCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.confirmFoodCart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "确认餐盒";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/getFoodCart" , method = RequestMethod.POST)
	public void getFoodCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.getFoodCart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取餐盒数据";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/iherbCart" , method = RequestMethod.POST)
	public void iherbCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.iherbCart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "订购保健品";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/CartMed" , method = RequestMethod.POST)
	public void CartMed(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.CartMed");
		log.setServerUrl(serverUrl);
		
		String clientModule = "订购药品";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/question/question-end/getQuestion" , method = RequestMethod.POST)
	public void getQuestion(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.getQuestion");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立维他获取某种疾病的所有问题";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/plan/genPlanVita" , method = RequestMethod.POST)
	public void genPlanVita(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.genPlanVita");
		log.setServerUrl(serverUrl);
		
		String clientModule = "独立Vita根据回答过的问题获取诊断结果和方案信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/dagocart" , method = RequestMethod.POST)
	public void dagocart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.dagocart");
		log.setServerUrl(serverUrl);
		
		String clientModule = "非处方药生成订单接口";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/iherbCartDuli" , method = RequestMethod.POST)
	public void iherbCartDuli(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.iherbCartDuli");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保健品方案加入购物车";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/app/ios" , method = RequestMethod.POST)
	public void ios(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.ios");
		log.setServerUrl(serverUrl);
		
		String clientModule = "程序更新";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/cart/duGoCartMed" , method = RequestMethod.POST)
	public void duGoCartMed(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.duGoCartMed");
		log.setServerUrl(serverUrl);
		
		String clientModule = "免煎颗粒生成订单";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "api/plan/getPharmacy" , method = RequestMethod.POST)
	public void getPharmacy(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.admin.vitahelper.getPharmacy");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取授权信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	
}

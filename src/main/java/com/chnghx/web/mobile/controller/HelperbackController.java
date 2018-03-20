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
@RequestMapping("helperback")
public class HelperbackController extends BaseController{

	@RequestMapping(value = "open/helperSpecialtyCategory" , method = RequestMethod.POST)
	public void helperSpecialtyCategory(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperSpecialtyCategory");
		log.setServerUrl(serverUrl);
		
		String clientModule = "技能端帮手擅长类目";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperOutproductList" , method = RequestMethod.POST)
	public void helperOutproductList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperOutproductList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手未引入的服务商品列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/addHelperProduct" , method = RequestMethod.POST)
	public void addHelperProduct(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.addHelperProduct");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手引入新技能服务详情（帮手引入商品页面）";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/saveHelperProduct" , method = RequestMethod.POST)
	public void saveHelperProduct(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.saveHelperProduct");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保存引入新的技能服务";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperProductList" , method = RequestMethod.POST)
	public void helperProductList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperProductList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手已经引入的服务商品列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperProductEdit" , method = RequestMethod.POST)
	public void helperProductEdit(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperProductEdit");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手编辑技能服务商品";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperProductEditSave" , method = RequestMethod.POST)
	public void helperProductEditSave(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperProductEditSave");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手技能服务商品的编辑保存";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperProductStatus" , method = RequestMethod.POST)
	public void helperProductStatus(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperProductStatus");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手服务商品的上下架、删除操作";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperDisabledProductList" , method = RequestMethod.POST)
	public void helperDisabledProductList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperDisabledProductList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "回收站商品列表";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperProductActivation" , method = RequestMethod.POST)
	public void helperProductActivation(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperProductActivation");
		log.setServerUrl(serverUrl);
		
		String clientModule = "回收站商品的启用";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/checkIsHelper" , method = RequestMethod.POST)
	public void checkIsHelper(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.checkIsHelper");
		log.setServerUrl(serverUrl);
		
		String clientModule = "检查是是否是帮手登录";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/applyHelper" , method = RequestMethod.POST)
	public void applyHelper(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.applyHelper");
		log.setServerUrl(serverUrl);
		
		String clientModule = "申请帮手(特别提示:申请帮手需要该账号的特权指数大于等于5%)";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getCategoryList" , method = RequestMethod.POST)
	public void getCategoryList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getCategoryList");
		log.setServerUrl(serverUrl);
		
		String clientModule = "注册帮手选择擅长类目";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/saveApplyInfo" , method = RequestMethod.POST)
	public void saveApplyInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.saveApplyInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保存注册信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getReserveTime" , method = RequestMethod.POST)
	public void getReserveTime(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getReserveTime");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取预约时间";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/updateReserveTime" , method = RequestMethod.POST)
	public void updateReserveTime(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.updateReserveTime");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保存修改的预约时间";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getWorkTime" , method = RequestMethod.POST)
	public void getWorkTime(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getWorkTime");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取每日工作时间";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/updateWorkTime" , method = RequestMethod.POST)
	public void updateWorkTime(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.updateWorkTime");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保存修改的每日工作时间";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getHelperPersonInfo" , method = RequestMethod.POST)
	public void getHelperPersonInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getHelperPersonInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取帮手个人信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/editHelperInfo" , method = RequestMethod.POST)
	public void editHelperInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.editHelperInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保存修改的帮手个人信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/updateWorkStatus" , method = RequestMethod.POST)
	public void updateWorkStatus(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.updateWorkStatus");
		log.setServerUrl(serverUrl);
		
		String clientModule = "修改营业状态";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getHelperCategory" , method = RequestMethod.POST)
	public void getHelperCategory(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getHelperCategory");
		log.setServerUrl(serverUrl);
		
		String clientModule = "编辑帮手擅长类目时获取帮手擅长的类目";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/updateHelperCategory" , method = RequestMethod.POST)
	public void updateHelperCategory(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.updateHelperCategory");
		log.setServerUrl(serverUrl);
		
		String clientModule = "保存帮手编辑的擅长类目";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getApplyInfo" , method = RequestMethod.POST)
	public void getApplyInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getApplyInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取未通过帮手注册时填写的信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/updateApplyInfo" , method = RequestMethod.POST)
	public void updateApplyInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.updateApplyInfo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手修改注册信息后再次提交注册帮手";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/mainInterface" , method = RequestMethod.POST)
	public void mainInterface(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.mainInterface");
		log.setServerUrl(serverUrl);
		
		String clientModule = "从子模块返回app主界面，获取帮手头像，工作状态，当日营业额，待处理订单，待收款订单，预处理订单统计数";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getOrderByStatus" , method = RequestMethod.POST)
	public void getOrderByStatus(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getOrderByStatus");
		log.setServerUrl(serverUrl);
		
		String clientModule = "手机app点击待处理查看新订单统计数，退款申请订单统计数和分页预览新订单详情";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/acceptOrder" , method = RequestMethod.POST)
	public void acceptOrder(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.acceptOrder");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手同意接单";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/refuseOrder" , method = RequestMethod.POST)
	public void refuseOrder(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.refuseOrder");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手取消订单";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/agreeRefund" , method = RequestMethod.POST)
	public void agreeRefund(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.agreeRefund");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手确定退款";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/finishService" , method = RequestMethod.POST)
	public void finishService(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.finishService");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手完成服务";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/refuseService" , method = RequestMethod.POST)
	public void refuseService(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.refuseService");
		log.setServerUrl(serverUrl);
		
		String clientModule = "帮手拒绝服务";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/financialReconciliation" , method = RequestMethod.POST)
	public void financialReconciliation(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.financialReconciliation");
		log.setServerUrl(serverUrl);
		
		String clientModule = "财务对账";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/reconciliationItem" , method = RequestMethod.POST)
	public void reconciliationItem(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.reconciliationItem");
		log.setServerUrl(serverUrl);
		
		String clientModule = "财务对账点击展开查询详情";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/helperAddress" , method = RequestMethod.POST)
	public void helperAddress(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.helperAddress");
		log.setServerUrl(serverUrl);
		
		String clientModule = "省市区获取接口";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/getOrderItem" , method = RequestMethod.POST)
	public void getOrderItem(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.helperback.vinuxpost.getOrderItem");
		log.setServerUrl(serverUrl);
		
		String clientModule = "点击展开，获取订单详情信息";
		Object res = MobileCommonManager.exec(request , clientModule);
		
		displayJSON(res, response);
	}
}

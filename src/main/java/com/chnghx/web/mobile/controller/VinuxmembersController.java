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
@RequestMapping("vinuxmembers")
public class VinuxmembersController  extends BaseController {

	@RequestMapping(value = "open/request/user/signup/phone/validateCode", method = RequestMethod.POST)
	public void validateCode(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.validateCode");
		log.setServerUrl(serverUrl);

		String clientModule = "发送手机验证码";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "mobile/open/user/signup/phone", method = RequestMethod.POST)
	public void signupPhone(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.signup.phone");
		log.setServerUrl(serverUrl);

		String clientModule = "注册验证手机号";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/user/info", method = RequestMethod.POST)
	public void userInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.info");
		log.setServerUrl(serverUrl);

		String clientModule = "查询注册用户信息";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/user/resetpassword/sendValidateCode", method = RequestMethod.POST)
	public void sendValidateCode(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.sendValidateCode");
		log.setServerUrl(serverUrl);

		String clientModule = "更改密码时发送验证码";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/user/resetpassword/changePassword", method = RequestMethod.POST)
	public void changePassword(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.changePassword");
		log.setServerUrl(serverUrl);

		String clientModule = "更改密码";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/user/certificateIdCard", method = RequestMethod.POST)
	public void certificateIdCard(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.certificateIdCard");
		log.setServerUrl(serverUrl);

		String clientModule = "实名认证";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/user/certificate/check/phone", method = RequestMethod.POST)
	public void checkPhone(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.check.phone");
		log.setServerUrl(serverUrl);

		String clientModule = "验证用户手机是否通过验证";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/user/consumer/dologin", method = RequestMethod.POST)
	public void dologin(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.dologin");
		log.setServerUrl(serverUrl);

		String clientModule = "调用登录接口登录";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/certificate/sendCodeByLoginNameAndPhone", method = RequestMethod.POST)
	public void sendCodeByLoginNameAndPhone(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.sendCodeByLoginNameAndPhone");
		log.setServerUrl(serverUrl);

		String clientModule = "注册时获取验证码";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "open/request/user/signup", method = RequestMethod.POST)
	public void userSignup(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.user.signup");
		log.setServerUrl(serverUrl);

		String clientModule = "提交注册";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
//	
	@RequestMapping(value = "open/request/penny/findUserCoordinate", method = RequestMethod.POST)
	public void findUserCoordinate(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.vinuxmembers.findUserCoordinate");
		log.setServerUrl(serverUrl);

		String clientModule = "获取当前位置的周边店铺";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
}

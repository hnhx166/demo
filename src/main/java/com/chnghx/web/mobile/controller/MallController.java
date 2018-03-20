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
@RequestMapping("mall")
public class MallController  extends BaseController {

	@RequestMapping(value = "directory/getPostLogo" , method = RequestMethod.POST)
	public void listNews(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.mall.getPostLogo");
		log.setServerUrl(serverUrl);
		
		String clientModule = "获取POST首页LOGO";
		Object res = MobileCommonManager.exec(request , clientModule);
		displayJSON(res, response);
	}
}

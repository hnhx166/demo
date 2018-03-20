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
@RequestMapping("community")
public class CommunityController extends BaseController  {

		@RequestMapping(value = "open/listNews" , method = RequestMethod.POST)
		public void listNews(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.listNews");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取社区发布的全部公告";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		
		@RequestMapping(value = "open/listTitlesByThemeId" , method = RequestMethod.POST)
		public void listTitlesByThemeId(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.listTitlesByThemeId");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取某公告下的全部标题";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		
		@RequestMapping(value = "open/getNewsTitleContent" , method = RequestMethod.POST)
		public void getNewsTitleContent(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.getNewsTitleContent");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取公告标题详细内容";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		@RequestMapping(value = "open/themelist" , method = RequestMethod.POST)
		public void themelist(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.themelist");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取活动社区主题列表";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		
		@RequestMapping(value = "open/themeDsc" , method = RequestMethod.POST)
		public void themeDsc(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.themeDsc");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取社区或送主题详情";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		@RequestMapping(value = "open/themegroup" , method = RequestMethod.POST)
		public void themegroup(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.themegroup");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取主题下的全部分组";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		@RequestMapping(value = "open/workerslist" , method = RequestMethod.POST)
		public void workerslist(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.workerslist");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取主题下的作品列表";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		
		@RequestMapping(value = "open/uservote" , method = RequestMethod.POST)
		public void uservote(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.uservote");
			log.setServerUrl(serverUrl);
			
			String clientModule = "投票";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
		
		@RequestMapping(value = "open/getWorksInfo" , method = RequestMethod.POST)
		public void getWorksInfo(HttpServletRequest request, HttpServletResponse response) {
			APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
			//调用服务端的URL
			String serverUrl = MobileConfig.getProperty("mobile.community.getWorksInfo");
			log.setServerUrl(serverUrl);
			
			String clientModule = "获取作品详情";
			Object res = MobileCommonManager.exec(request , clientModule);
			displayJSON(res, response);
		}
}

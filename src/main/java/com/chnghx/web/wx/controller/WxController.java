package com.chnghx.web.wx.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.chnghx.web.common.config.WeChatConfig;
import com.chnghx.web.wx.util.HttpClientUtils;
import com.chnghx.web.wx.util.WeChatUtil;

@Controller
@Scope("prototype")
@RequestMapping("wx")
@RestController
public class WxController {
	
	@RequestMapping(value="photo", produces="application/json;charset=UTF-8")
	public ModelAndView photo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		ModelAndView view = new ModelAndView("wx/photo");
		return view;
	}
	
	@RequestMapping(value="pt", produces="application/json;charset=UTF-8")
	public ModelAndView pt(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		ModelAndView view = new ModelAndView("wx/pt");
		return view;
	}
	
	@RequestMapping(value="p1", produces="application/json;charset=UTF-8")
	public ModelAndView p1(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		ModelAndView view = new ModelAndView("wx/p1");
		return view;
	}
	

	
	/**
	 * 1.1 开放数据接口–根据productPk或者produckId查询房源详情接口
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value="index", produces="application/json;charset=UTF-8")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		ModelAndView view = new ModelAndView("wx/index");
		
		String url = WeChatConfig.getProperty("access_token");
		url = String.format(url, WeChatConfig.getProperty("AppId"), WeChatConfig.getProperty("AppSecret"));
		String result = HttpClientUtils.sendGet(url, null);
		JSONObject data = JSONObject.parseObject(result);
		System.out.println("data=" + data);
		
		String jsapi_ticket_url = String.format(WeChatConfig.getProperty("jsapi_ticket"), data.getString("access_token"));
		String jsapi_ticket_Str = HttpClientUtils.sendGet(jsapi_ticket_url, null);
		JSONObject jsapi_ticket_data = JSONObject.parseObject(jsapi_ticket_Str);
		
		System.out.println("jsapi_ticket_data=" + jsapi_ticket_data);
		
		String noncestr = UUID.randomUUID().toString().replaceAll("-", "");
		String jsapi_ticket = jsapi_ticket_data.getString("ticket");
		
		long timestamp = System.currentTimeMillis();
		//当前url地址不包括#后面的
		String curl = "http://wx.chnghx.com/wx/index.vhtml";
		
		
		String params = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + curl;
		
		MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
		messageDigest.reset();
		messageDigest.update(params.getBytes("UTF-8"));
		String signature = byteToHex(messageDigest.digest());
		view.addObject("signature", signature);
		
		view.addObject("noncestr", noncestr);
		view.addObject("jsapi_ticket", jsapi_ticket);
		view.addObject("appId", WeChatConfig.getProperty("AppId"));
		view.addObject("timestamp", timestamp);
		
		System.out.println("params=" + params);
		System.out.println("jsapi_ticket=" + jsapi_ticket);
		System.out.println("noncestr=" + noncestr);
		System.out.println("timestamp=" + timestamp);
		System.out.println("url=" + url);
		System.out.println("signature=" + signature);
		
		return view;
	}
	
	private static String byteToHex(final byte[] hash) {  
        Formatter formatter = new Formatter();  
        for (byte b : hash)  
        {  
            formatter.format("%02x", b);  
        }  
        String result = formatter.toString();  
        formatter.close();  
        return result;  
    } 
	
}

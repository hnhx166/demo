package com.chnghx.web.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.VCache;

@Controller
@Scope("prototype")
@RequestMapping("qqlogin")
@RestController
public class AuthController extends BaseController{
	
	
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("index");
		VCache.put("a", "abcccc", 360000);
		Object obj = VCache.get("a");
		view.addObject("t", obj);
		return view;
	}
	
	@RequestMapping(value="/pgback")
	public ModelAndView index1(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("index");
		return view;
	}
	
	
	
	
	
}

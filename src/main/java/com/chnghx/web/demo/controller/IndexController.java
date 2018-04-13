package com.chnghx.web.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chnghx.web.common.BaseController;

@Controller
@Scope("prototype")
@RequestMapping("")
@RestController
public class IndexController extends BaseController{
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		return index1(request, response);
	}
	
	@RequestMapping(value="index")
	public ModelAndView index1(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("demo/index/index");
//		String view_template = "demo/index/index";
		String view_template = "demo/index/index";
		
//		view.setViewName(view_template);
		return view;
	}
	
	
	
	
	
}

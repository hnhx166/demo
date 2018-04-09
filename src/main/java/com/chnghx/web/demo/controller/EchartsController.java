package com.chnghx.web.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("charts")
public class EchartsController {

	@RequestMapping("line-x")
	public ModelAndView line_x(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("demo/charts/line-x");
		
		return view;
	}
	
	@RequestMapping("line-mutil-x")
	public ModelAndView line_mutil_x(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("demo/charts/line-mutil-x");
		
		return view;
	}
	
	@RequestMapping("line-y")
	public ModelAndView line_y(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("demo/charts/line-y");
		
		return view;
	}
	
	@RequestMapping("tree-x")
	public ModelAndView tree_x(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("demo/charts/tree-x");
		
		return view;
	}
	
	@RequestMapping("tree-y")
	public ModelAndView tree_y(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("demo/charts/tree-y");
		
		return view;
	}
	
	@RequestMapping("tree-mutil")
	public ModelAndView tree_mutil(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView view = new ModelAndView("demo/charts/tree-mutil");
		
		return view;
	}
	
	
}

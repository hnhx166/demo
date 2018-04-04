package com.chnghx.web.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chnghx.web.common.BaseController;

@Controller
@Scope("prototype")
@RequestMapping("video")
public class VideoController extends BaseController {
	
	@RequestMapping("")
	public ModelAndView video() {
		ModelAndView view = new ModelAndView("demo/video/video");
		
		return view;
	}

}

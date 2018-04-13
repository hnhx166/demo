package com.chnghx.web.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("editor")
public class EditorController {

	@RequestMapping("ckeditor")
	public ModelAndView editor() {
		ModelAndView view = new ModelAndView("demo/editor/ckeditor");
		
		return view;
	}
}

package com.chnghx.web.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("prototype")
@RequestMapping("camera")
@RestController
public class CameraController {

	@RequestMapping(value = "photo", produces = "application/json;charset=UTF-8")
	public ModelAndView photo(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ModelAndView view = new ModelAndView("demo/camera/photo");
		return view;
	}

	@RequestMapping(value = "pt", produces = "application/json;charset=UTF-8")
	public ModelAndView pt(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ModelAndView view = new ModelAndView("demo/camera/pt");
		return view;
	}

	@RequestMapping(value = "p1", produces = "application/json;charset=UTF-8")
	public ModelAndView p1(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		ModelAndView view = new ModelAndView("demo/camera/p1");
		return view;
	}


}

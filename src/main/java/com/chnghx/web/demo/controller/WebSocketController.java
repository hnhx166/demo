package com.chnghx.web.demo.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chnghx.web.common.BaseController;

@Controller
@RequestMapping("socket")
public class WebSocketController extends BaseController{

	@RequestMapping("chat")
	public ModelAndView chat(HttpServletRequest request) {
		ModelAndView view = new ModelAndView("demo/socket/chat");
		String userName = UUID.randomUUID().toString();
		view.addObject("userName", userName);
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		return view;
	}
}

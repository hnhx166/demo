package com.chnghx.web.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chnghx.core.mybatis.page.Pagination;
import com.chnghx.service.entity.SsoDomain;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.demo.service.SsoDomainService;

@Controller
@RequestMapping("domain")
public class SsoDomainController extends BaseController{
	
	@Autowired
	SsoDomainService ssoDomainService;

	@RequestMapping("index")
	@ResponseBody
	public Map<String, Object> index(){
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("secondDomain", "vinux");
		Integer pageSize = 5; 
		Integer pageNo = 1;
		Pagination<SsoDomain> list =ssoDomainService.findSsoDomainsByPage(paraMap, pageSize, pageNo);
		System.out.println("**********************" + list);
		return null;
	}
	
}

package com.chnghx.web.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.chnghx.web.common.utils.LoggerUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BaseController {
	
	public void displayJSON(Object data, HttpServletResponse response) {
		//必须放到上边
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		try {
			String jsonString = "";
			if (data instanceof List) {
				JSONArray jsonObject = JSONArray.fromObject(data);
				jsonString = jsonObject.toString();
				jsonObject = null;
			} else {
				JSONObject jsonObject = JSONObject.fromObject(data);
				jsonString = jsonObject.toString();
				jsonObject = null;
			}
			PrintWriter writer = response.getWriter();
			writer.write(jsonString);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			LoggerUtils.error(BaseController.class, "接口中心BaseController处理请求发生IOException异常！", e);
		}
	}
	
	  
	public void displayString(Object data, HttpServletResponse response) {
		//必须放到上边
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/text;charset=UTF-8");
		try {
//			String jsonString = "";
//			if (data instanceof List) {
//				JSONArray jsonObject = JSONArray.fromObject(data);
//				jsonString = jsonObject.toString();
//				jsonObject = null;
//			} else {
//				JSONObject jsonObject = JSONObject.fromObject(data);
//				jsonString = jsonObject.toString();
//				jsonObject = null;
//			}
			PrintWriter writer = response.getWriter();
			writer.write(data.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			LoggerUtils.error(BaseController.class, "接口中心BaseController处理请求发生IOException异常！", e);
		}
	}
	
}

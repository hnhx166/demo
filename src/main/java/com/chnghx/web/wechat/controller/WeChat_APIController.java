package com.chnghx.web.wechat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chnghx.web.common.APIResult;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.utils.StringUtils;
import com.chnghx.web.wechat.utils.WeChatAPIUtil;
/**
 *　提供总后台生成二维码
 * @author Administrator
 *
 */
@Controller
@RequestMapping("vk/open/api/wechatQRCode")
public class WeChat_APIController  extends BaseController{
	private Logger log = Logger.getLogger(WeChatController.class);
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public APIResult<Map<String,Object>> post(HttpServletRequest request, HttpServletResponse response) {
		log.info("POST:请求进来了...");
		APIResult<Map<String,Object>> apiResult = new APIResult<Map<String,Object>>();
		apiResult.setStatus("500");
		Object expire_seconds = request.getParameter("expire_seconds");// 时间
		Object action_name = request.getParameter("action_name");// 永久临时、字符、数字
		Object sceneValue = request.getParameter("sceneValue");// 参数
		if (StringUtils.isBlank(action_name) || StringUtils.isBlank(sceneValue)) {
			apiResult.setMessage("参数有误！");
			return apiResult;
		}
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			String ticket=WeChatAPIUtil.getTicket(
					(StringUtils.isBlank(expire_seconds) ? null : Integer.parseInt(String.valueOf(expire_seconds))),
					String.valueOf(action_name), String.valueOf(sceneValue));
			String result = WeChatAPIUtil.showQrcode(ticket);
			apiResult.setStatus("200");
			apiResult.setMessage("请求成功");
			map.put("ticket", ticket);
			map.put("QRCode", result);
			apiResult.setResult(map);
			return apiResult;
		} catch (NumberFormatException e) {
			apiResult.setMessage("生成二维码失败，请联系管理员");
			e.printStackTrace();
		}
		return apiResult;
	}
}

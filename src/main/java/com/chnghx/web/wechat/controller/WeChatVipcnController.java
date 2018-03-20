package com.chnghx.web.wechat.controller;



import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.chnghx.web.common.APIResult;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.utils.StringUtils;
import com.chnghx.web.wechat.utils.ReadFile;
import com.chnghx.web.wechat.utils.WeChatAPIUtil;
/**
 * 公众号设置
 * 如：设置导航
 * @author Administrator
 *
 */
@Controller
@RequestMapping("wechatVipcn")
public class WeChatVipcnController extends BaseController {
	
	private Logger log = Logger.getLogger(WeChatVipcnController.class);
	
	/**
	 * 添加菜单 
	 * 添加菜单功能可直接覆盖原有菜单，不用执行删除，但添加菜单后24小时生效，可取消关注再次关注方可得到最新菜单。
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="createMenu",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public APIResult<String> createMenu(HttpServletRequest request,HttpServletResponse response) {
		APIResult<String>  apiResult=new APIResult<String>();
		apiResult.setStatus("200");
		String fileStr=ReadFile.readFileByBytes(this.getClass().getResource("/").getPath()+ReadFile.WECHAT_MENU);
		JSONObject result=WeChatAPIUtil.createMenu(JSONObject.parseObject(fileStr));
		apiResult.setResult(result.toString());
		log.debug(apiResult);
		return apiResult;
	}
	/**
	 * 删除菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="deleteMenu",method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public APIResult<String> deleteMenu(HttpServletRequest request,HttpServletResponse response) {
		APIResult<String>  apiResult=new APIResult<String>();
		apiResult.setStatus("200");
		JSONObject result=WeChatAPIUtil.deleteMenu();
		apiResult.setResult(result.toString());
		log.debug(apiResult);
		return apiResult;
	}
	
	/**
	 * 上传素材
	 * http://www.vitahelper.com/wechatVipcn/uploadPermanentMaterial.vhtml?material=image&fileName=image\APP.png
	 * 
	 * material:素材类型
	 * fileName:素材所在项目位置，系统默认在h5目录下，可自行添加子目录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="uploadPermanentMaterial",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public APIResult<String> uploadPermanentMaterial(HttpServletRequest request,HttpServletResponse response) {
		APIResult<String>  apiResult=new APIResult<String>();
		apiResult.setStatus("200");
		String realPath=request.getRealPath("");
		String material=request.getParameter("material");
		String fileName=request.getParameter("fileName");
		fileName=realPath+ReadFile.WECHAT_MATERIAL+fileName;
		if(StringUtils.isBlank(material)) {
			apiResult.setStatus("500");
			apiResult.setMessage("参数错误");
			return apiResult;
		}
		try {
			JSONObject result= WeChatAPIUtil.uploadPermanentMaterial(material,fileName);
			apiResult.setResult(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug(apiResult);
		return apiResult;
	}
	
	/**
	 * 获取永久素材
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="getPermanentMaterial",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public APIResult<String> getPermanentMaterial(HttpServletRequest request,HttpServletResponse response) {
		APIResult<String>  apiResult=new APIResult<String>();
		apiResult.setStatus("200");
		String material=request.getParameter("mediaId");
		String fileDir=request.getParameter("fileDir");
		if(StringUtils.isBlank(material)) {
			apiResult.setStatus("500");
			apiResult.setMessage("参数错误");
			return apiResult;
		}
		try {
			File result= WeChatAPIUtil.getPermanentMaterial(material,fileDir);
			apiResult.setResult(result.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug(apiResult);
		return apiResult;
	}	
	
	
	
	public static void main(String[] args) throws Exception {
		String material="image";
		String fileDir="D:/APP.png";//rfObFYeZEZ9e6vMwHui892o4MX50sy38_gMkOR8TXwA
		String mediaId="rfObFYeZEZ9e6vMwHui89_ZYZslrMJXxnBG6evlS2Ss";
		String fileDirDom="D:/img/";
//		JSONObject result= WechatAPIUtil.uploadPermanentMaterial(material,fileDir);
		WeChatAPIUtil.getPermanentMaterial(mediaId,fileDirDom);
	}
}

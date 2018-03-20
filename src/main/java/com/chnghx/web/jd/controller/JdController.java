
package com.chnghx.web.jd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.chnghx.test.ClientPostMethod;
import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.VCache;
import com.chnghx.web.common.config.jd.JdConfig;
import com.chnghx.web.jd.JdSign;
import com.chnghx.web.jd.manager.JdCommonManager;


/**
* <一句话功能简述>
*
* @author  贾瑞丰
*@date  [2017年6月6日]
*/

@Scope("singleton")
@RequestMapping("api/jd")
@RestController
public class JdController  extends BaseController{
	@RequestMapping(value = "accessToken" , method = RequestMethod.POST)
	public synchronized void accessToken(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("this:"+this);
		String res=getToken();
		displayString(res, response);
		
	}
	@RequestMapping(value = "refreshToken" , method = RequestMethod.POST)
	public synchronized void refreshToken(HttpServletRequest request, HttpServletResponse response) {
		refreshToken();
		accessToken(request, response);
		return;
	}
	/**
	* <p>功能描述：内部调用获取Token</p> 
	* <p>eg: 一句话描述方法功能</p> 
	* @param map
	* @return
	*/ 
	private String getToken(){
		Object res=VCache.get("jd_token");
		System.out.println("取出缓存："+res);
		if(res==null){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("grant_type", "access_token");
			map.put("client_id", JdConfig.CLIENT_ID);
			map.put("client_secret", JdConfig.CLIENT_SECRET);
			map.put("timestamp", timestamp());
			map.put("username", JdConfig.USERNAME);
			map.put("password", JdConfig.PASSWORD);//加密一次
			map.put("scope", "");
			
			map.put("sign", JdSign.getAccessTokeSign(map));
			ClientPostMethod clientPostMethod=new ClientPostMethod(JdConfig.getUrlProperty("accessToken"), map);
			res=clientPostMethod.executeMethod();
			System.out.println(res);
			VCache.put("jd_token", getAccessTokenFromRes(res), 12*3600);
		}
		return  res.toString();
	}
	

	
	/**
	* <p>功能描述：一句话描述方法功能</p> 
	* <p>eg: 一句话描述方法功能</p> 
	* @param res
	* @return
	*/ 
	private String getAccessTokenFromRes(Object res){
		JSONObject json=JSONObject.parseObject(res.toString());
		System.out.println("响应："+json.getJSONObject("result").get("access_token"));
		String access_token=json.getJSONObject("result").get("access_token").toString();
		return access_token;
	}
	
	
	@RequestMapping(value = "getPageNum" , method = RequestMethod.POST)
	public void getPageNum(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getPageNum");
		log.setServerUrl(serverUrl);
		String clientModule = "getPageNum";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		Object res = JdCommonManager.exec(request , clientModule,map);
		
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getPageNum(request,response); 
			return;			
		}
		displayJSON(res, response);
	}

	/**
	* <p>功能描述：一句话描述方法功能</p> 
	* <p>eg: 一句话描述方法功能</p> 
	*/ 
	private synchronized void  refreshToken() {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("grant_type", "access_token");
			map.put("client_id", JdConfig.CLIENT_ID);
			map.put("client_secret", JdConfig.CLIENT_SECRET);
			map.put("timestamp", timestamp());
			map.put("username", JdConfig.USERNAME);
			map.put("password", JdConfig.PASSWORD);//加密一次
			map.put("scope", "");
			map.put("sign", JdSign.getAccessTokeSign(map));
			ClientPostMethod clientPostMethod=new ClientPostMethod(JdConfig.getUrlProperty("accessToken"), map);
			Object res=clientPostMethod.executeMethod();
			VCache.put("jd_token", getAccessTokenFromRes(res), 12*3600);
			
	}

	/**
	* <p>功能描述：一句话描述方法功能</p> 
	* <p>eg: 一句话描述方法功能</p> 
	* @return
	*/ 
	private boolean overdue(Object res) {
		JSONObject json=JSONObject.parseObject(res.toString());
		System.out.println("响应："+json.get("resultCode"));
		String resultCode=json.get("resultCode").toString();
		if(resultCode.equals("2007")){
			return true;
		}

		return false;
	}

	@RequestMapping(value = "getSkuByPage" , method = RequestMethod.POST)
	public void getSkuByPage(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getSkuByPage");
		log.setServerUrl(serverUrl);
		String clientModule = "getSkuByPage";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		request.getParameterMap();
		map.put("pageNum", request.getParameter("pageNum"));
		map.put("pageNo", request.getParameter("pageNo"));
		
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getSkuByPage(request,response); 
			return;			
		}
		
		displayJSON(res, response);
	}
	@RequestMapping(value = "getDetail" , method = RequestMethod.POST)
	public void getDetail(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getDetail");
		log.setServerUrl(serverUrl);
		String clientModule = "getDetail";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("sku", request.getParameter("sku"));
		map.put("isShow", request.getParameter("isShow"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getDetail(request,response); 
			return;			
		}
		displayJSON(res, response);
		
	}
	/**
	* <p>功能描述：获取商品上下架状态</p> 
	* <p>eg: 一句话描述方法功能</p> 
	* @param request
	* @param response
	*/ 
	@RequestMapping(value = "skuState" , method = RequestMethod.POST)
	public void skuState(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("skuState");
		log.setServerUrl(serverUrl);
		String clientModule = "skuState";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("sku", request.getParameter("sku"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			skuState(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}
	/**
	* <p>功能描述：一句话描述方法功能</p> 
	* <p>eg: 一句话描述方法功能</p> 
	* @param request
	* @param response
	*/ 
	@RequestMapping(value = "skuImage" , method = RequestMethod.POST)
	public void skuImage(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("skuImage");
		log.setServerUrl(serverUrl);
		String clientModule = "skuImage";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("sku", request.getParameter("sku"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			skuImage(request,response); 
			return;			
		}
		displayJSON(res, response);
	}
	@RequestMapping(value = "checkAreaLimit" , method = RequestMethod.POST)
	public void checkAreaLimit(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("checkAreaLimit");
		log.setServerUrl(serverUrl);
		String clientModule = "checkAreaLimit";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("skuIds", request.getParameter("skuIds"));
		map.put("province", request.getParameter("province"));
		map.put("city", request.getParameter("city"));
		map.put("county", request.getParameter("county"));
		map.put("town", request.getParameter("town"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			checkAreaLimit(request,response); 
			return;			
		}		
		displayJSON(handleCheckAreaLimit(res), response);
	}
	private Object handleCheckAreaLimit(Object res){
		String result=StringUtils.replace(res.toString(), "\\\"", "\"");
		String result2=StringUtils.replace(result, "\"[", "[");
		String result3=StringUtils.replace(result2, "]\"", "]");
		System.out.println(result3);
		return result3;
	}
	private Object handleStock(Object res){
		String result=StringUtils.replace(res.toString(), "\\\"", "\"");
		String result2=StringUtils.replace(result, "\"[", "[");
		String result3=StringUtils.replace(result2, "]\"", "]");
		System.out.println(result3);
		return result3;
	}
	@RequestMapping(value = "search" , method = RequestMethod.POST)
	public void search(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("search");
		log.setServerUrl(serverUrl);
		String clientModule = "search";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("keyword", request.getParameter("keyword"));
		
		map.put("catId", request.getParameter("catId"));
		map.put("pageIndex", request.getParameter("pageIndex"));
		map.put("pageSize", request.getParameter("pageSize"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			search(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "searchByKeyword" , method = RequestMethod.POST)
	public void searchByKeyword(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("search");
		log.setServerUrl(serverUrl);
		String clientModule = "search";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("keyword", request.getParameter("keyword"));
		map.put("pageIndex", request.getParameter("pageIndex"));
		map.put("pageSize", request.getParameter("pageSize"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			searchByKeyword(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}
	/**
	* <p>功能描述：3.13 商品可售验证接口</p> 
	* <p>eg: 一句话描述方法功能</p> 
	* @param request
	* @param response
	*/ 
	@RequestMapping(value = "check" , method = RequestMethod.POST)
	public void check(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("check");
		log.setServerUrl(serverUrl);
		String clientModule = "getSkuByPage";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("skuIds", request.getParameter("sku"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			check(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}
	@RequestMapping(value = "getProvince" , method = RequestMethod.POST)
	public void getProvince(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getProvince");
		log.setServerUrl(serverUrl);
		String clientModule = "getProvince";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getProvince(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}

	
	
	
	@RequestMapping(value = "getCity" , method = RequestMethod.POST)
	public void getCity(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getCity");
		log.setServerUrl(serverUrl);
		String clientModule = "getCity";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("id", request.getParameter("id"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getCity(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}

	
	
	
	@RequestMapping(value = "getCounty" , method = RequestMethod.POST)
	public void getCounty(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getCounty");
		log.setServerUrl(serverUrl);
		String clientModule = "getCounty";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("id", request.getParameter("id"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getCounty(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}

	
	
	
	@RequestMapping(value = "getTown" , method = RequestMethod.POST)
	public void getTown(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getTown");
		log.setServerUrl(serverUrl);
		String clientModule = "getTown";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("id", request.getParameter("id"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getTown(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}

	
	
	
	@RequestMapping(value = "getJdPrice" , method = RequestMethod.POST)
	public void getJdPrice(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getJdPrice");
		log.setServerUrl(serverUrl);
		String clientModule = "getJdPrice";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("sku", request.getParameter("sku"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getJdPrice(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}
	
	@RequestMapping(value = "getPrice" , method = RequestMethod.POST)
	public void getPrice(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getPrice");
		log.setServerUrl(serverUrl);
		String clientModule = "getPrice";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("sku", request.getParameter("sku"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getPrice(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}
	@RequestMapping(value = "getStockById" , method = RequestMethod.POST)
	public void getStockById(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getStockById");
		log.setServerUrl(serverUrl);
		String clientModule = "getStockById";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("sku", request.getParameter("sku"));
		map.put("area", request.getParameter("area"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getStockById(request,response); 
			return;			
		}		
		displayJSON(handleStock(res), response);
	}	

	
	@RequestMapping(value = "getNewStockById" , method = RequestMethod.POST)
	public void getNewStockById(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getNewStockById");
		log.setServerUrl(serverUrl);
		String clientModule = "getNewStockById";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("skuNums", request.getParameter("skuNums"));
		map.put("area", request.getParameter("area"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getNewStockById(request,response); 
			return;			
		}		
		displayJSON(handleStock(res), response);
	}
	
	@RequestMapping(value = "getCategorys" , method = RequestMethod.POST)
	public void getCategorys(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		throw new Exception("xxxxx");
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getCategorys");
		log.setServerUrl(serverUrl);
		String clientModule = "getCategorys";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("pageNo", request.getParameter("pageNo"));
		map.put("pageSize", request.getParameter("pageSize"));
		map.put("parentId", request.getParameter("parentId").equals("0")?"":request.getParameter("parentId"));
		map.put("catClass", request.getParameter("catClass"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getCategorys(request,response); 
			return;			
		}		
		displayJSON(res, response);
	}		
	private String timestamp(){
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return time.format(new Date());
	}

	
	@RequestMapping(value = "getFreight" , method = RequestMethod.POST)
	public void getFreight(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog)request.getAttribute("api_log");
		//调用服务端的URL
		String serverUrl = JdConfig.getUrlProperty("getFreight");
		log.setServerUrl(serverUrl);
		String clientModule = "getFreight";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", getToken());
		map.put("sku", request.getParameter("skuNums"));
		map.put("province", request.getParameter("province"));
		map.put("city", request.getParameter("city"));
		map.put("county", request.getParameter("county"));
		map.put("town", request.getParameter("town"));
		map.put("paymentType", request.getParameter("paymentType"));
		Object res = JdCommonManager.exec(request , clientModule,map);
		System.out.println("响应："+res);
		if(overdue(res)){//如果token 过期则重新获取token
			refreshToken();
			getFreight(request,response); 
			return;			
		}		
		displayJSON(handleStock(res), response);
	}



}

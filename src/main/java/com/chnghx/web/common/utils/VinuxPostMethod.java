package com.chnghx.web.common.utils;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.config.Config;
import com.chnghx.web.common.statics.Constant;



/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * <p>
 * 
 * Vinux PostMethod
 * 
 * <p>
 * 
 * @author ghx
 * 
 * 
 * 
 */
public class VinuxPostMethod extends PostMethod {

	//自定义请求头信息
	private Map<String,String> head = new LinkedHashMap<String, String>();
	private Map<String, Object> paramsMap = new HashMap<String, Object>();
	private int timeOut = 60000 ;//默认超时时间

	/***
	 * 
	 * 同步执行方法
	 * 
	 * 执行方法 type 可以不传，默认返回String
	 * @return
	 * @throws Exception 
	 */
	public String syncExecuteMethod(HttpServletRequest request) throws Exception {
		APIServiceLog apiLog = (APIServiceLog)request.getAttribute("api_log");
		String result = null;
		try {
			//host
			apiLog.setApiHost("api.vinux.com");
			
			//服务端请求URL
//			apiLog.setServerUrl(getPath());
			apiLog.setServerHead(null);
			apiLog.setServerStartTime(System.currentTimeMillis());
			HttpClient client = new HttpClient();
			HttpClientParams params = client.getParams();
			//serv参数
			apiLog.setServerParam(paramsMap);
			//开始时间
			apiLog.setServerStartTime(System.currentTimeMillis());
			params.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			/**设置请求来源
			 * 如果没有配置domain  那么就直接把domain换成你自己的域名即可
			 * */
			params.setParameter("Connection","close");
			/**
			 * 请求超时时间
			 * 如果需要调整，请setTimeOut(自定义时间(单位毫秒))
			 */
			client.getHttpConnectionManager().getParams().setConnectionTimeout(getTimeOut());
			//加入额外的请求头信息
			for (String key : head.keySet()) {
				if(StringUtils.isNotBlank(key,head.get(key))){
					params.setParameter(key,head.get(key));
				}
			}
			this.setHead(head);
			int status = 0;
			status = client.executeMethod(this);
			//结束时间
			if (status == HttpStatus.SC_OK) {
				result = this.getResponseBodyAsString();
				apiLog.setServerCode(Constant.SERVER_SUCCESS_API);
			}else{
				apiLog.setServerCode(Constant.SERVER_ERROR_API);
				RuntimeException  ex=new RuntimeException("请求服务端错误, syncExecuteMethod(HttpServletRequest request)！HTTP_CODE : " + status);
				LoggerUtils.error(VinuxPostMethod.class, "请求服务端错误, syncExecuteMethod(HttpServletRequest request)！HTTP_CODE : " + status, ex);
				throw ex;
				
			}
		}catch (Exception e) {
			apiLog.setServerException(APIServiceLogUitls.buildExceptionStack(e));
			apiLog.setServerCode(Constant.SERVER_ERROR_API);
			LoggerUtils.error(VinuxPostMethod.class, "接口中心syncExecuteMethod(HttpServletRequest request)处理请求发送异常！", e);
			throw e;
		}finally{
			apiLog.setServerEndTime(System.currentTimeMillis());
			//server 结果
			apiLog.setServerResult(result);
			this.releaseConnection();
		}
		return result;
	}
	
	
	/***
	 * 
	 * 异步执行方法
	 * 
	 * @param type
	 *            [JSONObject,JSONArray]
	 * @return
	 * @throws Exception 
	 */
	public String asyncExecuteMethod(APIServiceLog apiLog) throws Exception {
		String result = null;
		try {
			//host
			apiLog.setApiHost("api.vinux.com");
			//接口中心处理请求方式(sync：同步处理, cache:同步加缓存处理,async：异步处理 )
//			apiLog.setProcessMode("sync");
			//服务端请求URL
			apiLog.setServerHead(null);
			HttpClient client = new HttpClient();
			HttpClientParams params = client.getParams();
			//serv参数
//			apiLog.setServerParam(paramsMap);
			//开始时间
			apiLog.setServerStartTime(System.currentTimeMillis());
			params.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			/**设置请求来源
			 * 如果没有配置domain  那么就直接把domain换成你自己的域名即可
			 * */
			params.setParameter("Connection","close");
			/**
			 * 请求超时时间
			 * 如果需要调整，请setTimeOut(自定义时间(单位毫秒))
			 */
			client.getHttpConnectionManager().getParams().setConnectionTimeout(getTimeOut());
			//加入额外的请求头信息
			for (String key : head.keySet()) {
				if(StringUtils.isNotBlank(key,head.get(key))){
					params.setParameter(key,head.get(key));
				}
			}
			this.setHead(head);
			int status = 0;
			status = client.executeMethod(this);
			//结束时间
			if (status == HttpStatus.SC_OK) {
				result = this.getResponseBodyAsString();
				apiLog.setServerCode(Constant.SERVER_SUCCESS_API);
			}else{
				apiLog.setServerCode(Constant.SERVER_ERROR_API);
				RuntimeException  ex=new RuntimeException("请求服务端错误,asyncExecuteMethod(APIServiceLog apiLog)！HTTP_CODE : " + status);
				LoggerUtils.error(VinuxPostMethod.class, "请求服务端错误,asyncExecuteMethod(APIServiceLog apiLog)！HTTP_CODE : " + status, ex);
				throw ex;
			}
		}catch (Exception e) {
			apiLog.setServerException(APIServiceLogUitls.buildExceptionStack(e));
			apiLog.setServerCode(Constant.SERVER_ERROR_API);
			LoggerUtils.error(VinuxPostMethod.class, "接口中心asyncExecuteMethod(APIServiceLog apiLog)处理请求发送异常！", e);
			throw e;
		}finally{
			apiLog.setServerEndTime(System.currentTimeMillis());
			//server 结果
			apiLog.setServerResult(result);
			this.releaseConnection();
		}
		return result;
	}
	
	/**
	 * 回调客户端使用此方法
	 * @param apiLog
	 * @return
	 */
	public String notifyExecuteMethod(APIServiceLog apiLog) {
		String result = null;
		try {
			//host
//			apiLog.setApiHost("api.vinux.com");
			
			//服务端请求URL
//			apiLog.setServerUrl(getPath());
//			apiLog.setServerHead(null);
			apiLog.setNotifyStartTime(System.currentTimeMillis());
			HttpClient client = new HttpClient();
			HttpClientParams params = client.getParams();
			
			//回调客户端参数，该参数由MQ处理完数据后提供
			apiLog.setNotifyParam(paramsMap);
			params.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			/**设置请求来源
			 * 如果没有配置domain  那么就直接把domain换成你自己的域名即可
			 * */
			params.setParameter("Connection","close");
			/**
			 * 请求超时时间
			 * 如果需要调整，请setTimeOut(自定义时间(单位毫秒))
			 */
			client.getHttpConnectionManager().getParams().setConnectionTimeout(getTimeOut());
			//加入额外的请求头信息
			for (String key : head.keySet()) {
				if(StringUtils.isNotBlank(key,head.get(key))){
					params.setParameter(key,head.get(key));
				}
			}
			this.setHead(head);
			int status = 0;
			status = client.executeMethod(this);
			//结束时间
			if (status == HttpStatus.SC_OK) {
				result = this.getResponseBodyAsString();
				apiLog.setNotifyCode(Constant.CLIENT_SUCCESS_API);
			}else{
				apiLog.setNotifyCode(Constant.CLIENT_ERROR_API);
				RuntimeException  ex=new RuntimeException("回调客户端状态错误, notifyExecuteMethod(APIServiceLog apiLog)！HTTP_CODE:" + status);
				LoggerUtils.error(VinuxPostMethod.class, "回调客户端状态错误, notifyExecuteMethod(APIServiceLog apiLog)！HTTP_CODE:" + status, ex);
				throw ex;
				
			}
		}catch (Exception e) {
			apiLog.setServerException(APIServiceLogUitls.buildExceptionStack(e));
			apiLog.setNotifyCode(Constant.CLIENT_ERROR_API);
			LoggerUtils.error(VinuxPostMethod.class, "接口中心executeMethod(APIServiceLog apiLog)回调客户端请求发送异常！", e);
//			throw e;
		}finally{
			apiLog.setNotifyEndTime(System.currentTimeMillis());
			//server 结果
			apiLog.setNotifyResult(result);
			this.releaseConnection();
		}
		return result;
	}

	/**
	 * 设置参数List<Map<String, Object>>
	 * 
	 * @param parameter
	 */
	public void setParameter(List<Map<String, Object>> parameter) {
		for (Map<String, Object> map : parameter) {
			
			setParameter(map);
		}
	}

//	/**
//	 * 设置参数JSONObject
//	 * 
//	 * @param parameter
//	 */
//	public void setJSONParameter(JSONObject parameter) {
//		for (Iterator<?> iter = parameter.keys(); iter.hasNext();) {
//			String key = (String) iter.next();
//			Object str = parameter.get(key);
//			String value = null == str ? "" : StringUtils.trimToEmpty(str
//					.toString());
//			this.addParameter(key,value);
//		}
//	}
//
//	/**
//	 * 设置参数JSONArray
//	 * 
//	 * @param parameter
//	 */
//	public void setJSONArrayParameter(JSONArray parameter) {
//		for (Object object : parameter) {
//			JSONObject jsonObject = (JSONObject) object;
//			this.setJSONParameter(jsonObject);
//		}
//	}

	/**
	 * 设置通用参数Map<String, Object>
	 * 
	 * @param parameter
	 */
	public void setParameter(Map<String, Object> parameter) {
		if(null != parameter){
			for (String key : parameter.keySet()) {
				Object str = parameter.get(key);
	//			String value = null == str ? "" : StringUtils.trimToEmpty(str.toString());
				String value = null == str ? "" : str.toString().trim();
				paramsMap.put(key, value);
				this.addParameter(key, value);
			}
		}
	}
	
	/**
	 * 设置member参数
	 * @param parameter
	 * @throws Exception 
	 */
//	public void setMemberParameter(Map<String, Object> parameter) throws Exception {
//		if(null != parameter){
//			//系统类型
//			parameter.put("sys_type", Config.getProperty("api_system_type"));
//			String paramStr = "";
//			for (String key : parameter.keySet()) {
//				if(!"sync".equals(key) && !"cache_time".equals(key)){
//					Object str = parameter.get(key);
//					String value = null == str ? "" : str.toString().trim();
//					paramsMap.put(key, value);
//					paramStr+= key + "=" + value + "&";
//					this.addParameter(key, value);
//				}
//			}
//			
//			//参数排序
//			String [] params = paramStr.split("&");
//			Arrays.sort(params);
//			
//			//排序后组合
//			String signStr = "";
//			for (int i = 0; i < params.length; i++) {
//				signStr += params[i] + "&";
//			}
//			//获取key
//			signStr += Config.getProperty("member_sign");
//			//生成md5签名
//			String sign = MD5.md5Digest(signStr);
//			//签名作为参数
//			this.addParameter("sign", sign);
//		}
//	}

	/**
	 * 构造方法begin
	 */
	// public VinuxPostMethod() {
	// super();
	// }
	public VinuxPostMethod(String url) {
		super(url);
	}

	public VinuxPostMethod(List<Map<String, Object>> parameter) {
		super();
		this.setParameter(parameter);
	}

	public VinuxPostMethod(String url, List<Map<String, Object>> parameter) {
		super(url);
		this.setParameter(parameter);
	}

//	public VinuxPostMethod(JSONObject parameter) {
//		super();
//		this.setJSONParameter(parameter);
//	}

	public VinuxPostMethod(Map<String, Object> parameter) {
		super();
		paramsMap = parameter;
		this.setParameter(parameter);
	}

	public VinuxPostMethod(String url, Map<String, Object> parameter) {
		super(url);
		paramsMap = parameter;
		this.setParameter(parameter);
	}

//	public VinuxPostMethod(String url, JSONObject parameter) {
//		super(url);
//		this.setJSONParameter(parameter);
//	}
//
//	public VinuxPostMethod(JSONArray parameter) {
//		super();
//		this.setJSONArrayParameter(parameter);
//	}
//
//	public VinuxPostMethod(String url, JSONArray parameter) {
//		super(url);
//		this.setJSONArrayParameter(parameter);
//	}
	
	
	/**
	 * 构造方法end
	 */
	

	public Map<String, String> getHead() {
		return head;
	}

	public void setHead(Map<String, String> head) {
		this.head = head;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	
	
//	public JsonConfig getConfig() {
//		JsonConfig config = new JsonConfig();
//		// 实现属性过滤器接口并重写apply()方法
//		PropertyFilter pf = new PropertyFilter() {
//			@Override
//			// 返回true则跳过此属性，返回false则正常转换
//			public boolean apply(Object source, String name, Object value) {
//				if (StringUtils.isBlank(value)) {
//					return true;
//				}
//				return false;
//			}
//		};
//		// 将过滤器放入json-config中
//		config.setJsonPropertyFilter(pf);
//
//		return config;
//	}

}

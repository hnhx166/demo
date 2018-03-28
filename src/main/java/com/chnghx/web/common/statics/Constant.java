package com.chnghx.web.common.statics;

import java.util.HashMap;
import java.util.Map;


public interface Constant {
	
	static Map<String, String> SYSTEM_ = new HashMap<String, String>();
	final long CACHE_1min = 60l; 
	final long CACHE_2min = 120l;
	final long CACHE_3min = 180l;
	final long CACHE_5min = 300l;
	final long CACHE_10min = 600l;
	final long CACHE_15min = 900l;
	final long CACHE_30min = 1800l;
	final long CACHE_1h = 3600l;
	final long CACHE_2h = 3600 * 2l;
	final long CACHE_3h = 3600 * 3l;
	final long CACHE_4h = 3600 * 4l;
	final long CACHE_8h = 3600 * 8l;
	final long CACHE_12h = 3600 * 12l;
	final long CACHE_1d = 3600 * 24l;
	final long CACHE_2d = 3600 * 24 * 2l;
	final long CACHE_3d = 3600 * 24 * 3l;
	final long CACHE_1week = 3600 * 24 * 7l;
	final long CACHE_2week = 3600 * 24 * 7 * 2l;
	final long CACHE_1month = 3600 * 24 * 30l;
	
	//客户端请求接口中心状态码
	String API_ACCEPT_CLIENT="A100";//接口中心接受成功
	String API_NOACCEPT_CLIENT="A101";//接口中心接受失败
	String API_SUCCESS_CLIENT="A200";//接口中心处理成功
	String API_PROCESS_CLIENT="A300";//接口中心正在处理中
	String API_NOFIND_CLIENT="A400";//接口中心找不到数据
	String API_ERROR_CLIENT="A500";//接口中心处理失败
	
	//接口中心请求服务端状态码
	String SERVER_ACCEPT_API="S100";//服务端接受成功
	String SERVER_NOACCEPT_API="S101";//服务端接受失败
	String SERVER_SUCCESS_API="S200";//服务端处理成功
	String SERVER_PROCESS_API="S300";//服务端正在处理中
	String SERVER_NOFIND_API="S400";//服务端找不到数据
	String SERVER_ERROR_API="S500";//服务端处理失败
	
	//接口中心通知客户端状态码
	String CLIENT_ACCEPT_API="C100";//客户端接受成功
	String CLIENT_NOACCEPT_API="C101";//客户端接受失败
	String CLIENT_SUCCESS_API="C200";//客户端处理成功
	String CLIENT_PROCESS_API="C300";//客户端正在处理中
	String CLIENT_NOFIND_API="C400";//客户端找不到数据
	String CLIENT_ERROR_API="C500";//客户端处理失败
	
	//接口返回值类型
	final String RESULT_TYPE_JSONOBJECT = "JSONOBJECT";//jsonObject
	final String RESULT_TYPE_JSONARRAY = "JSONARRAY";//jsonarray
	final String RESULT_TYPE_APIRESULT = "APIRESULT";//apirresult
	final String RESULT_TYPE_STRING = "STRING";//字符串
	
	
		
}

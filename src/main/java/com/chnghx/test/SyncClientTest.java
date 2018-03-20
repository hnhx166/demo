package com.chnghx.test;

import java.util.HashMap;
import java.util.Map;


public class SyncClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://api.vinux.com/api/member/asynctest";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sessionId", "vs_b2fc3f78738a49de8e63aa803301d6e0");//sessionId
		params.put("describe", "测试接口根据sessionId获取用户信息");//描述信息
		params.put("host", "api.vinux.com");//host
		params.put("sys_type", "vinux_platform");//系统
		params.put("sync", "async");//异步执行
		params.put("notifyUrl", "http://api.vinux.com/common/refused.html");//回调地址
		ClientPostMethod client = new ClientPostMethod(url, params);//执行HttpClient
		
		Object  result = client.executeMethod();
		
		System.out.println(result);
	}

}

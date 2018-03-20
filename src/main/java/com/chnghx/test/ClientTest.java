package com.chnghx.test;

import java.util.HashMap;
import java.util.Map;


public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String url = "http://api.vinux.com/api/member/getUserInfoBySessionId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sessionId", "vs_19998e8469fc452d9f6c53b9567a1ec4");//sessionId
		params.put("desc", "根据sessionId获取用户信息get demo userinfo");//描述信息
		params.put("host", "api.vinux.com");//host
		params.put("sys_type", "vinux_platform");//系统
		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}

}

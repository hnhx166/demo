package com.chnghx.test.creat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chnghx.test.ClientPostMethod;

public class TestCreat {
	@Test
	public void refundMethod() {
		String url = "http://api.vinux.com/api/creat/876/refundMethod";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("serviceOrderId", "13211111111");
		params.put("cartOrderId", "13211111111");
		params.put("key", "87.6");
		params.put("sync", "sync"); 
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
}

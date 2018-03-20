/*
 * 文 件 名:  TestJd.java
 * 版    权:  xxxx Technologies Co., Ltd. Copyright 2010-9999,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  Administrator
 * 修改时间:  2017年6月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.chnghx.test.jd;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * <一句话功能简述>
 *
 * @author 贾瑞丰
 * @date [2017年6月6日]
 */
public class TestJd {

	@Test
	public void accessToken() {
		String url = "http://api.vinux.com/api/jd/accessToken";
		Map<String, Object> params = new HashMap<String, Object>();
		// String usserId=Security.encrypt("536");
		// System.out.println("AAAAA:"+usserId);
		// params.put("userId",usserId);
		// params.put("sync", "sync");
		JdClientPostMethod client = new JdClientPostMethod(url, params);
		Object result = client.executeMethod();
		System.out.println(result);

	}
	
	@Test
	public void getPageNum() {
		String url = "http://api.vinux.com/api/jd/getPageNum";
		Map<String, Object> params = new HashMap<String, Object>();
		JdClientPostMethod client = new JdClientPostMethod(url, params);
		Object result = client.executeMethod();
		System.out.println(result);

	}
}

package com.chnghx.test.agedcare;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chnghx.test.ClientPostMethod;
import com.vinux.utils.security.Security;

public class TestAgedcare {

	@Test
	public void isNotAged(){
		String url="http://api.vinux.com/api/agedcare/isNotAged";
		Map<String,Object> params=new HashMap<String,Object>();
		String usserId=Security.encrypt("536");
		System.out.println("AAAAA:"+usserId);
		params.put("userId",usserId);
		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
		
	}
	
	@Test
	public void getSubsidyInfo(){
		String url="http://api.vinux.com/api/agedcare/getSubsidyInfo";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("pageNo", 1);
		params.put("pageSize", 10);
		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
		//{"message":"开放数据接口–养老官网补贴墙成功！","result":{"status":200,"message":"查询信息成功","result":{"totalCount":2380,"list":[{"name":"程代宁","head_photo":"1405308920469.jpg","order_money":440,"apply_pension_index":15.48,"apply_money":68.11,"expenseType":"家政","apply_time":"2017/01/17 15:52"},{"name":"任雍","head_photo":"1405308386520.jpg","order_money":288,"apply_pension_index":50.76,"apply_money":146.19,"expenseType":"调理","apply_time":"2017/01/17 10:11"},{"name":"年伟民","head_photo":"1405308371801.jpg","order_money":10,"apply_pension_index":5,"apply_money":0.5,"expenseType":"订餐","apply_time":"2017/01/16 15:21"},{"name":"王惠青","head_photo":"1405309072533.jpg","order_money":16,"apply_pension_index":5,"apply_money":0.8,"expenseType":"订餐","apply_time":"2017/01/16 15:21"},{"name":"宽卓太","head_photo":"1405309072533.jpg","order_money":10,"apply_pension_index":5,"apply_money":0.5,"expenseType":"订餐","apply_time":"2017/01/16 15:20"},{"name":"宽卓太","head_photo":"1405309072533.jpg","order_money":10,"apply_pension_index":5,"apply_money":0.5,"expenseType":"订餐","apply_time":"2017/01/16 15:20"},{"name":"祝君","head_photo":"1405308371801.jpg","order_money":10,"apply_pension_index":5,"apply_money":0.5,"expenseType":"订餐","apply_time":"2017/01/16 15:19"},{"name":"郭爱琴","head_photo":"1405309038391.jpg","order_money":10,"apply_pension_index":5,"apply_money":0.5,"expenseType":"订餐","apply_time":"2017/01/16 15:18"},{"name":"栾振国","head_photo":"1405308371801.jpg","order_money":10,"apply_pension_index":5,"apply_money":0.5,"expenseType":"订餐","apply_time":"2017/01/16 15:18"},{"name":"陈观荣","head_photo":"1405308851627.jpg","order_money":10,"apply_pension_index":5,"apply_money":0.5,"expenseType":"订餐","apply_time":"2017/01/16 15:17"}]}},"status":"A200"}
	}
	@Test
	public void fupinbaoxiaoCallBack(){
		String url="http://api.vinux.com/api/agedcare/fupinbaoxiaoCallBack";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("requestSn", "1");
		params.put("type","1");
		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
}

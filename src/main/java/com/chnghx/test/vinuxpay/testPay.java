package com.chnghx.test.vinuxpay;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.junit.Test;

public class testPay {
	
	public static void main(String[] args) {
		String a = "qwertyuiopasdfghjklzxcvbnm123456";
		System.out.println(a.length());
	}
	
	public void testG(){

	}
	
	
	@Test
	public void testWechatPay(){
		String url = "https://pay.vinuxpay.com/vinuxpay/wechatpay/unifiedorder";
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
		postMethod.addParameter("journalCode", "171101721291830");
		postMethod.addParameter("body", "Vita订单");
//		postMethod.addParameter("spbill_create_ip", "192.168.0.125");
//		postMethod.addParameter("apptype", "VITAPOLLO");
		postMethod.addParameter("apptype", "VITAHELPER");//VINUXPOST, VITAPOLLO
		try {
			int result = client.executeMethod(postMethod);
			if (result == HttpStatus.SC_OK) {
				System.out.println("响应成功！" + postMethod);
				System.out.println(postMethod.getResponseBodyAsString());
			} else {
				System.out.println("响应错误！");
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * 确认下钱是否分了（查账户变动表  有账户变动记录就是分了），分了的话看看deal_finance 分账表  的分账状态status 是10未分账还是11已分账，11的话就没问题  不会重复分，10就会重复分
	 * 
	 * 樱桃派分账成功，回调购物车接口
	 * 
	 * 分账成功 购物车的状态还为未分账
	 * 
	 * 订单状态为配送，樱桃派分账状态为分账完成
	 * 
	 * 分账完成后未通知购物车，重新通知下
	 * 
	 * 解决 樱桃派订单状态为9，分账状态为11    但购物车订单状态为6未分账的情况
	 * 分账成功 购物车的状态还为未分账
	 */
	@Test
	public void testSignCart() {
		HttpClient client = new HttpClient();
		String[] orderCode = {"201709100858504373"};//订单号"201709221038299736","201710221828125066"
		
		String url = "http://pay.vinuxpay.com/vinuxpay/transaction/getDealFinance";
		for (int i = 0; i < orderCode.length; i++) {
			PostMethod postMethod = new PostMethod(url);
			postMethod.addParameter("orderCode", orderCode[i]);
			client.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
			try {
				int result = client.executeMethod(postMethod);
				 String body = new String(postMethod.getResponseBody());
				System.out.println("==============成功=========="+orderCode[i]);
				 System.out.println(body);
				if (result == HttpStatus.SC_OK) {
					System.out.println("成功通知VINUX。。。");

				}
			} catch (HttpException e1) {
				System.out.println("通知VINUX失败****");
				e1.printStackTrace();
			} catch (IOException e1) {
				System.out.println("通知VINUX失败****");
				e1.printStackTrace();
			}finally{
				postMethod.releaseConnection();
			}
		}
	}
	
	/***
	 * 1、有完整的分账xml文件(xml 根据订单号 从线上五个点的日志中查找)
	 * 2、DEAL_FINANCE无分账记录 或者 分账记录不全（不全也不需要处理，再次执行的时候不会再次记录）
	 * http://pay.vinuxpay.com/vinuxpay/guarantee/warrant/storehouse/newSplitcredit?splitCreditXml=分账xml
	 */
	

}

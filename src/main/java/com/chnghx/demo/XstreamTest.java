package com.chnghx.demo;

import com.chnghx.demo.bo.UnifiedorderBO;
import com.chnghx.demo.util.XmlUtil;

public class XstreamTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String appid = "appid";
		String attach = "支付测试";
		String body = "JSAPI支付测试";
		String mch_id ="10000100";
		String detail = "<![CDATA[{ \"goods_detail\":[ { \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, { \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }]]>";
		String nonce_str = "1add1a30ac87aa2db72f57a2375d8";
		String notify_url = "http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php";
		String openid = "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o";
		String out_trade_no = "1415659990";

		UnifiedorderBO bo = new UnifiedorderBO();
		bo.setAppid(appid);
		bo.setAttach(attach);
		bo.setBody(body);
		bo.setMch_id(mch_id);
		bo.setDetail(detail);
		bo.setNonce_str(nonce_str);
		bo.setNotify_url(notify_url);
		bo.setOpenid(openid);
		bo.setOut_trade_no(out_trade_no);
		
		String xmlString = XmlUtil.pojo2Xml(bo);
		System.out.println(xmlString);
		
		xmlString = XmlUtil.fomatXmlStr(xmlString);
		System.out.println(xmlString);
		UnifiedorderBO bbo = XmlUtil.xml2Bean(xmlString, UnifiedorderBO.class);
		System.out.println(bbo);
		
		
	}

}

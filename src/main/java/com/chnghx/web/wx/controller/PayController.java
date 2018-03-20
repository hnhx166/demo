package com.chnghx.web.wx.controller;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chnghx.demo.util.XmlUtil;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.wx.util.HttpUtil;
import com.chnghx.web.wx.util.MD5;
import com.chnghx.web.wx.util.PayConfig;

@Controller
@Scope("prototype")
@RequestMapping("wx_pay")
@RestController
public class PayController extends BaseController{
	
	@RequestMapping(value="index")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("wx_pay/index");
		return view;
	}
	
	@RequestMapping(value="choose_pay")
	public ModelAndView pay(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("wx_pay/choose_pay");
		return view;
	}
	
	@RequestMapping(value="test", produces="application/json;charset=UTF-8")
	public void test(HttpServletRequest request, HttpServletResponse response){
		String spbill_create_ip = request.getRemoteAddr();
		String out_trade_no = System.currentTimeMillis()+"";//订单号
		String nonce_str = UUID.randomUUID().toString().substring(0, 32);
		
		TreeMap<String, Object> signMap = new TreeMap <String, Object>();
		signMap.put("appid", PayConfig.appid);
		signMap.put("mch_id", PayConfig.mch_id);
		signMap.put("body", PayConfig.body);
		signMap.put("notify_url", PayConfig.notify_url);
		signMap.put("trade_type", PayConfig.trade_type);
		
		signMap.put("total_fee", PayConfig.total_fee);
		signMap.put("nonce_str", nonce_str);
		signMap.put("out_trade_no", out_trade_no);
		signMap.put("spbill_create_ip", spbill_create_ip);
		
		String sign = buildSign(signMap, PayConfig.key);
		signMap.put("sign", sign);
		
	}
	
	public static String buildSign(TreeMap<String, Object> signMap, String salt) {
	    StringBuilder sb = new StringBuilder();
	    Iterator<String> iterator = signMap.keySet().iterator();
	    while (iterator.hasNext()){
	    	String key = iterator.next();
	    	sb.append(key + "=" + signMap.get(key) + "&");
	    }
	    sb.append("key=").append(salt);
	    String result = MD5.MD5Encode(sb.toString());
	    return result;
	}
	
	public static String buildXml(TreeMap<String, Object> signMap) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<xml>");
	    Iterator<String> iterator = signMap.keySet().iterator();
	    while (iterator.hasNext()){
	    	String key = iterator.next();
	    	sb.append("<").append(key).append(">");
	    	sb.append(signMap.get(key));
	    	sb.append("</").append(key).append(">");
	    }
	    sb.append("</xml>");
	    return sb.toString();
	}
	
	public static JSON buildXml(String xml) {
		XMLSerializer xmlSerializer=new XMLSerializer();
        return xmlSerializer.read(xml);
	}
	
	public static void main(String[] args) throws Exception {
		String spbill_create_ip = "127.0.0.1";
		String out_trade_no = System.currentTimeMillis()+"";//订单号
		String nonce_str = UUID.randomUUID().toString().substring(0, 32);
		
		TreeMap<String, Object> signMap = new TreeMap <String, Object>();
		signMap.put("appid", PayConfig.appid);
		signMap.put("mch_id", PayConfig.mch_id);
		signMap.put("body", PayConfig.body);
		signMap.put("notify_url", PayConfig.notify_url);
		signMap.put("trade_type", PayConfig.trade_type);
		
		signMap.put("total_fee", PayConfig.total_fee);
		signMap.put("nonce_str", nonce_str);
		signMap.put("out_trade_no", out_trade_no);
		signMap.put("spbill_create_ip", spbill_create_ip);
		
		long timestamp = System.currentTimeMillis() / 1000;
		
		String sign = buildSign(signMap, PayConfig.key);
		signMap.put("sign", sign);
		String xml = buildXml(signMap);
		
		int connectTimeoutMs = 5000;
		int readTimeoutMs = 5000;
		String result = HttpUtil.httpRequest(PayConfig.unifiedorderURL, xml, connectTimeoutMs, readTimeoutMs);
		System.out.println(result);
		
		XMLSerializer xmlSerializer=new XMLSerializer();
        JSON json = xmlSerializer.read(result);
	    System.out.println("################## " + json);
	    
	    JSONObject obj = JSONObject.fromObject(json);
	    
	    String prepay_id = obj.getString("prepay_id");
	    
	    TreeMap<String, Object> sign2Map = new TreeMap <String, Object>();
		sign2Map.put("appid", PayConfig.appid);
		sign2Map.put("partnerid", PayConfig.mch_id);//商户号
		sign2Map.put("prepayid", prepay_id);//预支付交易会话ID
		sign2Map.put("package", "Sign=WXPay");
		sign2Map.put("noncestr", PayConfig.mch_id);
		sign2Map.put("timestamp", timestamp);
		String sign2 = buildSign(sign2Map, PayConfig.key);
		
//		JSONObject m = XmlUtil.xml2JSON(result, JSONObject.class);
//		
//		System.out.println(m);
	}
	
	
}

package com.chnghx.web.wx.util;

public abstract interface PayConfig {

	String appid = "wxc9dde155ff734260";//String(32) 公众账号ID ， 必填
	String mch_id = "1334253201";//String(32) 商户号 必填
	String sign_type = "MD5";//String(32)签名类型 默认为MD5，支持HMAC-SHA256和MD5。  非必填
	String secret = "7c4fbcad9f5297f95f8f82287c14bf61";
	String key = "okm9ijn8uhb7ygv6tfc5rdx4esz301qw";
	
	String body = "测试商品";//商品描述
	String total_fee = "1";//总金额(单位：分)
	String fee_type = "CNY";//货币类型
	String trade_type = "APP";//支付类型
	
	String unifiedorderURL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	String notify_url = "http://pay.vinuxpay.com/vinuxpay/transaction/pay/webchatNotify";
	
	
}

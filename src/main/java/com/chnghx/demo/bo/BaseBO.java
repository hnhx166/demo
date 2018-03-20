package com.chnghx.demo.bo;

import java.io.Serializable;

public class BaseBO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7772485886087745843L;
	
	private String appid;//String(32) 公众账号ID ， 必填
	private String mch_id;//String(32) 商户号 必填
	private String device_info;//String(32)设备号， 非必填
	private String nonce_str;//String(32)随机字符串 长度要求在32位以内 ， 必填
	private String sign;//String(32)签名 ， 必填
	private String sign_type;//String(32)签名类型 默认为MD5，支持HMAC-SHA256和MD5。  非必填
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
}

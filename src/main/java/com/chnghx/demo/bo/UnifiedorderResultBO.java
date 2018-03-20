package com.chnghx.demo.bo;


public class UnifiedorderResultBO extends BaseBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5024200311961626105L;
	
	private String return_code;//String(16)返回状态码,SUCCESS/FAIL,必填 ,此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	private String return_msg;//String(16)返回信息, 非必填
	
	/******以下字段在return_code为SUCCESS的时候有返回 ******/
	private String result_code;//String(16)业务结果,必填
	private String err_code;//String(32)错误代码,非必填
	private String err_code_des;//String(128)错误代码描述,非必填
	
	/*************以下字段在return_code 和result_code都为SUCCESS的时候有返回 ***********************/
	private String trade_type;//String(16)交易类型,必填, 交易类型，取值为：JSAPI，NATIVE，APP等
	private String prepay_id;//String(64)预支付交易会话标识,必填,微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
	private String code_url;//String(64)二维码链接,非必填, trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
	
	
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getPrepay_id() {
		return prepay_id;
	}
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}
	public String getCode_url() {
		return code_url;
	}
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}

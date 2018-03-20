package com.chnghx.demo.bo;



public class UnifiedorderBO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5776742543425611500L;
	
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
	
	
	
	private String body;//String(128)商品描述， 必填
	private String detail;//String(6000) 商品详情， 非必填
	private String attach;//String(127)附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用， 非必填
	private String out_trade_no;//String(32)商户订单号， 必填
	private String fee_type = "CNY";//String(32)标价币种， 符合ISO 4217标准的三位字母代码，默认人民币：CNY，详细列表请参见货币类型， 非必填
	private String total_fee;//String(32)订单总金额，单位为分，详见支付金额， 必填
	private String spbill_create_ip;//String(16)终端IP，APP和网页支付提交用户端ip，Native支付填调用微信支付API的机 ， 必填
	private String time_start;//String(14)交易起始时间，订单生成时间，格式为yyyyMMddHHmmss ， 非必填
	private String time_expire;//String(14)交易结束时间,订单失效时间，格式为yyyyMMddHHmmss ， 非必填
	private String goods_tag;//String(32)订单优惠标记 ， 非必填
	private String notify_url;//String(256)通知地址,异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。 必填
	private String trade_type;//String(16)//交易类型,取值如下：JSAPI，NATIVE，APP等，说明详见参数规定， 必填
	private String product_id;//String(32)商品ID， 非必填
	private String limit_pay;//String(32)指定支付方式,上传此参数no_credit--可限制用户不能使用信用卡支付， 非必填
	private String openid;//String(128)用户标识,trade_type=JSAPI时（即公众号支付），此参数必传，此参数为微信用户在商户对应appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
//	private SceneInfo scene_info;//String(256)场景信息,该字段用于上报场景信息，目前支持上报实际门店信息。
	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
//	public SceneInfo getScene_info() {
//		return scene_info;
//	}
//	public void setScene_info(SceneInfo scene_info) {
//		this.scene_info = scene_info;
//	}
	
	
}

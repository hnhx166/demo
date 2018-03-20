package com.chnghx.web.wechat.manager;
/**
 * 
 * 
 *开发公司：九樱天下（北京）信息技术有限公司
 *版权：九樱天下（北京）信息技术有限公司
 * @author lubaohui@vitapollo.com
 * 
 *@BaseWeChatMessage.java
 *@2018年1月2日
 *@下午2:41:14
 *
 *
 *说明：消息父类
 */
public class BaseWeChatMessage {
	/**
	 * 开发者微信号
	 */
	private String ToUserName;
	/**
	 * 发送方帐号（一个OpenID）
	 */
	private String FromUserName;
	/**
	 * 消息创建时间 （整型）
	 */
	private long CreateTime;
	/**
	 * 消息类型
	 */
	private String MsgType;
	private String MsgId;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getMsgId() {
		return MsgId;
	}
	public void setMsgId(String msgId) {
		MsgId = msgId;
	}
}

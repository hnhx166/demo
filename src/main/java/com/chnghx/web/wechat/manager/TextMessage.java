package com.chnghx.web.wechat.manager;
/**
 * 
 * 
 *开发公司：九樱天下（北京）信息技术有限公司
 *版权：九樱天下（北京）信息技术有限公司
 * @author lubaohui@vitapollo.com
 * 
 *@TextMessage.java
 *@2018年1月2日
 *@下午2:00:04
 *
 *说明：文本格式
 <xml>
    <ToUserName>< ![CDATA[toUser] ]>
    </ToUserName>
    <FromUserName>< ![CDATA[fromUser] ]>
    </FromUserName>
    <CreateTime>12345678</CreateTime>
    <MsgType>< ![CDATA[text] ]>
    </MsgType>
    <Content>< ![CDATA[你好] ]>
    </Content>
</xml>
 *
 */
public class TextMessage extends BaseWeChatMessage{
	/**
	 * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}

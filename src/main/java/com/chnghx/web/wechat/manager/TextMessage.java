package com.chnghx.web.wechat.manager;
/**
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

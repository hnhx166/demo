package com.chnghx.web.wechat.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.VCache;
import com.chnghx.web.common.config.Config;
import com.chnghx.web.wechat.manager.IMGEMessage;
import com.chnghx.web.wechat.manager.TextMessage;
import com.chnghx.web.wechat.utils.ReadFile;
import com.chnghx.web.wechat.utils.SignUtil;
import com.chnghx.web.wechat.utils.WeChatButtonUtil;
import com.chnghx.web.wechat.utils.WeChatMessageKeyUtil;
import com.chnghx.web.wechat.utils.WeChatMessageUtil;
import com.chnghx.web.wechat.utils.WeChatTextBusiness;
/**
 * 
 *开发公司：九樱天下（北京）信息技术有限公司
 *版权：九樱天下（北京）信息技术有限公司
 * @author lubaohui@bizviva.com
 *
 *2017年12月21日 下午3:31:17
 *WXController.java
 *
 *说明：
 */
@Controller
@RequestMapping("wechatToken")
public class WeChatController extends BaseController{
	private String path=this.getClass().getResource("/").getPath();
    private Logger log =Logger.getLogger(WeChatController.class);
    @RequestMapping(method = RequestMethod.GET)   
    public void get(PrintWriter out,HttpServletRequest request,HttpServletResponse response) {   
                 log.info("GET:请求进来了...");  
           printEchostr(out, request);   
       }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void post(HttpServletRequest request,HttpServletResponse response) {
    	response.setContentType("text/xml;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=null;
    		log.info("POST:请求进来了...");  
    		try {
    			out=response.getWriter();
    			Map<String, String> wechatObjct=WeChatMessageUtil.parseXML(request);
    			String event=wechatObjct.get(WeChatMessageKeyUtil.MSG_TYPE);//什么事件 
    			String eventType=wechatObjct.get(WeChatMessageKeyUtil.EVENT);//事件类型
    			String eventKey=wechatObjct.get(WeChatMessageKeyUtil.EVENT_KEY);//事件参数 
    			String openId=wechatObjct.get(WeChatMessageKeyUtil.FROM_USER_NAME);//openId
    			String vipcn=wechatObjct.get(WeChatMessageKeyUtil.TO_USER_NAME);//toUserName
    			String content=wechatObjct.get(WeChatMessageKeyUtil.CONTENT);//内容
				String msgId=wechatObjct.get(WeChatMessageKeyUtil.MSGID);//消息ID
				
//				{
//					//逻辑区
//	    			if(WeChatMessageUtil.MESSAGE_EVENT.equals(event)) {//事件
//	    				if(WeChatMessageUtil.MESSAGE_EVENT_SUBSCRIBE.equals(eventType)){//未订阅点击订阅，扫码进入或搜索公众号进入（搜索公众号进入的没有社区ID,将使用默认社区ID）
//	    					if(StringUtils.isNotBlank(eventKey)&&eventKey.contains(WeChatMessageUtil.EVENT_PREFIX)) {
//	    						String assId=eventKey.substring(WeChatMessageUtil.EVENT_PREFIX.length(),eventKey.length());//判断标记社区ID
//	    						Map<String, Object> mapUserInfo=RoleManager.selectMemberinfo(assId);
//	    						if(null!=mapUserInfo&&"230202".equals(String.valueOf(mapUserInfo.get("roleType")))) {
//	    							SignUtil.selectMemberinfo(openId, assId,vipcn);//存储公众号信息/注册再次关注、第一次关注
//	    							VCache.put(openId+"_assId", assId);//存储社区ID
//	    						}
//	    					}else {//搜索公众号进入
//	    						String vk_media_id = Config.getProperty("dietary.vk.media.id");//默认维康社区
//	    						log.debug("默认维康社区ID:"+vk_media_id);
//	    						SignUtil.selectMemberinfo(openId, vk_media_id,vipcn);//存储公众号信息/注册再次关注、第一次关注
//    							VCache.put(openId+"_assId", vk_media_id);//存储社区ID
//	    					}
//	    				}else if(WeChatMessageUtil.MESSAGE_EVENT_SCAN.equals(eventType)){//已订阅扫码进入或取消订阅
//	    					//已订阅，但没有绑定，或已订阅扫其他二维码进入重新归属社区ID
//	    					String assId=eventKey;//判断标记社区ID
//							Map<String, Object> mapUserInfo=RoleManager.selectMemberinfo(assId);
//							if(null!=mapUserInfo&&"230202".equals(String.valueOf(mapUserInfo.get("roleType")))) {
//								SignUtil.selectMemberinfo(openId, assId,vipcn);//存储公众号信息/注册再次关注、第一次关注
//								VCache.put(openId+"_assId", assId);//存储社区ID
//							}
//	    				}else if(WeChatMessageUtil.MESSAGE_EVENT_UNSUBSCRIBE.equals(eventType)){//取消订阅
//	    					VCache.remove(openId+"_assId");//清除存储社区ID
//	    				}else if(WeChatMessageUtil.MESSAGE_EVENT_CLICK.equals(eventType)) {//按钮点击事件 
//	    					if(StringUtils.isNotBlank(eventKey)) {
//	    						if(eventKey.equals(WeChatButtonUtil.VK_IMG_102_POSTER)) {//海报
//	    							String mediaId="rfObFYeZEZ9e6vMwHui898VtaSAX5rI8OrxD8zQSeV4";
//	    							IMGEMessageUtil(out, openId, vipcn, content, msgId,mediaId);
//	    						}else if(eventKey.equals(WeChatButtonUtil.VK_COMMON_101_ONEBUTTON)) {//欢迎你
//	    							
//	    							JSONObject jsonObject=JSONObject.fromObject(ReadFile.readFileByBytes(path+ReadFile.WECHAT_BUSINESS));
//	    							String returnCcontent=JSONObject.fromObject(jsonObject.get(eventKey).toString()).optString(WeChatButtonUtil.CONTENT);
//	    							
//	    							TextMessageUtil(out,openId, vipcn,returnCcontent,eventType, eventKey);
//	    						}else if(eventKey.equals(WeChatButtonUtil.VK_CONTACT_302_ONEBUTTON)) {//联系我们
//	    							
//	    							JSONObject jsonObject=JSONObject.fromObject(ReadFile.readFileByBytes(path+ReadFile.WECHAT_BUSINESS));
//	    							String returnCcontent=JSONObject.fromObject(jsonObject.get(eventKey).toString()).optString(WeChatButtonUtil.CONTENT);
//	    							
//	    							TextMessageUtil(out,openId, vipcn,returnCcontent,eventType, eventKey);
//	    						}
//	    					}
//	    				}
//	    			}else if(WeChatMessageUtil.MESSAGE_TEXT.equals(event)) {//文本消息推送
//	    				
//	    				if(WeChatTextBusiness.IMG_POSTER.equals(content)) {
//	    					String mediaId="rfObFYeZEZ9e6vMwHui89__R84pHh2tlqkm4oRPXRkI";
//		    				IMGEMessageUtil(out, openId, vipcn, content, msgId,mediaId);
//	    				}
//	    			}
//				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				out.close();   
               // out.flush();
               out = null; 
			}
    		
    		
       }
    /**
     * 图片
     * @param out
     * @param openId
     * @param vipcn
     * @param content
     * @param msgId
     */
	private void IMGEMessageUtil(PrintWriter out, String openId, String vipcn, String content, String msgId,String mediaId) {
//		IMGEMessage imgsMessage=new IMGEMessage();
//		imgsMessage.setFromUserName(vipcn);
//		imgsMessage.setToUserName(openId);
//		imgsMessage.setCreateTime(System.currentTimeMillis());
//		imgsMessage.setMsgType(WeChatMessageUtil.MESSAtGE_IMAGE);
//		imgsMessage.getImage().setMediaId(mediaId);
//		String message=WeChatMessageUtil.messageToXML(imgsMessage);
//		System.err.println("客户消息："+content+"  消息ID："+msgId);
//		System.err.println("消息："+message);
//		out.print(message);
	}
   
    /**
     * 文本消息推送
     * @param openId
     * @param vipcn
     * @param content
     * @param eventType
     * @param eventKey
     * @return
     */
	private void TextMessageUtil(PrintWriter out, String openId, String vipcn, String content,String eventType, String eventKey) {
//		TextMessage textMessage=new TextMessage();
//		textMessage.setFromUserName(vipcn);
//		textMessage.setToUserName(openId);
//		textMessage.setCreateTime(System.currentTimeMillis());
//		textMessage.setMsgType(WeChatMessageUtil.MESSAGE_TEXT);
//		textMessage.setContent(content);
//		String message=WeChatMessageUtil.messageToXML(textMessage);
//		System.err.println("事件："+eventType+"  按钮："+eventKey);
//		System.err.println("消息："+message);
//		out.print(message);
	}   
    
    /**
     * 返回Wechat信息
     * @param out
     * @param request
     */
    private void printEchostr(PrintWriter out, HttpServletRequest request) {
		// 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。   
           String signature =request.getParameter("signature");   
           String timestamp =request.getParameter("timestamp");// 时间戳   
           String nonce =request.getParameter("nonce");// 随机数   
           String echostr =request.getParameter("echostr"); // 随机字符串   
           try {   
               // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败   
               if (SignUtil.checkSignature(signature,timestamp, nonce)) {   
                   out.print(echostr);   
               }  
           } catch (Exception e) {   
               e.printStackTrace();   
           } finally {   
               out.close();   
               // out.flush();
               out = null;   
           }
	} 
}

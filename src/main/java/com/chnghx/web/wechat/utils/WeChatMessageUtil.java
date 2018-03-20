package com.chnghx.web.wechat.utils;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.chnghx.web.wechat.manager.IMGEMessage;
import com.chnghx.web.wechat.manager.TextMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class WeChatMessageUtil {

    /**
     * 文本消息
     */
    public static final String MESSAGE_TEXT = "text";
    /**
     * 图片消息
     */
    public static final String MESSAtGE_IMAGE = "image";
    /**
     * 图文消息
     */
    public static final String MESSAGE_NEWS = "news";
    /**
     * 语音消息
     */
    public static final String MESSAGE_VOICE = "voice";
    /**
     * 视频消息
     */
    public static final String MESSAGE_VIDEO = "video";
    /**
     * 小视频消息
     */
    public static final String MESSAGE_SHORTVIDEO = "shortvideo";
    /**
     * 地理位置消息
     */
    public static final String MESSAGE_LOCATION = "location";
    /**
     * 链接消息
     */
    public static final String MESSAGE_LINK = "link";
    /**
     * 事件推送消息
     */
    public static final String MESSAGE_EVENT = "event";
    
    public static final String EVENT_PREFIX= "qrscene_"; 
    /**
     * 事件推送消息中,事件类型，subscribe(订阅)（未关注订阅）
     */
    public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";
    
    /**
     * 事件推送消息中,事件类型，SCAN(用户已关注时
     */
    public static final String MESSAGE_EVENT_SCAN= "SCAN";
    /**
     * 事件推送消息中,事件类型，unsubscribe(取消订阅)
     */
    public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";
    /**
     * 事件推送消息中,上报地理位置事件
     */
    public static final String MESSAGE_EVENT_LOCATION_UP = "LOCATION";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单拉取消息时的事件推送
     */
    public static final String MESSAGE_EVENT_CLICK = "CLICK";
    /**
     * 事件推送消息中,自定义菜单事件,点击菜单跳转链接时的事件推送
     */
    public static final String MESSAGE_EVENT_VIEW = "VIEW";
    
    /**
     * 素材
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     */
    
    /**
     * 图片
     */
    public static final String image="image";
    /**
     * 语音（voice）
     */
    public static final String voice="voice";
    /**
     * 视频（video）
     */
    public static final String video="video";
    /**
     * 缩略图（thumb）
     */
    public static final String thumb="thumb";
   
    /**
     * 解析微信发来的请求（XML）
     * 
     * @param request
     * @return Map<String, String>
     * @throws Exception
     */
    public static HashMap<String, String> parseXML(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        HashMap<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(request.getInputStream());
        // 得到xml根元素
        Element root = document.getRootElement();
        
        recursiveParseXML(root,map);

        inputStream.close();
        inputStream = null;
        System.err.println(map);
        return map;
    }
    /**
     * 解析xml
     * 封装map
     * @param root
     * @param map上午10:58:31
     */
    private static void recursiveParseXML(Element root,HashMap<String, String> map){
                // 得到根元素的所有子节点
                List<Element> elementList = root.elements();
                //判断有没有子元素列表
                if(elementList.size() == 0){
                    map.put(root.getName(), root.getText());
                }else{
                    //遍历
                    for (Element e : elementList){
                        recursiveParseXML(e,map);
                    }
                }
            }
    
    /**
     * 扩展xstream使其支持CDATA
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                //@SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * 文本消息对象转换成xml
     * 
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String messageToXML(TextMessage textMessage) {
        xstream.alias("xml", TextMessage.class);
        return xstream.toXML(textMessage);
    }

    /**
     * 图片消息对象转换成xml
     * 
     * @param imageMessage 图片消息对象
     * @return xml
     */
    public static String messageToXML(IMGEMessage imagsMessage) {
        xstream.alias("xml", IMGEMessage.class);
        return xstream.toXML(imagsMessage);
    }
    
    
}

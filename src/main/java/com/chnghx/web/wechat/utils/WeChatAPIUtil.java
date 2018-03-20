package com.chnghx.web.wechat.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


/**
 * 微信API接口类
 * @author Administrator
 *
 */
public class WeChatAPIUtil {
	private static Logger logger = Logger.getLogger(WeChatAPIUtil.class);
	  //微信接口配置时填写的Token
    public  static String TOKEN = "VK_WX_TOKEN_QAZ_WSX";
    private static String VCACHE_KEY="VK_access_token";
    private static final String QR_SCENE="QR_SCENE";//临时数字格式
    private static final String QR_STR_SCENE="QR_STR_SCENE";//临时字符格式
    private static final String QR_LIMIT_SCENE="QR_LIMIT_SCENE"; //永久数字格式
    private static final String QR_LIMIT_STR_SCENE="QR_LIMIT_STR_SCENE"; //永久数字格式
    private static final Integer DAY_30=2592000;//30天
	private static final String GET_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	private static final String CREATE_TICKET_PATH  = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    private static final String SHOW_QRCODE="https://mp.weixin.qq.com/cgi-bin/showqrcode";
    private static final String CREAT_MENU ="https://api.weixin.qq.com/cgi-bin/menu/create";//创建自定义菜单
    private static final String DELETE_MENU="https://api.weixin.qq.com/cgi-bin/menu/delete";//删除自定义菜单
    private static final String ADD_NEWS="https://api.weixin.qq.com/cgi-bin/material/add_news";//新增新闻素材
    private static final String ADD_MATERIAL="https://api.weixin.qq.com/cgi-bin/material/add_material";//新增素材
	//新增永久素材(上传)——新增其他类型永久素材(image、voice、video、thumb)
    private static final String UPLOAD_PERMANENT_MATERIAL_URL="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";
    //获取永久素材(下载)
    private static final String GET_PERMANENT_MATERIAL_URL="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
    
    /**
     * 获取TOKEN
     * 
     */
	public static String getToken() {
//    	String getTokenUrl=GET_TOKEN.replace("APPID",WeChatConfig.APP_ID).replace("APPSECRET", WeChatConfig.SECRET);
//    	String tokenStr =VCache.get(VCACHE_KEY);
//		if(StringUtils.isBlank(tokenStr)) {
//			tokenStr= HttpClientUtils.getUserInfoHttp(getTokenUrl);
//			JSONObject obj = JSONObject.parseObject(tokenStr);
//			 tokenStr=obj.getString("access_token");
//			VCache.putex(VCACHE_KEY, tokenStr,7000);
//		}
//		System.err.println("TOKEN="+tokenStr);
//		return tokenStr;
		return null;
    }
    /** 
     * 获取二维码ticket后，通过ticket换取二维码图片展示 
     * @param ticket 
     * @return 
     */  
    public static String showQrcode(String ticket){  
        Map<String,String> params = new TreeMap<String,String>();  
        params.put("ticket", HttpRequestUtil.urlEncode(ticket, HttpRequestUtil.DEFAULT_CHARSET));  
        String showqrcode_path=null;
        try {  
        	showqrcode_path=HttpRequestUtil.setParmas(params,SHOW_QRCODE,"");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        System.err.println("图片地址："+showqrcode_path);
        return showqrcode_path;  
    } 
    
    /**
     * 获取票据
     * @param expire_seconds 时限
     * @param action_name　二维码类型（临时、永久）
     * @param sceneValue 参数
     * @return
     */
     public static String getTicket(Integer expire_seconds,String action_name,Object sceneValue) {
     	TreeMap<String,String> params = new TreeMap<String,String>();  
         params.put("access_token", getToken());  
         Map<String,Object> intMap = new HashMap<String,Object>();  
         Map<String,Map<String,Object>> mapMap = new HashMap<String,Map<String,Object>>(); 
         Map<String,Object> paramsMap = new HashMap<String,Object>(); 
         if((QR_STR_SCENE.equals(action_name)||QR_SCENE.equals(action_name))&&null!=expire_seconds) {
         	 paramsMap.put("expire_seconds", expire_seconds);
         }
         if(QR_STR_SCENE.equals(action_name)||QR_LIMIT_STR_SCENE.equals(action_name)) {//STR
          	intMap.put("scene_str",sceneValue); 
          }else if(QR_SCENE.equals(action_name)||QR_LIMIT_SCENE.equals(action_name)) {//INT
          	intMap.put("scene_id",sceneValue);
          }
         
         paramsMap.put("action_name", action_name);
         mapMap.put("scene", intMap);
         paramsMap.put("action_info", mapMap);  
         String data = JSONObject.toJSONString(paramsMap);  
         //必须扫码，URL直接访问不能识别
         //{"ticket":"gQEE8TwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyRlRKMjVScmhkSWkxaUFMejFxY2MAAgSkojtaAwQAjScA","expire_seconds":2592000,"url":"http:\/\/weixin.qq.com\/q\/02FTJ25RrhdIi1iALz1qcc"}
         data = HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,CREATE_TICKET_PATH,params,data);  
         data= JSONObject.parseObject(data).getString("ticket");
         System.err.println("Ticket="+data);
         return data;
     }
     
     /**
      * 创建自定义菜单
      * @param paramsMap
      * @return
      */
     public static JSONObject createMenu(JSONObject buttonJson) {
     	TreeMap<String,String> params = new TreeMap<String,String>();  
         params.put("access_token", getToken());  
         String data = buttonJson.toString(); 
         data =HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,CREAT_MENU,params,data);
         return JSONObject.parseObject(data);
     }
     
     /**
      * 删除菜单
      * @param paramsMap
      * @return
      */
     public static JSONObject deleteMenu() {
     	TreeMap<String,String> params = new TreeMap<String,String>();  
         params.put("access_token", getToken());  
         String data =HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD, DELETE_MENU,params,null);
         return JSONObject.parseObject(data);
     }
     
	 /**
     * @desc ： 新增永久素材——新增其他类型永久素材(image、voice、thumb)
     *  
     * @param accessToken  调用接口凭证
     * @param type 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param fileDir 本地图片路径
     * 
     * @return
     * media_id    新增的永久素材的media_id
     * url    新增的图片素材的图片URL（仅新增图片素材时会返回该字段）
     * 
     * @throws Exception String
     */
    public static JSONObject uploadPermanentMaterial(String type,String fileDir) throws Exception {
        //1.创建本地文件
        File file=new File(fileDir);

        //2.拼接请求url
        String url = UPLOAD_PERMANENT_MATERIAL_URL.replace("ACCESS_TOKEN", getToken()).replace("TYPE", type);

        //3.调用接口，发送请求，上传文件到微信服务器
        JSONObject jsonObject=HttpRequestUtil.uploadMedia(url, file);
        logger.info("JsonObject:"+jsonObject.toJSONString());

        //4.解析结果
        JSONObject returnJsonObject=null;
        if (jsonObject != null) {
            if (jsonObject.getString("media_id") != null) {

                logger.info("新增永久素材成功:"+jsonObject.getString("media_id"));
                returnJsonObject= jsonObject;
                //5.错误消息处理
            } else {
                int errCode = jsonObject.getInteger("errcode");
                String errMsg = jsonObject.getString("errmsg");
                logger.error("新增永久素材失败"+" errcode:"+errCode+", errmsg:"+errMsg);
            }
        }
        return returnJsonObject;
    }
    
    /**
     * @desc ：获取永久素材
     *  
     * @param accessToken 调用接口凭证
     * @param mediaId  媒体文件ID
     * @param fileDir  文件下载路径（文件所在文件夹路径）,如 D:/img/download/,会与文件名拼接成文件下载路径
     * @return
     * @throws Exception File
     */
    public static File getPermanentMaterial(String mediaId,String fileDir) throws Exception {
        //1.准备好json请求参数
        Map<String,String> paramMap=new HashMap<String,String>();
        paramMap.put("media_id", mediaId);

        Object data=JSON.toJSON(paramMap);

        //2.准备好请求url
        String url=GET_PERMANENT_MATERIAL_URL.replace("ACCESS_TOKEN", getToken());

        //3.调用接口，发送HTTP请求，下载文件到本地
        File file=HttpHelper.downloadMedia(url, data,fileDir);
        logger.info("fileName:"+file.getName());
        return file;
    }
}

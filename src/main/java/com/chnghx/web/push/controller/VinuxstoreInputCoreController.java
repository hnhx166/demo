package com.chnghx.web.push.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chnghx.core.mq.publics.MqPublicInfo;
import com.chnghx.web.common.APIResult;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.statics.Constant;
/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年11月23日 　<br/>
 * <p>
 *
 * 樱桃铺消息推送接收
 *
 * <p>
 * @author zhou-baicheng
 * @email  i@itboy.net
 * @version 1.0,2016年11月23日 <br/>
 * 
 */
@Controller
@RequestMapping("vinuxstore/{clientId}")
public class VinuxstoreInputCoreController extends BaseController {

	
	/**
	 * 消息推送。
	 * @author zhou-baicheng
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="push",method=RequestMethod.GET)
	public APIResult<Object> push(@PathVariable("clientId")String clientId,Map<String, Object> pushMap) throws Exception{
		
		/*System.out.println(clientId);*/
		//推送消息体
	    /* pushMap.put("ALIASID","26682");//用户ID（应用匿名ID)
	    pushMap.put("PUSHCONTENT", "{\"name\": \"tongchuanwei\"}");//传递业务JSON主体信息
	    pushMap.put("TITLE", "通知栏标题");//通知栏标题
	    pushMap.put("TEXT", "通知栏内容");//通知栏内容
	    pushMap.put("LOGOURL", "http://img.vinux.com/upload/1449805792130.png_154x154");//通知栏网络图标URL(网络地址）
	    pushMap.put("LOGO", "icon.png");//通知栏图标（本地名称）
	    pushMap.put("DURATION", "2015-01-16 11:40:00,2015-01-16 12:24:00");//设置定时展示时间(可选项) 
	    //PushtoSingle.doPush(pushMap);*/
	    MqPublicInfo.producerMsg(pushMap, "vinuxstorepushmsg");//推送消息
		return new APIResult<Object>(Constant.API_ACCEPT_CLIENT,"接受推送请求!");
	}
	
	
}

package com.chnghx.web.push.manager;

//public class PushtoSingle {
//   
//    /** 执行推送方法*/
//    public static void doPush(Map<String, Object> pushMap) throws Exception {
//        IGtPush push = new IGtPush(PushConstant.host, PushConstant.vinuxstore_appKey, PushConstant.vinuxstore_masterSecret);
//        TransmissionTemplate template = transmissionTemplate(pushMap);
//        SingleMessage message = new SingleMessage();
//        message.setOffline(true);
//        // 离线有效时间，单位为毫秒，可选
//        message.setOfflineExpireTime(24 * 3600 * 1000);
//        message.setData(template);
//        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
//        message.setPushNetWorkType(0); 
//        Target target = new Target();
//        target.setAppId(PushConstant.vinuxstore_appId);
//        target.setAlias(pushMap.get("ALIASID").toString());
//        IPushResult ret = null;
//        try {
//            ret = push.pushMessageToSingle(message, target);
//        } catch (RequestException e) {
//        	LoggerUtils.error(PushtoSingle.class, "个推服务器响应异常", e);
//            ret = push.pushMessageToSingle(message, target, e.getRequestId());
//        }
//        if (ret != null) {
//            System.out.println(ret.getResponse().toString());
//            LoggerUtils.debug(PushtoSingle.class, ret.getResponse().toString());
//        } else {
//            LoggerUtils.error(PushtoSingle.class, "个推服务器响应异常", null);
//        }
//    }
//    
//  
//    /**设置透传模板*/
//    public static TransmissionTemplate transmissionTemplate(Map<String, Object> pushMap) throws Exception {
//    	 TransmissionTemplate template = new TransmissionTemplate();
//	    // 设置APPID与APPKEY
//	    template.setAppId(PushConstant.vinuxstore_appId);
//	    template.setAppkey(PushConstant.vinuxstore_appKey);
//	    // 1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
//	    template.setTransmissionType(2);
//	    // 透传消息设置
//	    template.setTransmissionContent(pushMap.get("PUSHCONTENT").toString());
//	    
//	    // APNPayload设置
//	    APNPayload payload = new APNPayload();
//	    payload.setBadge(1);
//	    payload.setContentAvailable(1);
//	    payload.setSound("default");
//	    payload.addCustomMsg("payload", pushMap.get("PUSHCONTENT").toString());
//	    
//	  
//	    //字典模式使用下者
//	    APNPayload.DictionaryAlertMsg msg=getDictionaryAlertMsg(pushMap);
//	    payload.setAlertMsg(msg);
//	    
//	    template.setAPNInfo(payload);
//	    return template;
//	}
//    
//    /**
//     * 字典模式使用
//     * @param pushMap
//     * @return
//     */
//    private static APNPayload.DictionaryAlertMsg getDictionaryAlertMsg(Map<String, Object> pushMap){
//        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
//        alertMsg.setTitle(pushMap.get("TITLE").toString());
//        alertMsg.setBody(pushMap.get("TEXT").toString());
//        return alertMsg;
//    }
//    
//}

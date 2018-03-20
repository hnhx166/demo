package com.chnghx.core.mq.excute;

import com.chnghx.core.mq.publics.MqPublicInfo;

/**
 * 
 * @author 初始化消费者
 * 
 */
public class InitConsumer {
	public static void executeCustomerInfo() {
		//初始化可能多个消费者
		MqPublicInfo.consumerMsg("apiPushToMq");
		//樱桃派推送通知消息到MQ
		MqPublicInfo.consumerMsg("vinuxstorepushmsg");
	}

	public void init() {

		executeCustomerInfo();
	}

	// how validate the destory method is a question
	public void cleanup() {

		System.out.println("cleanUp");
	}

}

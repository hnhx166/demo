package com.chnghx.core.mq.publics;

import java.io.IOException;

import com.chnghx.web.common.utils.LoggerUtils;
import com.chnghx.web.common.utils.SerializeUtil;
import com.chnghx.web.common.utils.StringUtils;
import com.rabbitmq.client.MessageProperties;

public class Producer extends EndPoint implements Runnable {

	protected Object obj;
	protected String routingKey;

	public Producer(String queueName, Object obj) {

		super(queueName);
		this.obj = obj;
	}
	
	public Producer(Object obj,String routingKey) {
		super("");
		this.routingKey = routingKey;
		this.obj = obj;
	}

	// 生产者发送消息
	public void sendMessage(Object object) throws IOException {
		if (StringUtils.isNotBlank(routingKey)) {
			channel.exchangeDeclare(exchange, exchangeType);
			channel.basicPublish(exchange, routingKey, MessageProperties.PERSISTENT_BASIC, SerializeUtil.serialize(object));
		} 
		else {
			channel.basicPublish("", queueName, MessageProperties.PERSISTENT_BASIC, SerializeUtil.serialize(object));
		}
		LoggerUtils.debug(getClass(), "send.................... '" + object + "'");
	}
	
	public void run() {
		try {
			sendMessage(obj);
		} catch (IOException e) {
			LoggerUtils.error(getClass(), "向生产者发送消息抛出异常",e);
		}
	}
}
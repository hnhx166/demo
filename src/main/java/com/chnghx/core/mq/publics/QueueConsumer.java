package com.chnghx.core.mq.publics;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.chnghx.core.mq.excute.MQExecute;
import com.chnghx.web.common.utils.LoggerUtils;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class QueueConsumer extends EndPoint implements Runnable, Consumer {

	public QueueConsumer(String queueName) {
		super(queueName);
	}

	public void run() {
			try {
				channel.basicConsume(queueName, true, this);
				//channel.basicQos(1);
				//channel.basicConsume(queueName, false, this);
			} catch (IOException e) {
				LoggerUtils.error(getClass(), queueName + ":执行异常！",e);
			}
	}

	/**
	 * Called when consumer is registered.
	 */
	public void     handleConsumeOk(String consumerTag) {

		LoggerUtils.debug(getClass(), "Consumer " + consumerTag + " registered");
	}

	/**
	 * Called when new message is available.
	 */
	public void handleDelivery(String consumerTag, Envelope env,
			BasicProperties props, byte[] body) throws IOException {
		MQExecute.excMqManager(body,queueName);
		//channel.basicAck(env.getDeliveryTag(), false);
	}

	public void handleCancel(String consumerTag) {
		
		LoggerUtils.debug(getClass(), "Consumer " + consumerTag + "handleCancel");
	}

	public void handleCancelOk(String consumerTag) {
		
		LoggerUtils.debug(getClass(), "Consumer " + consumerTag + "handleCancelOk");
	}

	public void handleRecoverOk(String consumerTag) {
		
		LoggerUtils.debug(getClass(), "Consumer " + consumerTag + "handleRecoverOk");
	}

	public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {
		
		LoggerUtils.debug(getClass(), "Consumer " + consumerTag + "handleShutdownSignal");
		MQExecute.recoverconsumer();
	}

	
	
}

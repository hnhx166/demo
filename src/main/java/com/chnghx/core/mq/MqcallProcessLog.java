package com.chnghx.core.mq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.chnghx.core.mq.bo.MqEntity;
import com.chnghx.core.mq.publics.MqPublicInfo;
import com.chnghx.core.mq.publics.Producer;
import com.chnghx.core.mq.publics.QueueConsumer;

public class MqcallProcessLog {

	/**
	 * 
	 * 生产者推送系统日志到队列
	
	 */
	public static void sendProcessLog(SystemLog systemLog) {
		MqEntity<SystemLog> entity = new MqEntity<SystemLog>();
		entity.setObject(systemLog);
		entity.setType(systemLog.getSystemType());

		// 生产者
		Producer producer = new Producer("systemLog_"+systemLog.getSystemType(), entity);

		// 线程池方式
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(producer);

	}
	
	/**
	 * 
	 *  消费者处理队列中系统日志
	
	 */
	public static void receiveProcessLog(String systemType) {

		// 消费者
		QueueConsumer consumer = new QueueConsumer("systemLog_"+systemType);

		// 线程池方式
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(consumer);

	}
	
	/**
	 * 
	 *  生产者和消费者一起处理队列中系统日志
	
	 */
	public static void sendAndreceiveProcessLog(SystemLog systemLog) {

		MqEntity<SystemLog> entity = new MqEntity<SystemLog>();
		entity.setObject(systemLog);

		MqPublicInfo.processMsg(entity, "systemLog");

	}
}

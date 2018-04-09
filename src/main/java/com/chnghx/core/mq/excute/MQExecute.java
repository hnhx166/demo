package com.chnghx.core.mq.excute;

import java.io.Serializable;
import java.util.Map;

import com.chnghx.core.mq.bo.MqEntity;
import com.chnghx.core.mq.publics.MqPublicInfo;
import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.utils.APIServiceLogUitls;
import com.chnghx.web.common.utils.LoggerUtils;
import com.chnghx.web.common.utils.SerializeUtil;

public class MQExecute implements Serializable {
	private static final long serialVersionUID = 5669902966340931851L;

	/**
	 * 
	 * 处理系统日志
	 * 
	 * @param object
	 *            队列存储对象
	 * @param queueName
	 *            队列名称
	 */
	@SuppressWarnings("unchecked")
	public static void excMqManager(byte[] body, String queueName) {

		// 队列名称 ： queueName
		// 队列类型 ： mqEntity.getType()
		/**
		 * 1.可以根据queueName[队列名称]进行判断要执行的业务。 2.如果一个队列里有多个业务，可以用mqEntity.getType() 来区分。
		 */
		// TODO --------------------------------
		try {
			// 接口中心异步通知
			if (queueName.equals("apiPushToMq")) {
				MqEntity<APIServiceLog> entity = SerializeUtil.deserialize(body, MqEntity.class);
				APIServiceLog log = entity.getObject();
				APIServiceLogUitls.info(log);
			}
			// 樱桃铺推送服务
			if (queueName.equals("vinuxstorepushmsg")) {
				Map<String, Object> pushMap = SerializeUtil.deserialize(body, Map.class);
				// PushtoSingle.doPush(pushMap);
			}
		} catch (Exception e) {
			LoggerUtils.error(MQExecute.class, "队列处理发生异常", e);
		}
	}

	/**
	 * 发送关闭连接信号时重新创建消费者
	 */
	public static void recoverconsumer() {

	}

	/**
	 * API推送消息到MQ,MQ请求服务端成功之后请求客户端,最后插入日志相关信息
	 */
	public static void apiPushToMq(APIServiceLog apiServiceLog) {
		MqEntity<APIServiceLog> entity = new MqEntity<APIServiceLog>();
		entity.setObject(apiServiceLog);
		entity.setType("apiPushToMq");
		MqPublicInfo.producerMsg(entity, "apiPushToMq");
	}

}

package com.chnghx.test.mq;

import com.chnghx.core.mq.LogConstant;
import com.chnghx.core.mq.MqcallProcessLog;
import com.chnghx.core.mq.publics.MqPublicInfo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("####################开始启动加载MQ消费者##################################");
		for (int i = 0; i < 1; i++) {
			
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_MYDEMO);

			// 监控数据
			MqPublicInfo.consumerMsg("monitor");
			MqcallProcessLog.receiveProcessLog("");
			//处理API接口日志
			MqPublicInfo.consumerMsg("apiServiceLog");
		}
		System.out.println("####################启动加载MQ消费者完成##################################");

	}

}

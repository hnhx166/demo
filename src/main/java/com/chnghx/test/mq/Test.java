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
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXCART);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXMEMBERS);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXEXPRESS);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPAY);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXCARE);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXGOODS);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_XGANMAO);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_XAPOLLOVITA);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXLOGIN);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX_FINEFOOD);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXCARE_SERVICE);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX_DATACENTER);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX_IMAGE);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VITAPOLLO);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VITAHELPER);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPAY_DB);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX_DATACENTER_MEDIA);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX_DATACENTER_SELLER);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_PCMALL);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_COWMALL);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_MOBILEMALL);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_VIP);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_KAKADING);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXICENTER);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_VS_SDM);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VITAROLE);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXICENTER);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_MEDICALCENTER);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX_BUY);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_SELLER_CENTER);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_MONITOR);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_APIMALL);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUX_HELPER);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_YANGLAO);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXDESIGN);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_VINUXBUY);

			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPAY_STORE);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPROPERTY);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_YANGLAO_COW);
			
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_COMMUNITY);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_TRIP);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXPOST_CPSM);
			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXCAR);
//			MqcallProcessLog.receiveProcessLog(LogConstant.SYSTEM_VINUXHOME);

			// 监控数据
			MqPublicInfo.consumerMsg("monitor");
			MqcallProcessLog.receiveProcessLog("");
			//处理API接口日志
			MqPublicInfo.consumerMsg("apiServiceLog");
		}
		System.out.println("####################启动加载MQ消费者完成##################################");

	}

}

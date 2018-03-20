package com.chnghx.web.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.chnghx.core.mq.bo.MqEntity;
import com.chnghx.core.mq.publics.MqPublicInfo;
import com.chnghx.web.common.APIServiceLog;


public class APIServiceLogUitls {

	/**
	 * 
	 * @param clazz
	 *            class名称
	 * @param message
	 *            异常消息
	 */
	public static void debug(Class<? extends Object> clazz, String message) {
		LoggerUtils.debug(clazz, message);
	}

	/**
	 */
	public static void info(APIServiceLog apiServiceLog) {
		// 推送接口日志到管理系统
		//String jsonArray = StringUtils.isJSONArray(apiServiceLog).toString();
		MqEntity<APIServiceLog> entity = new MqEntity<APIServiceLog>();
		entity.setObject(apiServiceLog);
		entity.setType("apiServiceLog");
		MqPublicInfo.producerMsg(entity, "apiServiceLog");
	}

	// 打印错误栈的信息
	public static String buildExceptionStack(Throwable exception) {
		if (exception != null) {
			StringWriter writer = new StringWriter(2048);

			exception.printStackTrace(new PrintWriter(writer));
			return writer.toString();
		} else {
			return "";
		}
	}

	// 打印线程栈的信息
	private static String buildThreadStack(StackTraceElement[] st) {
		StringBuffer sb = new StringBuffer();
		for (StackTraceElement stackTraceElement : st) {
			sb.append("\tat " + stackTraceElement + "\r\n");
		}
		return sb.toString();
	}

}

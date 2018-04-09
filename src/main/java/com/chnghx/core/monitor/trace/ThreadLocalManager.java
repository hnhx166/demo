package com.chnghx.core.monitor.trace;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.chnghx.web.common.config.Config;
import com.chnghx.web.common.utils.StringUtils;

public class ThreadLocalManager {
	private final static Log LOG = LogFactory.getLog(ThreadLocalManager.class);
	private static ThreadLocal<TraceBody> myThreadLocal = new ThreadLocal<TraceBody>() {
		@Override
		protected TraceBody initialValue() {
			String traceId = UUID.randomUUID().toString();
			double rpcId = -0.1;

			TraceBody logBody = new TraceBody();
			logBody.setTraceId(traceId);
			logBody.setRpcId(rpcId);
			logBody.setLastTime(new Date());

			final Thread currentThread = Thread.currentThread();
			String className = currentThread.getStackTrace()[8].getClassName();
			String methodName = currentThread.getStackTrace()[8].getMethodName();
			Map<String, Object> tags = new HashMap<String, Object>();
			tags.put("className", className);
			tags.put("methodName", methodName);

			String ip = null;
			try {
				if (StringUtils.isNotBlank(InetAddress.getLocalHost())) {
					ip = InetAddress.getLocalHost().getHostAddress().toString();
				}
			} catch (UnknownHostException e) {
				LOG.error("推送监控数据获取IP异常，不影响业务执行..............................");
			}
			String domain = Config.getProperty("domain").replaceAll("http://", "");
			tags.put("ip", ip);
			tags.put("domain", domain);
			logBody.setTags(tags);

			return logBody;
		}
	};

	public static TraceBody getLocal() {
		TraceBody logBody = myThreadLocal.get();
		Map<String, Object> tags = logBody.getTags();

		Date oldDate = logBody.getLastTime();
		Date newdate = new Date();
		Long spanTime = newdate.getTime() - oldDate.getTime();
		tags.put("spanTime", spanTime);
		logBody.setLastTime(newdate);

		final Thread currentThread = Thread.currentThread();
		String className = currentThread.getStackTrace()[4].getClassName();
		String methodName = currentThread.getStackTrace()[4].getMethodName();

		double rpcId = logBody.getRpcId();
		if (!tags.get("className").equals(className)) {
			rpcId = (int) rpcId + 1.0;
		} else {
			rpcId = rpcId + 0.1;
		}
		tags.put("className", className);
		tags.put("methodName", methodName);
		logBody.setRpcId(rpcId);
		logBody.setTags(tags);
		setLocal(logBody);
		return myThreadLocal.get();
	}

	public static void setLocal(TraceBody logBody) {
		myThreadLocal.set(logBody);
	}

	public static void removeLocal() {
		myThreadLocal.remove();
	}

}

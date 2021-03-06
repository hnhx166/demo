package com.chnghx.core.mq.publics;

import java.io.IOException;

import com.chnghx.web.common.config.Config;
import com.chnghx.web.common.utils.LoggerUtils;
import com.chnghx.web.common.utils.StringUtils;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class EndPoint {
	
	protected static Connection connection; // 创建链接
	protected static Channel channel; // 创建信息通道
	protected String queueName; // 队列名称
	private static final boolean durable = true;// 消息队列持久化
	protected static final String exchange = "dataCenter";//自定义交换机名称
	//接收消息，转发消息到绑定的队列。四种类型：direct, topic, headers and fanout。topic：按规则转发消息（最灵活）。
	protected static final String exchangeType = "topic";
	
	public EndPoint(String queueName) {
		this.queueName = queueName;

		// Create a connection factory
		ConnectionFactory factory = new ConnectionFactory();

		String ip = Config.getProperty("mq.ip");
		String name = Config.getProperty("mq.name");
		String pswd = Config.getProperty("mq.pswd");
		String scope = Config.getProperty("mq.scope");
		String message = "当前MQ获取的参数:ip[%s],name[%s],pswd[%s],scope[%s],queueName[%s]";
		
		LoggerUtils.debug(getClass(), String.format(message, ip, name, pswd, scope,queueName));

		factory.setHost(ip);
		factory.setUsername(name);
		factory.setPassword(pswd);
		factory.setVirtualHost(scope);
		// To enable automatic connection recovery
		factory.setAutomaticRecoveryEnabled(true);// 网络异常connection重连
		// To enable automatic consumers recovery
		factory.setTopologyRecoveryEnabled(true);//  网络异常consumers重连 
		factory.setNetworkRecoveryInterval(10000);// 10秒间隔重接
		factory.setRequestedHeartbeat(5);// 5秒心跳保持连接
		try {
			if (null==connection || !connection.isOpen()) {
				String ipNext = Config.getProperty("mq.next.ip");
				Address[] addresses = { new Address(ipNext) };
				connection = factory.newConnection(addresses);
			}
			
			if (null==channel || !channel.isOpen()) {
				// creating a channel
				channel = connection.createChannel();
			}
			
			// declaring a queue for this channel. If queue does not exist,
			// it will be created on the server.
			if (StringUtils.isNotBlank(queueName)) {
				channel.queueDeclare(queueName, durable, false, false, null);
			}
			
		} catch (Exception e) {
			String errorStr = "队列初始化异常：" + e;
			LoggerUtils.error(getClass(), errorStr);
		}
	}

	/**
	 * 关闭channel和connection。并非必须，因为隐含是自动调用的。
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		channel.close();
		connection.close();
	}
}

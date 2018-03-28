package com.chnghx.web.common.config;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.utils.LoggerUtils;

/**
 * 
* 项目名称：demo   
* 类名称：WeChatConfig   
* 类描述：   
* 创建人：guohaixiang  
* 创建时间：2018年3月19日 上午11:22:45   
* 修改人：Administrator   
* 修改时间：2018年3月19日 上午11:22:45   
* 修改备注：   
* @version 1.0
*
 */
public class WeChatConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/wechat.properties";
	
	private WeChatConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(WeChatConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
			LoggerUtils.error(WeChatConfig.class, "配置文件读取出现IOException异常", e);
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		return value;
	}
}

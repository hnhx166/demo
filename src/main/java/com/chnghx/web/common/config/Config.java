package com.chnghx.web.common.config;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.utils.LoggerUtils;

public class Config {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/config.properties";
	
	private Config() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(Config.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
			LoggerUtils.error(Config.class, "配置文件读取出现IOException异常", e);
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		return value;
	}
}

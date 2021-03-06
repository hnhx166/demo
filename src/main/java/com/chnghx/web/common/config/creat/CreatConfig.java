package com.chnghx.web.common.config.creat;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.utils.LoggerUtils;
public class CreatConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/creat/creat_url.properties";
	
	private CreatConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(CreatConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			LoggerUtils.error(CreatConfig.class, "配置文件/creat/creat_url.properties读取出现IOException异常", e);
			e.printStackTrace();
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		LoggerUtils.error(CreatConfig.class, "读取 /creat/creat_url.properties , key = " + key  + ", value = " + value, null);
		return value;
	}
}

package com.chnghx.web.common.config.care;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.utils.LoggerUtils;


public class CareConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/care/care_url.properties";
	
	private CareConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(CareConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			LoggerUtils.error(CareConfig.class, "配置文件/care/care_url.properties读取出现IOException异常", e);
			e.printStackTrace();
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		LoggerUtils.error(CareConfig.class, "读取/care/care_url.properties , key = " + key  + ", value = " + value, null);
		return value;
	}
}

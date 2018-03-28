package com.chnghx.web.common.config.agedcare;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.utils.LoggerUtils;


public class AgedcareConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/agedcare/agedcare_url.properties";
	
	private AgedcareConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(AgedcareConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			LoggerUtils.error(AgedcareConfig.class, "配置文件/agedcare/agedcare_url.properties读取出现IOException异常", e);
			e.printStackTrace();
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		LoggerUtils.error(AgedcareConfig.class, "读取 /agedcare/agedcare_url.properties , key = " + key  + ", value = " + value, null);
		return value;
	}
}

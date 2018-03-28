package com.chnghx.web.common.config.mobile;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.config.MemberConfig;
import com.chnghx.web.common.utils.LoggerUtils;

public class MobileConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/mobile/mobile_url.properties";
	
	private MobileConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(MobileConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
			LoggerUtils.error(MobileConfig.class, "配置文件/mobile/mobile_url.properties读取出现IOException异常", e);
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		LoggerUtils.error(MemberConfig.class, "读取/mobile/mobile_url.properties , key = " + key  + ", value = " + value, null);
		return value.trim();
	}
}

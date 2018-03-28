package com.chnghx.web.common.config;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.utils.LoggerUtils;

public class MemberConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/member/member_url.properties";
	
	private MemberConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(MemberConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			LoggerUtils.error(MemberConfig.class, "配置文件/member/member_url.properties读取出现IOException异常", e);
			e.printStackTrace();
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		LoggerUtils.error(MemberConfig.class, "读取 /member/member_url.properties , key = " + key  + ", value = " + value, null);
		return value;
	}
}

package com.chnghx.web.common.config.jd;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.config.MemberConfig;
import com.chnghx.web.common.utils.LoggerUtils;

public class JdConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/jd/jd.properties";
	
	private JdConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(JdConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			e.printStackTrace();
			LoggerUtils.error(JdConfig.class, "配置文件/jd/jd.properties读取出现IOException异常", e);
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		LoggerUtils.error(MemberConfig.class, "读取/jd/jd.properties , key = " + key  + ", value = " + value, null);
		return value;
	}
	public static String getUrlProperty(String key){
		String value = prop.getProperty("jd.url."+key);
		LoggerUtils.error(MemberConfig.class, "读取/jd/jd.properties , key = " + key  + ", value = " + value, null);
		return value;
	}
	
//	public static String ACCESS_TOKEN=prop.getProperty("jd.access_token");
	public static String REFRESH_TOKEN=prop.getProperty("jd.refresh_token");
	public static String CLIENT_ID=prop.getProperty("jd.client_id");
	public static String CLIENT_SECRET=prop.getProperty("jd.client_secret");
	public static String USERNAME=prop.getProperty("jd.username");
	public static String PASSWORD=prop.getProperty("jd.password");
}

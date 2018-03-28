package com.chnghx.web.common.config.express;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.utils.LoggerUtils;
public class ExpressConfig {

	/**
	 * 配置文件
	 */
	private static Properties prop = null;
	
	
	/**
	 * 配置文件名称
	 */
	private final static String FILE_NAME = "/express/express_url.properties";
	
	private ExpressConfig() {
	}
	static{
		prop = new Properties();
		try {
			prop.load(ExpressConfig.class.getResourceAsStream(FILE_NAME));
		} catch (IOException e) {
			LoggerUtils.error(ExpressConfig.class, "配置文件/express/express_url.properties读取出现IOException异常", e);
			e.printStackTrace();
		}
	}

	public static String getProperty(String key){
		String value = prop.getProperty(key);
		LoggerUtils.error(ExpressConfig.class, "读取 /express/express_url.properties , key = " + key  + ", value = " + value, null);
		return value;
	}
}

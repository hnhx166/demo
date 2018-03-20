package com.chnghx.web.common.config.mobile;

import java.io.IOException;
import java.util.Properties;

import com.chnghx.web.common.VCache;
import com.chnghx.web.common.config.MemberConfig;
import com.chnghx.web.common.utils.LoggerUtils;

/**
 * 
 * 开发公司：九樱天下<br/>
 * 版权：九樱天下<br/>
 * <p>
 * 
 * <p>
 * 
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2014年5月29日 　<br/>
 * <p>
 *  
 *  
 * <p>
 * @author zhou-baicheng
 * 
 * @version 1.0,2014年12月59日 <br/>
 * 
 */

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

package com.chnghx.web.common.utils;

import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.MapConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;


public class PinYinPropertiesManager {
	private static final Logger logger = Logger.getLogger(PinYinPropertiesManager.class);
	
	private static Configuration config = null;
	static { new PinYinPropertiesManager(); }

	private PinYinPropertiesManager() {
		try {
			PropertiesConfiguration p=new PropertiesConfiguration();
			p.setEncoding("UTF-8");
			p.load("pinyin.properties");
			config = p;
			((PropertiesConfiguration) config).setReloadingStrategy(new FileChangedReloadingStrategy());
			logger.info("配置文件读取成功....");
		} catch (Throwable e) {
			config = new MapConfiguration(new HashMap<String,Object>());
			logger.debug("配置文件读取失败:"+e.getStackTrace());
		}
	}
	
	  public static boolean getBoolean(String key, boolean defaultValue) {
	    return config.getBoolean(key, defaultValue);
	  }

	  public static Boolean getBoolean(String key, Boolean defaultValue) {
	    return config.getBoolean(key, defaultValue);
	  }

	  public static boolean getBoolean(String key) {
	    return config.getBoolean(key);
	  }
	  
	  /**
	   * 方法描述: 获取类型为 double 的值
	   * @param key           
	   * @param defaultValue  默认值
	   * @return  double
	   * @author wuqiong  2014-11-27  上午11:02:14
	   */
	  public static double getDouble(String key, double defaultValue) {
	    return config.getDouble(key, defaultValue);
	  }

	  public static Double getDouble(String key, Double defaultValue) {
	    return config.getDouble(key, defaultValue);
	  }

	  public static double getDouble(String key) {
	    return config.getDouble(key);
	  }

	  public static float getFloat(String key, float defaultValue) {
	    return config.getFloat(key, defaultValue);
	  }

	  public static Float getFloat(String key, Float defaultValue) {
	    return config.getFloat(key, defaultValue);
	  }

	  public static float getFloat(String key) {
	    return config.getFloat(key);
	  }

	  public static int getInt(String key, int defaultValue) {
	    return config.getInt(key, defaultValue);
	  }

	  public static int getInt(String key) {
	    return config.getInt(key);
	  }

	  public static Integer getInteger(String key, Integer defaultValue) {
	    return config.getInteger(key, defaultValue);
	  }

	  public static long getLong(String key, long defaultValue) {
	    return config.getLong(key, defaultValue);
	  }

	  public static Long getLong(String key, Long defaultValue) {
	    return config.getLong(key, defaultValue);
	  }

	  public static long getLong(String key) {
	    return config.getLong(key);
	  }

	  public static Properties getProperties(String key) {
	    return config.getProperties(key);
	  }

	  public static Object getProperty(String key) {
	    return config.getProperty(key);
	  }
	  public static String getString(String key) {
	    return config.getString(key, "");
	  }
	  /**
	   * 方法描述: 获取String类型的值
	   * @param key 
	   * @param defaultValue  默认值
	   * @return  String
	   * @author wuqiong  2014-11-27  上午11:03:20
	   */
	  public static String getString(String key, String defaultValue) {
		return config.getString(key, defaultValue);
	  }

	  public static String[] getStringArray(String key) {
	    return config.getStringArray(key);
	  }

	  public static void setProperty(String key, Object value) {
	    config.setProperty(key, value);
	  }
	
	/**
	 * 方法描述:
	 * @param args  void
	 * @author wuqiong  2015-6-8  上午10:43:14
	 */
	public static void main(String[] args) {
		String value = PinYinPropertiesManager.getString("hang");
	    System.out.println("显示出来的字体为："+value);
	}

}

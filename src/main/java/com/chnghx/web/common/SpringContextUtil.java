package com.chnghx.web.common;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

import com.chnghx.web.common.utils.LoggerUtils;

public class SpringContextUtil implements ApplicationContextAware,
		ServletContextAware {

	private static ApplicationContext applicationContext;
	private static ServletContext servletContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext context) {
		servletContext = context;
	}
	
	
	public static <T> T getBean(String name, Class<T> requiredType) {
		try {
			return applicationContext.getBean(name, requiredType);
		} catch (Exception e) {
			LoggerUtils.error(SpringContextUtil.class, "SpringContextUtil 获取Bean出错 ,  <T> T getBean", e);
		}
		return null;
		
	}
	
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
		
	}

}

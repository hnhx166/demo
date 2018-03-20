package com.chnghx.core.freemarker;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModelException;

public class FreeMarkerConfigExtend extends FreeMarkerConfigurer{
	
	public void afterPropertiesSet() throws IOException, TemplateException{
		super.afterPropertiesSet();
		Configuration cfg = getConfiguration();
		
//		put(cfg, "TimeFormat", new TimeFormat());
	}

	private static void put(Configuration cfg, String k, Object v) throws TemplateModelException{
		cfg.setSharedVariable(k, v);
	}
}

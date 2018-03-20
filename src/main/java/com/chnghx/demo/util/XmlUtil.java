package com.chnghx.demo.util;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

public class XmlUtil {
	
	public static String pojo2Xml(Object obj)
	  {
	    String xmlStr = "";
	    if (obj == null) {
	      return null;
	    }
	    if (((obj instanceof Map)) || ((obj instanceof Collection)) || ((obj instanceof Dictionary))) {
	      throw new RuntimeException("Object type must be pojo");
	    }
	    if ((obj instanceof String))
	    {
	      xmlStr = (String)obj;
	    }
	    else
	    {
	      //带下划线的属性转换
	      XStream xstream = new XStream(new DomDriver("utf-8",new XmlFriendlyNameCoder("__", "_")));
	      xstream.processAnnotations(obj.getClass());
	      xstream.alias("xml", obj.getClass());
	      xmlStr = xstream.toXML(obj);
	    }
	    return xmlStr;
	  }

	public static <T> T xml2Bean(String xmlStr, Class<T> cls)
	  {
	    XStream xstream = new XStream(new DomDriver("utf8"));
	    
	    xstream.processAnnotations(cls);
	    xstream.alias("xml", cls);
	    T obj = (T)xstream.fromXML(xmlStr);
	    return obj;
	  }
	
	public static <T> T xml2JSON(String xmlStr, Class<T> cls)
	  {
	    XStream xstream = new XStream(new JettisonMappedXmlDriver());
	    
	    xstream.processAnnotations(cls);
	    xstream.alias("xml", cls);
	    T obj = (T)xstream.fromXML(xmlStr);
	    return obj;
	  }
	
	public static String fomatXmlStr(String xml)
	  {
	    String formatStr = "";
	    Pattern p = Pattern.compile("\t|\r|\n");
	    Scanner scanner = new Scanner(xml);
	    scanner.useDelimiter(p);
	    while (scanner.hasNext()) {
	      formatStr = formatStr + scanner.next().trim();
	    }
	    return formatStr;
	  }
}

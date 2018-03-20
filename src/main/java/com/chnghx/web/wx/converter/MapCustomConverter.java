package com.chnghx.web.wx.converter;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.collections.AbstractCollectionConverter;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class MapCustomConverter extends AbstractCollectionConverter {

	public MapCustomConverter(Mapper mapper) {
		super(mapper);
	}

	@Override
	public boolean canConvert(Class type) {
		return type.equals(Map.class)
		|| type.equals(HashMap.class)
        || type.equals(Hashtable.class)
        || type.getName().equals("java.util.LinkedHashMap")
        || type.getName().equals("sun.font.AttributeMap"); // Used by java.awt.Font in JDK 6
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		Map map = (Map) source;  
        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {  
            Entry entry = (Entry) iterator.next();  
            ExtendedHierarchicalStreamWriterHelper.startNode(writer, entry.getKey().toString(), Entry.class);  
            writer.addAttribute("key",  entry.getKey().toString());  
            writer.addAttribute("value", entry.getValue().toString());  
            writer.endNode();  
        }
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		 Map map = (Map) createCollection(context.getRequiredType());  
	        populateMap(reader, context, map);  
	        return map; 
	}
	
	protected void populateMap(HierarchicalStreamReader reader, UnmarshallingContext context, Map map) {  
        while (reader.hasMoreChildren()) {  
            reader.moveDown();  
            Object key = reader.getAttribute("key");  
            Object value = reader.getAttribute("value");  
            map.put(key, value);  
            reader.moveUp();  
        }  
    } 
	
	
	public static void main(String[] args) {
		String xml = "<xml><returncode><![CDATA[SUCCESS]]></returncode><returnmsg><![CDATA[OK]]></returnmsg><appid><![CDATA[wxc9dde155ff734260]]></appid><mchid><![CDATA[1334253201]]></mchid><noncestr><![CDATA[7MWWdHD8bbQTghNj]]></noncestr><sign><![CDATA[1BF9DB4C7EAB53BF3B11FCC6731BFF94]]></sign><resultcode><![CDATA[SUCCESS]]></resultcode><prepayid><![CDATA[wx201710101438152488836e3b0255939485]]></prepayid><tradetype><![CDATA[APP]]></tradetype></xml>";
//		XStream xstream = new XStream(new Dom4JDriver());  
//		xstream.registerConverter(new MapConverter(new DefaultMapper(XStream.class.getClassLoader())));  
//	    xstream.alias("xml", HashMap.class);
//	    Map m  = (Map)xstream.fromXML(xml);
		
		
		XMLSerializer xmlSerializer=new XMLSerializer();
        JSON json=xmlSerializer.read(xml);
	    System.out.println(json);
	}
	

}

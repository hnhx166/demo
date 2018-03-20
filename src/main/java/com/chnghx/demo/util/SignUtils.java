package com.chnghx.demo.util;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.chnghx.demo.util.sign.Md5Sign;

public class SignUtils {

	public static String buildSign(TreeMap signMap, String salt){
		StringBuffer singStr = new StringBuffer();
		Iterator iterator = signMap.entrySet().iterator();
	    while (iterator.hasNext())
	    {
	      Object entry = (Map.Entry)iterator.next();
	      singStr.append((String)((Map.Entry)entry).getKey() + "=" + (String)((Map.Entry)entry).getValue() + "&");
//	      if ((((Map.Entry)entry).getValue() != null) && (((String)((Map.Entry)entry).getValue()).trim().length() > 0)) {
//	    	  singStr.append((String)((Map.Entry)entry).getKey() + "=" + (String)((Map.Entry)entry).getValue() + "&");
//	      }
	    }
	    singStr.append("key=").append(salt);
	    String result = Md5Sign.sign(singStr.toString(), "MD5", null);
	    return result;
	}
}

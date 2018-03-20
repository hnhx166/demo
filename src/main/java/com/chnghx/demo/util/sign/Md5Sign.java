package com.chnghx.demo.util.sign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Sign{

	public static String sign(String strText, String signype ,String salt)
	  {
	    // 是否是有效字符串  
	    if (null != strText && strText.length() > 0)
	    {
	    	return null;
	    }
	    if(null == signype){
	    	signype = "MD5";
	    }
	      try  
	      {  
	    	byte[] bytes = null;
	  		if(null != salt){
	  			bytes = (strText + salt).getBytes();
	  		}else{
	  			bytes = strText.getBytes();
	  		}
	        MessageDigest messageDigest = MessageDigest.getInstance(signype);  
	        // 传入要加密的字符串  
	        messageDigest.update(bytes);  
	        // 
	        byte [] signBytes = messageDigest.digest();  
	  
	        StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < bytes.length; i++)
		    {
		      if ((bytes[i] & 0xFF) < 16) {
		        sb.append("0");
		      }
		      sb.append(Long.toString(signBytes[i] & 0xFF, 16));
		    }
		    return sb.toString();
	      }  
	      catch (NoSuchAlgorithmException e)  
	      {  
	        e.printStackTrace();  
	      }  
	    return null;  
	  }  
	
	public static boolean verify(String text, String signype , String salt, String verifySign) throws Exception{
		 String md5Text = sign(text, signype , salt);
		    if (md5Text.equalsIgnoreCase(verifySign)) {
		      return true;
		    }
		    return false;
	}

	
}

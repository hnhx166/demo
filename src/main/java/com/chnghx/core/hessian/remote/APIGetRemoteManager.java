package com.chnghx.core.hessian.remote;

import java.net.MalformedURLException;

import com.caucho.hessian.client.HessianProxyFactory;

public class APIGetRemoteManager {

	@SuppressWarnings("unchecked")
	public   static <T> T   getAPIServiceBean(String  url,Class<T> api){
		 HessianProxyFactory factory = new HessianProxyFactory();
		 try {
		  return (T) factory.create(api, url);
		 } catch (MalformedURLException e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		return null;
	}   
}

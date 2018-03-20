package com.chnghx.test.jd;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang.StringUtils;

import sdk.vinux.core.utils.SslUtils;

import com.chnghx.web.common.utils.LoggerUtils;
import com.vinux.util.SSLProtocolSocketFactory;


 
public class JdClientPostMethod extends PostMethod {

	public final static String JSONObject = "JSONObject";
	public final static String JSONArray = "JSONArray";
	
	private String systemType = "vinuxpost_jd";
//	private String processMode = "sync";//默认同步方式 //由被调用接口写死
//	private String module = "get userinfo by sessionid"//模块放到ＡＰＩｃｅｎｔｅｒ写死

	
	//自定义请求头信息
	private List<Header> headers = new ArrayList<Header>();

	private int timeOut = 60000 ;//默认超时时间

	/**
	 * 直接返回对应类型
	 * @param <T>
	 * @param requiredType  支持[net.sf.json.JSONArray,net.sf.json.JSONObject,String]
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T executeMethod(Class<T> requiredType) {
		if (null == requiredType) {
			return null;
		}
		if ("net.sf.json.JSONArray".equals(requiredType
				.getCanonicalName())) {
			return (T)executeMethod(JSONArray);
		}
		if ("net.sf.json.JSONObject".equals(requiredType
				.getCanonicalName())) {
			return (T)executeMethod(JSONObject);
		}
		return (T) (executeMethod());
	}
	private String timestamp(){
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return time.format(new Date());
	}
	/***
	 * 执行方法 type 可以不传，默认返回String
	 * 
	 * @param type
	 *            [JSONObject,JSONArray]
	 * @return
	 */
	public Object executeMethod(String... type) {
		try {
			HttpClient client = new HttpClient();
			HttpClientParams params = client.getParams();
			//调用方系统类型
			headers.add(new Header("systemType", systemType));
//			headers.add(new Header(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8"));
//			headers.add(new Header("Connection","close"));
			//调用时间
			headers.add(new Header("rd", new Date().getTime()+""));
			if(!headers.isEmpty()){
				client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
			}
			params.setParameter("Connection","close");
			/**
			 * 请求超时时间
			 * 如果需要调整，请setTimeOut(自定义时间(单位毫秒))
			 */
	        client.getHttpConnectionManager().getParams().setConnectionTimeout(getTimeOut());
	        //设置编码
			params.setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");

			int status = 0;
			String result = null;
			String apiUrl = this.getURI().toString();
			if ((StringUtils.isNotEmpty(apiUrl))&& (apiUrl.startsWith("https"))) {
				try{
					SslUtils.ignoreSsl();
					status = client.executeMethod(this);
				}catch (Exception e) {
					HostnameVerifier hv = new HostnameVerifier() {
			            public boolean verify(String urlHostName, SSLSession session) {
			                System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
			                return true;
			            }
			        };
					e.printStackTrace();
					Protocol vhttps = new Protocol("https", new SSLProtocolSocketFactory(), 443);
					Protocol.registerProtocol("https", vhttps);
					  HttpsURLConnection.setDefaultHostnameVerifier(hv);
					status = client.executeMethod(this);
				}
			}else{
				status = client.executeMethod(this);
			}
			
			if (status == HttpStatus.SC_OK) {
				try {
					result = this.getResponseBodyAsString();
				} catch (IOException e) {
					e.printStackTrace();
					LoggerUtils.error(this.getClass(), "客户端HttpClient异常, getResponseBodyAsString 异常", e);
				}
			} 
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.releaseConnection();
		}
		return null;
	}

	/**
	 * 设置参数List<Map<String, Object>>
	 * 
	 * @param parameter
	 */
	public void setParameter(List<Map<String, Object>> parameter) {
		for (Map<String, Object> map : parameter) {
			setParameter(map);
		}
	}

	/**
	 * 设置参数Map<String, Object>
	 * 
	 * @param parameter
	 */
	public void setParameter(Map<String, Object> parameter) {
		for (String key : parameter.keySet()) {
			Object str = parameter.get(key);
//			String value = null == str ? "" : StringUtils.trimToEmpty(str.toString());
			this.addParameter(key, str.toString());
		}
	}

	/**
	 * 构造方法begin
	 */
	public JdClientPostMethod(String url) {
		super(url);
	}

	public JdClientPostMethod(List<Map<String, Object>> parameter) {
		super();
		this.setParameter(parameter);
	}

	public JdClientPostMethod(String url, List<Map<String, Object>> parameter) {
		super(url);
		this.setParameter(parameter);
	}

	public JdClientPostMethod(Map<String, Object> parameter) {
		super();
		this.setParameter(parameter);
	}

	public JdClientPostMethod(String url, Map<String, Object> parameter) {
		super(url);
		this.setParameter(parameter);
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	
	
	public List<Header> getHeaders() {
		return headers;
	}

	public void setHeaders(List<Header> headers) {
		this.headers = headers;
	}
	

}

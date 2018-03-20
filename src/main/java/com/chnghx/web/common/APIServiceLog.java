package com.chnghx.web.common;

import java.io.Serializable;
import java.util.Map;

public class APIServiceLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8307071952649389309L;

	/** 一 ：客户端请求参数#######################################################################
	 * 
	 **/
	// 1：客户端host
	String clientHost = "";

	// 2：客户端应用名称
	String clientApplication = "";

	// 3：客户端业务模块功能
	String clientModule = "";

	// 4：客户端请求URL
	String clientUrl = "";

	// 5：客户端请求头信息（包含秘钥）
	Map<String, Object> clientHead = null;

	// 6：客户端请求参数
	Map<String, Object> clientParam = null;

	// 7：客户端请求结果状态码(A100：接受成功,A200：处理成功,A500：处理失败)
	String clientCode = "";

	// 8：客户端请求结果信息(JSON)
	APIResult<Object> clientResult = null;

	// 9：客户端请求接口中心开始时间（开始与结束时间差---同步时：时间差代表整个请求时间，异步时：时间差表示接受时间)
	long clientStartTime = 0L;

	// 10：客户端请求接口中心结束时间(异步时：接口中心请求服务端开始时间差代表异步等待时间）
	long clientEndTime = 0L;

	// 11：客户端请求接口中心异常
	String clientException = "";

	/** 二：接口中心参数#########################################################################
	 * 
	 */
	// 12：接口中心host
	String apiHost = "";

	// 13：接口中心服务版本
	String apiVersion = "1.0";

	// 14：接口中心处理请求方式(sync：同步处理, cache:同步加缓存处理,async：异步处理 )
	String processMode = "sync";

	/**
	 * 三：调用各个服务##########################################################################
	 *    (目前只调一个服务接口，多个服务接口合并暂时不考虑）
	 **/
	// 15：服务端请求URL
	String serverUrl = "";

	// 16：服务端请求头信息(包含秘钥）
	Map<String, Object> ServerHead = null;

	// 17：服务端请求参数
	Map<String, Object> ServerParam = null;
	// 18：服务端请求结果状态码(S200:处理成功,S501：请求服务端失败)
	String serverCode = "";

	// 19：服务端请求结果信息(JSON)
	String serverResult = "{}";

	// 20：接口中心请求服务端开始时间
	long serverStartTime = 0L;

	// 21：接口中心请求服务端结束时间
	long serverEndTime = 0L;

	// 22：接口中心请求服务端异常
	String serverException = "";

	/** 四：异步回调各个服务#######################################################################
	 * 
	 **/

	// 23：接口中心通知客户端请求URL
	String notifyUrl = "";

	// 24：接口中心通知客户端请求头信息(包含秘钥）
	Map<String, Object> notifyHead = null;

	// 25：接口中心通知客户端请求参数
	Map<String, Object> notifyParam = null;

	// 26：接口中心通知客户端返回结果状态码(C200：处理成功,C502：回调客户端失败)
	String notifyCode = "";

	// 27：接口中心通知客户端返回结果信息(JSON)
	String notifyResult = "{}";

	// 28：接口中心通知客户端开始时间
	long notifyStartTime = 0L;

	// 29：接口中心通知客户端结束时间
	long notifyEndTime = 0L;

	// 30：接口中心通知客户端异常
	String notifyException = "";

	public String getClientHost() {
		return clientHost;
	}

	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}

	public String getClientApplication() {
		return clientApplication;
	}

	public void setClientApplication(String clientApplication) {
		this.clientApplication = clientApplication;
	}

	public String getClientModule() {
		return clientModule;
	}

	public void setClientModule(String clientModule) {
		this.clientModule = clientModule;
	}

	public String getClientUrl() {
		return clientUrl;
	}

	public void setClientUrl(String clientUrl) {
		this.clientUrl = clientUrl;
	}

	public Map<String, Object> getClientHead() {
		return clientHead;
	}

	public void setClientHead(Map<String, Object> clientHead) {
		this.clientHead = clientHead;
	}

	public Map<String, Object> getClientParam() {
		return clientParam;
	}

	public void setClientParam(Map<String, Object> clientParam) {
		this.clientParam = clientParam;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public APIResult<Object> getClientResult() {
		return clientResult;
	}

	public void setClientResult(APIResult<Object> clientResult) {
		this.clientResult = clientResult;
	}

	public long getClientStartTime() {
		return clientStartTime;
	}

	public void setClientStartTime(long clientStartTime) {
		this.clientStartTime = clientStartTime;
	}

	public long getClientEndTime() {
		return clientEndTime;
	}

	public void setClientEndTime(long clientEndTime) {
		this.clientEndTime = clientEndTime;
	}

	public String getClientException() {
		return clientException;
	}

	public void setClientException(String clientException) {
		this.clientException = clientException;
	}

	public String getApiHost() {
		return apiHost;
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getProcessMode() {
		return processMode;
	}

	public void setProcessMode(String processMode) {
		this.processMode = processMode;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
	}

	public Map<String, Object> getServerHead() {
		return ServerHead;
	}

	public void setServerHead(Map<String, Object> serverHead) {
		ServerHead = serverHead;
	}

	public Map<String, Object> getServerParam() {
		return ServerParam;
	}

	public void setServerParam(Map<String, Object> serverParam) {
		ServerParam = serverParam;
	}

	public String getServerCode() {
		return serverCode;
	}

	public void setServerCode(String serverCode) {
		this.serverCode = serverCode;
	}

	public String getServerResult() {
		return serverResult;
	}

	public void setServerResult(String serverResult) {
		this.serverResult = serverResult;
	}

	public long getServerStartTime() {
		return serverStartTime;
	}

	public void setServerStartTime(long serverStartTime) {
		this.serverStartTime = serverStartTime;
	}

	public long getServerEndTime() {
		return serverEndTime;
	}

	public void setServerEndTime(long serverEndTime) {
		this.serverEndTime = serverEndTime;
	}

	public String getServerException() {
		return serverException;
	}

	public void setServerException(String serverException) {
		this.serverException = serverException;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public Map<String, Object> getNotifyHead() {
		return notifyHead;
	}

	public void setNotifyHead(Map<String, Object> notifyHead) {
		this.notifyHead = notifyHead;
	}

	public Map<String, Object> getNotifyParam() {
		return notifyParam;
	}

	public void setNotifyParam(Map<String, Object> notifyParam) {
		this.notifyParam = notifyParam;
	}

	public String getNotifyCode() {
		return notifyCode;
	}

	public void setNotifyCode(String notifyCode) {
		this.notifyCode = notifyCode;
	}

	public String getNotifyResult() {
		return notifyResult;
	}

	public void setNotifyResult(String notifyResult) {
		this.notifyResult = notifyResult;
	}

	public long getNotifyStartTime() {
		return notifyStartTime;
	}

	public void setNotifyStartTime(long notifyStartTime) {
		this.notifyStartTime = notifyStartTime;
	}

	public long getNotifyEndTime() {
		return notifyEndTime;
	}

	public void setNotifyEndTime(long notifyEndTime) {
		this.notifyEndTime = notifyEndTime;
	}

	public String getNotifyException() {
		return notifyException;
	}

	public void setNotifyException(String notifyException) {
		this.notifyException = notifyException;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

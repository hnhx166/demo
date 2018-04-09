package com.chnghx.core.mq;

import java.io.Serializable;
import java.util.Date;

public class SystemLog implements Serializable {

	private static final long serialVersionUID = 7913370117433376949L;
	// 第三方请求url
	private String url;
	// 第三方请求参数
	private String param;
	// 第三方返回结果
	private String result;
	// 创建时间
	private Long time;
	// 创建日期
	private Date dateTime;

	// local执行class名称
	private String className;
	// local执行method名称
	private String methodName;
	// local执行method参数
	private String methodParam;
	// local执行method结果
	private String methodMessage;

	// 数据处理方式
	private String dealType;
	// 各个系统编号
	private String systemType;
	// 系统具体小业务流程
	private String businessType;
	// 主键或者索引ID
	private String indexID;
	// 其他属性字段
	private String other;

	// 日志级别
	private String success;
	// 接口统计
	private String api;
	// 域名统计
	private String domain;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodParam() {
		return methodParam;
	}

	public void setMethodParam(String methodParam) {
		this.methodParam = methodParam;
	}

	public String getMethodMessage() {
		return methodMessage;
	}

	public void setMethodMessage(String methodMessage) {
		this.methodMessage = methodMessage;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getIndexID() {
		return indexID;
	}

	public void setIndexID(String indexID) {
		this.indexID = indexID;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}

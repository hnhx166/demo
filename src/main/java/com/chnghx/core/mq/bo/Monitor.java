package com.chnghx.core.mq.bo;

import java.io.Serializable;
import java.util.Map;

public class Monitor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5325400466893122841L;
	// 时间戳
	public long timestamp;
	// 指标项(websession,basic,datasource,sql,webapp,weburi,websession)
	public String metrics;
	// 指标值
	public Object result;
	// 详情
	public Object detail;
	// 系统与域名与IP分组
	public Map<String, Object> tags;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMetrics() {
		return metrics;
	}

	public void setMetrics(String metrics) {
		this.metrics = metrics;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getDetail() {
		return detail;
	}

	public void setDetail(Object detail) {
		this.detail = detail;
	}

	public Map<String, Object> getTags() {
		return tags;
	}

	public void setTags(Map<String, Object> tags) {
		this.tags = tags;
	}

}

package com.chnghx.core.monitor.trace;

import java.util.Date;
import java.util.Map;

public class TraceBody {
	
    //跟踪ID
    public String TraceId ;

    //上下文ID
    public double RpcId ;

    //处理时间
    public Date LastTime ;
    
    //标签(指标)
    public Map<String, Object> tags;

	public String getTraceId() {
		return TraceId;
	}

	public void setTraceId(String traceId) {
		TraceId = traceId;
	}
    
	public double getRpcId() {
		return RpcId;
	}

	public void setRpcId(double rpcId) {
		RpcId = rpcId;
	}

	public Date getLastTime() {
		return LastTime;
	}

	public void setLastTime(Date lastTime) {
		LastTime = lastTime;
	}

	public Map<String, Object> getTags() {
		return tags;
	}

	public void setTags(Map<String, Object> tags) {
		this.tags = tags;
	}
    
}

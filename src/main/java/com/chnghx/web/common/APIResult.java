package com.chnghx.web.common;

import java.io.Serializable;
/**
 * 
*    
* 项目名称：demo   
* 类名称：APIResult   
* 类描述：   调用公共接口返回的结果集
* 创建人：guohaixiang  
* 创建时间：2018年3月28日 下午3:46:33   
* 修改人：Administrator   
* 修改时间：2018年3月28日 下午3:46:33   
* 修改备注：   
* @version 1.0
*
 */
public class APIResult<V> implements Serializable{
	
	private static final long serialVersionUID = -7925016012331196255L;
	/**返回状态，
	 * 处理中：A100
	 * 成功：A200，
	 * 失败：A500，
	 * 备用成功：A300，(如重复提交，重复执行等，即可返回A300，表示已经提交过了)
	 * 其他具体情况自定义 
	 * */
	private String status ;
	/**
	 * 返回具体执行信息
	 */
	private String message;
	/**
	 * V V根据在new APIResult<V>的时候，如果V是存储一个User对象，那么就new APIResult<User>();
	 * 可以达到不用强转，直接Get即可获取。
	 */
	private V result ;

	public APIResult() {
		super();
	}
	public APIResult(String status,String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public APIResult(String status,String message,V result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result ;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public V getResult() {
		return result;
	}
	public void setResult(V result) {
		this.result = result;
	}

	
	
	
}

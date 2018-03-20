package com.chnghx.demo.bo;

import java.io.Serializable;

public class SceneInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2806165095659915278L;
	private String id;//String(32)门店唯一标识 
	private String name;//String(64)门店名称 
	private String area_code;//String(6)门店所在地行政区划码
	private String address;//String(128)门店详细地址 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea_code() {
		return area_code;
	}
	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

package com.chnghx.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class Catalog {

	public Catalog() {}
	public Catalog(String catalogName, int num) {
		this.catalogName = catalogName;
		this.num = num;
	}
	
	private String catalogName;
	private int num;
	private List<Catalog> children;
	
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<Catalog> getChildren() {
		return children;
	}
	public void setChildren(List<Catalog> children) {
		this.children = children;
	}
	
	public void sortChildren() {
		sort(this.children);
//		if(CollectionUtils.isNotEmpty(this.children)) {
//		    Collections.sort(this.children, new Comparator<Catalog>() {
//		        public int compare(Catalog o1, Catalog o2) {
//		            if(o1.getNum() < o2.getNum()) {
//		            	return -1;
//		            }else if(o1.getNum() > o2.getNum()) {
//		            	return 1;
//		            }else {
//		            	return 0;
//		            }
//		        }
//		    });
//		}
	}
	
	public void sort(List<Catalog> list) {
		if(CollectionUtils.isNotEmpty(list)) {
		    Collections.sort(list, new Comparator<Catalog>() {
		        public int compare(Catalog o1, Catalog o2) {
		            if(o1.getNum() < o2.getNum()) {
		            	return -1;
		            }else if(o1.getNum() > o2.getNum()) {
		            	return 1;
		            }else {
		            	return 0;
		            }
		        }
		    });
		}
	}
}

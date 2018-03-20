package com.chnghx.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class ListObjectSort {
	
//	
//	// 进行降序排列
//    Collections.sort(list, new Comparator<ResultTypeDesc>() {
//        public int compare(ResultTypeDesc o1, ResultTypeDesc o2) {
//            return o2.getRatio().compareTo(o1.getRatio());
//        }
//    });
//
//
//
//    //进行升序排列
//    Collections.sort(list, new Comparator<ResultTypeDesc>() {
//        public int compare(ResultTypeDesc o1, ResultTypeDesc o2) {
//            return o1.getRatio().compareTo(o2.getRatio());
//        }
//    });
	
	public static void sort(List<Catalog> list) {
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
	
	

	public static void main(String[] args) {
		
		Catalog root = new Catalog("根目录", 0);
		
		
		List<Catalog> data = new ArrayList<Catalog>();
		
		Catalog pc3 = new Catalog("第3个目录", 3);
		Catalog pc1 = new Catalog("第1个目录", 1);
		Catalog pc2 = new Catalog("第2个目录", 2);
		Catalog pc5 = new Catalog("第5个目录", 5);
		Catalog pc4 = new Catalog("第4个目录", 4);
		
		data.add(pc3);
		data.add(pc1);
		data.add(pc2);
		data.add(pc5);
		data.add(pc4);
		
		
		List<Catalog> children1 = new ArrayList<Catalog>();
		Catalog p1cc4 = new Catalog("第1个父节点目录4", 4);
		Catalog p1cc1 = new Catalog("第1个父节点目录1", 1);
		Catalog p1cc3 = new Catalog("第1个父节点目录3", 3);
		Catalog p1cc5 = new Catalog("第1个父节点目录5", 5);
		Catalog p1cc2 = new Catalog("第1个父节点目录2", 2);
		children1.add(p1cc4);
		children1.add(p1cc1);
		children1.add(p1cc3);
		children1.add(p1cc5);
		children1.add(p1cc2);
		pc1.setChildren(children1);
		
		
		List<Catalog> children2 = new ArrayList<Catalog>();
		Catalog p2cc1 = new Catalog("第2个父节点目录1", 1);
		Catalog p2cc3 = new Catalog("第2个父节点目录3", 3);
		Catalog p2cc5 = new Catalog("第2个父节点目录5", 5);
		Catalog p2cc2 = new Catalog("第2个父节点目录2", 2);
		Catalog p2cc4 = new Catalog("第2个父节点目录4", 4);
		children2.add(p2cc1);
		children2.add(p2cc3);
		children2.add(p2cc5);
		children2.add(p2cc2);
		children2.add(p2cc4);
		pc2.setChildren(children2);
		
		
		root.setChildren(data);
		
		for(Catalog pcatalog : data) {
			System.out.println("父节点名称：" + pcatalog.getCatalogName()  + " ， 父节点顺序" + pcatalog.getNum());
			List<Catalog> cc = pcatalog.getChildren();
			if(CollectionUtils.isNotEmpty(cc)) {
				for(Catalog ccatalog : cc) {
					System.out.println("****************子节点名称：" + ccatalog.getCatalogName()  + " ， 子节点顺序" + ccatalog.getNum());
				}
			}
		}
		
		System.out.println("***********************************************************");
		sort(data);
		for(Catalog pcatalog : data) {
			System.out.println("父节点名称：" + pcatalog.getCatalogName()  + " ， 父节点顺序" + pcatalog.getNum());
			List<Catalog> cc = pcatalog.getChildren();
			pcatalog.sortChildren();
			if(CollectionUtils.isNotEmpty(cc)) {
				for(Catalog ccatalog : cc) {
					System.out.println("****************子节点名称：" + ccatalog.getCatalogName()  + " ， 子节点顺序" + ccatalog.getNum());
				}
			}
		}

	}

}

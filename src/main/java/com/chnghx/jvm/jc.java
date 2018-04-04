package com.chnghx.jvm;

public class jc {

	public static void main(String[] args) {
		Object obj = new Object();
		System.gc();
		System.out.println();
		obj = new Object();
		obj = new Object();
		System.gc();
		System.out.println();
	}
}

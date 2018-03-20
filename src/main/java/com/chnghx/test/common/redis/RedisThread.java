package com.chnghx.test.common.redis;

import com.chnghx.web.common.VCache;

public class RedisThread implements Runnable {
	
	private final long liveTime = 300l;
	private int count = 10000;
	
	public void run() {
		for (int i = count; 0 < i; i--) {
			long s = System.currentTimeMillis();
			VCache.put(RedisThread.class.toString() + i, RedisThread.class.toString() + i, liveTime);
			long end = System.currentTimeMillis();
			if((end - s) >= 500){
				TestRedis.timeout++;
			}
		}
		System.out.println("###############################################################线程结束大于1秒的数量 ：" + TestRedis.timeout);
	}
	
}

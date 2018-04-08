package com.chnghx.core.shiro.session.cache;

import org.apache.shiro.cache.Cache;

public class JedisShiroCacheManager implements ShiroCacheManager{

	private JedisManager jedisManager;
	
	public JedisManager getJedisManager() {
		return jedisManager;
	}

	public void setJedisManager(JedisManager jedisManager) {
		this.jedisManager = jedisManager;
	}

	@Override
	public <K, V> Cache<K, V> getCache(String name) {
		return new JedisShiroCache<K, V>(name, getJedisManager());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

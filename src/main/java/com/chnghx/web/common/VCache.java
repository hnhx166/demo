package com.chnghx.web.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.chnghx.web.common.utils.LoggerUtils;

public final class VCache {

	static RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 
	 * @param key 缓存key
	 * @param value 缓存值
	 * @param liveTime 缓存时间(单位： 秒)
	 */
	public static void put(Object key, Object value, final long liveTime) {
		final String keyf = obj2Str(key);
		final Object valuef = value;

		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] keyb = keyf.getBytes();
				byte[] valueb = toByteArray(valuef);
				connection.set(keyb, valueb);
				if (liveTime > 0) {
					connection.expire(keyb, liveTime);
				}
				return 1L;
			}
		});
	}
	
	/**
	 * 根据key获取缓存
	 * @param key
	 * @return
	 */
	public final static Object get(Object key) {
		final String keyf = obj2Str(key);
		Object object = null;
		object = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {

				byte[] key = keyf.getBytes();
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				return toObject(value);

			}
		});
		
		ValueWrapper wrapper = (object != null ? new SimpleValueWrapper(object) : null);
        return wrapper == null ? null : (Object) wrapper.get();
	}
	
	/**
	 * 根据key获取缓存
	 * @param <T>
	 * @param key
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T get(Object key, Class<T> type) {
		final String keyf = obj2Str(key);
		Object object = null;
		object = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {

				byte[] key = keyf.getBytes();
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				return toObject(value);

			}
		});
		ValueWrapper wrapper = (object != null ? new SimpleValueWrapper(object) : null);
        return wrapper == null ? null : (T) wrapper.get();
	}
	
	/**
	 * 根据key删除缓存
	 * @param key
	 */
	public static void remove(Object key) {
		final String keyf = obj2Str(key);  
        redisTemplate.execute(new RedisCallback<Long>() {  
            public Long doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                return connection.del(keyf.getBytes());  
            }  
        });

	}
	
	
	
	
	
	public static String obj2Str(Object key) {
		String keyStr = null;
		if (key instanceof Integer) {
			keyStr = ((Integer) key).toString();
		} else if (key instanceof Long) {
			keyStr = ((Long) key).toString();
		} else {
			keyStr = (String) key;
		}
		return keyStr;
	}

	/**
	 * 描述 : <Object转byte[]>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param obj
	 * @return
	 */
	private static byte[] toByteArray(Object obj) {
		byte[] bytes = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
			bytes = bos.toByteArray();
			oos.close();
			bos.close();
		} catch (IOException ex) {
			LoggerUtils.error(VCache.class, "Object转byte[]出现IOException异常", ex);
		}
		return bytes;
	}

	
	/** 
     * 描述 : <byte[]转Object>. <br> 
     * <p> 
     * <使用方法说明> 
     * </p> 
     *  
     * @param bytes 
     * @return 
     */  
    private static Object toObject(byte[] bytes) {  
        Object obj = null;  
        try {  
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);  
            ObjectInputStream ois = new ObjectInputStream(bis);  
            obj = ois.readObject();  
            ois.close();  
            bis.close();  
        } catch (IOException ex) {  
            LoggerUtils.error(VCache.class, "byte[]转Object出现IOException异常", ex);
        } catch (ClassNotFoundException ex) {
            LoggerUtils.error(VCache.class, "byte[]转Object出现ClassNotFoundException异常", ex);
        }  
        return obj;  
    }


	public static void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		VCache.redisTemplate = redisTemplate;
	}  
	
}

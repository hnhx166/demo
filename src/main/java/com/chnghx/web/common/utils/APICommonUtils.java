package com.chnghx.web.common.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.chnghx.web.common.APIServiceLog;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * 接口中心公共方法提取类
 * 
 * @author Administrator
 *
 */
public class APICommonUtils {

	/**
	 * 根据缓存前缀和请求参数map获取缓存key
	 * @param prefix
	 * @param params
	 * @return
	 */
	public static String getCacheKeyByParametersMap(String prefix, Map<String, Object> params, APIServiceLog log){
		//系统来源
		String clientSystemType = (String)log.getClientHead().get("systemType");
		//缓存前缀
		String cacheKey = prefix + clientSystemType;
		//参数排序，并解析参数
		SortedMap<String,Object> sortedMap = new TreeMap<String,Object>(params);
		Set<Entry<String,Object>> entrySet = sortedMap.entrySet(); 
		Iterator<Entry<String,Object>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<String,Object> entry = it.next();
			String key = entry.getKey();
			String value = (String)entry.getValue();
			cacheKey+= "_" + key+"_" + value;
		}
		return cacheKey;
	}
}

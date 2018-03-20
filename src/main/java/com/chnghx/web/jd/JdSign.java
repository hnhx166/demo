/*
* 文 件 名:  JdSign.java
* 版    权:  xxxx Technologies Co., Ltd. Copyright 2010-9999,  All rights reserved
* 描    述:  <描述>
* 修 改 人:  Administrator
* 修改时间:  2017年6月7日
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.chnghx.web.jd;

import java.util.Map;

import com.chnghx.web.common.config.jd.JdConfig;
import com.chnghx.web.common.utils.MD5;

/**
 * <一句话功能简述>
 *
 * @author  贾瑞丰
 *@date  [2017年6月7日]
 */
public class JdSign {

	/**
	* <p>功能描述：AccessToke签名</p> 
	* <p>eg: 一句话描述方法功能</p> 
	* @param map
	* @return
	*/ 
	public static String getAccessTokeSign(Map<String,Object> map){
		StringBuffer orgString=new StringBuffer("");
		orgString.append(JdConfig.CLIENT_SECRET);
		orgString.append(map.get("timestamp"));
		orgString.append(JdConfig.CLIENT_ID);
		orgString.append(JdConfig.USERNAME);
		orgString.append(JdConfig.PASSWORD);
		orgString.append(map.get("grant_type"));
		orgString.append(map.get("scope"));
		orgString.append(JdConfig.CLIENT_SECRET);
		System.out.println("明文："+orgString.toString());
		try {
			System.out.println("签名："+MD5.md5Digest(orgString.toString()).toUpperCase());
			return MD5.md5Digest(orgString.toString()).toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}

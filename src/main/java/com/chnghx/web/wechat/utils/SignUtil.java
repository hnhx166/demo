package com.chnghx.web.wechat.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.chnghx.web.common.utils.VinuxPostMethod;

import net.sf.json.JSONObject;

/**
 * 
 *开发公司：九樱天下（北京）信息技术有限公司
 *版权：九樱天下（北京）信息技术有限公司
 * @author lubaohui@bizviva.com
 *
 *2017年12月21日 下午3:29:48
 *SignUtil.java
 *
 *说明：
 */
public class SignUtil {
    /**
     * 
     * 校验签名
     * @param signature 微信加密签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @return true/false
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        //字典排序
        String[] paramArr = new String[] { WeChatAPIUtil.TOKEN, timestamp, nonce };
        Arrays.sort(paramArr);
        
        String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);
        
        String ciphertext = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // 对接后的字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            ciphertext = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ciphertext != null ? ciphertext.equals(signature.toUpperCase()) : false;
    }
    
    
    /**
     *  将字节转换为十六进制字符串
     * @param byteArray
     * @return 
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }
    
    
    /**
     * 将字节转换为十六进制字符串
     * 
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
    /**
     * 调用会员接口查询信息
     * @param openId
     * @param commId
     * @param vipcn
     * @return
     */
    public static Map<String, Object> selectMemberinfo(String openId,String commId,String vipcn) {
		// 接口参数集合
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultmap = new HashMap<String, Object>();
		JSONObject commResult = new JSONObject();
//		String url = OpenUrlConfig.getProperty("vipcn.saveVipcnInfo");
//		String systype = OpenUrlConfig.getProperty("member.vitatype"); // 类型
//		String memberkey = OpenUrlConfig.getProperty("member.getmd5key"); // 密钥
//		try {
//			map.put("openId", openId);
//			map.put("commId", commId);
//			map.put("vipcn", vipcn);
//			VinuxPostMethod memberinfo = new VinuxPostMethod(url, CommonService.bulidParamsForHttpClick(map, systype, memberkey));
//			commResult = (JSONObject) memberinfo.executeMethod("JSONObject");
//			resultmap.put("userSex", commResult.get("gender"));
//			resultmap.put("userPic", commResult.get("avatar"));
//			resultmap.put("regDate", commResult.get("regDate"));
//			resultmap.put("age", commResult.get("age"));
//			resultmap.put("mobile", commResult.get("certificationMobile"));
//			resultmap.put("name", commResult.get("name"));
//			resultmap.put("roleType", commResult.get("type"));
//			resultmap.put("userId", commResult.get("id"));
//			// resultmap.put("vinuxId",TokenManager.getToken().getVinuxId());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return resultmap;
	}
}

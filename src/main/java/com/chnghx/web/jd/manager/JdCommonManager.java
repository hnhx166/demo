package com.chnghx.web.jd.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.chnghx.test.ClientPostMethod;
import com.chnghx.web.common.APIResult;
import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.VCache;
import com.chnghx.web.common.config.jd.JdConfig;
import com.chnghx.web.common.statics.Constant;
import com.chnghx.web.common.utils.APIServiceLogUitls;
import com.chnghx.web.common.utils.LoggerUtils;
import com.chnghx.web.common.utils.VPostMethod;
import com.chnghx.web.jd.JdSign;

public class JdCommonManager {

	public static Object exec(HttpServletRequest request, String clientModule,Map<String,Object> params){
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		APIResult<Object> result = new APIResult<Object>();
		log.setClientModule(clientModule);
		try {
//			Map<String, Object> params = log.getClientParam();
			VPostMethod postMethod = new VPostMethod(log.getServerUrl());
			postMethod.setParameter(params);
			//从member获取数据
			Object data = postMethod.syncExecuteMethod(request);
			result.setStatus(Constant.API_SUCCESS_CLIENT);
			result.setMessage(clientModule + "接口调用成功！");
			result.setResult(data);
			
			log.setClientResult(result);
			log.setClientCode(Constant.API_SUCCESS_CLIENT);
			return data;
		} catch (Exception e) {//出现异常记录异常信息，返回失败结果
			log.setClientException(APIServiceLogUitls.buildExceptionStack(e));
			log.setClientCode(Constant.API_ERROR_CLIENT);
			result = new APIResult<Object>(Constant.API_ERROR_CLIENT, "接口中心处理出现异常！" + clientModule + " 处理异常", null);
			log.setClientResult(result);
			LoggerUtils.error(JdCommonManager.class, "findCareAndSellerPennys 处理发生异常", e);
			return null;
		}
	}
	
//	private static String getToken(){
//		Object res=VCache.get("jd_token");
//		if(res==null){
//			Map<String,Object> map=new HashMap<String,Object>();
//			map.put("grant_type", "access_token");
//			map.put("client_id", JdConfig.CLIENT_ID);
//			map.put("client_secret", JdConfig.CLIENT_SECRET);
//			map.put("timestamp", timestamp());
//			map.put("username", JdConfig.USERNAME);
//			map.put("password", JdConfig.PASSWORD);//加密一次
//			map.put("scope", "");
//			
//			map.put("sign", JdSign.getAccessTokeSign(map));
//			ClientPostMethod clientPostMethod=new ClientPostMethod(JdConfig.getUrlProperty("accessToken"), map);
//			res=clientPostMethod.executeMethod();
//			System.out.println(res);
//			VCache.put("jd_token", res, 12*3600);
//		}
//		return  res.toString();
//	}
//	
//	private static String timestamp(){
//		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		return time.format(new Date());
//	}
}

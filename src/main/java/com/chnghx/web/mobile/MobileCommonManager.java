package com.chnghx.web.mobile;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.chnghx.web.common.APIResult;
import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.statics.Constant;
import com.chnghx.web.common.utils.APIServiceLogUitls;
import com.chnghx.web.common.utils.LoggerUtils;
import com.chnghx.web.common.utils.VinuxPostMethod;

public class MobileCommonManager {

	public static Object exec(HttpServletRequest request, String clientModule){
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		APIResult<Object> result = new APIResult<Object>();
		log.setClientModule(clientModule);
		try {
			Map<String, Object> params = log.getClientParam();
			VinuxPostMethod postMethod = new VinuxPostMethod(log.getServerUrl());
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
			LoggerUtils.error(MobileCommonManager.class, "findCareAndSellerPennys 处理发生异常", e);
			return null;
		}
	}
}

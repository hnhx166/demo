package com.chnghx.test.member;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chnghx.test.ClientPostMethod;
import com.chnghx.web.common.config.Config;
import com.chnghx.web.common.utils.MD5;

public class testMemberUser {
	
	public void setMemberParameter(Map<String, Object> parameter) throws Exception {
		if(null != parameter){
			//系统类型
			parameter.put("sys_type", Config.getProperty("api_system_type"));
			String paramStr = "";
			for (String key : parameter.keySet()) {
					Object str = parameter.get(key);
					String value = null == str ? "" : str.toString().trim();
					paramStr+= key + "=" + value + "&";
			}
			
			//参数排序
			String [] params = paramStr.split("&");
			Arrays.sort(params);
			
			//排序后组合
			String signStr = "";
			for (int i = 0; i < params.length; i++) {
				signStr += params[i] + "&";
			}
			//获取key
			signStr += Config.getProperty("member_sign");
			//生成md5签名
			String sign = MD5.md5Digest(signStr);
			//签名作为参数
			parameter.put("sign", sign);
		}
	}

	/**
	 * 1.9
	 * 
	 * 会员基础信息查询接口
	 * 
	 * 
	 * s_{param} 	String 	查询参数 ,目前会员系统可以提供的参数有id、loginName，由于参数不固定，
	 * 					如需提供其它的查询参数，请告知会员系统负责人进行扩展。
	 * 示例：s_id=181s_loginName=seller_temai”
	 * 
	 *描述：测试通过
	 * 
	 */
	@Test
	public void testUserinfo() throws Exception{
		String url = "http://api.vinux.com/api/member/userinfo";
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("s_id", "181");//sessionId
		params.put("s_loginName", "15911188740");//描述信息
//		params.put("host", "api.vinux.com");//host
//		params.put("sys_type", "vinux_platform");//系统
		params.put("sync", "sync");
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
//	@Test
//	public void testUserinfo() throws Exception{
//		String url = "http://api.vinux.com/api/member/userinfo";
//		Map<String, Object> params = new HashMap<String, Object>();
////		params.put("s_id", "181");//sessionId
//		params.put("s_loginName", "15911188740");//描述信息
////		params.put("host", "api.vinux.com");//host
////		params.put("sys_type", "vinux_platform");//系统
//		params.put("sync", "sync");
//		
//		setMemberParameter(params);
//		ClientPostMethod client = new ClientPostMethod(url, params);
//		
//		Object  result = client.executeMethod();
//		System.out.println(result);
//	}
//	
	
	/**
	 * 2.0
	 * 
	 * 会员归属信息更新接口
	 * 
	 * 描述 ： 已经测试通过
	 * @throws Exception 
	 * 
	 */
	@Test
	public void testUpdate() throws Exception {
		String url = "http://api.vinux.com/api/member/update";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", 200804);//用户id
		params.put("firstOrderMedia", 169);//用户归属
		params.put("sys_type", "xapollovita");
		params.put("sync", "sync");//同步处理
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	/***
	 * TODO {"message":"获取分账关系分账比例(仅购物车使用)为空！ JSONArray 数据转换失败！","result":{"is_success":false,"msg":"购物车获取分账比例调用cartPenny()方法，传入的参数param是空值"},"status":"A500"}
	 * @throws Exception 
	 */
	@Test
	public void testGetCartPenny() throws Exception {
		String url = "http://api.vinux.com/api/member/getCartPenny";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comId", 157);//sessionId
		params.put("saleId", 201726);//描述信息
		params.put("loginName", "hahaha");//host
		params.put("supplyId", 124);//
		params.put("goodsId","168");
		
		params.put("sync", "cache");
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object result = client.executeMethod();
		System.out.println(result);
	}
	
	
	
	/**
	 * 2.8
	 * 
	 * 获取和某个用户合作的对应角色下的所有用户列表
	 * 
	 * 描述 ： 已经测试通过
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testGetPennyIds() throws Exception {
		String url = "http://api.vinux.com/api/member/getPennyIds";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mediaId", "157");//用户id
		params.put("outRoleType", "230101");//角色代码 格式 201001,200031 注：（多个以逗号隔开）
		params.put("sys_type", "weixin");
		params.put("sync", "sync");//缓存处理
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	/**
	 * 2.9
	 * 
	 * 获取用户从属关系
	 * 
	 * 描述 ： 已经测试通过
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testFindSubordinateIds() throws Exception {
		String url = "http://api.vinux.com/api/member/findSubordinateIds";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("memberId", "306");//用户id
//		params.put("loginNames", "15911188740");//用户登录名称 备注：不传默认是ID查询，否则登录名查询（传多个账号名称，要用，隔开。例如：”zhangu,zhangyu123”）
		params.put("backRoleTypes", "230202");//角色代码 备注：格式 201001,200031 注：（多个以逗号隔开）
		params.put("sys_type", "weixin");
		params.put("sync", "sync");//缓存处理
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	/**
	 * 2.10
	 * 
	 * 获取和基金合作的卖家（且和某些社群合作的卖家）分账信息
	 * 
	 * 描述 ： 已经测试通过
	 * 
	 * @throws Exception 
	 */
	@Test
	public void testFindSellerPennys() throws Exception {
		String url = "http://api.vinux.com/api/member/findSellerPennys";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("loginName", "fangshequ@qq.com");//用户登录名 运营、代理、社群loginName   fangshequ@qq.com
		params.put("sys_type", "weixin");
		params.put("sync", "sync");//缓存处理
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	/**
	 * 2.11
	 * 
	 * 获取和基金合作的卖家分账信息（基金系统）
	 * 
	 * 描述 ： 已经测试通过
	 * @throws Exception 
	 * 
	 */
	@Test
	public void testFindCareAndSellerPennys() throws Exception {
		String url = "http://api.vinux.com/api/member/findCareAndSellerPennys";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("loginName", "xiaoshou@xianlu.com");//用户登录名 顾问loginName（传入null，为不筛选顾问所属卖家）
		params.put("sys_type", "weixin");
		params.put("sync", "sync");//缓存处理
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	
	/**
	 * 2.13
	 * 
	 * 获取一对一的分账信息
	 * 
	 * 描述 ： 已经测试通过
	 * @throws Exception 
	 * 
	 */
	@Test
	public void testOneToOnePenny() throws Exception {
		String url = "http://api.vinux.com/api/member/oneToOnePenny";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("mainId", "619");//用户id （不能为空）
//		params.put("subId", "168");//用户id（可为空，为空的情况查询和care的分账，否则查询mainId和subId的分账）
//		params.put("sys_type", "weixin");
		params.put("sync", "sync");//缓存处理
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	/**
	 * 2.21
	 * 
	 * 根据卖家类型筛选社区下的合作卖家
	 * 
	 * 描述 ： 已经测试通过
	 * @throws Exception 
	 * 
	 */
	@Test
	public void testGetSellerInfoByType() throws Exception {
		String url = "http://api.vinux.com/api/member/getSellerInfoByType";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("mediaId", "157");//社区ID
		params.put("sellerType", 1);//sellerType支持传递多个参数，如”1,2,3”;单个参数时只能传递，如：”1”(中间不能带有逗号)。卖家类型 1，传统电商类业务；2，带货支付类业务；3，入户服务类业务；4，到店服务类业务；5，网点执行类业务；6，充值缴费类业务；
		params.put("sync", "sync");//缓存处理
		
		setMemberParameter(params);
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	/**
	 * 
	 */
	@Test
	public void sendCodeByLoginNameAndPhone() {
		String url = "https://api.vinux.com/vinuxmembers/open/request/certificate/sendCodeByLoginNameAndPhone";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("loginName", "13211111111");
		params.put("phone", "13211111111");
//		params.put("sync", "sync");//缓存处理
		params.put("sign", "588CC305E0E474C0BFE3733E82F84D68"); 
		params.put("sys_type", "vinux_mobilemall"); 
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void sendCodeByLoginNameAndPhone2() {
		String url = "http://www.vinuxmembers.com/open/request/certificate/sendCodeByLoginNameAndPhone.vhtml";
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("loginName", "13211111111");
		params.put("phone", "13211111111");
		params.put("sign", "588CC305E0E474C0BFE3733E82F84D68"); 
		params.put("sys_type", "vinux_mobilemall"); 
		ClientPostMethod client = new ClientPostMethod(url, params);
		
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	
}

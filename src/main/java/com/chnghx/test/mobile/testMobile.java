package com.chnghx.test.mobile;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.chnghx.test.ClientPostMethod;

/**
 * 
 * @author Administrator
 *
 */
public class testMobile {
	
	public static void main(String[] args) {
		String str = "%7B%22avatar%22%3A%22default-head.jpg%22%2C%22careFirstOrderMedia%22%3A619%2C%22certificationMobile%22%3A%2215911188740%22%2C%22firstOrder%22%3Anull%2C%22loginName%22%3A%2215911188740%22%2C%22nickname%22%3A%22%E9%83%AD%E6%B5%B7%E9%A6%99%22%2C%22roleId%22%3A15%2C%22roleName%22%3A%22vinuxconsumer%22%2C%22roleType%22%3A120201%2C%22sellerType%22%3Anull%2C%22userId%22%3A9290%2C%22userName%22%3A%2215911188740%22%2C%22userType%22%3A120201%2C%22vinuxId%22%3A%222015041619070526140%22%7D";
		String s = URLDecoder.decode(str);
		System.out.println(s);
	}
	
	@Test
	public void testmdologin() {
		String url = "https://api.vinux.com/vinuxmembers/open/request/user/consumer/dologin.vhtml";
//		String url =  "http://www.vinuxmembers.com/open/request/user/consumer/dologin.vhtml";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", "15911188740");
		params.put("password", "000000");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	//http://mobile.vinuxcart.com/open/api/app/appCartToOrder.vhtml
	@Test
	public void testappCartToOrder() {
		//http://mall.vinuxpost.com/directory/getPostLogo.vhtml?mediaId=213&versionsType=3
//		String url = "http://api.vinux.com/vinuxcart/open/api/app/appCartToOrder";
		String url =  "http://mobile.vinuxcart.com/open/api/app/appCartToOrder.vhtml";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", "200175");
		params.put("username", "15097398894");
		params.put("comId", "213");
		params.put("cartIds", "aa978d48-739e-4939-9a63-be681da0088d,0062a65d-7d11-41c1-bffb-dfb53ecab94e");
		params.put("userAccount", "15097398894");
//		params.put("versionsType ", "3");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testgetCartLength() {
		//http://mall.vinuxpost.com/directory/getPostLogo.vhtml?mediaId=213&versionsType=3
		String url = "http://api.vinux.com/vinuxcart/open/cart/getCartLength";
//		String url =  "http://admin.vinuxcart.com/open/cart/getCartLength.vhtml";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user_info ", "6K6p5qKm5oOz5Y%2BY55qE566A5Y2V%23%40%23%40%23%40-%25user_info%3A15521");
//		params.put("versionsType ", "3");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testgetPostLogo() {
		//http://mall.vinuxpost.com/directory/getPostLogo.vhtml?mediaId=213&versionsType=3
		String url = "https://api.vinux.com/mall/directory/getPostLogo?mediaId=213&versionsType=3";
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("mediaId ", "213");
//		params.put("versionsType ", "3");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
//	https://api.vinux.com/vitahelper/api/plan/genPlan     参数 	diseaseId = 8BH5LcS0j38=,
//		userId = xl5O5kYte3w=,
//		assId = FJnqYcv3yXs=,
//		quesAndAns = gRD1shFwJTGla+7i/KKitA==,
//		recordFrom = 3
	
	
	
	@Test
	public void testthemeDsc() {
		//http://admin.vitahelper.com/api/plan/genPlan.vhtml
		String url = "https://api.vinux.com/community/open/themeDsc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("themeId", "114");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testgenPlan() {
//		String url = "http://admin.vitahelper.com/api/plan/genPlan.vhtml";
		String url = "https://api.vinux.com/vitahelper/api/plan/genPlan";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("diseaseId", "PGx364+0qIE=");
		params.put("userId", "pOP7WleKIWI=");
		params.put("assId", "JMtggu7jYB0=");
		params.put("quesAndAns", "yGMN+Z7EQuVMqg+ZOv0JZg==");
		params.put("recordFrom", "3");
		
		
//		diseaseId = PGx364+0qIE=,
//		recordFrom = 3,
//		quesAndAns = yGMN+Z7EQuVMqg+ZOv0JZg==,
//		assId = JMtggu7jYB0=,
//		userId = pOP7WleKIWI=
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
		
	@Test
	public void listNews() {
		String url = "https://api.vinux.com/community/open/listNews"; 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mediaId", "213");
		params.put("pageNo", "1");
		params.put("pageSize", "10");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testgetCookBaseInfo() {
		String url = "https://api.vinux.com/apikitchen/chef/getCookBaseInfo"; 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginId", "200384");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testcashCoupon() {
		String url = "https://api.vinux.com/vip/open/app/cashCoupon"; 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", "15097398894");//描述信息
		params.put("pageSize", "10");
		params.put("currenPage", "1");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testorderQuery() {
		String url = "https://api.vinux.com/vip/open/app/orderQuery"; 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", "{\"value\":\"payStatus=0&servicStatus=0\"}");//描述信息
		params.put("roleType", "120201");
		params.put("userId", "200175");
		params.put("pageInfo", "{\"pageSize\":\"10\",\"currenPage\":\"1\"}");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testdologin() {
		String url = "https://api.vinux.com/mobilemall/open/request/dologin"; 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", "15911188740");//描述信息
		params.put("password", "000000");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testquerymobile() {
		String url = "https://api.vinux.com/mobilevinuxpost/MobileOpen/querymobile"; 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", "100");//描述信息
		params.put("mobile", "15097398894");
		params.put("price", "99.9");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testgetGroupMonthlyStatisticsInfo() {
		String url = "https://api.vinux.com/vinuxcare/groupInfo/getGroupMonthlyStatisticsInfo"; 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("_SIGN", "10000001");//描述信息
		params.put("date", "2017-06-06");
		params.put("groupId", "G8kGD5IJeFO8uN/2niD8MA%3D%3D");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testrecommend() {
		String url = "https://api.vinux.com/vinuxbuy/app/recommend";//pageNo=1&pageSize=10 
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pageNo", "1");//描述信息
		params.put("pageSize", "10");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testgetCustomerDetails() {//open.vinuxcare.com
		String url = "https://api.vinux.com/vinuxcare/customerInfo/getCustomerDetails";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("_SIGN", "10000001");//描述信息
		params.put("customerid", "4QptnqVrhj482X8F0VdjHA==");
		params.put("type", "1");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testkitchenList() {
		String url = "https://api.vinux.com/apikitchen/community/kitchenList";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", "");//描述信息
		params.put("pageNo", "1");
		params.put("pageSize", "10");
		params.put("mediaId", "157");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}

	//ApikitchenController
	@Test
	public void testApikitchen() {
		String url = "https://api.vinux.com/apikitchen/order/getYtHouseAddress";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mediaId", "619");//描述信息
//		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	//MallApiController
	@Test
	public void testMallService() {
		String url = "https://api.vinux.com/mallapi/chef/memberLogin";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", "15911188740");//描述信息
		params.put("password", "000000");
//		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	//./configure --user=root --group=root--prefix=/usr/local/nginx --with-http_stub_status_module --with-openssl=/usr/local/openssl-1.1.0-pre6
	
	//HelperbackController
	@Test
	public void testHelperback() {
		String url = "https://api.vinux.com/helperback/open/checkIsHelper";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", "15911188740");//描述信息
		params.put("password", "111111");

		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	//MallApiController
	@Test
	public void testMallApi() {
		String url = "https://api.vinux.com/mallapi/mall/service";
		
//		http://mall.api.com/mall/service.vhtml?catalogType=3,4,5&currentSize=1&memberId=213&method=1103&pageSize=9&platform=mobile
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("catalogType", "3,4,5");//描述信息
		params.put("currentSize", "1");//描述信息
		params.put("memberId", "112");//描述信息213
		params.put("method", "1103");//描述信息
		params.put("pageSize", "9");//描述信息
		params.put("platform", "mobile");//描述信息
//		params.put("sync", "sync");
		//catalogType=3%2C4%2C5&currentSize=1&memberId=213&method=1103&pageSize=9&platform=mobile
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	//MallApiController
	@Test
	public void testDiseaseList() {
		String url = "http://api.vinux.com/vitahelper/api/disease/diseaseList";
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("s_loginName", "15911188740");//描述信息
//		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	//MallApiController
	@Test
	public void testSendCodeByLoginNameAndPhone() {
		String url = "http://api.vinux.com/vitahelper/api/disease/diseaseList";
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("s_loginName", "15911188740");//描述信息
//		params.put("sync", "sync");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testPay() {
		//https://pay.vinuxpay.com/vinuxpay/apinew/getcode/getShopQRCode
		String url = "https://pay.vinuxpay.com/vinuxpay/apinew/getcode/getShopQRCode?userId=12310";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", "12310");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	
	@Test
	public void testpushCart() {
		//https://pay.vinuxpay.com/vinuxpay/apinew/getcode/getShopQRCode
		String url = "https://api.vinux.com/mobilemall/open/request/pushCart";
		
		//buyNums=1&limitSale=1&mediaId=619&plateForm=app&productId=100118&productPk=163346_163335_7271_70545&promotionId=&userId=99968
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("buyNums", "1");
		params.put("limitSale", "1");
		params.put("mediaId", "619");
		params.put("plateForm", "app");
		params.put("productId", "10011");
		params.put("productPk", "163346_163335_7271_70545");
		params.put("promotionId", "");
		params.put("userId", "99968");
		params.put("wareHouseId", "0");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testgetStockInfo() {
		//https://pay.vinuxpay.com/vinuxpay/apinew/getcode/getShopQRCode
		String url = "https://api.vinux.com/mobilemall/open/request/getStockInfo";
		
		//productPk = 168_162_5439_53381_402     mediaId = 213
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mediaId", "213");
		params.put("productPk", "168_162_5439_53381_402");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
//	
	@Test
	public void testgetCookPageByMediaIdNew() {
		//https://pay.vinuxpay.com/vinuxpay/apinew/getcode/getShopQRCode
		String url = "https://api.vinux.com/apikitchen/cook/getCookPageByMediaIdNew";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mediaId", "145");
		params.put("pageSize", "10");
		params.put("pageNo", "1");
		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	@Test
	public void testfindUserCoordinate() {
		//https://pay.vinuxpay.com/vinuxpay/apinew/getcode/getShopQRCode
		String url = "https://api.vinux.com/vinuxmembers/open/request/penny/findUserCoordinate";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("storeName", "");
		params.put("sys_type", "retailstore");
		params.put("pageNo", "1");
		params.put("pageSize", "15");
		params.put("customerCoordinate", "116.491383,39.915081");

		ClientPostMethod client = new ClientPostMethod(url, params);
		Object  result = client.executeMethod();
		System.out.println(result);
	}
	
	//https://api.vinux.com/mallapi/mall/service?catalogType=3%2C4%2C5&currentSize=1&memberId=213&method=1103&pageSize=9&platform=mobile
	
	
	
//	
}

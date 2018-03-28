1、不产生session配置参考/doc/nosession/readme.txt

2、API—CENTER接口调用说明：
   	(1)接口调用需要设置调用头信息，头信息包括：系统类型(必须项)   systemType 和 请求时间((必须项)) rd ; 头信息不全或者不正确会返回拒绝访问。
   	(2)请求参数除业务参数外还需要设置请求处理类型sync， （同步不走缓存，sync；同步走缓存，cache；异步处理，需要提供完整的回调客户端URL，回调参数由APICENTER规定）
   	(3)结果返回值：
   		String API_ACCEPT_CLIENT="A100";//接口中心接受成功
		String API_NOACCEPT_CLIENT="A101";//接口中心接受失败
		String API_SUCCESS_CLIENT="A200";//接口中心处理成功
		String API_PROCESS_CLIENT="A300";//接口中心正在处理中
		String API_NOFIND_CLIENT="A400";//接口中心找不到数据
		String API_ERROR_CLIENT="A500";//接口中心处理失败
   		//结果为空时返回A500，正常结果返回A200
	 
	 (4)对于有缓存的接口，可以根据缓存可以先直接获取信息，如果信息不存在，再调接口中心
	 
	 
3、接口中心接口访问定义，/api/系统/业务方法
4、缓存key定义：前缀+参数列表方式，详细参照 vinux.service.api.center.common.utils.APICommonUtils
5、缓存key前缀按系统划分，参考缓存前缀常量类 vinux.service.api.center.common.statics.CachePrefix
6、接口中心拦截器：vinux.service.core.interceptor.RequestInterceptor
7、测试类参考vinux.server.test包，不同系统使用不同的测试包。
	 
	 
	 
ios 测试环境

测试环境需配host
192.168.0.150  api.vinux.com

联调测试host 
192.168.0.166  api.vinux.com

商品库图片读取:https://imggoods.vinux.com

修改方法如下：
IOS 配置文件配置的URL：http://www.vinuxmembers.com/open/request/user/signup/phone/validateCode.vhtml
需要修改域名和URL后缀：https://api.vinux.com/vinuxmembers/open/request/user/signup/phone/validateCode

具体域名修改参考 如下列表（如果有域名没找到或者不清楚的地方，请随时沟通）:

购物车相关的域名：mobile.vinuxcart.com  admin.vinuxcart.com
https://api.vinux.com/vinuxcart/

厨房相关的域名：apikitchen.vinuxpost.com
https://api.vinux.com/apikitchen/

技能相关的域名：helperback.vinuxpost.com
https://api.vinux.com/helperback/

vitapollo相关域名：medicalcenter.vitapollo.com
https://api.vinux.com/medicalcenter/

个人中心相关的域名：vip.vinuxpost.com
https://api.vinux.com/vip/

vitahelper相关的域名：admin.vitahelper.com
https://api.vinux.com/vitahelper/

api.vinuxpost.com
https://api.vinux.com/mallapi/


樱桃铺相关的域名：pay.vinuxpay.com
https://api.vinux.com/vinuxstore/

基金相关的域名：open.vinuxcare.com
https://api.vinux.com/vinuxcare/


会员相关的域名：www.vinuxmembers.com 
https://api.vinux.com/vinuxmembers/


手机充值相关的域名：mobile.vinuxpost.com
https://api.vinux.com/mobilevinuxpost/


实体商城域名：mobilemall.vinuxpost.com
https://api.vinux.com/mobilemall/

海外购相关域名： vinuxbuy.vinuxpost.com
https://api.vinux.com/vinuxbuy/

樱桃阵相关域名： mall.vinuxpost.com
https://api.vinux.com/mall/

社区运营相关域名：community.vinuxpost.com
https://api.vinux.com/community/





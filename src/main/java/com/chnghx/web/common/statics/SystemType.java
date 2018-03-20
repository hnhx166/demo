package com.chnghx.web.common.statics;

import java.util.HashMap;
import java.util.Map;

public abstract class SystemType {
	/**平台系统类型**/
	static final String SYSTEM_VINUX_PLATFORM = "vinux_platform";
	static final String SYSTEM_VINUX_SSO="vinux_sso";

	/**应用名称
	/** 购物车 */
	static final String SYSTEM_VINUXCART="vinuxcart";
	static final String SYSTEM_VINUXCART_PC="vinuxcart_pc";
	static final String SYSTEM_VINUXCART_COW="vinuxcart_cow";
	static final String SYSTEM_VINUXCART_PHONE="vinuxcart_phone";
	/** 会员 */
	static final String SYSTEM_VINUXMEMBERS="vinuxmembers";
	/** 樱桃阵 */
	static final String SYSTEM_VINUXPOST="vinuxpost";
	/**樱桃阵PC 商城 **/
	static final String SYSTEM_VINUXPOST_PCMALL="vinuxpost_pcmall";
	/**樱桃阵奶牛商城*/
	static final String SYSTEM_VINUXPOST_COWMALL="vinuxpost_cowmall";
	/**樱桃阵手机商城*/
	static final String SYSTEM_VINUXPOST_MOBILEMALL="vinuxpost_mobilemall";
	/**会员中心*/
	static final String SYSTEM_VINUXPOST_VIP="vinuxpost_vip";
	/** 邮局 */
	static final String SYSTEM_VINUXEXPRESS="vinuxexpress";
	/** 樱桃派 */
	static final String SYSTEM_VINUXPAY="vinuxpay";
	/** 基金*/
	static final String SYSTEM_VINUXCARE="vinuxcare";
	/** 基金服务 */
	static final String SYSTEM_VINUXCARE_SERVICE="vinuxcare_service";
	/** 商品库 */
	static final String SYSTEM_VINUXGOODS="vinuxgoods";
	/** 感冒医生 */
	static final String SYSTEM_XGANMAO="xganmao";
	/** xapollovita */
	static final String SYSTEM_XAPOLLOVITA="xapollovita";
	/** vinux */
	static final String SYSTEM_VINUX="vinux";
	/** vinux_login */
	static final String SYSTEM_VINUXLOGIN="vinuxlogin";
	/** 樱桃厨房 */
	static final String SYSTEM_VINUX_FINEFOOD = "vinuxfinefood";
	/**数据统计中心  */
	static final String SYSTEM_VINUX_DATACENTER="vinuxdatacenter";
	static final String SYSTEM_VINUX_DATACENTER_MEDIA="vinuxdatacenter_media";
	static final String SYSTEM_VINUX_DATACENTER_SELLER="vinuxdatacenter_seller";
	/** vinuximage */
	static final String SYSTEM_VINUX_IMAGE="vinuximage";
	/** 维他菠萝 */
	static final String SYSTEM_VITAPOLLO="vitapollo";
	/** 维他引擎 */
	static final String SYSTEM_VITAHELPER="vitahelper";
	/** 樱桃派 数据管理*/
	static final String SYSTEM_VINUXPAY_DB="vinuxpaydb";
	/**樱桃阵卡拉丁服务*/
	static final String SYSTEM_VINUXPOST_KAKADING = "vinux_kalading";
	/** 接口中心系统 */
	static final String SYSTEM_VINUXICENTER="vinuxicenter";
	/**水电煤缴费服务*/
	static final String SYSTEM_VINUXPOST_VS_SDM = "vinuxpost_vs_sdm";
	/**vita角色日志，包含vita运营，药房，诊院，检所，用户，社区*/
	static final String SYSTEM_VITAROLE = "vitarole";
	/**病案中心日志*/
	static final String SYSTEM_MEDICALCENTER = "medicalcenter";
	/** 海外购 */
	static final String SYSTEM_VINUX_BUY="vinuxbuy";
	/** 卖家中心 */
	static final String SYSTEM_SELLER_CENTER="seller_center";
	/** 监控中心 */
	static final String SYSTEM_MONITOR = "monitor";
	/**樱桃阵商城中间件*/
	static final String SYSTEM_VINUXPOST_APIMALL="vinuxpost_apimall";
	/**樱桃生活*/
	static final String SYSTEM_VINUX_HELPER="vinux_helper";
	/**养老 */
	static final String SYSTEM_YANGLAO="yanglao";
	/**设计中心*/
	static final String SYSTEM_VINUXDESIGN = "vinux_design";
	/** 樱桃良品后台*/
	static final String SYSTEM_VINUXPOST_VINUXBUY="vinuxpost_managerbuy";
	/** 樱桃店铺*/
	static final String SYSTEM_VINUXPAY_STORE="vinuxpay_store";
	/***物业**/
	static final String SYSTEM_VINUXPROPERTY="vinuxproperty";
	/***奶牛养老**/
	static final String SYSTEM_YANGLAO_COW="yanglaocow";
	/**社区运营中心*/
	static final String SYSTEM_VINUXPOST_COMMUNITY="vinuxpost_community";
	/**樱桃旅行*/
	static final String SYSTEM_VINUXPOST_TRIP="vinuxpost_trip";
	/**奶牛养老组合服务*/
	static final String SYSTEM_VINUXPOST_CPSM="vinuxpost_package";

	static final String SYSTEM_VINUXPOST_JD="vinuxpost_jd";
	
	
	
	//接口中心处理请求的处理方式
	public static final String API_PROCESS_SYNC="sync";  // 同步处理,请求完直接返回数据
	public static final String API_PROCESS_CACHE="cache"; //同步加缓存处理,非实时业务，控制好时间
	public static final String API_PROCESS_ASYNC="async";// 异步处理,直接不做处理返回，MQ处理请求与回调
	
	//
	public final static Map<String, String> SYSTEM_MAP;
	//
	public final static Map<String, String> CACHE_MAP;
	
	static{
		//系统类型
		SYSTEM_MAP = new HashMap<String, String>();
		SYSTEM_MAP.put(SYSTEM_VINUXCART, SYSTEM_VINUXCART);
		SYSTEM_MAP.put(SYSTEM_VINUXCART_PC, SYSTEM_VINUXCART_PC);
		SYSTEM_MAP.put(SYSTEM_VINUXCART_COW, SYSTEM_VINUXCART_COW);
		SYSTEM_MAP.put(SYSTEM_VINUXCART_PHONE, SYSTEM_VINUXCART_PHONE);
		SYSTEM_MAP.put(SYSTEM_VINUXMEMBERS, SYSTEM_VINUXMEMBERS);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST, SYSTEM_VINUXPOST);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_PCMALL, SYSTEM_VINUXPOST_PCMALL);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_COWMALL, SYSTEM_VINUXPOST_COWMALL);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_MOBILEMALL, SYSTEM_VINUXPOST_MOBILEMALL);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_VIP, SYSTEM_VINUXPOST_VIP);
		SYSTEM_MAP.put(SYSTEM_VINUXEXPRESS, SYSTEM_VINUXEXPRESS);
		SYSTEM_MAP.put(SYSTEM_VINUXPAY, SYSTEM_VINUXPAY);
		SYSTEM_MAP.put(SYSTEM_VINUXCARE_SERVICE, SYSTEM_VINUXCARE_SERVICE);
		SYSTEM_MAP.put(SYSTEM_VINUXGOODS, SYSTEM_VINUXGOODS);
		SYSTEM_MAP.put(SYSTEM_XGANMAO, SYSTEM_XGANMAO);
		SYSTEM_MAP.put(SYSTEM_XAPOLLOVITA, SYSTEM_XAPOLLOVITA);
		SYSTEM_MAP.put(SYSTEM_VINUX, SYSTEM_VINUX);
		SYSTEM_MAP.put(SYSTEM_VINUXLOGIN, SYSTEM_VINUXLOGIN);
		SYSTEM_MAP.put(SYSTEM_VINUX_FINEFOOD, SYSTEM_VINUX_FINEFOOD);
		SYSTEM_MAP.put(SYSTEM_VINUX_DATACENTER, SYSTEM_VINUX_DATACENTER);
		SYSTEM_MAP.put(SYSTEM_VINUX_DATACENTER_MEDIA, SYSTEM_VINUX_DATACENTER_MEDIA);
		SYSTEM_MAP.put(SYSTEM_VINUX_DATACENTER_SELLER, SYSTEM_VINUX_DATACENTER_SELLER);
		SYSTEM_MAP.put(SYSTEM_VINUX_IMAGE, SYSTEM_VINUX_IMAGE);
		SYSTEM_MAP.put(SYSTEM_VITAPOLLO, SYSTEM_VITAPOLLO);
		SYSTEM_MAP.put(SYSTEM_VITAHELPER, SYSTEM_VITAHELPER);
		SYSTEM_MAP.put(SYSTEM_VINUXPAY_DB, SYSTEM_VINUXPAY_DB);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_KAKADING, SYSTEM_VINUXPOST_KAKADING);
		SYSTEM_MAP.put(SYSTEM_VINUXICENTER, SYSTEM_VINUXICENTER);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_VS_SDM, SYSTEM_VINUXPOST_VS_SDM);
		SYSTEM_MAP.put(SYSTEM_VITAROLE, SYSTEM_VITAROLE);
		SYSTEM_MAP.put(SYSTEM_MEDICALCENTER, SYSTEM_MEDICALCENTER);
		SYSTEM_MAP.put(SYSTEM_VINUX_BUY, SYSTEM_VINUX_BUY);
		SYSTEM_MAP.put(SYSTEM_SELLER_CENTER, SYSTEM_SELLER_CENTER);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_APIMALL, SYSTEM_VINUXPOST_APIMALL);
		SYSTEM_MAP.put(SYSTEM_VINUX_HELPER, SYSTEM_VINUX_HELPER);
		SYSTEM_MAP.put(SYSTEM_YANGLAO, SYSTEM_YANGLAO);
		SYSTEM_MAP.put(SYSTEM_VINUXDESIGN, SYSTEM_VINUXDESIGN);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_VINUXBUY, SYSTEM_VINUXPOST_VINUXBUY);
		SYSTEM_MAP.put(SYSTEM_VINUXPAY_STORE, SYSTEM_VINUXPAY_STORE);
		SYSTEM_MAP.put(SYSTEM_VINUXPROPERTY, SYSTEM_VINUXPROPERTY);
		SYSTEM_MAP.put(SYSTEM_YANGLAO_COW, SYSTEM_YANGLAO_COW);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_COMMUNITY, SYSTEM_VINUXPOST_COMMUNITY);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_TRIP, SYSTEM_VINUXPOST_TRIP);
		SYSTEM_MAP.put(SYSTEM_VINUX_PLATFORM, SYSTEM_VINUX_PLATFORM);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_CPSM, SYSTEM_VINUXPOST_CPSM);
		SYSTEM_MAP.put(SYSTEM_VINUX_SSO, SYSTEM_VINUX_SSO);
		SYSTEM_MAP.put(SYSTEM_VINUXPOST_JD, SYSTEM_VINUXPOST_JD);
		
		//请求处理方式(同步，异步，缓存)
		CACHE_MAP = new HashMap<String, String>();
		CACHE_MAP.put(API_PROCESS_SYNC, API_PROCESS_SYNC);
		CACHE_MAP.put(API_PROCESS_CACHE, API_PROCESS_CACHE);
		CACHE_MAP.put(API_PROCESS_ASYNC, API_PROCESS_ASYNC);
		
	}
	
	
	
}

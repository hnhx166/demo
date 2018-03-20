package com.chnghx.web.mobile.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chnghx.web.common.APIServiceLog;
import com.chnghx.web.common.BaseController;
import com.chnghx.web.common.config.mobile.MobileConfig;
import com.chnghx.web.mobile.MobileCommonManager;

@Controller
@Scope("prototype")
@RequestMapping("apikitchen")
public class ApikitchenController extends BaseController {

	@RequestMapping(value = "cook/getCookPageByMediaIdNew", method = RequestMethod.POST)
	public void getCookPageByMediaIdNew(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCookPageByMediaIdNew");
		log.setServerUrl(serverUrl);

		String clientModule = "根据社区ID获取厨师列表";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}

	@RequestMapping(value = "cook/getCookByMediaIdAndLoginId", method = RequestMethod.POST)
	public void getCookByMediaIdAndLoginId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCookByMediaIdAndLoginId");
		log.setServerUrl(serverUrl);

		String clientModule = "根据社区ID获取厨师信息";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cook/getAdvertListByMediaId", method = RequestMethod.POST)
	public void getAdvertListByMediaId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getAdvertListByMediaId");
		log.setServerUrl(serverUrl);

		String clientModule = "根据社区ID获取厨师广告图片";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "food/getFoodListByDate", method = RequestMethod.POST)
	public void getFoodListByDate(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getFoodListByDate");
		log.setServerUrl(serverUrl);

		String clientModule = "获取厨师菜品列表";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cart/getSessionCart", method = RequestMethod.POST)
	public void getSessionCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getSessionCart");
		log.setServerUrl(serverUrl);

		String clientModule = "获取餐盒所有菜品";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cart/setCartFood", method = RequestMethod.POST)
	public void setCartFood(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.setCartFood");
		log.setServerUrl(serverUrl);

		String clientModule = "添加菜品数量";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	
	@RequestMapping(value = "cart/checkCookIsSame", method = RequestMethod.POST)
	public void checkCookIsSame(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.checkCookIsSame");
		log.setServerUrl(serverUrl);

		String clientModule = "添加购物车前验证将要购买的菜品是否来自同一厨师";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cart/delFoodByFoodSku", method = RequestMethod.POST)
	public void delFoodByFoodSku(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.delFoodByFoodSku");
		log.setServerUrl(serverUrl);

		String clientModule = "根据SKU删除菜品";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cart/clearCart", method = RequestMethod.POST)
	public void clearCart(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.clearCart");
		log.setServerUrl(serverUrl);

		String clientModule = "清空菜品购物车";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cart/confirmSelection", method = RequestMethod.POST)
	public void confirmSelection(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.confirmSelection");
		log.setServerUrl(serverUrl);

		String clientModule = "菜品确认";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "food/getFoodInfo", method = RequestMethod.POST)
	public void getFoodInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getFoodInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "获取菜品详情";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cook/searchCookListByKeyword", method = RequestMethod.POST)
	public void searchCookListByKeyword(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.searchCookListByKeyword");
		log.setServerUrl(serverUrl);

		String clientModule = "根据关键词搜索菜品";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "order/getYtHouseAddress", method = RequestMethod.POST)
	public void getYtHouseAddress(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getYtHouseAddress");
		log.setServerUrl(serverUrl);

		String clientModule = "获取樱桃屋地址";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "order/getLastAddressByLoginId", method = RequestMethod.POST)
	public void getLastAddressByLoginId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getLastAddressByLoginId");
		log.setServerUrl(serverUrl);

		String clientModule = "获取用户最后一次下单地址";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "order/saveShippingInfoByType", method = RequestMethod.POST)
	public void saveShippingInfoByType(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.saveShippingInfoByType");
		log.setServerUrl(serverUrl);

		String clientModule = "保存订单信息到购物车";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "order/pushCartInfo", method = RequestMethod.POST)
	public void pushCartInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.pushCartInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "推送订单信息到购物车";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cook/getCookInfoMap", method = RequestMethod.POST)
	public void getCookInfoMap(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCookInfoMap");
		log.setServerUrl(serverUrl);

		String clientModule = "得到厨房信息（配送时间，地址）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "cart/operateDeliverFee", method = RequestMethod.POST)
	public void operateDeliverFee(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.operateDeliverFee");
		log.setServerUrl(serverUrl);

		String clientModule = "得到厨房配送费";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	
	@RequestMapping(value = "chef/applyKitchenCook", method = RequestMethod.POST)
	public void applyKitchenCook(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.applyKitchenCook");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–厨师相关–申请成为厨师（保存厨师信息接口）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/updateCookInfo", method = RequestMethod.POST)
	public void updateCookInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.updateCookInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–厨师相关–修改厨师信息根据社群id与厨师id";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/checkUserFirstOrder", method = RequestMethod.POST)
	public void checkUserFirstOrder(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.checkUserFirstOrder");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–厨师相关–根据会员登录id判断该会员是否有首单归属(如没有消费过则不能申请厨师)";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/updateOperateStatus", method = RequestMethod.POST)
	public void updateOperateStatus(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.updateOperateStatus");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–厨师相关–根据厨师ID修改厨房营业状态（营业/停止营业）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/getCookBaseInfo", method = RequestMethod.POST)
	public void getCookBaseInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCookBaseInfo");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–厨师相关–获取厨师后台首页厨师基础信息（厨房名称、头像等";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/getCookOrderCountsById", method = RequestMethod.POST)
	public void getCookOrderCountsById(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCookOrderCountsById");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–厨师相关–获取厨师后台首页的各种销售数据统计数量（今日订单数量，预定数量，销售额等）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/getTodayFoodsById", method = RequestMethod.POST)
	public void getTodayFoodsById(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getTodayFoodsById");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–菜品相关–根据厨师登录id获取今日要做的菜品列表请求地址";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/getDataListByDictId", method = RequestMethod.POST)
	public void getDataListByDictId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getDataListByDictId");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–菜品相关–根据字典类型id得到字典数据（目前仅用于擅长菜系）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getAllFoodByCookId", method = RequestMethod.POST)
	public void getAllFoodByCookId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getAllFoodByCookId");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–获取厨师的所有菜品分页数据根据厨师id";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getSaleFoodsByCookId", method = RequestMethod.POST)
	public void getSaleFoodsByCookId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getSaleFoodsByCookId");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–获取厨师所有的上架菜品列表（设置预定菜单时使用）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/updateFoodSaleStatus", method = RequestMethod.POST)
	public void updateFoodSaleStatus(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.updateFoodSaleStatus");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–菜品相关–更改菜品上下架状态";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getGoodsList", method = RequestMethod.POST)
	public void getGoodsList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getGoodsList");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–菜品相关–根据关键字与厨师id获取到元素商品库中的所有未引入菜品";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getFoodStockByWeek", method = RequestMethod.POST)
	public void getFoodStockByWeek(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getFoodStockByWeek");
		log.setServerUrl(serverUrl);

		String clientModule = "APP后台–菜品相关–根据星期与厨师id获取到当天在售菜品的库存信息";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/updateFoodStockByWeek", method = RequestMethod.POST)
	public void updateFoodStockByWeek(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.updateFoodStockByWeek");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–根据星期与厨师id批量更改当天菜品的库存数量";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/getOrderListByType", method = RequestMethod.POST)
	public void getOrderListByType(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getOrderListByType");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–订单相关–根据订单类型获取厨师已付款的订单分页数据（今日/预定订单）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/confirmOrder", method = RequestMethod.POST)
	public void confirmOrder(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.confirmOrder");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–订单相关–厨师确认订单。根据登录id、名称、订单号、xmlid";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/cancelOrder", method = RequestMethod.POST)
	public void cancelOrder(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.cancelOrder");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–订单相关–厨师取消订单。根据登录id、名称、订单号、xmlid";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/getOrderDetailByCode", method = RequestMethod.POST)
	public void getOrderDetailByCode(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getOrderDetailByCode");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–订单相关–根据订单号获取订单详情";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefReserve/getReserveMenuByWeek", method = RequestMethod.POST)
	public void getReserveMenuByWeek(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getReserveMenuByWeek");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–预定菜品–根据星期获取预定菜品列表";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefReserve/updateReserveMenuByWeek", method = RequestMethod.POST)
	public void updateReserveMenuByWeek(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.updateReserveMenuByWeek");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–预定菜品–根据星期设置预定菜品";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/getWeeksMapInfo", method = RequestMethod.POST)
	public void getWeeksMapInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getWeeksMapInfo");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–其它–获取未来一周的日期与星期（包括今天）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getFoodMenuList", method = RequestMethod.POST)
	public void getFoodMenuList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getFoodMenuList");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–获取菜品标签列表（盖饭、汤羹等，添加/编辑菜品时使用）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getGoodsInfoBySku", method = RequestMethod.POST)
	public void getGoodsInfoBySku(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getGoodsInfoBySku");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–获产品信息（在添加菜品时选择相关菜品后页面显示使用）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/saveFoodInfo", method = RequestMethod.POST)
	public void saveFoodInfo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.saveFoodInfo");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–保存菜品信息";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getFoodInfoBySku", method = RequestMethod.POST)
	public void getFoodInfoBySku(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getFoodInfoBySku");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–菜品相关–获取需要修改的菜品信息";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/updateFoodInfoByAttr", method = RequestMethod.POST)
	public void updateFoodInfoByAttr(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.updateFoodInfoByAttr");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–修改菜品信息";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefReserve/deleteReserveFoodByWeek", method = RequestMethod.POST)
	public void deleteReserveFoodByWeek(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.deleteReserveFoodByWeek");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–预定相关–根据星期删除这个菜品的预定信息";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chef/memberLogin", method = RequestMethod.POST)
	public void memberLogin(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.memberLogin");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–登录相关–会员登录验证接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/getCookOrderListByAttr", method = RequestMethod.POST)
	public void getCookOrderListByAttr(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCookOrderListByAttr");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–订单相关–全部订单查询接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/getOrderInfoByOrderNo", method = RequestMethod.POST)
	public void getOrderInfoByOrderNo(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getOrderInfoByOrderNo");
		log.setServerUrl(serverUrl);

		String clientModule = "  APP后台–订单相关–根据订单号从购物车获取订单详情";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/getFoodOrderList", method = RequestMethod.POST)
	public void getFoodOrderList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getFoodOrderList");
		log.setServerUrl(serverUrl);

		String clientModule = "   APP后台–订单相关–根据foodSku查询相关的订单分页列表数据（已支付的订单,支付时间今天或预定时间是今天,订单未配送完成）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefOrder/getOrderStatisticCount", method = RequestMethod.POST)
	public void getOrderStatisticCount(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getOrderStatisticCount");
		log.setServerUrl(serverUrl);

		String clientModule = "   APP后台–订单相关–获取指定时间段内的全部订单统计数量（未就餐、已付款、已完成、其它等）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "chefFood/getFoodListByLoginId", method = RequestMethod.POST)
	public void getFoodListByLoginId(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getFoodListByLoginId");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–菜品相关–获取厨师所有菜品（从厨房本地数据库）";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "income/getIncomeDetail", method = RequestMethod.POST)
	public void getIncomeDetail(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getIncomeDetail");
		log.setServerUrl(serverUrl);

		String clientModule = "获取分账明细";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "income/getOrderDetail", method = RequestMethod.POST)
	public void getOrderDetail(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getOrderDetail");
		log.setServerUrl(serverUrl);

		String clientModule = "分账明细点击单个订单获取详情";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "image/img_upload", method = RequestMethod.POST)
	public void img_upload(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.img_upload");
		log.setServerUrl(serverUrl);

		String clientModule = " APP后台–图片相关–厨师、菜品图片上传";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	
	@RequestMapping(value = "income/getCountScore", method = RequestMethod.POST)
	public void getCountScore(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCountScore");
		log.setServerUrl(serverUrl);

		String clientModule = "getCountScore 接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "income/getCommentList", method = RequestMethod.POST)
	public void getCommentList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.getCommentList");
		log.setServerUrl(serverUrl);

		String clientModule = "getCommentList 接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	@RequestMapping(value = "community/kitchenList", method = RequestMethod.POST)
	public void kitchenList(HttpServletRequest request, HttpServletResponse response) {
		APIServiceLog log = (APIServiceLog) request.getAttribute("api_log");
		// 调用服务端的URL
		String serverUrl = MobileConfig.getProperty("mobile.apikitchen.vinuxpost.kitchenList");
		log.setServerUrl(serverUrl);

		String clientModule = "community/kitchenList 接口";
		Object res = MobileCommonManager.exec(request, clientModule);

		displayJSON(res, response);
	}
	
	
	

}


/* Drop Tables */

DROP TABLE CARD;
DROP TABLE CARD_BASE;
DROP TABLE CARD_ORDER;




/* Create Tables */

CREATE TABLE CARD
(
	ID bigint NOT NULL,
	-- CART_ID
	CART_ID varchar(32),
	-- 卡券编号（核销码）
	CART_CODE varchar,
	-- 卡券状态（0：未使用，1：已核销，2：已过期）
	CART_STATUS varchar,
	-- 用户openId
	USER_OPEN_ID varchar,
	-- 卡券领取时间
	RECEIVE_TIME datetime,
	-- 卡券领取方式（1：二维码扫描）
	RECEIVE_TYPE integer,
	-- 卡券核销时间
	USE_TIME datetime,
	-- 卡券核销方式（1：默认H5页面核销）
	USE_TYPE integer,
	PRIMARY KEY (ID)
);


CREATE TABLE CARD_BASE
(
	ID bigint NOT NULL,
	-- 微信卡券ID
	CARD_ID varchar(32),
	-- 卡券类型:
	-- CASH	代金券类型
	-- DISCOUNT	折扣券类型
	-- GROUPON	团购券类
	-- GIFT	兑换券
	-- GENERAL_COUPON	优惠券
	-- 
	CARD_TYPE varchar(16),
	-- CODE_TYPE_TEXT:仅code类型,仅适用于输码核销
	-- CODE_TYPE_QRCODE/CODE_TYPE_BARCODE	适用于扫码/输码核销
	CODE_TYPE varchar,
	-- 领取数量
	RECEIVE_COUNT integer DEFAULT 0,
	-- 使用数量
	USE_COUNT integer DEFAULT 0,
	-- 图片路径
	IMAGE_URL varchar(200),
	-- 商户名字,字数上限为12个汉字。
	BRAND_NAME varchar(36),
	-- 卡券库存的数量，上限为100000000。
	QUANTITY integer,
	-- 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
	TITLE varchar(27),
	-- 券颜色。按色彩规范标注填写Color010-Color100。
	COLOR varchar(16),
	-- 卡券使用提醒，字数上限为16个汉字。
	NOTICE varchar(48),
	-- 卡券使用说明，字数上限为1024个汉字。
	DESCRIPTION varchar(3072),
	-- 商品信息，JSON格式
	SKU varchar,
	-- 使用日期，有效期的信息。JSON结构
	DATE_INFO varchar,
	-- 使用时间的类型。DATE_TYPE_FIX _TIME_RANGE 表示固定日期区间，DATETYPE FIX_TERM 表示固定时长 
	TYPE varchar(32),
	-- type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间.（ 东八区时间,UTC+8，单位为秒 ）
	BEGIN_TIMESTAMP bigint,
	-- 表示结束时间 ， 建议设置为截止日期的23:59:59过期 。 （ 东八区时间,UTC+8，单位为秒 ）
	END_TIMESTAMP bigint,
	-- type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。
	FIXED_TERM bigint,
	-- type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）
	FIXED_BEGIN_TERM integer,
	-- 可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间 ， 建议设置为截止日期的23:59:59过期 。 （ 东八区时间,UTC+8，单位为秒 ），设置了fixed_term卡券，当时间达到end_timestamp时卡券统一过期
	END_TIME_STAMP bigint,
	-- 修改时间
	MDATE datetime,
	-- 创建时间
	CDATE datetime DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (ID)
);


CREATE TABLE CARD_ORDER
(
	ID bigint NOT NULL,
	-- 订单号（购物车下单返回）
	ORDER_NO varchar(20),
	-- 卡券编号（核销码）
	CART_CODE varchar(32),
	-- 卡券名称
	CART_NAME varchar(64),
	-- 卡券抵扣金额（元）
	CART_MONEY float,
	CDATE datetime DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (ID)
);




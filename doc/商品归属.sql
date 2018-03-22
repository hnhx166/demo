SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS PRODUCT_CATALOG;




/* Create Tables */

CREATE TABLE PRODUCT_CATALOG
(
	ID bigint NOT NULL AUTO_INCREMENT,
	CATALOG_ID bigint,
	PRODUCT_ID bigint,
	PRODUCT_SKU varchar(64),
	MEMBER_ID bigint,
	OPERATOR bigint,
	MDATE datetime DEFAULT NOW(), SYSDATE(),
	CDATE datetime DEFAULT NOW(), SYSDATE(),
	PRIMARY KEY (ID)
);




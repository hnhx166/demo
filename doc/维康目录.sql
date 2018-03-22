
/* Drop Tables */

DROP TABLE CATALOG;
DROP TABLE CATALOG_RELATION;




/* Create Tables */

-- CATALOG
CREATE TABLE CATALOG
(
	-- ID
	ID bigint DEFAULT 0 NOT NULL,
	-- PARENT_ID : 父节点ID
	PARENT_ID bigint DEFAULT 0,
	-- MEMBER_ID : 角色ID
	MEMBER_ID bigint,
	-- NAME : 目录名称
	NAME varchar(50) NOT NULL,
	-- NUM
	NUM bigint,
	-- PLATFORM : 终端 1手机端
	PLATFORM bigint DEFAULT 0,
	-- STATUS : 状态:0启用，1禁用
	STATUS integer DEFAULT 0,
	-- MDATE
	MDATE datetime,
	-- CDATE
	CDATE datetime DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (ID)
);


-- CATALOG_RELATION
CREATE TABLE CATALOG_RELATION
(
	-- ID
	ID bigint NOT NULL,
	-- MEMBER_ID
	MEMBER_ID bigint,
	-- CATALOG_ID
	CATALOG_ID bigint,
	-- NUM
	NUM integer,
	-- STATUS
	STATUS integer,
	-- MDATE
	MDATE datetime,
	-- CDATE
	CDATE datetime DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (ID)
);




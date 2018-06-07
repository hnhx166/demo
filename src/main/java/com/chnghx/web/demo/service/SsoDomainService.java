package com.chnghx.web.demo.service;

import java.util.Map;

import com.chnghx.core.mybatis.page.Pagination;
import com.chnghx.service.entity.SsoDomain;

public interface SsoDomainService {
	
	Pagination<SsoDomain> findSsoDomainsByPage(Map<String,Object> paraMap, Integer pageSize, Integer pageNo);
}

package com.chnghx.web.demo.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.chnghx.core.mybatis.base.BaseMybatisDao;
import com.chnghx.core.mybatis.page.Pagination;
import com.chnghx.service.dao.SsoDomainMapper;
import com.chnghx.service.entity.SsoDomain;
import com.chnghx.web.demo.service.SsoDomainService;

@Service("ssoDomainService")
public class SsoDomainServiceImpl extends BaseMybatisDao<SsoDomainMapper> implements SsoDomainService {

	@Override
	public Pagination<SsoDomain> findSsoDomainsByPage(Map<String,Object> params, Integer pageSize, Integer pageNo) {
//		super.findByPageBySqlId(sqlId, params, pageNo, pageSize);
		super.findPage("selectDomains", "selectDomainCount", params, pageNo, pageSize);
		return null;
	}

   
	
	

}

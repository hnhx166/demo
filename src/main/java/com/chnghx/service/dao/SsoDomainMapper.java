package com.chnghx.service.dao;

import com.chnghx.service.entity.SsoDomain;

public interface SsoDomainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SsoDomain record);

    int insertSelective(SsoDomain record);

    SsoDomain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SsoDomain record);

    int updateByPrimaryKey(SsoDomain record);
}
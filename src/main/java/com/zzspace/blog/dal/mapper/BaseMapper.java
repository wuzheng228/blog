package com.zzspace.blog.dal.mapper;

/**
 * Created by 76973 on 2021/6/17 22:16
 */
public interface BaseMapper<D> {

    int insertSelective(D record);

    int updateByPrimaryKeySelective(D record);

    D selectByPrimaryKey(Long id);
}

package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.mapper.BaseMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/17 22:27
 */
public abstract class BaseRepository<D> {

    @Autowired
    protected BaseMapper<D> mapper;

    public Long save(D record) {
        return (long)mapper.insertSelective(record);
    }

    public int updateById(D record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    public D findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    public D fetchOne(List<D> records) {
        if (CollectionUtils.isNotEmpty(records)) {
            return records.get(0);
        }
        return null;
    }

    public D selectByPrimaryKey (Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}

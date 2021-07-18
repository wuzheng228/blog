package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.dal.domain.TypeExample;
import com.zzspace.blog.dal.mapper.BlogMapper;
import com.zzspace.blog.dal.mapper.TypeMapper;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.query.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Priority;
import javax.annotation.Resource;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by 76973 on 2021/5/24 22:24
 */
@Repository
public class TypeRepository {
    @Resource
    private TypeMapper typeMapper;

    public TypeDO insertType(TypeDO typeDO) {
        int i = typeMapper.insertSelective(typeDO);
        return typeDO;
    }

    public TypeDO findTypeById(int id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    public List<TypeDO> listType(Pageable pageable) {
        TypeExample example = new TypeExample();
        example.setOffset(pageable.getOffset());
        example.setLimit(pageable.getLimit());
        return typeMapper.selectByExample(example);
    }

    public List<TypeDO> listType() {
        return typeMapper.selectByExample(new TypeExample());
    }

    public TypeDO findTypeByName(String name) {
        TypeExample example = new TypeExample();
        example.createCriteria().andNameEqualTo(name);
        List<TypeDO> typeDOS = typeMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(typeDOS)) {
            return null;
        }
        return typeDOS.get(0);
    }

    public int updateById(int id, TypeDO typeDO) {
        TypeExample example = new TypeExample();
        example.createCriteria().andIdEqualTo(id);
        int i = typeMapper.updateByExampleSelective(typeDO, example);
        return i;
    }

    public int deleteById(int id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    public Long countType() {
        return typeMapper.countByExample(new TypeExample());
    }
}

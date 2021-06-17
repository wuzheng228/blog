package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.dal.domain.TypeExample;
import com.zzspace.blog.dal.mapper.BlogMapper;
import com.zzspace.blog.dal.mapper.TypeMapper;
import com.zzspace.blog.model.dto.PageDTO;
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
    @Resource
    private BlogMapper blogMapper;

    public TypeDO insertType(TypeDO typeDO) {
        int i = typeMapper.insertSelective(typeDO);
        return typeDO;
    }

    public TypeDO findTypeById(int id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    public PageDTO<TypeDO> listType(Integer start, Integer pageSize) {
        TypeExample example = new TypeExample();
        long count = typeMapper.countByExample(example);
        PageDTO<TypeDO> pageDTO = new PageDTO<>(start, pageSize, 2, count);
        example.setOffset((pageDTO.getCurpage() - 1) * pageDTO.getPageSize());
        example.setLimit(pageDTO.getPageSize());
        List<TypeDO> typeDOS = typeMapper.selectByExample(example);
        pageDTO.setPageData(typeDOS);
        return pageDTO;
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

}

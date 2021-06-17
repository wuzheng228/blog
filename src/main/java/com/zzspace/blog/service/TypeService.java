package com.zzspace.blog.service;


import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.dto.TypeDTO;

import java.util.List;

/**
 * Created by 76973 on 2021/5/23 11:25
 */
public interface TypeService {
    TypeDTO insertType(TypeDTO typeDO);

    TypeDTO findTypeById(int id);

    PageDTO<TypeDO> listType(Integer start, Integer pageSize);

    List<TypeDTO> listType();

    int upateTypeById(int id, TypeDTO typeDO);

    TypeDTO findTypeByName(String name);

    int deleteById(int id);

    List<TypeDTO> findTopKType(int k);
}

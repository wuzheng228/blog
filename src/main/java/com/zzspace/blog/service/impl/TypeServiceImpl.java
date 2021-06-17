package com.zzspace.blog.service.impl;

import com.zzspace.blog.common.strategy.Sorter;
import com.zzspace.blog.common.strategy.impl.Sorters;
import com.zzspace.blog.common.util.ConvertUtils;
import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.dal.repository.BlogRepository;
import com.zzspace.blog.dal.repository.TypeRepository;
import com.zzspace.blog.model.dto.PageDTO;
import com.zzspace.blog.model.dto.TypeDTO;
import com.zzspace.blog.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/5/24 22:22
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeRepository typeRepository;
    @Resource
    private BlogRepository blogRepository;

    @Override
    public TypeDTO insertType(TypeDTO type) {
        TypeDO convert = ConvertUtils.convert(type, TypeDO.class);
        TypeDO typeDO = typeRepository.insertType(convert);
        return ConvertUtils.convert(typeDO, TypeDTO.class);
    }

    @Override
    public TypeDTO findTypeById(int id) {
        TypeDO typeDO = typeRepository.findTypeById(id);
        return ConvertUtils.convert(typeDO, TypeDTO.class);
    }

    @Override
    public TypeDTO findTypeByName(String name) {
        TypeDO typeDO = typeRepository.findTypeByName(name);
        if (typeDO == null) {
            return null;
        }
        return ConvertUtils.convert(typeDO, TypeDTO.class);
    }

    @Override
    public PageDTO<TypeDO> listType(Integer start, Integer pageSize) {
        return typeRepository.listType(start, pageSize);
    }

    @Override
    public List<TypeDTO> listType() {
        List<TypeDO> typeDOS = typeRepository.listType();
        return ConvertUtils.convertList(typeDOS, TypeDTO.class);
    }

    @Override
    public int upateTypeById(int id, TypeDTO typeDTO) {
        TypeDO typeDO = ConvertUtils.convert(typeDTO, TypeDO.class);
        return typeRepository.updateById(id, typeDO);
    }

    @Override
    public int deleteById(int id) {
        return typeRepository.deleteById(id);
    }

    @Override
    public List<TypeDTO> findTopKType(int k) {
        List<TypeDO> typeDOS = typeRepository.listType();
        List<TypeDTO> typeDTOS = ConvertUtils.convertList(typeDOS, TypeDTO.class);
        typeDTOS.forEach(typeDTO -> {
            long num = blogRepository.countBlogByTypeId(typeDTO.getId());
            typeDTO.setBlogNum(num);
        });
        return Sorters.TOPK_PRIORITI_QUEUE.topK(typeDTOS, k, Sorter.DESC);
    }
}

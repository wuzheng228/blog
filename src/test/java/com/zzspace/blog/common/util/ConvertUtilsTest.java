package com.zzspace.blog.common.util;

import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.model.dto.TypeDTO;
import org.junit.jupiter.api.Test;

/**
 * Created by 76973 on 2021/6/5 9:30
 */

public class ConvertUtilsTest {

    @Test
    public void convert2DO() {
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.setId(2);
        typeDTO.setName("java");
        TypeDO typeDO = ConvertUtils.convert(typeDTO, TypeDO.class);
        System.out.println(typeDO);
    }
}

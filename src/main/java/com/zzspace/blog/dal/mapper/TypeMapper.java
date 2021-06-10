package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.TypeDO;
import com.zzspace.blog.dal.domain.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TypeMapper {
    long countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TypeDO record);

    int insertSelective(TypeDO record);

    List<TypeDO> selectByExample(TypeExample example);

    TypeDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TypeDO record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") TypeDO record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(TypeDO record);

    int updateByPrimaryKey(TypeDO record);

    int batchInsert(@Param("list") List<TypeDO> list);

    int batchInsertSelective(@Param("list") List<TypeDO> list, @Param("selective") TypeDO.Column ... selective);
}
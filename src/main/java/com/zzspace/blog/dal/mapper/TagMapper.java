package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.TagDO;
import com.zzspace.blog.dal.domain.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagMapper extends BaseMapper<TagDO> {
    long countByExample(TagExample example);

    int deleteByExample(TagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TagDO record);

    int insertSelective(TagDO record);

    List<TagDO> selectByExample(TagExample example);

    TagDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TagDO record, @Param("example") TagExample example);

    int updateByExample(@Param("record") TagDO record, @Param("example") TagExample example);

    int updateByPrimaryKeySelective(TagDO record);

    int updateByPrimaryKey(TagDO record);

    int batchInsert(@Param("list") List<TagDO> list);

    int batchInsertSelective(@Param("list") List<TagDO> list, @Param("selective") TagDO.Column ... selective);
}
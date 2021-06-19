package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.BlogTagDO;
import com.zzspace.blog.dal.domain.BlogTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogTagMapper extends BaseMapper<BlogTagDO> {
    long countByExample(BlogTagExample example);

    int deleteByExample(BlogTagExample example);

    int insert(BlogTagDO record);

    int insertSelective(BlogTagDO record);

    List<BlogTagDO> selectByExample(BlogTagExample example);

    int updateByExampleSelective(@Param("record") BlogTagDO record, @Param("example") BlogTagExample example);

    int updateByExample(@Param("record") BlogTagDO record, @Param("example") BlogTagExample example);

    int batchInsert(@Param("list") List<BlogTagDO> list);

    int batchInsertSelective(@Param("list") List<BlogTagDO> list, @Param("selective") BlogTagDO.Column ... selective);
}
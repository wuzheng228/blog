package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.BlogDO;
import com.zzspace.blog.dal.domain.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogMapper {
    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogDO record);

    int insertSelective(BlogDO record);

    List<BlogDO> selectByExampleWithBLOBs(BlogExample example);

    List<BlogDO> selectByExample(BlogExample example);

    BlogDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BlogDO record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogDO record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") BlogDO record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(BlogDO record);

    int updateByPrimaryKeyWithBLOBs(BlogDO record);

    int updateByPrimaryKey(BlogDO record);

    int batchInsert(@Param("list") List<BlogDO> list);

    int batchInsertSelective(@Param("list") List<BlogDO> list, @Param("selective") BlogDO.Column ... selective);
}
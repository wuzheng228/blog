package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.CommentDO;
import com.zzspace.blog.dal.domain.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper extends BaseMapper<CommentDO> {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentDO record);

    int insertSelective(CommentDO record);

    List<CommentDO> selectByExample(CommentExample example);

    CommentDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentDO record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") CommentDO record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(CommentDO record);

    int updateByPrimaryKey(CommentDO record);

    int batchInsert(@Param("list") List<CommentDO> list);

    int batchInsertSelective(@Param("list") List<CommentDO> list, @Param("selective") CommentDO.Column ... selective);
}
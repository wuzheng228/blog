package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.PathDO;
import com.zzspace.blog.dal.domain.PathExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PathMapper extends BaseMapper<PathDO> {
    long countByExample(PathExample example);

    int deleteByExample(PathExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PathDO record);

    int insertSelective(PathDO record);

    List<PathDO> selectByExample(PathExample example);

    PathDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PathDO record, @Param("example") PathExample example);

    int updateByExample(@Param("record") PathDO record, @Param("example") PathExample example);

    int updateByPrimaryKeySelective(PathDO record);

    int updateByPrimaryKey(PathDO record);

    int batchInsert(@Param("list") List<PathDO> list);

    int batchInsertSelective(@Param("list") List<PathDO> list, @Param("selective") PathDO.Column ... selective);
}
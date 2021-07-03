package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.FileDO;
import com.zzspace.blog.dal.domain.FileExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileMapper extends BaseMapper<FileDO> {
    long countByExample(FileExample example);

    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileDO record);

    int insertSelective(FileDO record);

    List<FileDO> selectByExample(FileExample example);

    FileDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileDO record, @Param("example") FileExample example);

    int updateByExample(@Param("record") FileDO record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(FileDO record);

    int updateByPrimaryKey(FileDO record);

    int batchInsert(@Param("list") List<FileDO> list);

    int batchInsertSelective(@Param("list") List<FileDO> list, @Param("selective") FileDO.Column ... selective);
}
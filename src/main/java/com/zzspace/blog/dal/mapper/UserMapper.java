package com.zzspace.blog.dal.mapper;

import com.zzspace.blog.dal.domain.UserDO;
import com.zzspace.blog.dal.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    List<UserDO> selectByExample(UserExample example);

    UserDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserExample example);

    int updateByExample(@Param("record") UserDO record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    int batchInsert(@Param("list") List<UserDO> list);

    int batchInsertSelective(@Param("list") List<UserDO> list, @Param("selective") UserDO.Column ... selective);
}
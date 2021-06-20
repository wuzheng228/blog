package com.zzspace.blog.dao;

import com.zzspace.blog.dal.domain.BlogDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 76973 on 2021/6/20 21:56
 */
@Mapper
public interface BlogDAO {

    @Select("select * from tb_blog")
    List<BlogDO> listBlog();
}

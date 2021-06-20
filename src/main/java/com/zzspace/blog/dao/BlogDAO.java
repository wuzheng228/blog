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

    @Select("select * from tb_blog b join tb_blog_tag tb JOIN tb_tag t where tb.blog_id = b.id AND tb.tag_id = t.id;")
    List<BlogDO> listBlog();
}

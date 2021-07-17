package com.zzspace.blog.dao;

import com.zzspace.blog.dal.domain.BlogDO;
import com.zzspace.blog.model.query.BlogQuery;
import com.zzspace.blog.model.query.Pageable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 76973 on 2021/6/20 21:56
 */
@Mapper
public interface BlogDAO {
    List<BlogDO> listBlogByTagId(BlogQuery query);

    @Select("select date_format(b.gmt_created, '%Y') as year from tb_blog b where is_deleted = false group by year order by year desc")
    List<String> findGroupYear();

    @Select("select * from tb_blog b where date_format(b.gmt_created, '%Y') = #{year} and is_deleted = false order by b.gmt_created desc limit #{pageable.startRow},#{pageable.pageSize}")
    List<BlogDO> listByYear(String year, Pageable pageable);

    @Select("select count(*) from tb_blog b where is_deleted = false and date_format(b.gmt_created, '%Y') = #{year}")
    Long countByYear(String year);

    Long countBlogByTagId(Long id);
}

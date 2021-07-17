package com.zzspace.blog.dao;

import com.zzspace.blog.dal.domain.BlogDO;
import com.zzspace.blog.model.query.BlogQuery;
import com.zzspace.blog.model.query.Pageable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/6/20 22:00
 */
@SpringBootTest
public class BlogDAOTest {
    @Resource
    private BlogDAO blogDAO;

    @Test
    public void findGroupByYear() {
        List<String> years = blogDAO.findGroupYear();
        System.out.println(years);
    }

    @Test
    public void listByYear() {
        List<BlogDO> strings = blogDAO.listByYear("2021", new Pageable());
        System.out.println(strings.size());
//        System.out.println(strings);
    }

    @Test
    public void countByTagId() {
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setTagId(18L);
        Long aLong = blogDAO.countBlogByTagId(blogQuery.getTagId());
        System.out.println(aLong);
    }
}

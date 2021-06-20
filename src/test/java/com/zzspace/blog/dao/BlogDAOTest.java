package com.zzspace.blog.dao;

import com.zzspace.blog.dal.domain.BlogDO;
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
    public void listAllBlogTest() {
        List<BlogDO> blogDOS = blogDAO.listBlog();
        System.out.println(blogDOS);
    }
}

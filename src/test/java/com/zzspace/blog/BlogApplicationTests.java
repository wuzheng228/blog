package com.zzspace.blog;

import com.zzspace.blog.dal.domain.UserDO;
import com.zzspace.blog.dal.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BlogApplicationTests {

    @Resource
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper);
        UserDO userDO = userMapper.selectByPrimaryKey(1);
        System.out.println(userDO);
    }

}

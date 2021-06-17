package com.zzspace.blog.dal.repository;

import com.zzspace.blog.dal.domain.UserDO;
import com.zzspace.blog.dal.domain.UserExample;
import com.zzspace.blog.dal.mapper.UserMapper;
import com.zzspace.blog.model.dto.UserDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 76973 on 2021/5/16 21:46
 */

@Repository
public class UserRepository {
    @Resource
    private UserMapper userMapper;

    public UserDO getUserByEmailAndPassword(String email, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<UserDO> userDOS = userMapper.selectByExample(example);
        return CollectionUtils.isEmpty(userDOS) ? null : userDOS.get(0);
//        return null;
    }

    public UserDO findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

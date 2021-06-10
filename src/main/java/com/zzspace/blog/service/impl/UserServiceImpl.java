package com.zzspace.blog.service.impl;

import com.zzspace.blog.common.util.MD5Utils;
import com.zzspace.blog.dal.domain.UserDO;
import com.zzspace.blog.dal.repository.UserRepository;
import com.zzspace.blog.model.dto.UserDTO;
import com.zzspace.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 76973 on 2021/5/16 21:45
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    public UserDTO checkUser(String email, String password) {
        UserDO userDO = userRepository.getUserByEmailAndPassword(email, MD5Utils.stringToMD5(password));
        if (userDO == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDO.getId());
        userDTO.setUsername(userDO.getUsername());
        userDTO.setEmail(userDO.getEmail());
        return userDTO;
    }
}

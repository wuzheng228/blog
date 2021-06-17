package com.zzspace.blog.service;

import com.zzspace.blog.model.dto.UserDTO;

/**
 * Created by 76973 on 2021/5/16 21:53
 */
public interface UserService {
    UserDTO checkUser(String email, String password);
    UserDTO findUserById(int id);
}

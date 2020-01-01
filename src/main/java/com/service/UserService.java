package com.service;

import com.pojo.User;

import java.util.List;

/**
 * Created by lemon on 2019-12-29 14:02.
 */
public interface UserService {
    Integer registerUser(User user);
    Integer logOut(Long id);
    Integer changePassword(String username, String passWord, String newPassWord);
    List<User> findByCondition(String keyWord);
    Integer login(String username, String passWord);

    Integer updateUser(User user);
}

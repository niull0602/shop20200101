package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.pojo.UserExample;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lemon on 2019-12-29 14:02.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Integer registerUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public Integer logOut(Long id) {
        return userDao.deleteById(id);
    }

    @Override
    public Integer changePassword(String username,String passWord, String newPassWord) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(newPassWord);
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.createCriteria().andPasswordEqualTo(passWord);
        return userDao.changePassWord(user,example);
    }

    @Override
    public List<User> findByCondition(String keyWord) {
        return userDao.findUsersByNickName(keyWord);
    }

    @Override
    public Integer login(String username, String passWord) {
        return userDao.select(username,passWord);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.update(user);
    }
}

package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lemon on 2020-01-01 0:56.
 */
@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping(value = "add", produces = "text/html;charset=utf-8")
    public String add(User user){
        Integer i = service.registerUser(user);
        if (i==1)
        return "注册成功";
        else
            return "注册失败";
    }

    @GetMapping(value = "login", produces = "text/html;charset=utf-8")
    public String login(User user){
        Integer i = service.login(user.getUsername(),user.getPassword());
        if (i==1)
            return "登录成功";
        else
            return "登录失败";
    }

    @DeleteMapping(value = "logOut", produces = "text/html;charset=utf-8")
    public String logOut(User user){
        Integer i = service.logOut(user.getId());
        if (i==1)
            return "删除成功";
        else
            return "删除失败";
    }

    @GetMapping(value = "find", produces = "text/html;charset=utf-8")
    public List<User> logOut(String key){
        List<User> list = service.findByCondition(key);
        return list;
    }

    @PutMapping(value = "update", produces = "text/html;charset=utf-8")
    public String update(User user){
        Integer result = service.updateUser(user);
        if (result.equals(1)){
            return "用户更新成功";
        }else {
            return "更新失败";
        }
    }
}

package com.dao;

import com.mapper.UserMapper;
import com.pojo.User;
import com.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lemon on 2019-12-29 14:02.
 */
@Repository
public class UserDao {
    @Autowired
    UserMapper mapper;

    public Integer insert(User user) {
        return mapper.insert(user);
    }

    public Integer deleteById(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer changePassWord(User user,UserExample userExample) {
        return mapper.updateByExampleSelective(user,userExample);
    }

    public List<User> findUsersByNickName(String keyWord) {
        UserExample example = new UserExample();
        example.createCriteria().andNickNameLike("%"+keyWord+"%");
        return mapper.selectByExample(example);
    }

    public Integer select(String username, String passWord) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.createCriteria().andPasswordEqualTo(passWord);
        List<User> list = mapper.selectByExample(example);
        if (list.size()==1){
            return 1;
        }else {
            return 0;
        }
    }

    public Integer update(User user) {
        return mapper.updateByPrimaryKeySelective(user);
    }
}

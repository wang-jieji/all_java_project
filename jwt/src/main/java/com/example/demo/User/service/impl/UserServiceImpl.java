package com.example.demo.User.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.User.entity.User;
import com.example.demo.User.mapper.UserMapper;
import com.example.demo.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author WJJ
 * @since 2021-04-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
     User userDB = userMapper.selectOne(new QueryWrapper<User>().eq(true,"NAME",user.getName()));
     if(userDB != null) {
         return userDB;
     }
     throw  new RuntimeException("认证失败");

    }
}

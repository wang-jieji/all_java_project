package com.example.demo.User.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.User.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author WJJ
 * @since 2021-04-02
 */
public interface UserService extends IService<User> {

    User login(User user);
}

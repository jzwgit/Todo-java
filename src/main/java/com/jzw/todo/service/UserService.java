package com.jzw.todo.service;

import com.jzw.todo.entity.User;

public interface UserService {
    //注册
    public int insertUser(User user);
    //登录
    public User selectUser(User user);
}

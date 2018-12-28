package com.jzw.todo.mapper;

import com.jzw.todo.entity.User;

public interface UserMapper {
    //注册
    public int insertUser(User user);
    //登录
    public User selectUser(User user);
}

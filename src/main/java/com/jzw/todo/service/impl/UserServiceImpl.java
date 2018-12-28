package com.jzw.todo.service.impl;

import com.jzw.todo.entity.User;
import com.jzw.todo.mapper.UserMapper;
import com.jzw.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }
}

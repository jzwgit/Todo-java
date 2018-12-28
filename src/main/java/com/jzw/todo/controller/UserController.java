package com.jzw.todo.controller;

import com.jzw.todo.entity.User;
import com.jzw.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @RequestMapping("/register")
    @ResponseBody
    public boolean register(@RequestBody User user){
        user.setLoginTime(sdf.format(new Date()));
        System.out.println(user);
        int rows = userService.insertUser(user);
        if(rows>0){
            return true;
        }
        return false;
    }

    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody User user, HttpSession session){
        User user1 = userService.selectUser(user);
        if(user1 != null) {
            user1.setLoginTime(sdf.format(new Date()));
            session.setAttribute("user",user1);
            return user1;
        }
        return null;
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public User checkUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user;
    }
}

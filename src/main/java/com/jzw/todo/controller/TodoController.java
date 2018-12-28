package com.jzw.todo.controller;

import com.jzw.todo.entity.Todo;
import com.jzw.todo.entity.User;
import com.jzw.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("/insert")
    @ResponseBody
    public boolean insertTodo(@RequestBody Todo todo, HttpSession session){
        User user = (User)session.getAttribute("user");
        todo.setUid(user.getId());
        todo.setCreateTime(sdf.format(new Date()));
        System.out.println(todo);
        int rows = todoService.insertTodo(todo);
        if(rows > 0) {
            return true;
        }
        return false;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public boolean deleteTodo(@RequestBody Todo todo, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user != null){
            int rows = todoService.deleteTodo(todo.getId());
            if(rows>0){
                return true;
            }
        }
        return false;
    }

    @RequestMapping("/select")
    @ResponseBody
    public List<Todo> selectTodos(@RequestBody Todo todo, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user != null) {
            List<Todo> todos = todoService.selectTodos(todo);
            return todos;
        }
        return null;
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updateTodo(@RequestBody Todo todo, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user != null) {
            todo.setCreateTime(sdf.format(new Date()));
            int rows = todoService.updateTodo(todo);
            if(rows > 0) {
                return true;
            }
        }
        return false;
    }
}

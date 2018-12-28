package com.jzw.todo.service.impl;

import com.jzw.todo.entity.Todo;
import com.jzw.todo.mapper.TodoMapper;
import com.jzw.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoMapper todoMapper;
    @Override
    public int insertTodo(Todo todo) {
        return todoMapper.insertTodo(todo);
    }

    @Override
    public int deleteTodo(int id) {
        return todoMapper.deleteTodo(id);
    }

    @Override
    public List<Todo> selectTodos(Todo todo) {
        return todoMapper.selectTodos(todo);
    }

    @Override
    public int updateTodo(Todo todo) {
        return todoMapper.updateTodo(todo);
    }
}

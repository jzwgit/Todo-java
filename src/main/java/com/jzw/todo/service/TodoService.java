package com.jzw.todo.service;

import com.jzw.todo.entity.Todo;

import java.util.List;

public interface TodoService {
   public int insertTodo(Todo todo);
   public int deleteTodo(int id);
   public List<Todo> selectTodos(Todo todo);
   public int updateTodo(Todo todo);
}

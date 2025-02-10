package com.todolist.list.repository;

import com.todolist.list.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {



}

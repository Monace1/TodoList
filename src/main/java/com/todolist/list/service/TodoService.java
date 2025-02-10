package com.todolist.list.service;

import com.todolist.list.model.Todo;
import com.todolist.list.repository.TodoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return Optional.ofNullable(todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id:" + id)));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id).map(existingTodo -> {
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setCompleted(updatedTodo.isCompleted());

            return todoRepository.save(existingTodo);
        }).orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Transactional
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Task not found with id: " + id);
        }
        todoRepository.deleteById(id);
    }
}

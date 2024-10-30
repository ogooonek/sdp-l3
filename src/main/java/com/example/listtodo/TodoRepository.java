package com.example.listtodo;

import com.example.listtodo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoItem, Long> {
}

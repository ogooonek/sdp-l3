package com.example.listtodo.controller;

import com.example.listtodo.model.TodoItem;
import com.example.listtodo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public String listTodos(Model model) {
        List<TodoItem> todos = todoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todoList"; // имя представления (HTML)
    }

    @PostMapping("/create")
    public String createTodo(@RequestParam String title) {
        TodoItem todoItem = new TodoItem(title);
        todoRepository.save(todoItem);
        return "redirect:/todos"; // перенаправление на список
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/todos"; // перенаправление на список
    }
}

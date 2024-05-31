package com.sparta.todo.controller;

import com.sparta.todo.dto.TodoRequestDto;
import com.sparta.todo.dto.TodoResponseDto;
import com.sparta.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.createTodo(todoRequestDto);
    }

    @GetMapping("/todos/{id}")
    public TodoResponseDto selectTodoById(@PathVariable Long id) {
        return todoService.selectTodo(id);
    }

    @GetMapping("/todos")
    public List<TodoResponseDto> getAllTodoList(){
        return todoService.getAllTodoList();
    }

    @PutMapping("/todos/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.updateTodo(id, todoRequestDto);
    }
    @DeleteMapping("/todos/{id}")
    public TodoResponseDto deleteTodo(@PathVariable Long id, @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.deleteTodo(id, todoRequestDto);
    }
}


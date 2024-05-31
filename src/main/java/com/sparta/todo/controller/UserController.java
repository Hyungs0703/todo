package com.sparta.todo.controller;

import com.sparta.todo.dto.UserRequestDto;
import com.sparta.todo.dto.UserResponseDto;
import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.repository.UserRepository;
import com.sparta.todo.service.TodoService;
import com.sparta.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")

public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping("/users/{id}")
    public UserResponseDto createUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.createUser(id,userRequestDto);
    }
    @PutMapping("/users/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        return userService.updateUser(id, userRequestDto);
    }
    @ResponseStatus
    @DeleteMapping("/users/{id}")
    public UserResponseDto deleteUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto ) {
        log.info("선택한 일정이 삭제되었습니다.{}", id);
        return userService.deleteUser(id, userRequestDto);
    }
}

package com.sparta.todo.dto;

import lombok.Getter;

@Getter
public class TodoRequestDto {
    private String title;
    private String content;
    private String writer;
    private String password;
}

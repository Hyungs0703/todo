package com.sparta.todo.dto;

import lombok.Getter;

@Getter
public class UserRequestDto {
    private String comment;
    private String consumerId;
    private Long selectTodoId;
}

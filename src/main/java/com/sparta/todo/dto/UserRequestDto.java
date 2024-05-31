package com.sparta.todo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequestDto {
    private String comment;
    private String consumerId;
    private Long selectTodoId;
}

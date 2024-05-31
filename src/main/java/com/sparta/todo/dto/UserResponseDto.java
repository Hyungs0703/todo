package com.sparta.todo.dto;

import com.sparta.todo.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private String comment;
    private String consumerId;
    private Long selectTodoId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public UserResponseDto(User user) {
        this.comment = user.getComment();
        this.consumerId = user.getConsumerId();
        this.selectTodoId = user.getSelectTodoId();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }
}

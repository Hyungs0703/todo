package com.sparta.todo.dto;

import com.sparta.todo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoResponseDto {

    private String title;
    private String content;
    private String writer;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    @Builder
    public TodoResponseDto(Todo todo) {
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.writer = todo.getWriter();
        this.createAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}



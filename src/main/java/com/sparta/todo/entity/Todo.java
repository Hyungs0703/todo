package com.sparta.todo.entity;


import com.sparta.todo.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "todos")
@NoArgsConstructor
public class Todo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column
    private String content;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "orders", // 중간 테이블 생성
            joinColumns = @JoinColumn(name = "todo_id"), // 현재 위치인 Food Entity 에서 중간 테이블로 조인할 컬럼 설정
            inverseJoinColumns = @JoinColumn(name = "user_id")) // 반대 위치인 User Entity 에서 중간 테이블로 조인할 컬럼 설정
    private List<User> userList = new ArrayList<>();

    public Todo(TodoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
        this.password = requestDto.getPassword();
    }
    @Builder
    public void updateTodo(TodoRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.writer = requestDto.getWriter();
    }
}

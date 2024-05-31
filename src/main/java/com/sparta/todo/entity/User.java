package com.sparta.todo.entity;

import com.sparta.todo.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "user")
@NoArgsConstructor
public class User extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String comment;
    @Column(nullable = false)
    private String consumerId;
    @Column(nullable = false)
    private Long selectTodoId;

    @ManyToMany(mappedBy = "userList")
    private List<Todo> todoList = new ArrayList<>();

    public void addFoodList(Todo todo) {
        this.todoList.add(todo);
        todo.getUserList().add(this); // 외래 키(연관 관계) 설정
    }

    public User(UserRequestDto userRequestDto) {
        this.comment = userRequestDto.getComment();
        this.consumerId = userRequestDto.getConsumerId();
        this.selectTodoId = userRequestDto.getSelectTodoId();
    }

    public void updateUser(UserRequestDto userRequestDto) {
        this.comment = userRequestDto.getComment();
    }
}

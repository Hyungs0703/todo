package com.sparta.todo.service;

import com.sparta.todo.dto.UserRequestDto;
import com.sparta.todo.dto.UserResponseDto;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.entity.User;
import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final TodoService todoService;

    //댓글 생성
    public UserResponseDto createUser(Long id, UserRequestDto userRequestDto) {
        Todo todo = todoService.findById(id);
        User user = new User(userRequestDto);
        if(!todo.getId().equals(user.getSelectTodoId())) {
            throw new IllegalArgumentException("Todo id와 일정번호가 맞지 않습니다");
        }
        if(user.getComment() == null){
            throw new NullPointerException("내용이 적혀져있지 않습니다.");
        }
        userRepository.save(user);
        return new UserResponseDto(user);
    }

    //선택 댓글 수정
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);
        userRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 댓글은 존재하지 않습니다.")
        );
        if(user.getComment() == null){
            throw new NullPointerException("댓글을 입력하지 않았습니다.");
        }
        if(!(user.getSelectTodoId() == id) ){
            throw new IllegalArgumentException("해당 id는 일치하지 않습니다.");
        }

        user.updateUser(userRequestDto);
        userRepository.save(user);

        return new UserResponseDto(user);
    }

    //삭제 기능구현
    public UserResponseDto deleteUser(Long id, UserRequestDto userRequestDto) {
        User user = new User(userRequestDto);
        userRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 댓글은 존재하지 않습니다.")
        );
        if(!(user.getSelectTodoId() == userRepository.findById(id).get().getSelectTodoId()) ){
            throw new IllegalArgumentException("해당 id는 일치하지 않습니다.");
        }

        userRepository.deleteById(id);
        return new UserResponseDto(user);
    }
}

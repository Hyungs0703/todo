package com.sparta.todo.service;

import com.sparta.todo.repository.TodoRepository;
import com.sparta.todo.dto.TodoRequestDto;
import com.sparta.todo.dto.TodoResponseDto;
import com.sparta.todo.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    //생성
    public TodoResponseDto createTodo(TodoRequestDto requestDto){
        Todo todo = new Todo(requestDto);
         todoRepository.save(todo);

         return new TodoResponseDto(todo);
    }
    //선택조회
    public TodoResponseDto selectTodo(Long id){
        Todo todo = todoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 일정은 존재하지 않습니다.")
        );
        return new TodoResponseDto(todo);
    }
    //전체목록조회
    public List<TodoResponseDto> getAllTodoList() {
        return todoRepository.findAllByOrderByModifiedAtDesc()
                .stream()
                .map(TodoResponseDto::new)
                .toList();
    }
    //선택정보 수정
    public TodoResponseDto updateTodo(Long id, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 일정은 존재하지 않습니다.")
        );
        if(!todo.getPassword().equals(todoRequestDto.getPassword())){
            throw new IllegalArgumentException("비밀 번호가 일치하지 않습니다");
        }
        todo.updateTodo(todoRequestDto);
        todoRepository.save(todo);

        return new TodoResponseDto(todo);
    }
}

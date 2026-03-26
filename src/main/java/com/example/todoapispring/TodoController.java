package com.example.todoapispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {


    private TodoService todoService;
    private static List<Todo> todoList;


    public TodoController(@Qualifier("fakeTodoService") TodoService todoService){
        this.todoService=todoService;
        todoList=new ArrayList<>();
        todoList.add(new Todo(1,false,"Todo 1",1));
        todoList.add(new Todo(2,true,"Todo 2",2));
    }

    @GetMapping
    public ResponseEntity<List<Todo>>getTodos(@RequestParam(required = false) Boolean isCompleted){
        System.out.print("Incoming query param "+isCompleted+" "+this.todoService.functionality());
        return ResponseEntity.ok(todoList);
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> createTodo(@RequestBody Todo newTodo){
        todoList.add(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);

    }

    @GetMapping("/{todoID}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long todoID){
        for(Todo todo:todoList){
            if(todo.getId()==todoID){
                return ResponseEntity.ok(todo);
            }
        }
        return ResponseEntity.notFound().build();
    }

}

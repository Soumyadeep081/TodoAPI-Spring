package com.example.todoapispring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("anotherTodoService")

public class AnotherTodoService implements TodoService{
    @Override
    public String functionality(){
        return "Working from another todo service";
    }

}

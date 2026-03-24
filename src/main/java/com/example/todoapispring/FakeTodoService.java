package com.example.todoapispring;

import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService {
    @Override
    public String functionality(){
        return "Working for fake todo service";
    }
}

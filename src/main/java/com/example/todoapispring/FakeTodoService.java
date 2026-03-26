package com.example.todoapispring;

import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService {

    @TimeMonitor
    public String functionality(){
        return "Working from fake todo service";
    }
}

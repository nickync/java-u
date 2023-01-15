package com.example.springsecurity.resource;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldResource {

    private static final List<Todo> TODOS =
            List.of(new Todo("user", "AWS"),new Todo("user", "Quant"));

    @GetMapping("/todos/{username}")
    public List<Todo> retrieveTodo(@PathVariable String username){
        return TODOS.stream().filter(i -> i.user().equalsIgnoreCase(username)).toList();
    }

    @PostMapping("/todos/{username}")
    public void createTodo(@PathVariable String username, @RequestBody Todo todo){
        TODOS.add(todo);
    }
    @GetMapping("/todos")
    public List<Todo> retrieveAll(){
        return TODOS;
    }
}

record Todo (String user, String des){}
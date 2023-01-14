package com.example.springsecurity.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldResource {

    @GetMapping("/hello-world")
    public List<Todo> retrieveTodo(){
        return List.of(new Todo("user", "AWS"),new Todo("user", "AWS"));
    }
}

record Todo (String user, String des){}
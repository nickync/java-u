package com.example.springsecurity.resource;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldResource {

    private static final List<Todo> TODOS =
            List.of(new Todo("user", "AWS"),new Todo("user", "Quant"));

    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.user == 'user'")
    @RolesAllowed({"ADMIN", "USER"})
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public Todo retrieveTodo(@PathVariable String username){
//        return TODOS.stream().filter(i -> i.user().equalsIgnoreCase(username)).toList();
        return TODOS.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodo(@PathVariable String username, @RequestBody Todo todo){
        TODOS.add(todo);
    }
    @GetMapping("/todos")
    public List<Todo> retrieveAll(){
        return TODOS;
    }
}

record Todo (String user, String des){}
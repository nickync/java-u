package com.example.springboot.webapp.Service;

import com.example.springboot.webapp.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "Udemy", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "Udemy", "Learn MLE", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(3, "Udemy", "Learn QUANT", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}

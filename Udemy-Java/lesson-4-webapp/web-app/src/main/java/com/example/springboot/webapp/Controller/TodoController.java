package com.example.springboot.webapp.Controller;

import com.example.springboot.webapp.Service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap modelMap){
        modelMap.put("todos", todoService.findByUsername("name"));
        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showTodo(){
        return "todo";
    }

    @PostMapping("add-todo")
    public String addTodo(){
        return "redirect:list-todos";
    }
}

package com.example.springboot.webapp.Controller;

import com.example.springboot.webapp.Service.TodoService;
import com.example.springboot.webapp.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public String showTodo(ModelMap modelMap){
        modelMap.put("todo", new Todo(0, (String)modelMap.getAttribute("name"), "", LocalDate.now().plusYears(1), false));
        return "todo";
    }

    @PostMapping("add-todo")
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "todo";
        }
        todoService.addTodo((String)modelMap.getAttribute("name"), todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}

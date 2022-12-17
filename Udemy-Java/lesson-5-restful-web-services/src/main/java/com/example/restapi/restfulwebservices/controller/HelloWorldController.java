package com.example.restapi.restfulwebservices.controller;

import com.example.restapi.restfulwebservices.model.HelloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello World");
    }

    @GetMapping("hello-world/path-variable/{username}")
    public HelloWorld helloWorldBean(@PathVariable String username){
        return new HelloWorld("Hello World");
    }
}

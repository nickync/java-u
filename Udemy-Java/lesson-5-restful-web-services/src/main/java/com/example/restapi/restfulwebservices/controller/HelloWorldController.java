package com.example.restapi.restfulwebservices.controller;

import com.example.restapi.restfulwebservices.model.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;
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

    @GetMapping("hello-world-internationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}

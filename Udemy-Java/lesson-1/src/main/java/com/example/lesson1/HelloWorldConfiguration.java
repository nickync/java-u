package com.example.lesson1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
record Person(String name, int age){};
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Ranga";
    }

    @Bean
    public int age(){
        return 15;
    }

    @Bean
    public Person person(){
        return new Person("lala", 14);
    }
}

package com.example.lesson1.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Primary
    public Person person(){
        return new Person("lala", 14);
    }

    @Bean(name = "person2methodCall")
    public Person person2(){
        return new Person(name(), age());
    }
}

package com.example.lesson1.prepost;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
    }

    @PostConstruct
    public void init() {
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Clean up.");
    }
}

@Component
class SomeDependency{
    public void getReady(){
        System.out.println("Some logic using some dependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}

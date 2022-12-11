package com.example.lesson1.cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Named
class BusinessService {
    DataService dataService;


    public DataService getDataService() {
        return dataService;
    }
    @Inject
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}

@Named
class  DataService {

}

@Configuration
@ComponentScan
public class CdiContextLaunderApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(CdiContextLaunderApplication.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BusinessService.class).getDataService());
    }
}

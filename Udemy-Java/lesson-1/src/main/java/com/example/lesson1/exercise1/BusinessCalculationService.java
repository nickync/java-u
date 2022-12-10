package com.example.lesson1.exercise1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
//class MongoDB implements DataService {
//    @Override
//    public int[] retrieveData() {
//        return new int[]{1,2,3,4,5};
//    }
//}
//
//@Component
//@Primary
//class MySQLDB implements DataService {
//
//    @Override
//    public int[] retrieveData() {
//        return new int[]{11,22,33,44,55};
//    }
//}

@Configuration
@ComponentScan
public class BusinessCalculationService {

    DataService dataService;
    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(BusinessCalculationService.class);
        System.out.println(context.getBean(BusinessCalculationService.class).findMax());
    }


}

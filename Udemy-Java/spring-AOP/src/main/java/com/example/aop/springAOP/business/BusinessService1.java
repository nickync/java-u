package com.example.aop.springAOP.business;

import com.example.aop.springAOP.annotations.TrackTime;
import com.example.aop.springAOP.dataservice.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    @Autowired
    private DataService1 dataService1;
    // business logic

    @TrackTime
    public int calculateMax(){
        int[] data = dataService1.retrieveData();
//        throw new RuntimeException("Something went wrong! On purpose!");
        return Arrays.stream(data).max().orElse(0);
    }
}

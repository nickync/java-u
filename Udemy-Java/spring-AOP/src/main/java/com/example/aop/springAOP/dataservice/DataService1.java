package com.example.aop.springAOP.dataservice;

import com.example.aop.springAOP.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    @TrackTime
    public int[] retrieveData(){
        return new int[]{11, 22, 33};
    }
}

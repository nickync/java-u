package com.example.lesson1.exercise1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class MongoDB implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[]{1,2,3,4,5};
    }
}

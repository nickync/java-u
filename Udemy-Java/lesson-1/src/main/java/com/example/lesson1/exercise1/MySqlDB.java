package com.example.lesson1.exercise1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySqlDB implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[]{11,22,33,44,55};
    }
}

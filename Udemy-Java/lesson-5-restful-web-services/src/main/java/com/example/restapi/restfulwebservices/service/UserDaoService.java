package com.example.restapi.restfulwebservices.service;

import com.example.restapi.restfulwebservices.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private int userCount = users.size();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(28)));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOne(int id){
        return users.stream().filter(i -> i.getId() == id).findFirst().get();
    }

    public void deleteById(int id){
        users.removeIf(i -> i.getId() == id);
    }

}

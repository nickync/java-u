package com.example.restapi.restfulwebservices.repository;

import com.example.restapi.restfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

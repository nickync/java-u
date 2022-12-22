package com.example.restapi.restfulwebservices.repository;

import com.example.restapi.restfulwebservices.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

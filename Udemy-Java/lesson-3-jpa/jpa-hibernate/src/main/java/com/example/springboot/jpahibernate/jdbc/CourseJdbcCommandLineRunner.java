package com.example.springboot.jpahibernate.jdbc;

import com.example.springboot.jpahibernate.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository jdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.insert(new Course(1, "Learn AWS Now", "Udemy"));
        jdbcRepository.insert(new Course(2, "Learn Azure Now", "Udemy"));
        jdbcRepository.insert(new Course(3, "Learn DevOps Now", "Udemy"));
        jdbcRepository.insert(new Course(4, "Learn ML Now", "Udemy"));

        jdbcRepository.delete(2);

        System.out.println(jdbcRepository.findById(1));
        System.out.println(jdbcRepository.findById(3));
    }

}

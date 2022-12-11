package com.example.springboot.jpahibernate.jpa;

import com.example.springboot.jpahibernate.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CourseJPACommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(1, "Learn AWS Now JPA", "Udemy"));
        courseJpaRepository.insert(new Course(2, "Learn Azure Now", "Udemy"));
        courseJpaRepository.insert(new Course(3, "Learn DevOps Now", "Udemy"));
        courseJpaRepository.insert(new Course(4, "Learn ML Now", "Udemy"));

        courseJpaRepository.delete(2);

        System.out.println(courseJpaRepository.findById(1));
        System.out.println(courseJpaRepository.findById(3));
    }

}

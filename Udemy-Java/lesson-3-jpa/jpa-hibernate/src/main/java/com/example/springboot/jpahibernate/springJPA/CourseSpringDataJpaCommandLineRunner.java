package com.example.springboot.jpahibernate.springJPA;

import com.example.springboot.jpahibernate.Model.Course;
import com.example.springboot.jpahibernate.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {
        jpaRepository.save(new Course(1, "Learn AWS Now SpringJPA", "Udemy"));
        jpaRepository.save(new Course(2, "Learn Azure Now SpringJPA", "Udemy"));
        jpaRepository.save(new Course(3, "Learn DevOps Now SpringJPA", "Udemy"));
        jpaRepository.save(new Course(4, "Learn ML Now SpringJPA", "Udemy"));

        jpaRepository.deleteById(2l);

        System.out.println(jpaRepository.findById(1l));
        System.out.println(jpaRepository.findById(3l));
    }

}

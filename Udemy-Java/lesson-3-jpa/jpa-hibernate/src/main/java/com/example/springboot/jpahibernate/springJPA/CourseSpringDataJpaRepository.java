package com.example.springboot.jpahibernate.springJPA;

import com.example.springboot.jpahibernate.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
}

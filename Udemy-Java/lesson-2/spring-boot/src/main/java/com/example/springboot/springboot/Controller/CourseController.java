package com.example.springboot.springboot.Controller;

import com.example.springboot.springboot.Model.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "udemy"),
                new Course(2, "Learn DevOps", "udemy"),
                new Course(3, "Learn Azure", "udemy"),
                new Course(3, "Learn ML", "udemy")
        );
    }
}

package com.example.springboot.jpahibernate.jdbc;

import com.example.springboot.jpahibernate.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String SQL =
            """
            insert into course(id, name, author) values(?,?,?);
            """;

    private static String DELETE_SQL =
            """
            delete from course where id = ?;
            """;

    private static String SELECT_SQL =
            """
            select * from course where id = ?;        
            """;

    public void insert(Course course){
        jdbcTemplate.update(SQL, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id){
        jdbcTemplate.update(DELETE_SQL, id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_SQL,new BeanPropertyRowMapper<>(Course.class), id);
    }
}

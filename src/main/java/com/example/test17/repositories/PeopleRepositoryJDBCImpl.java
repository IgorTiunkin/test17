package com.example.test17.repositories;

import com.example.test17.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PeopleRepositoryJDBCImpl implements PeopleRepositoryJDBC{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> findAllByNameAndAge(String name, Integer age) {
        String query1 = """
                SELECT * from person
                WHERE name = '%s' and age = %d;
                """.formatted(name, age);
        return jdbcTemplate.query(query1, new BeanPropertyRowMapper<>(Person.class));
    }
}

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
        String query = """
                SELECT * from person
                WHERE name = '%s' and age = %d;
                """.formatted(name, age);
        //not protected from sql injections
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void insertIntoPerson(Person person) {
        String query = """
                INSERT INTO person (name, age)
                values (?, ?);               
                """;
        jdbcTemplate.update(query, person.getName(), person.getAge());
    }
}

package com.example.test17.repositories;

import com.example.test17.models.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepositoryJDBC {

    List<Person> findAllByNameAndAge(String name, Integer age);

    void insertIntoPerson(Person person);
}

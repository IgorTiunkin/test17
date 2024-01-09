package com.example.test17.services;

import com.example.test17.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PeopleServiceTest {

    private final PeopleService peopleService;

    @Autowired
    PeopleServiceTest(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Test
    void whenIvanJdbcTemplateTextBlocks_ThenOk() {
        List<Person> ivans = peopleService.findAllByNameAndAge("ivan", 10);
        System.out.println(ivans);
    }
}
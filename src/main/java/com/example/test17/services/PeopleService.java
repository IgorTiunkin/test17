package com.example.test17.services;

import com.example.test17.models.Person;
import com.example.test17.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final PeopleRepository peopleRepository;

    public List<Person> findAllByNameAndAge(String name, Integer age) {
        return peopleRepository.findAllByNameAndAge(name, age);
    }

}

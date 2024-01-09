package com.example.test17.repositories;

import com.example.test17.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>, PeopleRepositoryJDBC{
}

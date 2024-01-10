package com.example.test17.records;

import com.example.test17.models.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RectangleTest {

    @Test
    void whenPositiveParameters_thenOk() {
        Rectangle rectangle = new Rectangle(1, 2);
        System.out.println(rectangle);
        assertAll(()->assertEquals(1, rectangle.length()),
                ()-> assertEquals(2, rectangle.width()));
    }

    @Test
    void whenNegativeParameters_thenException() {
        assertThrows(IllegalArgumentException.class, ()->new Rectangle(-1, -2));
    }

    @Test
    void whenUsageDefaultMethod_thenOk() {
        new Rectangle(1,1).defaultRecordInterfaceMethod();
    }

    @Test
    void whenCalculateArea_thenOk() {
        Rectangle rectangle = new Rectangle(2, 5);
        assertEquals(10, rectangle.calculateArea());
    }

    @Test
    void whenInnerRecord_thenOk(){
        Person person1 = Person.builder().name("ivan").age(30).build();
        Person person2 = Person.builder().name("petr").age(10).build();
        Person person3 = Person.builder().name("sidor").age(15).build();
        //calculateScore - heavy function
        //creating record beforehand
        record PersonAndScore(Person person, Integer score){}

        List <Person> list = List.of(person1, person2, person3);

        //convert to record, calculate only once score, deconvert
        List<Person> list1 = list.stream()
                .map((person) -> new PersonAndScore(person, person.calculateScore()))
                .sorted(Comparator.comparing(PersonAndScore::score, Comparator.reverseOrder()))
                .map(PersonAndScore::person)
                .toList();
        System.out.println(list1);
    }

}
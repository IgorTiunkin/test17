package com.example.test17.records;

import com.example.test17.models.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

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


    @ParameterizedTest(name = "{arguments} test")
    @MethodSource("com.example.test17.records.RectangleTest#getArgsForAreaTest")
    @CsvFileSource(resources = "/area-calculation-test.csv",
    delimiter = ',', numLinesToSkip = 1)
    @CsvSource({
            "4,5,20",
            "2,6,12"
    })
    void parametrizedTestOfAreaCalculation(double length, double width, double area) {
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(area, rectangle.calculateArea());
    }

    static Stream<Arguments> getArgsForAreaTest () {
        return Stream.of(Arguments.of(2.0, 5.0, 10.0),
                Arguments.of(1.0, 5.0, 5.0),
                Arguments.of(2.0, 2.0, 4.0),
                Arguments.of(2.0, 10.0, 20.0));
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
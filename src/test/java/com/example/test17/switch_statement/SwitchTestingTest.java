package com.example.test17.switch_statement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SwitchTestingTest {

    private final SwitchTesting switchTesting;

    @Autowired
    SwitchTestingTest(SwitchTesting switchTesting) {
        this.switchTesting = switchTesting;
    }

    @Test
    void whenDog_Then4() {
        Integer numberOfLegs = switchTesting.checkNumberOfLegs(Animal.DOG);
        assertEquals(4,numberOfLegs);
    }

    @Test
    void whenParrot_then2() {
        Integer numberOfLegs = switchTesting.checkNumberOfLegs(Animal.PARROT);
        assertEquals(2,numberOfLegs);
    }

    @Test
    void whenFish_thenException() {
        assertThrows(IllegalArgumentException.class,
                ()->switchTesting.checkNumberOfLegs(Animal.FISH));
    }

}
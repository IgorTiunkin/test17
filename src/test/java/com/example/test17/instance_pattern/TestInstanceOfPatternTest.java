package com.example.test17.instance_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestInstanceOfPatternTest {

    private final TestInstanceOfPattern testInstanceOfPattern;

    @Autowired
    TestInstanceOfPatternTest(TestInstanceOfPattern testInstanceOfPattern) {
        this.testInstanceOfPattern = testInstanceOfPattern;
    }

    @Test
    void whenString_thenString() {
        String test = testInstanceOfPattern.checkType("test");
        assertEquals("test", test);
    }

    @Test
    void whenLocalDate_thenLocalDate() {
        LocalDate localDate = LocalDate.now();
        String localDateToString = "Date:" + localDate.toString();

        String checkType = testInstanceOfPattern.checkType(localDate);
        assertEquals(localDateToString, checkType);
    }

    @Test
    void whenNumber_thenLong() {
        long a = 1;
        String numberToTest = "Number:"+1;

        String checkType = testInstanceOfPattern.checkType(1);
        assertEquals(numberToTest, checkType);
    }


}
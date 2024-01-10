package com.example.test17.switch_statement;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SwitchTesting {

    public Integer checkNumberOfLegs(Animal animal) {
        Integer numberOfLegs = switch (animal) {
            case CAT, DOG -> 4;
            case PARROT -> {
                System.out.println("Попка дурак");
                yield 2;
            }
            case FISH -> throw new IllegalArgumentException("Нет ног");
        };
        return numberOfLegs;
    }

}

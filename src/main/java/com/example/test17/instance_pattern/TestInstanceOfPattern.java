package com.example.test17.instance_pattern;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TestInstanceOfPattern {

    public String checkType (Object object) {
        if (object instanceof String s) {
            return s;
        } else if (object instanceof LocalDate localDate) {
            return "Date:" + DateTimeFormatter.ISO_DATE.format(localDate);
        } else if (object instanceof Number number) {
            return "Number:" + number.longValue();
        } else {
            return null;
        }
    }
}

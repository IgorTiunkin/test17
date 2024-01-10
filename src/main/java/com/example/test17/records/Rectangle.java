package com.example.test17.records;

import com.example.test17.models.Person;

public record Rectangle  (double length, double width) implements RecordInterface{
    public Rectangle {
        if (length<0 || width <0) throw new IllegalArgumentException();
    }

    public double calculateArea() {
        return length*width;
    }
}

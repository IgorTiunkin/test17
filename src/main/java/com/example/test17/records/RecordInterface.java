package com.example.test17.records;

public interface RecordInterface {
    default void defaultRecordInterfaceMethod() {
        System.out.println("I am default method of record interface");
    }
}

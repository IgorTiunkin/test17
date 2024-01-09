package com.example.test17.textblocks;

public class TextBlocksTest {

    public static void main(String[] args) {
        String test1 = """
                This is a first test of text block. 
                Just to check how it look.
                In console.
                """;
        System.out.println(test1);

        String test2 = """
                Testing of single row.\
                But it is too long for one line.\
                Should look better.
                """;
        System.out.println(test2);

        String query1 = """
                INSERT INTO person (name, age)
                VALUES ('%s', %d)
                """.formatted("name", 10);
        System.out.println(query1);
    }
}

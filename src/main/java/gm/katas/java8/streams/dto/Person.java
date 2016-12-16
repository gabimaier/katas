package gm.katas.java8.streams.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Person {
    private final String name;
    private final int age;
    private final String nationality;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.nationality = null;
    }

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }
}

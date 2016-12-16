package gm.katas.java8.streams;

import gm.katas.java8.streams.dto.Person;

import java.util.Comparator;
import java.util.List;

public class OldestPerson {
    public static Person getOldestPerson(List<Person> collection) {
        return collection.stream().max(Comparator.comparing(Person::getAge)).orElse(null);
    }
}


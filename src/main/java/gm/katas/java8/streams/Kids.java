package gm.katas.java8.streams;

import gm.katas.java8.streams.dto.Person;

import java.util.List;
import java.util.stream.Collectors;

public class Kids {
    public static List<String> getKidNames(List<Person> collection) {
        return collection.stream().filter(person -> person.getAge()<18).map(Person::getName).collect(Collectors.toList());
    }
}

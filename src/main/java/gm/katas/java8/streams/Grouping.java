package gm.katas.java8.streams;

import gm.katas.java8.streams.dto.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static Map<String, List<Person>> groupByNationality(List<Person> collection) {
        return collection.stream().collect(Collectors.groupingBy(Person::getNationality));
    }
}

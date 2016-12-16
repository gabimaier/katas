package gm.katas.java8.streams;

import gm.katas.java8.streams.dto.Person;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Get people statistics: average age, count, maximum age, minimum age and sum og all ages.
 */
public class PeopleStats {
    public static IntSummaryStatistics getStats(List<Person> collection) {
//        return collection.stream().collect(Collectors.summarizingInt(Person::getAge));
        return collection.stream().mapToInt(Person::getAge).summaryStatistics();
    }
}

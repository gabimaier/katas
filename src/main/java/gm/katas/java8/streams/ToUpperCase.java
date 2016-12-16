package gm.katas.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Convert elements of a collection to upper case.
https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/
 */
public class ToUpperCase {


    public static List<String> transform(List<String> collection) {
        return collection.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public static List<String> transformNotSoGood(List<String> collection) {
        final List<String> upperCaseList = new ArrayList<>(collection.size());
        collection.stream().forEachOrdered(element -> upperCaseList.add(element.toUpperCase()));
        return upperCaseList;
    }
}
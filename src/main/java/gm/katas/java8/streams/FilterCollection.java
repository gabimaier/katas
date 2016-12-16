package gm.katas.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

/*
Filter collection so that only elements with less then 4 characters are returned.
 */

public class FilterCollection {
    public static List<String> transform(List<String> collection) {
        return collection.stream().filter(element -> element.length() < 4).collect(Collectors.toList());
    }
}

package gm.katas.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

public class FlatCollection {
    public static List<String> transform(List<List<String>> collection) {
        return collection.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}

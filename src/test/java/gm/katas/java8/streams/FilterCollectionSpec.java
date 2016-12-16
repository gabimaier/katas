package gm.katas.java8.streams;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterCollectionSpec {

    @Test
    public void transformShouldFilterCollection() {
        List<String> collection = asList("My", "name", "is", "John", "Doe");
        List<String> expected = asList("My", "is", "Doe");
        assertThat(FilterCollection.transform(collection)).hasSameElementsAs(expected);
    }

}
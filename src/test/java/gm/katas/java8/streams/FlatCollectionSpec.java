package gm.katas.java8.streams;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/*
Flatten multidimensional collection
 */
public class FlatCollectionSpec {

    @Test
    public void transformShouldFlattenCollection() {
        List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(FlatCollection.transform(collection)).hasSameElementsAs(expected);
    }

}
package gm.katas.java8.streams;

import gm.katas.java8.streams.dto.Person;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/*
Return people names separated by comma
 */
public class JoiningSpec {

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertThat(Joining.namesToString(collection))
                .isEqualTo("Names: Sara, Viktor, Eva.");
    }

}
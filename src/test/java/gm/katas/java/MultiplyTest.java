package gm.katas.java;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class MultiplyTest {

    @Test
    public void testMultiply() throws Exception {
        Assertions.assertThat(Multiply.multiply(1.2, .5)).isEqualTo(.6);
    }
}
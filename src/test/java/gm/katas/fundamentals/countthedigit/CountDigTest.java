package gm.katas.fundamentals.countthedigit;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(DataProviderRunner.class)
public class CountDigTest {
    @DataProvider
    public static Object[][] singleDigitNumbersAndOccurencesOf1() {
        return new Object[][] {{1, 1, 1 }, {1, 2, 0}, {1, 3, 0}, {1, 4, 0}, {1, 5, 0}, {1, 6, 0}, {1, 7, 0}, {1, 8, 0}, {1, 9, 0}, {0, 0, 1}};
    }

    @Test
    @UseDataProvider("singleDigitNumbersAndOccurencesOf1")
    public void should_count_occurences_of_digit_when_given_single_digit_number(final int digit, final long number, final int expectedCount){
        //given
        //when
        final int count = CountDig.countDigitInNumber(digit, number);
        //then
        assertThat(count).isEqualTo(expectedCount);
    }

    @DataProvider
    public static Object[][] multipleDigitNumbersAndOccurencesOf1() {
        return new Object[][] {{ 10, 1 }, {20, 0}, {11, 2}, {121, 2}, {0, 0}, {210, 1}};
    }

    @Test
    @UseDataProvider("complexGroups")
    public void should_count_occurences_when_given_multiple_digit_number(final long number, final int expectedCount){
        //given
        final int digit = 1;
        //when
        final int count = CountDig.countDigitInNumber(digit, number);
        //then
        assertThat(count).isEqualTo(expectedCount);

    }

    @DataProvider
    public static Object[][] numberDigitExpectedCount(){
        return new Object[][]{{10, 0, 3}, {10, 1, 4}, {25, 1, 11}, {5750, 0, 4700}, {11011, 2, 9481}, {12224, 8, 7733}, {11549, 1, 11905}};
    }

    @Test
    @UseDataProvider("numberDigitExpectedCount")
    public void test(int n, int d, int expectedCount) {
        assertThat(CountDig.nbDig(n, d)).isEqualTo(expectedCount);
    }

    @DataProvider
    public static Object[][] bigNumberDigitExpectedCount(){
        return new Object[][]{{46340, 1, 57993}, {46341, 1, 57995}};
    }

    @Test
    @UseDataProvider("bigNumberDigitExpectedCount")
    public void testBigNumbers(int n, int d, int expectedCount) {
        assertThat(CountDig.nbDig(n, d)).isEqualTo(expectedCount);
    }

}
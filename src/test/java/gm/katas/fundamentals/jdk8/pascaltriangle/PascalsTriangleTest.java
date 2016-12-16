package gm.katas.fundamentals.jdk8.pascaltriangle;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(DataProviderRunner.class)
public class PascalsTriangleTest {

    @DataProvider
    public static Object[][] testData(){
        return new Object[][]{
                {1, new Integer[][]{ {1} }},
                {2, new Integer[][]{ {1}, {1, 1} }},
                {5, new Integer[][] { {1}, {1,1}, {1,2,1}, {1,3,3,1}, {1,4,6,4,1} }}
        };
    }

    @Test
    @UseDataProvider("testData")
    public void test(int depth, Integer[][] expectedTriangle) {
        assertArrayEquals( String.format("Depth %d", depth),
                expectedTriangle,
                PascalsTriangle.pascal(depth));
    }

    @Test
    public void test5() {
        assertArrayEquals("Depth 5 should return [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]",
                new int[][] { {1}, {1,1}, {1,2,1}, {1,3,3,1}, {1,4,6,4,1} },
                PascalsTriangle.pascal(5));
    }
}
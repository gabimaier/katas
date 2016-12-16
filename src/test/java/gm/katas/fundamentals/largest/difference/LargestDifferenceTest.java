package gm.katas.fundamentals.largest.difference;

import junit.framework.TestCase;

public class LargestDifferenceTest extends TestCase {
    public void test3() {
        assertEquals(0, LargestDifference.largestDifference(new int[]{-2}));
    }
    public void test4() {
        assertEquals(0, LargestDifference.largestDifference(new int[]{}));
    }

    public void test1() {
        assertEquals(4, LargestDifference.largestDifference(new int[]{9,4,1,10,3,4,0,-1,-2}));
    }

    public void test2(){
        assertEquals(0, LargestDifference.largestDifference(new int[]{3,2,1}));
    }

}
package gm.katas.threads.threadedcounting;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class ThreadedCountingTest {
    @Test
    public void should_contain_all_numbers() throws InterruptedException {
        //given
        final Counter counter = new Counter();
        //when
        ThreadedCounting.countInThreads(counter);

        //then
        final List<Integer> numbers = counter.getNumbers();
        for (int i = 1; i <= ThreadedCounting.MAX_VALUE; i++) {
            assertTrue(numbers + " doesn't contain " + i, numbers.contains(i));
        }
    }

    @Test
    public void should_contain_all_numbers_in_order() throws InterruptedException {
        //given
        final Counter counter = new Counter();
        //when
        ThreadedCounting.countInThreads(counter);

        //then
        final List<Integer> numbers = counter.getNumbers();
        for (int i = 1; i <= ThreadedCounting.MAX_VALUE; i++) {
            assertTrue(numbers.get(i-1) + " isn't " + i, numbers.get(i-1)==i);
        }
    }

//    @Test
//    public void should_contain_thread_names_in_correct_order() throws InterruptedException {
//        //given
//        final Counter counter = new Counter();
//        //when
//        ThreadedCounting.countInThreads(counter);
//
//        //then
//        final List<String> threads = counter.getThreads();
//        for (int i = 1; i <= ThreadedCounting.MAX_VALUE; i++) {
//            final int expectedRemainder = i % DIVISOR;
//            assertTrue(threads.get(i - 1) + " isn't " + expectedRemainder, threads.get(i-1).endsWith("+"+ expectedRemainder));
//        }
//    }

}
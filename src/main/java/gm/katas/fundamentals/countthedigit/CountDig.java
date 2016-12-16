package gm.katas.fundamentals.countthedigit;

/**
 * https://www.codewars.com/kata/566fc12495810954b1000030/train/java
 */
public class CountDig {

    public static int nbDig(int n, int d) {
        int counter = 0;
        for (int i = 0; i <= n; i++) {
            final long square = (long) i * i;
            counter += countDigitInNumber(d, square);
        }
        return counter;
    }

    public static int countDigitInNumber(int digit, long number) {
        if(number==0 && digit==0) {
            return 1;
        }
        int counter = 0;
        while(number>0){
            if(number%10 == digit) {
                counter++;
            }
            number = number / 10;
        }
        return counter;
    }
}

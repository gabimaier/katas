package gm.katas.fundamentals.largest.difference;

public class LargestDifference {
    public static int largestDifference(int[] data) {
        int maxDif = 0;
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = data.length-1; j > i ; j--) {
                if(data[i] <= data[j] && maxDif < j - i){
                    maxDif = j - i;
                }
            }
        }
        return maxDif;
    }
}

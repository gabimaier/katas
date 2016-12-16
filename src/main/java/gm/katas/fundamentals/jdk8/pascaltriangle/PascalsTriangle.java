package gm.katas.fundamentals.jdk8.pascaltriangle;

public class PascalsTriangle {
    public static int[][] pascal(int depth) {
        final int[][] triangle = new int[depth][];
        int[] previousLine = null;
        for (int i = 0; i < depth; i++) {
            previousLine = getNextLine(previousLine);
            triangle[i] = previousLine;
        }
        return triangle;
    }

    public static int[] getNextLine(final int[] lastLine){
        if(lastLine==null || lastLine.length==0){
            return new int[]{1};
        }
        final int[] newLine = new int[lastLine.length+1];
        for (int i=0; i<lastLine.length; i++) {
            if(i==0) {
                newLine[i] = 1;
            }
            else {
                newLine[i] = lastLine[i-1] + lastLine[i];
            }
        }
        newLine[lastLine.length] = 1;
        return newLine;
    }
}

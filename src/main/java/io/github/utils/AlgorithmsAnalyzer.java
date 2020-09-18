package io.github.utils;


public class AlgorithmsAnalyzer {

    public static class NotEnoughDataException extends Exception {
    }

    public static long getRuntime(Runnable runnable) {

        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();

        return end - start;
    }

    public static double getLogarithmicRatio(long[] times) throws NotEnoughDataException {

        if(times.length < 2) {
            throw new NotEnoughDataException();
        }

        double logRatio = 0;
        for (int i = 1; i < times.length; i++) {
            double ratio = (double)times[i] / (times[i - 1] != 0 ? times[i - 1] : 1);
            logRatio += logBase2(ratio) / (times.length - 1);
        }

        return logRatio;
    }

    private static double logBase2(double number) {
        return Math.log(number) / Math.log(2);
    }
    
    protected static int[][] getEmptyDoublingSizeArrays(int initialSize, int count) {

        int[][] arrays = new int[count][];

        for (int i = 0; i < count; i++) {
            arrays[i] = new int[(int)(initialSize * Math.pow(2, i))];
        }

        return arrays;
    }
        
}

package io.github.utils;

import io.github.algorithms.ThreeSum;

public class ThreeSumAnalyzer {

    private static final int INITIAL_SET_SIZE = 2000;
    private static final int NUMBER_OF_SETS = 3;

    public static double getLogarithmicRatio() throws AlgorithmsAnalyzer.NotEnoughDataException {

        int[][] arrays = AlgorithmsAnalyzer.getEmptyDoublingSizeArrays(INITIAL_SET_SIZE, NUMBER_OF_SETS);
        long[] times = new long[arrays.length];
        for (int i = 0; i < arrays.length; i++) {

            int finalI = i;
            times[i] = AlgorithmsAnalyzer.getRuntime(() -> ThreeSum.countZeroSums(arrays[finalI]));
        }

        return AlgorithmsAnalyzer.getLogarithmicRatio(times);
    }
}

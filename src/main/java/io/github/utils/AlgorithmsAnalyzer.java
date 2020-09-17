package io.github.utils;


public class AlgorithmsAnalyzer {

    public static long getRuntime(Runnable runnable) {

        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();

        return end - start;
    }
}

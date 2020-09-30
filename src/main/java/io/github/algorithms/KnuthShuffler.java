package io.github.algorithms;

import io.github.algorithms.sorting.utils.AlgorithmsHelper;

import java.util.Random;

public class KnuthShuffler {

    @SuppressWarnings("rawtypes")
    public static Comparable[] shuffle(Comparable[] array) {

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            AlgorithmsHelper.swap(array, i, random.nextInt(i + 1));
        }

        return array;
    }
}

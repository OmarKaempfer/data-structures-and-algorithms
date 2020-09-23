package io.github.algorithms.sorting.utils;

import static io.github.algorithms.sorting.utils.SortingHelper.*;

public class InsertionSort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {

                if(less(array[j], array[j - 1])) {
                    swap(array, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}

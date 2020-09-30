package io.github.algorithms.sorting;

import static io.github.algorithms.sorting.utils.AlgorithmsHelper.*;

public class SelectionSort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] array) {

        for (int i = 0; i < array.length; i++) {

            int min = i;
            for(int j = i; j < array.length; j++) {
                if(less(array[j], array[min])) {
                    min = j;
                }
            }

            swap(array, min, i);
        }
    }
}

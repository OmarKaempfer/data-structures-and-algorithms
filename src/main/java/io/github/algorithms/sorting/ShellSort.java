package io.github.algorithms.sorting;

import static io.github.algorithms.sorting.utils.AlgorithmsHelper.less;
import static io.github.algorithms.sorting.utils.AlgorithmsHelper.swap;

public class ShellSort {

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] array) {

        int h = 1;
        while(h < array.length / 3) {
            h = 3 * h + 1;
        }

        while(h >= 1) {

            for (int i = h; i < array.length; i++) {

                for (int j = i; j >= h; j -= h) {
                    if(less(array[j], array[j - h])) {
                        swap(array, j, j - h);
                    } else {
                        break;
                    }
                }
            }

            h = h / 3;
        }
    }
}

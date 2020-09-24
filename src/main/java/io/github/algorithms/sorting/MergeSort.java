package io.github.algorithms.sorting;

import static io.github.algorithms.sorting.utils.SortingHelper.*;

public class MergeSort {

    @SuppressWarnings("rawtypes")
    public static void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {

        if(high - low == 0) {
            return;
        }

        for (int k = 0; k < aux.length; k++) {
            aux[k] = array[k];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if(i > mid) {
                array[k] = aux[j++];

            } else if(j > high) {
                array[k] = aux[i++];

            } else if(less(aux[i], aux[j])) {
                array[k] = aux[i++];

            } else {
                array[k] = aux[j++];
            }
        }
    }
}

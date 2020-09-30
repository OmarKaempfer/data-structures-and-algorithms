package io.github.algorithms.sorting;

import static io.github.algorithms.sorting.utils.AlgorithmsHelper.*;

public class MergeSort {

    @SuppressWarnings("rawtypes")
    public static Comparable[] sort(Comparable[] array) {

        return sort(array, new Comparable[array.length], 0, array.length - 1);
    }

    @SuppressWarnings("rawtypes")
    private static Comparable[] sort(Comparable[] array, Comparable[] aux, int low, int high) {

        if(high <= low) {
            return array;
        }

        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);
        return merge(array, aux, low, mid, high);
    }

    @SuppressWarnings("rawtypes")
    public static Comparable[] bottomUpSort(Comparable[] array) {

        int N = array.length;
        Comparable[] aux = new Comparable[N];

        for(int size = 1; size < N; size = 2 * size) {
            for (int i = 0; i < N - size - 1; i += 2 * size) {
                merge(array, aux, i, i + size - 1, Math.min(i + 2 * size - 1, N - 1));
            }
        }

        return array;
    }

    @SuppressWarnings("rawtypes")
    public static Comparable[] merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {

        if(high - low == 0) {
            return array;
        }

        for (int k = low; k <= high; k++) {
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

        return array;
    }
}

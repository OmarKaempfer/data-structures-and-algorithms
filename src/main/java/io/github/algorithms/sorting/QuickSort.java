package io.github.algorithms.sorting;

import io.github.algorithms.KnuthShuffler;

import static io.github.algorithms.sorting.utils.AlgorithmsHelper.*;

public class QuickSort {

    @SuppressWarnings("rawtypes")
    public static int partition(Comparable[] array, int low, int high) {

        int i = low;
        int j = high + 1;
        while(true) {
            while(less(array[++i], array[low])) {
                if(i >= high) {
                    break;
                }
            }

            while(less(array[low], array[--j])) {
                if(j == low) {
                    break;
                }
            }

            if(j <= i) {
                break;
            }

            swap(array, i, j);
        }

        swap(array, low, j);
        return j;
    }

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] array) {

        KnuthShuffler.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] array, int low, int high) {

        if(low >= high) {
            return;
        }

        int pivot = partition(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
    }
}

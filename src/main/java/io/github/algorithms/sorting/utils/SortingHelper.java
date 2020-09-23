package io.github.algorithms.sorting.utils;

public class SortingHelper {

    @SuppressWarnings("rawtypes")
    public static void swap(Comparable[] array, int i, int j) {

        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @SuppressWarnings("rawtypes, unchecked")
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if(less(array[i], array[i - 1])) {
                return false;
            }
        }

        return true;
    }
}

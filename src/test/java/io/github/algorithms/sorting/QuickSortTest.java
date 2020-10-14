package io.github.algorithms.sorting;

import io.github.algorithms.KnuthShuffler;
import io.github.algorithms.sorting.utils.AlgorithmsHelper;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.stream.IntStream;

import static io.github.algorithms.sorting.utils.AlgorithmsHelper.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class QuickSortTest {

    @Test
    @Parameters(method = "providePartitionCases")
    public void partition(Integer[] array, int low, int high, Integer[] expected) {

        int pivot = QuickSort.partition(array, low, high);
        System.out.println(pivot);
        System.out.println(Arrays.toString(array));


        Integer[] leftSideArray = pivot != 0 ? Arrays.stream(array, low, pivot - 1).toArray(Integer[]::new)
                                             : new Integer[]{};
        Integer[] rightSideArray =
                pivot != array.length - 1 ? Arrays.stream(array, pivot + 1, high).toArray(Integer[]::new)
                                          : new Integer[]{};

        assertThat(allLessThan(leftSideArray, array[pivot]));
        assertThat(allGreaterThan(rightSideArray, array[pivot]));
        assertThat(array).isEqualTo(expected);
    }

    private Object[][] providePartitionCases() {
        return new Object[][] {
                {new Integer[] {5, 1, 2, 3, 4}, 0, 4, new Integer[] {4, 1, 2, 3, 5}},
                {new Integer[] {7, 9, 8, 6, 5}, 0, 4, new Integer[] {6, 5, 7, 8, 9}}
        };
    }

    @Test
    @Parameters(method = "provideSortingCases")
    public void sort(Integer[] unsortedArray) {

        QuickSort.sort(unsortedArray);
        assertThat(unsortedArray).isSorted();
    }

    private Object[][] provideSortingCases() {
        return new Object[][] {
                {new Integer[] {1, 2, 3, 4, 5}},
                {new Integer[] {1, 2, 3, 4, 5, 6}},
                {new Integer[] {1}},
                {new Integer[] {}},
                {new Integer[] {5, 4, 3, 2, 1}},
                {new Integer[] {5, 4, 3, 2, 1, 0}},
                {new Integer[] {1, 5, 2, 4, 3}},
                {new Integer[] {1, 5, 2, 4, 3, 0}},
        };
    }

    @SuppressWarnings("rawtypes")
    private boolean allLessThan(Comparable[] array, Comparable value) {

        for (Comparable comparable : array) {
            if (!less(comparable, value)) {
                return false;
            }
        }

        return true;
    }

    @SuppressWarnings("rawtypes")
    private boolean allGreaterThan(Comparable[] array, Comparable value) {
        for(Comparable comparable : array) {
            if(!less(value, comparable)) {
                return false;
            }
        }

        return true;
    }
}
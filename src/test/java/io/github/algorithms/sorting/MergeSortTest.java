package io.github.algorithms.sorting;

import io.github.algorithms.sorting.utils.SortingHelper;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class MergeSortTest {

    @Test
    @Parameters(method = "provideTestCases")
    public void merge(Integer[] array, int low, int mid, int high) {
        Integer[] aux = new Integer[high - low + 1];
        MergeSort.merge(array, aux, 0, mid, high);

        System.out.println(Arrays.toString(array));
        assertThat(SortingHelper.isSorted(array)).isTrue();
    }

    private Object[][] provideTestCases() {
        return new Object[][] {
                {new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10}, 0, 4, 9},
                {new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11}, 0, 4, 10},
                {new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 5, 9},
                {new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 0, 5, 9},
                {new Integer[] {1}, 0, 0, 0},
                {new Integer[] {1, 2}, 0, 0, 1},
                {new Integer[] {2, 1}, 0, 0, 1},
                {new Integer[] {}, 0, 0, 0},
        };
    }

    @Test
    @Parameters(method = "provideSortCases")
    public void sort(Integer[] array) {
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));

        assertThat(SortingHelper.isSorted(array));
    }

    @Test
    @Parameters(method = "provideSortCases")
    public void bottomUpSort(Integer[] array) {
        MergeSort.bottomUpSort(array);
        System.out.println(Arrays.toString(array));

        assertThat(SortingHelper.isSorted(array));
    }

    private Object[][] provideSortCases() {
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
}
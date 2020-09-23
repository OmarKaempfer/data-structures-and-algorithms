package io.github.algorithms.sorting.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.github.algorithms.sorting.utils.SortingHelper.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class InsertionSortTest {

    @Test
    @Parameters(method = "provideIntegerCases")
    public void sort(Integer[] array) {
        InsertionSort.sort(array);
        assertThat(isSorted(array)).isTrue();
    }

    private Object[][] provideIntegerCases() {
        return new Object[][] {
                {new Integer[] {1, 2, 3, 4, 5}},
                {new Integer[] {1, 3, 2, 4, 5}},
                {new Integer[] {5, 4, 3, 2, 1}},
                {new Integer[] {1}},
                {new Integer[] {}}
        };
    }
}
package io.github.algorithms.sorting;

import io.github.algorithms.sorting.utils.SortingHelper;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SelectionSortTest {

    @Test
    @Parameters(method = "provideIntegerCases")
    public void sortIntegers(Integer[] array) {
        SelectionSort.sort(array);
        assertThat(SortingHelper.isSorted(array)).isTrue();
    }

    @Test
    @Parameters(method = "provideStringCases")
    public void sortStrings(String[] array) {
        SelectionSort.sort(array);
        assertThat(SortingHelper.isSorted(array)).isTrue();
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

    private Object[][] provideStringCases() {
        return new Object[][] {
                {new String[] {"abc", "bbb", "ccc", "ddd"}},
                {new String[] {"ddd", "ccc", "bbb", "abc"}},
                {new String[] {"abc", "ccc", "bbb", "ddd"}},
                {new String[] {"abc"}},
                {new String[] {}}
        };
    }
}
package io.github.algorithms.sorting;

import io.github.algorithms.sorting.utils.AlgorithmsHelper;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SelectionSortTest {

    @Test
    @Parameters(method = "provideIntegerCases")
    public void sortIntegers(Integer[] array) {
        SelectionSort.sort(array);
        assertThat(AlgorithmsHelper.isSorted(array)).isTrue();
    }

    @Test
    @Parameters(method = "provideStringCases")
    public void sortStrings(String[] array) {
        SelectionSort.sort(array);
        assertThat(AlgorithmsHelper.isSorted(array)).isTrue();
    }

    private Object[][] provideIntegerCases() {
        return new Object[][] {
                {IntStream.rangeClosed(1, 100).map(i -> new Random().nextInt(100)).boxed().toArray(Integer[]::new)},
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
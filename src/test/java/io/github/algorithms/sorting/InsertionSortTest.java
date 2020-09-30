package io.github.algorithms.sorting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.stream.IntStream;

import static io.github.algorithms.sorting.utils.AlgorithmsHelper.isSorted;
import static org.assertj.core.api.Assertions.assertThat;

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
                {IntStream.rangeClosed(1, 100).map(i -> new Random().nextInt(100)).boxed().toArray(Integer[]::new)},
                {new Integer[] {1, 2, 3, 4, 5}},
                {new Integer[] {1, 3, 2, 4, 5}},
                {new Integer[] {5, 4, 3, 2, 1}},
                {new Integer[] {1}},
                {new Integer[] {}}
        };
    }
}
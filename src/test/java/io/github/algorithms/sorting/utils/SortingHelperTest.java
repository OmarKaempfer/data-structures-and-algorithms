package io.github.algorithms.sorting.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class SortingHelperTest {

    @Test
    @Parameters(method = "provideCases")
    public void isSorted(Integer[] array, boolean expected) {
        assertThat(SortingHelper.isSorted(array)).isEqualTo(expected);
    }

    private Object[][] provideCases() {
        return new Object[][] {
                {new Integer[] {1, 2, 3, 4, 5}, true},
                {new Integer[] {1, 3, 2, 4, 5}, false},
                {new Integer[] {1, 3, 2, null, 5}, false},
                {new Integer[] {1}, true},
                {new Integer[] {}, true}
        };
    }
}
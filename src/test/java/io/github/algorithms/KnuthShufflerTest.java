package io.github.algorithms;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class KnuthShufflerTest {

    @Test
    @Parameters(method = "provideTestCases")
    public void shuffle(Integer[] array) {
        System.out.println(Arrays.toString(KnuthShuffler.shuffle(array)));
    }

    private Object[][] provideTestCases() {
        return new Object[][] {
                {new Integer[] {1, 2, 3, 4, 5}},
                {new Integer[] {}},
                {new Integer[] {1}},
                {new Integer[] {5, 4, 3, 2}}
        };
    }
}
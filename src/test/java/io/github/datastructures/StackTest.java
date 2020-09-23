package io.github.datastructures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class StackTest {

    public Stack<Integer> integerStack;
    public Stack<String> stringStack;

    @Before
    public void setUp() throws Exception {
        integerStack = new Stack<>();
        stringStack = new Stack<>();
    }


    @Test
    @Parameters(method = "pushPopIntegerCases")
    public void pushPopInteger(int[] elements, int pops, String expected) {

        fillStack(elements);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pops; i++) {
            sb.append(integerStack.pop());
        }

        assertThat(sb.toString()).isEqualTo(expected);
    }

    @Test
    public void testInternalArrayResizing() {

        assertThat(integerStack.getSize()).isEqualTo(8);
        IntStream.rangeClosed(1, 9)
                 .forEach(number -> integerStack.push(number));
        assertThat(integerStack.getSize()).isEqualTo(16);
        IntStream.rangeClosed(1, 5)
                 .forEach(index -> integerStack.pop());
        assertThat(integerStack.getSize()).isEqualTo(16);
        integerStack.pop();
        assertThat(integerStack.getSize()).isEqualTo(8);
    }

    public Object[][] pushPopIntegerCases() {
        return new Object[][] {
                {new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 9, "987654321"},
                {new int[] {1, 2, 3, 4}, 2, "43"},
                {new int[] {}, 2, "nullnull"}
        };
    }

    private void fillStack(int[] elements) {
        for (int element : elements) {
            integerStack.push(element);
        }
    }
}
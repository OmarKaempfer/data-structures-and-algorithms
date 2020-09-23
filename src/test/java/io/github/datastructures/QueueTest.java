package io.github.datastructures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class QueueTest {

    private Queue<Integer> integerQueue;
    @Before
    public void setUp() throws Exception {
        integerQueue = new Queue<>();
    }

    @Test
    @Parameters(method = "enqueueDequeueIntegerCases")
    public void enqueue(int[] elements, int dequeueTimes, String expected) {
        fillQueue(elements);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dequeueTimes; i++) {
            sb.append(integerQueue.dequeue());
        }

        assertThat(sb.toString()).isEqualTo(expected);
    }

    public Object[][] enqueueDequeueIntegerCases() {
        return new Object[][] {
                {new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 9, "123456789"},
                {new int[] {1, 2, 3, 4}, 2, "12"}
        };
    }

    @Test
    public void testInternalArrayResizing() {

        assertThat(integerQueue.getSize()).isEqualTo(8);
        IntStream.rangeClosed(1, 9)
                .forEach(number -> integerQueue.enqueue(number));
        assertThat(integerQueue.getSize()).isEqualTo(16);
        IntStream.rangeClosed(1, 5)
                .forEach(index -> integerQueue.dequeue());
        assertThat(integerQueue.getSize()).isEqualTo(16);
        integerQueue.dequeue();
        assertThat(integerQueue.getSize()).isEqualTo(8);
    }

    private void fillQueue(int[] elements) {
        for (int element : elements) {
            integerQueue.enqueue(element);
        }
    }
}
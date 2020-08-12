import cases.TestCases;
import datastructures.BinaryHeap;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BinaryHeap_ {

    @Test
    @Parameters(method = "heapCases", source = TestCases.class)
    public void isAHeap(int[] array) {
        assertThat(true);
    }

    @Test
    public void test() {
        new BinaryHeap(new int[] {1, 2, 3, 4});
    }

}

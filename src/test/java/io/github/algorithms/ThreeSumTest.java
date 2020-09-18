package io.github.algorithms;

import io.github.utils.AlgorithmsAnalyzer;
import io.github.utils.ThreeSumAnalyzer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ThreeSumTest {

    @Test
    public void count() {
        assertThat(ThreeSum.countZeroSums(new int[] {1, -1, 0})).isEqualTo(1);
        assertThat(ThreeSum.countZeroSums(new int[] {1, -1, 0, 2})).isEqualTo(1);
        assertThat(ThreeSum.countZeroSums(new int[] {1, -1, 0, 2, 3, 4})).isEqualTo(1);
        assertThat(ThreeSum.countZeroSums(new int[] {0, 0, 0, 0, 0, 0})).isEqualTo(20);
        assertThat(ThreeSum.countZeroSums(new int[] {1, 2, 3, 4, 5})).isEqualTo(0);
    }

    @Test
    public void test() throws AlgorithmsAnalyzer.NotEnoughDataException {
        System.out.println(ThreeSumAnalyzer.getLogarithmicRatio());
    }
}

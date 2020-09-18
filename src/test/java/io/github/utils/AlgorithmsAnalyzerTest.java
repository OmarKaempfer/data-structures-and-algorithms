package io.github.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class AlgorithmsAnalyzerTest {

    @Test
    public void getRuntime() {
        long runTime = AlgorithmsAnalyzer.getRuntime(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        assertThat(runTime).isGreaterThan(3000)
                            .isLessThan(3300);
    }

    @Test
    public void getLogarithmicRatio() throws AlgorithmsAnalyzer.NotEnoughDataException {

        assertThat(AlgorithmsAnalyzer.getLogarithmicRatio(new long[] {0, 2, 4, 8})).isCloseTo(1, withinPercentage(10));
        assertThat(AlgorithmsAnalyzer.getLogarithmicRatio(new long[] {0, 2, 8, 64})).isCloseTo(2, withinPercentage(10));
    }
}
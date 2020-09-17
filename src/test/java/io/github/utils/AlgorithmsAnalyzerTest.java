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
}
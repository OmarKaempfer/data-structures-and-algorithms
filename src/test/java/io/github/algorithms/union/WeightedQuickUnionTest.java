package io.github.algorithms.union;

import io.github.algorithms.union.WeightedQuickUnion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeightedQuickUnionTest {

    @Test
    public void connect() {

        WeightedQuickUnion weightedQU = new WeightedQuickUnion(10);
        assertThat(weightedQU.connected(1, 2)).isFalse();
        weightedQU.connect(1, 2);
        assertThat(weightedQU.connected(1, 2)).isTrue();
    }

    @Test
    public void anElementShouldBeConnectedToItself() {
        WeightedQuickUnion weightedQU = new WeightedQuickUnion(10);
        assertThat(weightedQU.connected(0, 0)).isTrue();
    }

    @Test
    public void shouldMeetTheTransitiveProperty() {

        WeightedQuickUnion weightedQU = new WeightedQuickUnion(10);
        assertThat(weightedQU.connected(0, 2)).isFalse();

        weightedQU.connect(0, 1);
        weightedQU.connect(1, 2);
        assertThat(weightedQU.connected(0, 2)).isTrue();
    }
}
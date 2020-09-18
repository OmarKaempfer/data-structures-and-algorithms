package io.github.algorithms.union;

import io.github.algorithms.union.QuickUnion;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickUnionTest {

    @Test
    public void connect() {

        QuickUnion quickUnion = new QuickUnion(10);
        assertThat(quickUnion.connected(1, 2)).isFalse();
        quickUnion.connect(1, 2);
        assertThat(quickUnion.connected(1, 2)).isTrue();
    }

    @Test
    public void anElementShouldBeConnectedToItself() {
        QuickUnion quickUnion = new QuickUnion(10);
        assertThat(quickUnion.connected(0, 0)).isTrue();
    }

    @Test
    public void shouldMeetTheTransitiveProperty() {

        QuickUnion quickUnion = new QuickUnion(10);
        assertThat(quickUnion.connected(0, 2)).isFalse();

        quickUnion.connect(0, 1);
        quickUnion.connect(1, 2);
        assertThat(quickUnion.connected(0, 2)).isTrue();
    }
}
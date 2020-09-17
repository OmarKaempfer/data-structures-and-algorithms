package algorithms;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompressedWeightedQuickUnionTest {

    @Test
    public void connect() {

        CompressedWeightedQuickUnion weightedQU = new CompressedWeightedQuickUnion(10);
        assertThat(weightedQU.connected(1, 2)).isFalse();
        weightedQU.connect(1, 2);
        assertThat(weightedQU.connected(1, 2)).isTrue();
    }

    @Test
    public void anElementShouldBeConnectedToItself() {
        CompressedWeightedQuickUnion weightedQU = new CompressedWeightedQuickUnion(10);
        assertThat(weightedQU.connected(0, 0)).isTrue();
    }

    @Test
    public void shouldMeetTheTransitiveProperty() {

        CompressedWeightedQuickUnion weightedQU = new CompressedWeightedQuickUnion(10);
        assertThat(weightedQU.connected(0, 2)).isFalse();

        weightedQU.connect(0, 1);
        weightedQU.connect(1, 2);
        assertThat(weightedQU.connected(0, 2)).isTrue();
    }
}
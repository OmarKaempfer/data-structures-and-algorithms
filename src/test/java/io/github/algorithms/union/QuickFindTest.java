package io.github.algorithms.union;

import io.github.algorithms.union.QuickFind;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class QuickFindTest {

    @Test
    public void connect() {

        QuickFind quickFind = new QuickFind(10);
        assertThat(quickFind.connected(1, 2)).isFalse();
        quickFind.connect(1, 2);
        assertThat(quickFind.connected(1, 2)).isTrue();
    }

    @Test
    public void anElementShouldBeConnectedToItself() {
        QuickFind quickFind = new QuickFind(10);
        assertThat(quickFind.connected(0, 0)).isTrue();
    }

    @Test
    public void shouldMeetTheTransitiveProperty() {

        QuickFind quickFind = new QuickFind(10);
        assertThat(quickFind.connected(0, 2)).isFalse();

        quickFind.connect(0, 1);
        quickFind.connect(1, 2);
        assertThat(quickFind.connected(0, 2)).isTrue();
    }
}
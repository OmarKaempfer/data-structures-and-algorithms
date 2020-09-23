package io.github.algorithms;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    @Test
    public void search() {
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3}, 2)).isEqualTo(2);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3}, 3)).isEqualTo(3);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3}, 0)).isEqualTo(0);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3}, -1)).isEqualTo(-1);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3}, 4)).isEqualTo(-1);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3, 4}, 0)).isEqualTo(0);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3, 4}, 4)).isEqualTo(4);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3, 4}, 2)).isEqualTo(2);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3, 4}, 1)).isEqualTo(1);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3, 4}, 5)).isEqualTo(-1);
        assertThat(BinarySearch.search(new int[] {0, 1, 2, 3, 4}, -1)).isEqualTo(-1);
        assertThat(BinarySearch.search(new int[] {}, 2)).isEqualTo(-1);
        assertThat(BinarySearch.search(new int[] {0}, 0)).isEqualTo(0);
        assertThat(BinarySearch.search(new int[] {0}, 1)).isEqualTo(-1);
    }
}
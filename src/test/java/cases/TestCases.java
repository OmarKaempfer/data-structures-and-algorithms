package cases;

public class TestCases {

    public Object[] heapMinCases() {
        return new Object[][] {
                {new int[] {5, 2, 4, 8, 1, 3, 6}, new int[] {1, 2, 3, 8, 5, 4, 6}},
                {new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[] {0, 1, 3, 2, 5, 4, 7, 9, 6, 8}},
                {new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new int[] {8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[] {0, 1, 2, 5, 4, 3, 6, 7, 8}},
                {new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}},
                {new int[] {2}, new int[] {2}},
                {new int[] {}, new int[] {}}
        };
    }

    public Object[] heapMaxCases() {
        return new Object[][] {
                {new int[] {5, 2, 4, 8, 1, 3, 6}, new int[] {8, 5, 6, 2, 1, 3, 4}},
                {new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}},
                {new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {9, 8, 6, 7, 4, 5, 2, 0, 3, 1}},
                {new int[] {8, 7, 6, 5, 4, 3, 2, 1, 0}, new int[] {8, 7, 6, 5, 4, 3, 2, 1, 0}},
                {new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, new int[] {8, 7, 6, 3, 4, 5, 2, 1, 0}},
                {new int[] {2}, new int[] {2}},
                {new int[] {}, new int[] {}}
        };
    }

    public int[][] generalCases() {
        return new int[][] {
                new int[] {5, 2, 4, 8, 1, 3, 6},
                new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                new int[] {8, 7, 6, 5, 4, 3, 2, 1, 0},
                new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8},
                new int[] {2},
                new int[] {}
        };
    }

    public Object[][] insertCases() {
        return new Object[][] {
                {new int[] {5, 2, 4, 8, 1, 3, 6}, 0},
                {new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 10},
                {new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10},
                {new int[] {8, 7, 6, 5, 4, 3, 2, 1, 0}, 9},
                {new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8}, 9},
                {new int[] {2}, 1},
                {new int[] {}, 1}
        };
    }
}

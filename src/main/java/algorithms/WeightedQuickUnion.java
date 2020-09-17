package algorithms;

public class WeightedQuickUnion {

    private final int[] elements;
    private final int[] treeSizes;

    public WeightedQuickUnion(int size) {

        elements = new int[size];
        treeSizes = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i;
            treeSizes[i] = 1;
        }
    }


    /**
     * @param firstElement
     * @param secondElement
     *
     * Worst case time complexity: 2 log N -> log N
     */
    public void connect(int firstElement, int secondElement) {

        int firstRoot = findRoot(firstElement);
        int secondRoot = findRoot(secondElement);
        if(firstRoot == secondRoot) {
            return;
        }

        if(treeSizes[firstRoot] >= treeSizes[secondRoot]) {
            elements[secondRoot] = firstRoot;
            treeSizes[firstRoot] += treeSizes[secondRoot];
        } else {
            elements[firstRoot] = secondRoot;
            treeSizes[secondRoot] += treeSizes[firstRoot];
        }
    }


    /**
     * @param firstElement
     * @param secondElement
     *
     * Worst case time complexity: 2 log N -> log N
     * @return
     */
    public boolean connected(int firstElement, int secondElement) {
        return findRoot(firstElement) == findRoot(secondElement);
    }


    /**
     * @param element
     *
     * Worst case time complexity: log N
     * Height is reduced dramatically by using weighted trees
     * @return
     */
    private int findRoot(int element) {

        while(elements[element] != element) {
            element = elements[element];
        }

        return element;
    }
}

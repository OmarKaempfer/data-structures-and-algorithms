package io.github.algorithms;

public class QuickUnion {

    private final int[] elements;

    public QuickUnion(int size) {

        elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i;
        }
    }


    /**
     * @param firstElement
     * @param secondElement
     *
     * Worst case time complexity: 2N -> N
     */
    public void connect(int firstElement, int secondElement) {

        int firstRoot = findRoot(firstElement);
        int secondRoot = findRoot(secondElement);

        elements[firstRoot] = secondRoot;
    }


    /**
     * @param firstElement
     * @param secondElement
     *
     * Worst case time complexity: 2 N -> N
     * @return
     */
    public boolean connected(int firstElement, int secondElement) {
        return findRoot(firstElement) == findRoot(secondElement);
    }


    /**
     * @param element
     *
     * Worst case time complexity: N
     * When the trees are too tall
     * @return
     */
    private int findRoot(int element) {

        while(elements[element] != element) {
            element = elements[element];
        }

        return element;
    }
}
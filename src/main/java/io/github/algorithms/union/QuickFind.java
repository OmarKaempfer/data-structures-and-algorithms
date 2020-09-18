package io.github.algorithms.union;

public class QuickFind {
    private final int[] elements;


    /**
     * @param size
     *
     * Time complexity N
     */
    public QuickFind(int size) {
        elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = i;
        }
    }

    /**
     * @param firstElement
     * @param secondElement
     *
     * Time complexity N
     */
    public void connect(int firstElement, int secondElement) {

        if(connected(firstElement, secondElement)) {
            return;
        }

        int firstGroup = elements[firstElement];
        int secondGroup = elements[secondElement];
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] == secondGroup) {
                elements[i] = firstGroup;
            }
        }
    }


    /**
     * @param firstElement
     * @param secondElement
     *
     * Time complexity 1
     *
     * @return
     */
    public boolean connected(int firstElement, int secondElement) {
        return elements[firstElement] == elements[secondElement];
    }
}

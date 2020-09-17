package algorithms;

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
     * Time complexity: 1
     */
    public void connect(int firstElement, int secondElement) {
        elements[firstElement] = secondElement;
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
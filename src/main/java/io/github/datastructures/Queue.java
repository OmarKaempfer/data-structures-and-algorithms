package io.github.datastructures;

public class Queue<T> {

    private static final int MIN_SIZE = 8;

    private int tail = 0;
    private int head = 0;
    private Object[] elements;

    public Queue() {
        this.elements = new Object[MIN_SIZE];
    }

    public void enqueue(T element) {

        if(tail >= elements.length) {

            elements = resize(elements, elements.length * 2);
        }
        this.elements[tail++] = element;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {

        T element = (T)elements[head];
        elements[head++] = null;

        if(head > tail) {
            head = tail;
        }

        if(tail - head < elements.length / 4 && elements.length / 2 >= MIN_SIZE) {
            elements = resize(elements, elements.length / 2);
        }

        return element;
    }

    private Object[] resize(Object[] initial, int newSize) {

        Object[] newArray = new Object[newSize];
        int j = 0;
        for (int i = head; i < initial.length; i++) {

            if(initial[i] == null) {
                break;
            }
            newArray[j] = initial[i];
            j++;
        }
        head = 0;
        tail = j;

        return newArray;
    }

    public int getSize() {
        return elements.length;
    }
}

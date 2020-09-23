package io.github.datastructures;

public class Queue<T> {

    private int tail = 0;
    private int head = 0;
    private T[] elements;

    public Queue() {
        this.elements = (T[])new Object[8];
    }

    public void enqueue(T element) {

        if(tail >= elements.length) {
            elements = (T[]) resize(elements, elements.length * 2);
        }
        this.elements[tail++] = element;
    }

    public T dequeue() {

        T element = elements[head];
        elements[head++] = null;

        if(tail - head < elements.length / 4) {
            elements = (T[]) resize(elements, elements.length / 2);
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

package io.github.datastructures;

import io.github.datastructures.utils.ArrayUtils;

public class Stack<T> {

    private static final int MIN_SIZE = 8;

    private Object[] elements;
    private int tail;


    public Stack() {
        tail = 0;
        elements = new Object[MIN_SIZE];
    }

    public void push(T element) {

        if(tail >= elements.length) {
            elements = ArrayUtils.arrayCopy(elements, elements.length * 2);
        }

        elements[tail++] = element;
    }

    @SuppressWarnings("unchecked")
    public T pop() {

        if(tail == 0) {
            return null;
        }

        T element = (T)elements[--tail];

        elements[tail] = null;
        if(tail < elements.length / 4 && elements.length / 2 >= MIN_SIZE) {
            elements = ArrayUtils.arrayCopy(elements, elements.length / 2);
        }

        return element;
    }

    public int getSize() {
        return elements.length;
    }
}

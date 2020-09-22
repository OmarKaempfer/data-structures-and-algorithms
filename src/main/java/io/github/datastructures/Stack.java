package io.github.datastructures;

import io.github.datastructures.utils.ArrayUtils;

public class Stack<T> {

    private Object[] elements;
    private int tail;


    public Stack() {
        tail = 0;
        elements = (T[])new Object[8];
    }

    public void push(T element) {

        if(tail >= elements.length) {
            elements = (T[])ArrayUtils.arrayCopy(elements, elements.length * 2);
        }

        elements[tail++] = element;
    }

    public T pop() {

        T element = (T)elements[--tail];
        elements[tail] = null;
        if(tail < elements.length / 4) {
            elements = (T[])ArrayUtils.arrayCopy(elements, elements.length / 2);
        }

        return element;
    }

    public int getSize() {
        return elements.length;
    }
}

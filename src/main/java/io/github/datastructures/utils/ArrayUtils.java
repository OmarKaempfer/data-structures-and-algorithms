package io.github.datastructures.utils;

public class ArrayUtils {

    public static Object[] arrayCopy(Object[] initial, int newSize) {
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < initial.length; i++) {

            if(initial[i] == null) {
                break;
            }
            newArray[i] = initial[i];
        }

        return newArray;
    }
}

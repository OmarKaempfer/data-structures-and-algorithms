package io.github.algorithms;

public class BinarySearch {

    public static int search(int[] numbers, int wanted) {

        int low = 0;
        int high = numbers.length - 1;
        while(low <= high) {

            int mid = (low + high) / 2;
            if(numbers[mid] == wanted) {
                return mid;
            } else if(numbers[mid] < wanted) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

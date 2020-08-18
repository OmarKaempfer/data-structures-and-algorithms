package datastructures;

import datastructures.utils.BinaryTreePrinter;
import org.junit.Test;

import java.util.stream.IntStream;

public class BinaryTreePrinter_ {

    @Test
    public void printBinaryTree() {

        BinaryHeap binaryHeap = new BinaryHeap(IntStream.range(1, 90).toArray(), BinaryHeap.Type.MAX);
        BinaryTreePrinter.printTree(binaryHeap.getRoot());
    }

}

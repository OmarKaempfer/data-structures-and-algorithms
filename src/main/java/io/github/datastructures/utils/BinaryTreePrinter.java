package io.github.datastructures.utils;

import io.github.datastructures.IBinaryNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreePrinter {

    public static int LEAF_NODES_DISTANCE = 4;
    public static int MAX_DIGITS = 2;

    public static void printTree(IBinaryNode node) {

        buildTreeStringRepresentation(node)
                .values()
                .forEach(System.out::println);
    }

    public static Map<Integer, String> buildTreeStringRepresentation(IBinaryNode node) {

        Map<Integer, String> treeStringRepresentation = new HashMap<>();
        buildTreeStringRepresentation(node, treeStringRepresentation, 0);
        return addSpacing(treeStringRepresentation);
    }

    public static Map<Integer, String> buildTreeStringRepresentation(IBinaryNode node, Map<Integer, String> tree, int depth) {

        if(node == null) {
            tree.put(depth, tree.getOrDefault(depth, "") + "X\t");
            return tree;
        }

        tree.put(depth, tree.getOrDefault(depth, "") + node.value()  + "\t");

        buildTreeStringRepresentation(node.getLeftChild(), tree, depth + 1);
        buildTreeStringRepresentation(node.getRightChild(), tree, depth + 1);

        return tree;
    }

    private static Map<Integer, String> addSpacing(Map<Integer, String> treeStringRepresentation) {

        setDeepestLevelSpacing(treeStringRepresentation);
        for(int i = treeStringRepresentation.size() - 2; i >= 0; i--) {
            setRelativeToDeepestLevelSpacing(treeStringRepresentation, i);
        }

        return treeStringRepresentation;
    }

    private static void setRelativeToDeepestLevelSpacing(Map<Integer, String> treeStringRepresentation, int currentDepth) {

        String[] nodeValues = treeStringRepresentation.get(currentDepth).trim().split("\t");
        String spaceBetweenNodes = getAppropiateSpaceBetweenNodes(treeStringRepresentation, currentDepth);

        StringBuilder sb = new StringBuilder();
        sb.append(setOuterSpaceOffset(treeStringRepresentation, currentDepth))
                .append(nodeValues[0]);

        Arrays.stream(nodeValues)
                .skip(1)
                .forEach(node -> {
                    sb.append(spaceBetweenNodes);
                    sb.append(pad(node));
                });

        treeStringRepresentation.put(currentDepth, sb.toString());
    }

    private static void setDeepestLevelSpacing(Map<Integer, String> treeStringRepresentation) {

        String spacedDeepestLevel = treeStringRepresentation.get(treeStringRepresentation.size() - 1)
                .trim()
                .replace("\t", " ".repeat(LEAF_NODES_DISTANCE));
        treeStringRepresentation.put(treeStringRepresentation.size() - 1, spacedDeepestLevel);
    }

    private static String getAppropiateSpaceBetweenNodes(Map<Integer, String> treeStringRepresentation, int currentDepth) {

        return " ".repeat((int) (depthSpaceMultiplier(treeStringRepresentation, currentDepth)))
        + " ".repeat(countLeftChildrenBeforeBottom(currentDepth, treeStringRepresentation.size() - 1) * MAX_DIGITS);
    }

    private static String setOuterSpaceOffset(Map<Integer, String> treeStringRepresentation, int currentDepth) {
        return " ".repeat((int) (depthSpaceMultiplier(treeStringRepresentation, currentDepth) / 2) - 2) +
                " ".repeat((int) Math.max(
                        countLeftChildrenBeforeBottom(currentDepth, treeStringRepresentation.size() - 1)
                                * MAX_DIGITS - Math.pow(2, treeStringRepresentation.size() - 1 - currentDepth - 1), 0));
    }

    private static double depthSpaceMultiplier(Map<Integer, String> treeStringRepresentation, int currentDepth) {
        return LEAF_NODES_DISTANCE * Math.pow(2, treeStringRepresentation.size() - 1 - currentDepth);
    }

    private static int countLeftChildrenBeforeBottom(int currentDepth, int maxDepth) {

        int subtreeDepth = maxDepth - currentDepth;

        int childrenCount = 0;
        for(int i = 0; i < subtreeDepth - 1; i++) {
            childrenCount += Math.pow(2, i);
        }

        return childrenCount;
    }

    private static String pad(String nodeValue) {
            return " ".repeat(MAX_DIGITS - nodeValue.length()) + nodeValue;
    }
}
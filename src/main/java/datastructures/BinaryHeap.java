package datastructures;


import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {

    public enum Type {
        MIN, MAX
    }

    public enum RelativePosition {
        FIRST, SECOND, NONE
    }

    public static class Node implements IBinaryNode {

        private int value;
        private IBinaryNode leftChild = null;
        private IBinaryNode rightChild = null;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int value() {
            return this.value;
        }

        @Override
        public void setLeftChild(IBinaryNode node) {
            this.leftChild = node;
        }

        @Override
        public void setRightChild(IBinaryNode node) {
            this.rightChild = node;
        }

        @Override
        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public IBinaryNode getLeftChild() {
            return this.leftChild;
        }

        @Override
        public IBinaryNode getRightChild() {
            return this.rightChild;
        }
    }

    public List<IBinaryNode> arrayList;
    private Type type;

    public BinaryHeap(int[] array, Type type) {
        this.type = type;
        buildHeap(array);
    }


    private void buildHeap(int[] array) {
        this.arrayList = new ArrayList<>(array.length * 2);
        for(int value : array) {
            appendToNextSpot(new Node(value));
        }
        heapify();
    }


    public IBinaryNode getRoot() {
        return arrayList.isEmpty() ? null : arrayList.get(0);
    }

    public List<IBinaryNode> asList() {
        return arrayList;
    }


    public BinaryHeap insert(int value) {

        IBinaryNode toBeInserted = new Node(value);
        appendToNextSpot(toBeInserted);
        siftUp(arrayList.size() - 1);

        return this;
    }

    private void appendToNextSpot(IBinaryNode node) {
        arrayList.add(node);

        appendToParent(node, arrayList.size() - 1);
    }

    private void siftUp(int nodePos) {

        int parentPos = findParentPosition(nodePos);
        IBinaryNode parent = arrayList.get(parentPos);
        IBinaryNode node = arrayList.get(nodePos);

        if(getHighestPriorityBetween(nodePos, parentPos) == RelativePosition.FIRST) {
            switchNodes(nodePos, parentPos);
            siftUp(parentPos);
        }
    }

    private void heapify() {

        for(int i = arrayList.size() - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    public void siftDown(int node) {

        if(arrayList.size() <= 1) {
            return;
        }

        int firstChild = findLeftChildPosition(node);
        int secondChild = findRightChildPosition(node);

        RelativePosition highestPriorityChild = getHighestPriorityBetween(firstChild, secondChild);

        switch(highestPriorityChild) {

            case FIRST:

                if(getHighestPriorityBetween(node, firstChild) == RelativePosition.SECOND) {
                    switchNodes(node, firstChild);
                    siftDown(firstChild);
                }
                break;

            case SECOND:

                if(getHighestPriorityBetween(node, secondChild) == RelativePosition.SECOND) {
                    switchNodes(node, secondChild);
                    siftDown(secondChild);
                }
                break;
        }
    }

    private RelativePosition getHighestPriorityBetween(int firstNodePosition, int secondNodePosition) {

        if(!exists(firstNodePosition) && !exists(secondNodePosition)) {
            return RelativePosition.NONE;
        }

        if(!exists(firstNodePosition)) {
            return RelativePosition.SECOND;
        }

        if(!exists(secondNodePosition)) {
            return RelativePosition.FIRST;
        }

        IBinaryNode firstNode = arrayList.get(firstNodePosition);
        IBinaryNode secondNode = arrayList.get(secondNodePosition);

        switch(type) {
            case MAX:
                return firstNode.value() > secondNode.value() ? RelativePosition.FIRST : RelativePosition.SECOND;
            case MIN:
                return firstNode.value() < secondNode.value() ? RelativePosition.FIRST : RelativePosition.SECOND;
        }

        return RelativePosition.NONE;
    }

    private void switchNodes(int firstNodePosition, int secondNodePosition) {

        IBinaryNode firstNode = arrayList.get(firstNodePosition);

        arrayList.set(firstNodePosition, arrayList.get(secondNodePosition));
        arrayList.set(secondNodePosition, firstNode);
        updateChildrenOf(firstNodePosition);
        updateChildrenOf(secondNodePosition);

        if(exists(findParentPosition(firstNodePosition))) {
            updateChildrenOf(findParentPosition(firstNodePosition));
        }
    }

    public IBinaryNode removeHead() {

        if(arrayList.isEmpty()) {
            return null;
        }

        IBinaryNode head = arrayList.get(0);
        replaceHeadWithTail();
        siftDown(0);

        return head;
    }

    private void replaceHeadWithTail() {

        switchNodes(0, arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);

        if(exists(findParentPosition(arrayList.size()))) {
            updateChildrenOf(findParentPosition(arrayList.size()));
        }
    }

    private void updateChildrenOf(int position) {

        IBinaryNode node = arrayList.get(position);
        int leftChildPosition = findLeftChildPosition(position);
        int rightChildPosition = findRightChildPosition(position);

        node.setLeftChild(exists(leftChildPosition) ? arrayList.get(leftChildPosition) : null);
        node.setRightChild(exists(rightChildPosition) ? arrayList.get(rightChildPosition) : null);
    }

    private void appendToParent(IBinaryNode toBeInserted, int position) {

        if(position == 0) {
            return;
        }

        IBinaryNode parentNode = arrayList.get(findParentPosition(position));
        if(position % 2 == 1) {
            parentNode.setLeftChild(toBeInserted);
        } else {
            parentNode.setRightChild(toBeInserted);
        }
    }

    private int findLeftChildPosition(int parentPosition) {

        int position =  2 * parentPosition + 1;
        return exists(position) ? position : -1;
    }

    private int findRightChildPosition(int parentPosition) {

        int position =  2 * parentPosition + 2;
        return exists(position) ? position : -1;
    }

    private boolean exists(int position) {
        return position < arrayList.size() && position >= 0;
    }

    private int findParentPosition(int childPosition) {
        return (childPosition - 1) / 2;
    }
}
package datastructures;


public class BinaryHeap {

    public static class Node implements IBinaryNode {

        private int value;
        private IBinaryNode leftChild = null;
        private IBinaryNode rightChild = null;
        private IBinaryNode parent = null;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int value() {
            return this.value;
        }

        @Override
        public void setLeftChild(IBinaryNode node) {
            node.setParent(this);
            this.leftChild = node;
        }

        @Override
        public void setRightChild(IBinaryNode node) {
            node.setParent(this);
            this.rightChild = node;
        }

        @Override
        public void setParent(IBinaryNode node) {
            this.parent = node;
        }

        @Override
        public IBinaryNode getLeftChild() {
            return this.leftChild;
        }

        @Override
        public IBinaryNode getRightChild() {
            return this.rightChild;
        }

        @Override
        public IBinaryNode getParent() {
            return parent;
        }
    }


    private IBinaryNode root = null;
    private IBinaryNode tail = null;

    public BinaryHeap(int[] array) {
        buildHeap(array);
    }


    private void buildHeap(int[] array) {

        for(int value : array) {
            insert(value);
        }
    }


    public IBinaryNode getRoot() {
        return root;
    }


    public BinaryHeap insert(int value) {

        IBinaryNode toBeInserted = new Node(value);

        if(root == null) {

            root = toBeInserted;
            tail = root;

        } else {
            appendChildTo(toBeInserted, findNextFreeLeafImmediateParent());
        }

        tail = toBeInserted;
        return reorderHeap();
    }


    private boolean appendChildTo(IBinaryNode toBeInserted, IBinaryNode currentNode) {

        if(currentNode.getLeftChild() == null) {
            currentNode.setLeftChild(toBeInserted);

        } else if (currentNode.getRightChild() == null) {
            currentNode.setRightChild(toBeInserted);
        } else {
            return false;
        }

        return true;
    }


    private IBinaryNode findNextFreeLeafImmediateParent() {

        if(isRoot(tail)) {
            return tail;
        }

        IBinaryNode previousNode = tail;
        IBinaryNode currentNode = tail.getParent();

        while(!isRoot(currentNode) &&
                isParentToTheLeft(currentNode, previousNode)) {

            previousNode = currentNode;
            currentNode = currentNode.getParent();
        }

        if(currentNode.getRightChild() == null) {
            return currentNode;
        }

        if(isRoot(currentNode) && isParentToTheLeft(currentNode, previousNode)) {
            return findLeftmostChild(currentNode.getLeftChild());
        }

        return findLeftmostChild(currentNode.getRightChild());
    }


    private BinaryHeap reorderHeap() {
        return this;
    }


    private boolean isRoot(IBinaryNode currentNode) {
        return currentNode.getParent() == null;
    }


    private boolean isParentToTheLeft(IBinaryNode currentNode, IBinaryNode previousNode) {
        return previousNode.equals(currentNode.getRightChild());
    }


    private IBinaryNode findLeftmostChild(IBinaryNode current) {

        while(current.getLeftChild() != null) {
            current = current.getLeftChild();
        }

        return current;
    }
}
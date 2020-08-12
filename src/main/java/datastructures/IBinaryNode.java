package datastructures;

public interface IBinaryNode {

    int value();

    void setLeftChild(IBinaryNode node);

    void setRightChild(IBinaryNode node);

    void setParent(IBinaryNode node);

    IBinaryNode getLeftChild();

    IBinaryNode getRightChild();

    IBinaryNode getParent();
}

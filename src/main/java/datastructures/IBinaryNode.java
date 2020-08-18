package datastructures;

public interface IBinaryNode {

    int value();

    void setLeftChild(IBinaryNode node);

    void setRightChild(IBinaryNode node);

    void setValue(int value);

    IBinaryNode getLeftChild();

    IBinaryNode getRightChild();
}

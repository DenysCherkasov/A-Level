package com.cherkasov.container;

import com.cherkasov.model.Car;

import java.util.Comparator;

public class CarTree extends BinaryTree<Car> {
    public CarTree() {
    }

    public CarTree(Comparator<Car> comparator) {
        super(comparator);
    }

    public int sumCount() {
        if (rootNode == null) {
            return 0;
        }
        return rootNode.getValue().getCount() +
                sumNodes(rootNode.getLeftChild()) +
                sumNodes(rootNode.getRightChild());
    }

    private int sumNodes(Node node) {
        if (node == null) {
            return 0;
        } else {
            int sumNodes = node.getValue().getCount() +
                    sumNodes(node.getLeftChild()) +
                    sumNodes(node.getRightChild());
            return sumNodes;
        }
    }


}

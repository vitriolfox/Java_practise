package com.flowacademy;

import java.util.ArrayList;
import java.util.List;

public class BinTreeJava {

    public BinTreeNode search(BinTreeNode targetRoot, Integer value) {
        BinTreeNode root = targetRoot;

        if (root != null && root.getValue() == value) {
            return root;

        } else if (value > root.getValue()) {
            root = search(targetRoot.getRightNode(), value);
        } else {
            root = search(targetRoot.getLeftNode(), value);
        }
        return root;
    }

    public BinTreeNode insertNode(BinTreeNode root, Integer value) {

        if (root == null) {
            return new BinTreeNode(value, null, null);

        } else if (root.getValue() > value) {
            root.setLeftNode(insertNode(root.getLeftNode(), value));
            return root;

        } else if (root.getValue() < value) {
            root.setRightNode(insertNode(root.getRightNode(), value));
            return root;

        } else {
            return root;

        }
    }

    public List<BinTreeNode> iterateTree(BinTreeNode root) {
        List<BinTreeNode> treeList = new ArrayList<>();

        if (root == null) {
            System.out.println("Tree is empty!");
            return treeList;

        } else if (root.getLeftNode() != null) {
            treeList.add(root.getLeftNode());

        } else if (root.getRightNode() != null) {
            treeList.add(root.getRightNode());

        }
        return treeList;
    }

    public int numberOfLeafs(BinTreeNode root) {
        int leafsCounter = 0;
        if (root == null) {
            return 0;

        } else if (root.getRightNode() == null && root.getLeftNode() == null) {
            return 1;

        } else {
            leafsCounter = (numberOfLeafs(root.getLeftNode()) + numberOfLeafs(root.getRightNode()));

        }
        return leafsCounter;
    }


}






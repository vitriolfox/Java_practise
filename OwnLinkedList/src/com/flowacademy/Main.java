package com.flowacademy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {


        BinTreeJava tree = new BinTreeJava();
        BinTreeNode root = tree.insertNode(null,0);
        Random random = new Random();
        for (int i= 0; i < 20; i++){
            tree.insertNode(root, random.nextInt(10));
        }



        //System.out.println(tree.iterateTree(root));
        BTreePrinter.printNode(root);
        System.out.println(tree.numberOfLeafs(root));
    }

}

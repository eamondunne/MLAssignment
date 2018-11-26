/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

import java.util.ArrayList;

/**
 * @author Cormac Buckley, Eamon Dunne
 */
public class CART {

    private Tree t = new Tree();
    private ArrayList<Integer> nodes = new ArrayList<Integer>();
    private ArrayList<Integer> features = new ArrayList<Integer>();
//    Data Stuff Goes Here

    /**
     * Constructor
     */
    public CART() {

    }

    /**
     * Calculate cost of split
     */
    void getSplitCost() {

    }

    /**
     * Test costs for split
     */
    void testSplits() {

    }

    /**
     * Split the tree
     */
    void splitTree() {

    }

    /**
     * Build the tree
     */
    Tree buildTree(ArrayList<Double> data) {

        Tree bt = t.buildTree(data);
        return bt;

    }

    /**
     * Set Data
     */
    void setData() {
        String file = "owls.csv";
        String delim = ",";
        ImportData owls = new ImportData(file, delim);
        owls.readCSV();
        owls.printFeatures();
        owls.printTargets();
        owls.printTarget_Names();

    }

    /**
     * Print Tree
     */
    void printTree(Node current, int level) {
        if (current == null) {
            return;
        }
        if (level == 1) {
            System.out.println(current.value + " ");
        } else {
            printTree(current.left, level - 1);
            printTree(current.right, level - 1);
        }

    }
}

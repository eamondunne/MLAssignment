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
    
          private BinaryTree t = new BinaryTree();
          private ArrayList<Integer> nodes = new ArrayList<Integer>(); 
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
    BinaryTree buildTree() {

        BinaryTree bt = t.buildTree();   
        return bt;
    
    }
    
    /**
     * Set Data
     */
    void setData() {

    }
    
    /**
     * Print Tree
     */
    ArrayList printTree(Node current) {
        System.out.println(current.value);
         nodes.add(current.value);
        if(current.left != null){
        printTree(current.left);
        
        }
         if(current.right != null){
        printTree(current.right);
        
        }
        return nodes;
    }
}

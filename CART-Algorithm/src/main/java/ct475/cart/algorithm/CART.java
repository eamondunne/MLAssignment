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
    BinaryTree buildTree(ArrayList<Integer> data) {

        BinaryTree bt = t.buildTree(data);   
        return bt;
    
    }
    
    /**
     * Set Data
     */
    void setData() {
        String file = "C:\\Users\\I342042\\Documents\\College\\4th Year\\Machine Learning & Data Mining\\Assignments\\Assignment3\\MLAssignment\\owls.csv";
        String delim = ",";
        ImportData owls = new ImportData(file, delim);
        owls.readCSV();
    }
    
    /**
     * Print Tree
     */
    void printTree(Node current, int level) {        
        if(current == null)
            return ;
        if(level == 1){
            System.out.println(current.value + " ");
        }
        else{ 
        printTree(current.left, level-1);
        printTree(current.right, level-1);
        }
       
    }
}

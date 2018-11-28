/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Cormac Buckley, Eamon Dunne
 */
public class CART {

    private Tree t = new Tree();
    private ArrayList<Integer> nodes = new ArrayList<Integer>();
    public ArrayList<Entry> features = new ArrayList<Entry>();
    private ArrayList<Integer> targets = new ArrayList<Integer>();
    
    private ArrayList<Entry> leftSplit = new ArrayList<Entry>();
    private ArrayList<Entry> rightSplit = new ArrayList<Entry>();
    
    private ArrayList<Entry> bestLeftSplit = new ArrayList<Entry>();
    private ArrayList<Entry> bestRightSplit = new ArrayList<Entry>();
//    Data Stuff Goes Here

    /**
     * Constructor
     */
    public CART() {

    }

    /**
     * Calculate cost of split
     */
    int getSplitCost(ArrayList<Entry> leftSplit,ArrayList<Entry> rightSplit, ArrayList<Integer> targets) {
       return (int)(Math.random()*100) + 1;
    }

    /**
     * Test costs for split
     */
    void testSplits(int index, double featureCheck, ArrayList<Entry> features) {
      
        for(int x = 0; x < features.size(); x++){
            if(features.get(x).ColumnData.get(index) > featureCheck){
                rightSplit.add(features.get(x));
            }else{
                leftSplit.add(features.get(x));
            }
        }        
    }

    /**
     * Split the tree
     */
    void splitTree(ArrayList<Entry> features) {
        int giniIndex;
        int lowestIndex = 1000,lowestScore = 1000;
        double lowestVal = 1000;
            for(int i = 0; i < features.size(); i++){
                for(int x = 0; x < features.get(i).ColumnData.size(); x++){
                    testSplits(x, features.get(i).ColumnData.get(x),features);
                    giniIndex = getSplitCost(leftSplit, rightSplit, targets);
                    if(giniIndex < lowestScore){
                        lowestIndex = i; 
                        lowestVal = features.get(i).ColumnData.get(x);
                        lowestScore = giniIndex;
                        bestLeftSplit = leftSplit;
                        bestRightSplit = rightSplit;
                        
                    }
                 }
            }
            System.out.println(lowestScore);  
            System.out.println(lowestVal);  
            System.out.println(bestLeftSplit.get(1).ColumnData);  
            System.out.println(bestRightSplit.get(1).ColumnData);  
            
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
        this.features = owls.getFeatures();
//        System.out.println(features.get(134).ColumnData);
       // owls.printFeatures();
       // owls.printTargets();
       // owls.printTarget_Names();

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

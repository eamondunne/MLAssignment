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
    public ArrayList<ArrayList<Double>> features = new ArrayList<ArrayList<Double>>();
    private ArrayList<Integer> targets = new ArrayList<Integer>();
    
    private ArrayList<ArrayList<Double>> leftSplit = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> rightSplit = new ArrayList<ArrayList<Double>>();
    
    private ArrayList<ArrayList<Double>> bestLeftSplit = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> bestRightSplit = new ArrayList<ArrayList<Double>>();
//    Data Stuff Goes Here

    /**
     * Constructor
     */
    public CART() {

    }

    /**
     * Calculate cost of split
     */
    int getSplitCost(ArrayList<ArrayList<Double>> leftSplit,ArrayList<ArrayList<Double>> rightSplit, ArrayList<Integer> targets) {
       return (int)(Math.random()*500) + 1; 
    }

    /**
     * Test costs for split
     */
    void testSplits(int index, double featureCheck, ArrayList<ArrayList<Double>> features) {
      
        for(int x = 0; x < features.get(0).size(); x++){
            if(features.get(x).get(index) > featureCheck){
                rightSplit.add(features.get(x));
            }else{
                leftSplit.add(features.get(x));
            }
        }        
    }

    /**
     * Split the tree
     */
    void splitTree(ArrayList<ArrayList<Double>> features) {
        int giniIndex;
        int lowestIndex = 1000,lowestScore = 1000;
        double lowestVal = 1000;
            for(int i = 0; i < features.size(); i++){
                for(int x = 0; x < features.get(i).size(); x++){
                    testSplits(i, features.get(i).get(x),features);
                    giniIndex = getSplitCost(leftSplit, rightSplit, targets);
                    if(giniIndex < lowestScore){
                        lowestIndex = i; 
                        lowestVal = features.get(i).get(x);
                        lowestScore = giniIndex;
                        bestLeftSplit = leftSplit;
                        bestRightSplit = rightSplit;
                    }
                 }
            }
            
            System.out.println(lowestScore);
            
            
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

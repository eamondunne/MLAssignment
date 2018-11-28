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
    private ArrayList<String> targets = new ArrayList<String>();
    
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
    double getSplitCost(ArrayList<Entry> leftSplit,ArrayList<Entry> rightSplit, ArrayList<String> targets) {
        double gini = 0.0;
        double size;
        double score = 1;
        double p = 0;
        String classVal;
        double occurences = 0;

        int totalSize = leftSplit.size() + rightSplit.size();
        System.out.println("Score: " + score);
        System.out.println("Total Size: " + totalSize);
        System.out.println("LEFT SIZE: " + leftSplit.size());
        System.out.println("RIGHT SIZE: " + rightSplit.size());
        for (String t : targets){
            occurences = 0;
            System.out.println(t);
            for (Entry e : leftSplit){
                if (e.Target.equals(t)){
                    occurences++;
                }
            }
            System.out.println("Occurences: " + occurences);
            p = (double)occurences / (double)leftSplit.size();
            System.out.println("p: " + p);
            
            score -= (p*p);
            System.out.println("Score: " + score);
        }
        
        System.out.println("END");
        
        
//        size = leftSplit.size();
        //TODO FIX THIS
//        if (size == 0) {
//            size = 1;
//        }
//        score = 0.0;
        /* Left Split Calculation goes here*/
//        System.out.println(targets.size());
//        for(Entry e : leftSplit){
//            for(Double d : e.ColumnData){
//                System.out.println(d);
//            }
//            System.out.println(e.Target);
//        }

        
//        System.out.println("NEXTITER");
//        for (String val : targets) {
////            for (Entry attrib : leftSplit){
////                classVal = attrib.Target;
////                if(val.equals(classVal)){
////                    p++;
////                    System.out.println("MATCHING VALS");
////                }
////            }
//            System.out.println(val);
//        }
            
            
//            for (ArrayList attrib : leftSplit) {
//                classVal = (double) attrib.get(attrib.size() - 1);
//                if (classVal == val) {
//                    p++;
//                }
//
//                proportion = p / size;
//                score += proportion * proportion;
//            }
//            gini += (1.0 - score) * (size / 2);
//        }
        return 0;
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
        double giniIndex;
        double lowestIndex = 1000,lowestScore = 1000;
        double lowestVal = 1000;
//        CHANGE i<1 back to features.size()
            for(int i = 0; i < 1; i++){
                for(int x = 0; x < features.get(i).ColumnData.size(); x++){
                    leftSplit.clear();
                    rightSplit.clear();
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
        this.targets = owls.getTargets();
        for(String a : targets){
            System.out.println(a);
        }
//        System.out.println(targets);
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

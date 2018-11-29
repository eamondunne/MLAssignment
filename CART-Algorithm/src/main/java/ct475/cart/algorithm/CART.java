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
    private int a = 0;
//    Data Stuff Goes Here

    /**
     * Constructor
     */
    public CART() {

    }

    /**
     * Calculate cost of split
     */
    double getSplitCost(ArrayList<Entry> leftSplit, ArrayList<Entry> rightSplit, ArrayList<String> targets) {
        if (leftSplit.size() == 0) {
            return 1;
        } else if (rightSplit.size() == 0) {
            return 1;
        } else {
            double gini = 0.0;
            double size;
            double leftscore = 1, rightscore = 1;
            double p = 0;
            double psqr;
            String classVal;
            double occurences = 0;

            double totalSize = leftSplit.size() + rightSplit.size();
//        LEFT
//        System.out.println("PRE Left Score: " + leftscore);
//        System.out.println("Total Size: " + totalSize);
//        System.out.println("LEFT SIZE: " + leftSplit.size());
//        System.out.println("RIGHT SIZE: " + rightSplit.size());
            for (String t : targets) {
                occurences = 0;
//            System.out.println(t);
                for (Entry e : leftSplit) {
                    if (e.Target.equals(t)) {
                        occurences++;
                    }
                }
//            System.out.println("Occurences: " + occurences);
                p = (double) occurences / (double) leftSplit.size();
                psqr = p * p;
//            System.out.println("psqr: " + psqr);
                leftscore -= psqr;
//            System.out.println("Left Score: " + leftscore);
            }
            gini = ((1 - leftscore) * (leftSplit.size() / totalSize));
//        System.out.println("GINILEFT: " + gini);

//        RIGHT SIDE
//        System.out.println("PRE Right Score: " + rightscore);
//        System.out.println("Total Size: " + totalSize);
//        System.out.println("LEFT SIZE: " + leftSplit.size());
//        System.out.println("RIGHT SIZE: " + rightSplit.size());
            for (String t : targets) {
                occurences = 0;
//            System.out.println(t);
                for (Entry e : rightSplit) {
                    if (e.Target.equals(t)) {
                        occurences++;
                    }
                }
//           System.out.println("Occurences: " + occurences);
                p = (double) occurences / (double) rightSplit.size();
                psqr = p * p;
//            System.out.println("psqr: " + psqr);
                rightscore -= psqr;
//            System.out.println("Score: " + rightscore);
            }
            gini += (1 - rightscore) * (rightSplit.size() / totalSize);
//        System.out.println("GINITOTAL: " + gini);
//        System.out.println("END\n\n\n");

            return gini;
        }
    }

    /**
     * Test costs for split
     */
    void testSplits(int index, double featureCheck, ArrayList<Entry> features) {

        for (int x = 0; x < features.size(); x++) {
            if (features.get(x).ColumnData.get(index) > featureCheck) {
                rightSplit.add(features.get(x));
            } else {
                leftSplit.add(features.get(x));
            }
        }
    }

    /**
     * Split the tree
     */
    void splitTree(ArrayList<Entry> features) {
       
        double giniIndex;
        int lowestIndex = 1000;
        double lowestScore = 1;
        int colToSplit = 100;
        double lowestVal = 1000;
        for (int i = 0; i < features.size(); i++) {
            for (int x = 0; x < features.get(i).ColumnData.size(); x++) {   
                leftSplit.clear();
                  rightSplit.clear();
                testSplits(x, features.get(i).ColumnData.get(x), features);
                giniIndex = getSplitCost(leftSplit, rightSplit, targets);
                if (giniIndex < lowestScore) {
                    lowestIndex = i;
                    lowestVal = features.get(i).ColumnData.get(x);
                    colToSplit = x;
                    lowestScore = giniIndex;
                    bestLeftSplit = leftSplit;
                    bestRightSplit = rightSplit;         
                }
                 
            
            }
          
        }
        System.out.println("Best gini Score: " + lowestScore);
        System.out.println(lowestVal);
        System.out.println("Column to split on: " + colToSplit);
        System.out.print(bestLeftSplit.get(lowestIndex).ColumnData);
        System.out.println(bestLeftSplit.get(lowestIndex).Target);
        System.out.print(bestRightSplit.get(lowestIndex).ColumnData);
        System.out.println(bestRightSplit.get(lowestIndex).Target);
   
    }
    
    Entry createLeaf(ArrayList<Entry> split){
        int occurrences = 0;
        int mostOccurences = 0;
        Entry mostCommon = null;
        ArrayList<Integer> nums = new ArrayList<Integer>();
          for (String t : targets) {
                occurrences = 0;
                for (Entry e : rightSplit) {
                    if (e.Target.equals(t)) {
                        occurrences++;
                    }
                     if(occurrences > mostOccurences){
                    mostCommon = e;
                }
                }
               
                
    }
          return mostCommon;
    }
   
    void recurseOnSplit(int maxDepth, int depth){
        //Get left and right splits
        ArrayList<Entry> left = bestLeftSplit;
        ArrayList<Entry> right = bestRightSplit;
        
        //If left or right are empty make it a leaf node
        if(left.isEmpty()){
            createLeaf(left);
            return;
        }
        if(right.isEmpty()){
            createLeaf(right);
            return;
        }
        
        //check if at max depth. If so create a leaf node
        if(depth >= maxDepth){
            createLeaf(left);
            createLeaf(right);
            return;
        }
             System.out.println("Loop");
          
         splitTree(left);
         recurseOnSplit(maxDepth,depth+1);
           
         splitTree(right);
         recurseOnSplit(maxDepth,depth+1);        
    }
    /**
     * Build the tree
     */
    Tree buildTree(ArrayList<Double> data) {

        Tree bt = t.buildTree(data);
        return bt;

    }

   void setTrainingData(String file, String delim) {
        ImportData data = new ImportData(file, delim);
        data.readCSV();
        this.features = data.getFeatures();
        this.targets = data.getTargets();
        for (String a : targets) {
            System.out.println(a);
        }
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

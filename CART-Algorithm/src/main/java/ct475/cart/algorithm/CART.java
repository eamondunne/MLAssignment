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

    public CART() {}

    /**
     * Calculate Cost of Split using GINI Index
     */
    double getSplitCost(ArrayList<Entry> leftSplit, ArrayList<Entry> rightSplit, ArrayList<String> targets) {
        /* Return 1 of either side is empty */
        if(leftSplit.isEmpty())
            return 1;
        
        if(rightSplit.isEmpty())
            return 1;

        double gini = 0.0;
        double size;
        double leftscore = 1, rightscore = 1;
        double p = 0;
        double psqr;
        String classVal;
        double occurences = 0;

        double totalSize = leftSplit.size() + rightSplit.size();

        /* Compute GINI Index for Left Split */
        for (String t : targets) {
            occurences = 0;
            System.out.println(t);
            for (Entry e : leftSplit) {
                if (e.Target.equals(t)) {
                    occurences++;
                }
            }
            p = (double) occurences / (double) leftSplit.size();
            psqr = p*p;
            leftscore -= psqr;
        }
        gini = ((1 - leftscore)*(leftSplit.size() / totalSize));
        
        /* Compute GINI Index for Right Split */
        for (String t : targets) {
            occurences = 0;
            System.out.println(t);
            for (Entry e : rightSplit) {
                if (e.Target.equals(t)) {
                    occurences++;
                }
            }
            p = (double) occurences / (double) rightSplit.size();
            psqr = p*p;
            rightscore -= psqr;
        }
        gini += (1 - rightscore)*(rightSplit.size() / totalSize);

        return gini;
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
        double lowestIndex = 1000, lowestScore = 1;
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
        /* Used for Testing / Debugging */
        System.out.println("Best gini Score: " + lowestScore);
        System.out.println(lowestVal);
        System.out.println("Column to split on: " + colToSplit);
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
     * Set Training Data
     */
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

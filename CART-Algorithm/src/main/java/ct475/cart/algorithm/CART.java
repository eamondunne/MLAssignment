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

//  private Tree t = new Tree();
    private ArrayList<Integer> nodes = new ArrayList<Integer>();
    public ArrayList<Entry> features = new ArrayList<Entry>();
    private ArrayList<String> targets = new ArrayList<String>();

    private ArrayList<Entry> leftSplit = new ArrayList<Entry>();
    private ArrayList<Entry> rightSplit = new ArrayList<Entry>();
//  Data Stuff Goes Here

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
            double leftscore = 1, rightscore = 1;
            double p = 0;
            double psqr;
            double occurences = 0;

            double totalSize = leftSplit.size() + rightSplit.size();
            for (String t : targets) {
                occurences = 0;
                for (Entry e : leftSplit) {
                    if (e.Target.equals(t)) {
                        occurences++;
                    }
                }
                p = (double) occurences / (double) leftSplit.size();
                psqr = p * p;
                leftscore -= psqr;
            }
            gini = ((1 - leftscore) * (leftSplit.size() / totalSize));
            for (String t : targets) {
                occurences = 0;
                for (Entry e : rightSplit) {
                    if (e.Target.equals(t)) {
                        occurences++;
                    }
                }
                p = (double) occurences / (double) rightSplit.size();
                psqr = p * p;
                rightscore -= psqr;
            }
            gini += (1 - rightscore) * (rightSplit.size() / totalSize);

            return gini;
        }
    }

    /**
     * Test costs for split to find best feature
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
    Branches splitTree(ArrayList<Entry> features) {
        Branches branches = null;
        double giniIndex;
        int lowestIndex = 1000;
        double lowestScore = 1;
        int colToSplit = 100;
        double valToSplit = 1000;
        for (int i = 0; i < features.size(); i++) {
//              System.out.print(features.get(i).ColumnData);
//              System.out.println(features.get(i).Target);
              
            for (int x = 0; x < features.get(i).ColumnData.size(); x++) {
                testSplits(x, features.get(i).ColumnData.get(x), features);
                giniIndex = getSplitCost(leftSplit, rightSplit, targets);
                if (giniIndex < lowestScore) {
                    lowestIndex = i;
                    valToSplit = features.get(i).ColumnData.get(x);
                    colToSplit = x;
                    lowestScore = giniIndex;
                    branches = new Branches(leftSplit,rightSplit);
                }
                else{
                leftSplit.clear();
                rightSplit.clear();
                }
            }
        }
        System.out.println("Best gini Score: " + lowestScore);
        System.out.println("Value to split on: " + valToSplit);
        System.out.println("Column to split on: " + colToSplit);
        
        return branches;

    }

    /*
     * Create Classifier on Leaf
     */
    String createClassifierLeaf(ArrayList<Entry> split) {
        int occurrences = 0;
        int mostOccurences = 0;
        String mostCommon = null;
        System.out.print(targets);
        for (String t : targets) {
            occurrences = 0;
            for (Entry e : split) {
                System.out.print("Hey Look at me " +e.Target);
                if (e.Target.equals(t)) {
                    occurrences++;
                }
                if (occurrences > mostOccurences) {
                    mostCommon = t;
                }
            }
        }
        return mostCommon;
    }

    void recurseOnSplit(Branches b,int maxDepth, int depth) {
        /*Get left and right splits*/
        ArrayList<Entry> left = b.getLeft();
        ArrayList<Entry> right = b.getRight();

        //If left or right are empty make it a leaf node
        
        //for some reason this is getting back a null from leaf method
        if (left.isEmpty()) {
            System.out.println("Left guess: " + createClassifierLeaf(left)+ " at depth " + depth);
            return;
        }
        if (right.isEmpty()) {
                        System.out.println("Right guess: " + createClassifierLeaf(right)+ " at depth " + depth);
            return;
        }

        //check if at max depth. If so create a leaf node
        if (depth >= maxDepth) {
            System.out.println("CALSSIFSAIASDF");
            System.out.println(createClassifierLeaf(left));
            System.out.println(createClassifierLeaf(right));
            return;
        }
        //Breaks somehwere in here?
        //Must be to do with global arrayList
        Branches leftBranches = splitTree(left);
        recurseOnSplit(leftBranches,maxDepth, depth + 1);
//
        Branches rightBranches = splitTree(right);
        recurseOnSplit(rightBranches,maxDepth, depth + 1);
    }

    /**
     * Build the tree //
     */
//    Tree buildTree(ArrayList<Double> data) {
//
//        Tree bt = t.buildTree(data);
//        return bt;
//
//    }
    void setTrainingData(String file, String delim) {
        ImportData data = new ImportData(file, delim);
        data.readCSV();
        this.features = data.getFeatures();
        this.targets = data.getTargets();
//        for (String a : targets) {
//            System.out.println(a);
//        }
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

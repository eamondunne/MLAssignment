package ct475.cart.algorithm;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cormac Buckley, Eamon Dunne
 */

 /*
  * Data Structure, agreed upon by both
  */
public class Branches {
    private ArrayList<Entry> left = new ArrayList<Entry>();
    private ArrayList<Entry> right = new ArrayList<Entry>();
    
    public Branches(ArrayList<Entry> leftSplit, ArrayList<Entry> rightSplit){
        left = leftSplit;
        right = rightSplit;
    }
    public Branches(){}
    
    ArrayList<Entry> getLeft(){
        return left;
    }
     ArrayList<Entry> getRight(){
        return right;
    }
    void setBranches(ArrayList<Entry> left, ArrayList<Entry> right){
        this.left = left;
        this.right = right;
    }
}

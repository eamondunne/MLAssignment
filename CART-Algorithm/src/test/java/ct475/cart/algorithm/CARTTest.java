/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cormac Buckley
 */
public class CARTTest {
    
    public CARTTest() {
    }
    /**
     * Test of getSplitCost method, of class CART.
     */
    @Test
    public void testGetSplitCost() {
        System.out.println("getSplitCost");
        CART instance = new CART();
        ArrayList<ArrayList<Double>> leftSplit = new ArrayList();
        ArrayList<ArrayList<Double>> rightSplit = new ArrayList();
        ArrayList<Integer> targets = new ArrayList();
        double gini;
        
        ArrayList<Double> attribsLeft = new ArrayList();
        ArrayList<Double> attribsRight = new ArrayList();
        
        attribsLeft.add(3.03);
        attribsLeft.add(7.02);
        attribsLeft.add(1.00);
        leftSplit.add(attribsLeft);
        targets.add(0);
        targets.add(1);

        attribsRight.add(2.03);
        attribsRight.add(1.02);
        attribsRight.add(0.00);
        leftSplit.add(attribsRight);
        
        
        gini = instance.getSplitCost(leftSplit, rightSplit, targets);
        System.out.println(gini);
    }
//
//    /**
//     * Test of testSplits method, of class CART.
//     */
//    @Test
//    public void testTestSplits() {
//        System.out.println("testSplits");
//        CART instance = new CART();
//        instance.testSplits();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of splitTree method, of class CART.
//     */
//    @Test
//    public void testSplitTree() {
//        System.out.println("splitTree");
//        CART instance = new CART();
//        //instance.setData(); 
//        instance.splitTree(instance.features);
//        // TODO review the generated test code and remove the default call to fail.
//    }

    /**
     * Test of buildTree method, of class CART.
     */
//    @Test
//    public void testBuildTree() {
//        System.out.println("Build Tree of Doubles");
//        CART instance = new CART();
//        ArrayList<Double> bt = new ArrayList<Double>();
//        bt.add(10.0);
//        bt.add(2.5);
//        bt.add(7.0);
//        bt.add(13.0);
//        bt.add(1.0);
//        bt.add(3.0);
//        bt.add(new Double(4));
//        
//        
//       Tree t = instance.buildTree(bt);
//        // TODO review the generated test code and remove the default call to fail.
//        for(int i = 0; i <= bt.size(); i++){
//        instance.printTree(t.root, i);
//        }
//    }
//
//    /**
//     * Test of setData method, of class CART.
//     */
//    @Test
//    public void testSetData() {
//        System.out.println("Importing data");
//        CART instance = new CART();
//        instance.setData();        
//    }
//
//    /**
//     * Test of printTree method, of class CART.
//     */
//    @Test
//    public void testPrintTree() {
//        System.out.println("printTree");
//        CART instance = new CART();
//        instance.printTree();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

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
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of getSplitCost method, of class CART.
     */
//    @Test
//    public void testGetSplitCost() {
//        System.out.println("getSplitCost");
//        CART instance = new CART();
//        instance.getSplitCost();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
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
//        instance.splitTree();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of buildTree method, of class CART.
     */
    @Test
    public void testBuildTree() {
        System.out.println("buildTree");
        CART instance = new CART();
       BinaryTree bt = instance.buildTree();
        // TODO review the generated test code and remove the default call to fail.
        
        System.out.println(instance.printTree(bt.root));
    }
//
//    /**
//     * Test of setData method, of class CART.
//     */
//    @Test
//    public void testSetData() {
//        System.out.println("setData");
//        CART instance = new CART();
//        instance.setData();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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
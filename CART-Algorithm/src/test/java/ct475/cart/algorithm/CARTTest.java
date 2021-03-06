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
 * @author Cormac Buckley, Eamon Dunne
 */
public class CARTTest {
    
    public CARTTest() {}
 
    /**
     * Test of splitTree method, of class CART.
     * Implemented and modified by both throughout development
     */
    @Test
    public void testSplitTree() {
     //   System.out.println("splitTree");
        String file = "owls.csv";
        String delim = ",";
        CART instance = new CART();

        instance.setTrainingData(file, delim); 
        Branches root = instance.splitTree(instance.features);
        instance.recurseOnSplit(root,3,0);
        

    }

    
}

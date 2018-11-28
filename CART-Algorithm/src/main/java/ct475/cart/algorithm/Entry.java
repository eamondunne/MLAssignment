/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

import java.util.ArrayList;

/**
 *
 * @author Cormac Buckley
 */
public class Entry {
    int Row = 0;
    public ArrayList<Double> ColumnData = new ArrayList<Double>();
    public String Target;
    
    public Entry(int Row, ArrayList<Double> Cols, String Target){
        this.Row = 0;
        this.ColumnData = Cols;
        this.Target = Target;
    }
}

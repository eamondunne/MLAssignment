/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct475.cart.algorithm;

/**
 *
 * @author Cormac Buckley
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

public class ImportData {

    String CSVFile;
    BufferedReader br = null;
    String line = "";
    String split;
    ArrayList<Entry> features = new ArrayList<Entry>();
    
    ArrayList<Integer> targets = new ArrayList<Integer>();
    ArrayList<String> targets_names = new ArrayList<String>();

    public ImportData(String file, String delim) {
        this.CSVFile = file;
        this.split = delim;
    }

    public void readCSV() {
        try {
            ArrayList<Double> index = new ArrayList<Double>();
                int x = 0;
                
            br = new BufferedReader(new FileReader(CSVFile));
            while ((line = br.readLine()) != null) {
                
                String[] owls = line.split(split);
                ArrayList<Double> tempFeatures = new ArrayList<Double>();
                for (int i = 0; i < owls.length - 1; i++) {
                   tempFeatures.add(Double.parseDouble(owls[i]));

                }
                
                features.add(new Entry(x, tempFeatures));
                
                
                for (int i = owls.length - 1; i < owls.length; i++) {
                    targets_names.add(owls[i]);
                    if (owls[i].startsWith("LongEaredOwl")) {
                        targets.add(0);
                    } else if (owls[i].startsWith("SnowyOwl")) {
                        targets.add(1);
                    } else if (owls[i].startsWith("BarnOwl")) {
                        targets.add(2);
                    }

                }
//                  System.out.print(features.get(x).ColumnData);
//                  System.out.print(" [" + targets.get(x)  + "] ");
//                  System.out.print(targets_names.get(x));
//                  System.out.println();
x++;
            }
         


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Entry> getFeatures(){
        return features;
    }
      public ArrayList getTargets(){
        return targets;
    }
      public ArrayList getTarget_Names(){
        return targets_names;
    }
      
          public void printFeatures(){
        System.out.println(features);
    }
      public void printTargets(){
        System.out.println(targets);
    }
      public void printTarget_Names(){
        System.out.println(targets_names);
    }
}

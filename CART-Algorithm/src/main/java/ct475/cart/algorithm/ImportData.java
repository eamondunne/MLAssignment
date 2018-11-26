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
    ArrayList<ArrayList<Double>> features = new ArrayList<ArrayList<Double>>();
    ArrayList<Integer> targets = new ArrayList<Integer>();
    ArrayList<String> targets_names = new ArrayList<String>();

    public ImportData(String file, String delim) {
        this.CSVFile = file;
        this.split = delim;
    }

    public void readCSV() {
        try {
int x = 0;
            br = new BufferedReader(new FileReader(CSVFile));
            while ((line = br.readLine()) != null) {
                String[] owls = line.split(split);

                for (int i = 0; i < owls.length - 1; i++) {
                    features.get(x).add(Double.parseDouble(owls[i]));

                }

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
x++;
            }
//            System.out.println(features);
//            System.out.println(targets);
//            System.out.println(targets_names);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList getFeatures(){
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
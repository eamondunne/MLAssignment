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
import java.util.ArrayList;

public class ImportData {

    String CSVFile;
    BufferedReader br = null;
    String line = "";
    String split;
    ArrayList<String> features = new ArrayList<String>();
    ArrayList<Integer> targets = new ArrayList<Integer>();
    ArrayList<String> targets_names = new ArrayList<String>();

    public ImportData(String file, String delim) {
        this.CSVFile = file;
        this.split = delim;
    }

    public void readCSV() {
        try {

            br = new BufferedReader(new FileReader(CSVFile));
            while ((line = br.readLine()) != null) {
                String[] owls = line.split(split);

                for (int i = 0; i < owls.length - 1; i++) {
                    features.add(owls[i]);

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

            }
            System.out.println(features);
            System.out.println(targets);
            System.out.println(targets_names);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

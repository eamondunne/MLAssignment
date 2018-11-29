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
    ArrayList<String> targets = new ArrayList<String>();

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

                String[] data = line.split(split);
                String target;
                ArrayList<Double> tempFeatures = new ArrayList<Double>();
                for (int i = 0; i < data.length - 1; i++) {
                    tempFeatures.add(Double.parseDouble(data[i]));

                }
                target = data[data.length - 1];

                features.add(new Entry(x, tempFeatures, target));
                if (!targets.contains(target)) {
                    targets.add(target);
                }
                x++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Entry> getFeatures() {
        return features;
    }

    public ArrayList getTargets() {
        return targets;
    }


    public void printFeatures() {
        System.out.println(features);
    }

    public void printTargets() {
        System.out.println(targets);
    }

}

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


public class ImportData {
    
    String CSVFile;
    BufferedReader br = null;
    String line = "";
    String split;

    
    public ImportData(String file, String delim){
        this.CSVFile = file;
        this.split = delim;
    }
    
    public void readCSV(){
        int counter = 0;
        try{
            br = new BufferedReader(new FileReader(CSVFile));
            while ((line = br.readLine()) != null) {
                String[] owls = line.split(split);
                
                for(int i = 0; i < owls.length; i++){
                    System.out.print(owls[i] + " | ");
                }
                System.out.println();
                counter++;
            }
            System.out.println("Number of samples: " + counter);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

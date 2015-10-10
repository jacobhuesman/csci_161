/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Client class to test functionality of TokenCheck.
 * @author Jacob Huesman
 */
public class Hom01Client {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{  
        FilePath filePath = new FilePath();
        Scanner scan;
        ArrayList<TokenCheck> tokenArray = new ArrayList<>();
        File file;
        
        /**
         * Step 1:
         * Read in a list of String-delimiter pairs from a text file.
         */
        
        //Makes an empty thread that causes the the main client to wait until the thread finishes executing. The thread finishes executing when the user either selects a file or closes the window.
        Thread thread = new Thread(new Runnable(){
        public void run(){try {while(true){Thread.sleep(1000);}} catch (InterruptedException e){}}});
        thread.start();
        
         //Runs an instance of GetFile. GetFile is a GUI that prompts the user for a file to import data from.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GetFile(filePath, thread).setVisible(true);
            }
        });

        //The client will wait for the user to select a file before continuing.
        thread.join();

        //Checks if the user provided a file. Triggered if user exits the application without importing a file.
        if(!filePath.getIsFilePath()){
            System.out.println("User failed to provide a valid file.");
            return;
        } 
        
        //Creates a new File object based on the path collected earlier and passes it to the Scanner constructor. 
        try {
            file = new File(filePath.getFilePath());
            scan = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("Couldn't find the file!");
            return;
        } catch (NullPointerException e){
            System.out.println("Couldn't find the file!");
            return;
        }
        
        //Scan in the String-delimiter pairs, construct a TokenCheck object from the pair, and store the object in an array.
        try {
            while(scan.hasNextLine()){
                String first = scan.nextLine();
                if(scan.hasNextLine()){
                    tokenArray.add(new TokenCheck(first, scan.nextLine()));
                } else {
                    System.out.println("Invalid input file. Please check formatting.");
                    return;
                }
                
            }
        }
            catch (PatternSyntaxException e){
                System.out.println("Unsupported character used as a delimiter");
        }
        
        /**
         * Step 2:
         * Manually creates two additional instances of the TokenCheck class. One instance demonstrates the default constructor and the set methods. The other demonstrates the overloaded constructor.
         */
        
        //Default constructor and set method
        tokenArray.add((new TokenCheck()));
        tokenArray.get(tokenArray.size()-1).setDataAndDelimiter("6.7:8.3:9.4:4", ":");
        
        //Overloaded Constructor
        tokenArray.add(new TokenCheck("a, 6, 5, f5, 6, 5", ","));

        /**
         * Step 3:
         * This step is implemented in the SortTokenCheck class. The class is static and sorts the array passed to it.
         * Note: For ease of implementation the class sorts the actual object passed to it and does not return anything.
         */
        SortTokenCheck.sort(tokenArray);
        
        /**
         * Step 4:
         * Print out the contents of the sorted ArrayList using the toString method.
         */
        System.out.format("\nSorted ArrayList: \n");
        for(TokenCheck token: tokenArray){
            System.out.print(token.toString());
        }
        
        
        /**
         * Step 5:
         * Write the contents of the sorted ArrayList as objects to a file named home01objects.
         * The file will be stored in the same folder the original file of data and delimiters was pulled from.
         */
        try {
            //First file.
            FileOutputStream fos = new FileOutputStream(file.toPath().getParent().resolve("home01objects").toFile(), false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for(TokenCheck token: tokenArray){
                oos.writeObject(token);
            }
            oos.close();
         
            //Second file.
            fos = new FileOutputStream(file.toPath().getParent().resolve("home01.txt").toFile(), false);
            PrintWriter pw = new PrintWriter(fos);   
            
            for(TokenCheck token: tokenArray){
                pw.println(token.getData());
                pw.println(token.getDelimiter());
                pw.println(token.getType());
            }
            pw.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't find file.");
        } catch (IOException ex) {
            System.out.println("Couldn't write to file.");
        }
        
    }
    
}

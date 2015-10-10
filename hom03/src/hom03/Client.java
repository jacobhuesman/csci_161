/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom03;

import GFile.*;
import java.io.File;
import java.util.Scanner;

/**
 * Client program that tests to see if given files read the same top to bottom as they do bottom to top
 * @author Jacob Huesman
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Declare and initialize objects and variables */
        Scanner scan = new Scanner(System.in);
        Scanner file;
        String[] files;
        LinkedStack<String> stack = new LinkedStack<>();  
        
        try {
            do {
                /**
                * Allow the user to specify the name (and location) of one or more input file(s)
                */
               System.out.println("Please enter your files...");  
               files = GFile.getFiles();
               System.out.println("List of files selected:");
               for (String file1 : files) {
                   System.out.println(file1);
               }

               /**
                * Process each input file in the order in which they were entered by the user.
                */
               for (String filePath : files) {
                   /* Create a new scanner object to scan lines from */
                   file = new Scanner(new File(filePath));

                   /* Tell user current file */
                   System.out.println("\nCurrent file: " + filePath);

                   /* Prime the while loop */
                   boolean cont = true, reads = false;
                   String line;

                   /**
                    * This while loop will loop through the file adding each line to a stack until two lines in a row match, at which point a nested loop takes over.
                    */
                   while(cont) {
                       if(file.hasNextLine()){
                           line = file.nextLine();

                           /* Stop execution if "end" is encountered */
                           if(line.trim().equalsIgnoreCase("end")){
                               break;
                           } 
                           /* Empty lines are ignored logically. However they are printed to retain proper formatting. */
                           else if(line.trim().equals("")){
                               System.out.println(line);
                               continue;
                           }
                           /* Print out line being added to the stack */
                           System.out.println(line);

                           /* This decision structure adds lines to the stack until two lines match up. */
                           if(stack.first() == null){
                               stack.push(line);
                           } else if(StringOps.equalsIgnoreCaseAndPunctuation(stack.first(), line)){
                               stack.pop();
                               /* Loop through the rest of the file comparing to the entries in the stack. If they all match up then the file reads the same forward and back. */
                               while(cont){
                                   line = file.nextLine();
                                   if(line.trim().equals("")){
                                       System.out.println(line);
                                   } else if(file.hasNextLine() && StringOps.equalsIgnoreCaseAndPunctuation(line, stack.pop())){
                                       System.out.println(line);
                                   } else if(line.equalsIgnoreCase("end")){
                                       reads = true;
                                       cont = false;
                                       break;
                                   } else {
                                       System.out.println(line);
                                       while(file.hasNextLine()){
                                           line = file.nextLine();
                                           if(!line.trim().equalsIgnoreCase("end")){
                                               System.out.println(line);
                                           }
                                       }
                                       break;
                                   }
                               }
                           } else {
                               stack.push(line);
                           }
                       } else {
                           break;
                       }
                   }
                   /* Display this message if the file reads the same forward and back */
                   if( reads ){
                       System.out.println("\nThe passage reads the same top to bottom (or bottom to top).");
                   } else {
                       System.out.println("\nThe passage did not read the same from the top to bottom.");
                   }
               } 

               /* Ask the user if they would like to process more files. */
                System.out.print("\nWould you like to process additional files? (yes/no): ");
                String response = scan.nextLine();
                if(!response.trim().equalsIgnoreCase("yes")){
                    System.out.println("");
                    break;
                }        
            } while(true);  
            System.out.println("");
        } catch (Exception e) {
            System.out.println(e);
        }
    }  
}

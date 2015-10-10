/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab02;

import java.util.Random;

/**
 *Used to demonstrate Scores class.
 * @author jacob.huesman
 */
public class TestScores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        
        //Create an Object of Type Scores using the overloaded constructor and pass the value 100.
        Scores scores = new Scores(100);
        
        //Use a for loop to populate to populate the list in Scores object with random numbers between 
        for(int i=0; i<100; i++){
            scores.add(rand.nextInt(1000)+1);
        }
        
        //Run a for loop to print the contents of the list array in the Scores object.
        for(int i=0; i<scores.getCurrentSize(); i++){
            System.out.println(scores.get(i));
        }
        
        //Call the add( ) method to add the number 606 to the Bag
        scores.add(606);
        
        //Print the current size of the list in the Scores object.
        scores.getCurrentSize();
        
        //Call the remove( ) method to randomly remove a number from the Bag
        scores.remove();
        
        //Get the number at the 75th index position
        //Call the appropriate overloaded remove () method to remove the first occurrence of number retrieved in the earlier step from the Bag
        scores.remove(scores.get(75));
        
        //Run a for loop to print the contents of the list array in the Scores object.
        for(int i=0; i<scores.getCurrentSize(); i++){
            System.out.println(scores.get(i));
        }
        
        //Print the frequency of the number 100
        System.out.println(scores.getFrequencyOf(100));
        
        //Check whether the list array in Scores object contains the number 606.
        //Assuming you want this printed?
        System.out.println(scores.contains(606));
    }
    
}

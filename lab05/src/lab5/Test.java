/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.Random;

/**
 * Test class for analyzing the time taken in milliseconds for carrying out selected operations of the ArrayBag and LinkedBag classes.
 * @author Jacob Huesman
 */
public class Test {
    public static void main(String[] args){
        //1. Create an ArrayBag object named teamArray using the default constructor to store Player objects
        ArrayBag<Player> teamArray = new ArrayBag<>();
        
        //2. Create a LinkedBag object named teamLinkedList to store Player ojbects
        LinkedBag<Player> teamLinkedList = new LinkedBag<>();
        
        //3. Create a long type of variable  named start and set it's value to System.currentMilliseconds()
        long start = System.currentTimeMillis();
        
        //4. Populate the ArrayBag with 1000 Player objects
        Random random = new Random();
        for(int i=0; i<1000000; i++){
            teamArray.add(new Player("John","guard",random.nextInt()));
        }
        
        //5. Create a long type of variable named end and set it's value to System.currentMilliseconds()
        long end = System.currentTimeMillis();
        
        //6. Calculate elapsed time using the difference between start and end
        long elapsed = end - start;
        
        //7. Print the elapsed time for teamArray using verbose output
        System.out.println("The time it took to add 1,000,000 Player entries to teamArray is: " + elapsed);
        
        //8. Reuse the start variable and set it's value to System.currentMilliseconds()
        start = System.currentTimeMillis();
        
        //9. Populate the LinkedBag with 1000 Player objects
        for(int i=0; i<1000000; i++){
            teamLinkedList.add(new Player("John","guard",random.nextInt()));
        }
        
        //10. Reuse the end variable and set it's value to System.currentMilliseconds()
        end = System.currentTimeMillis();
        
        //11. Calculate elapsed time using the difference between start and end
        elapsed = end - start;
        
        //12. Print the elapsed time for teamLinkedList using verbose output
        System.out.println("The time it took to add 1,000,000 Player entries to teamLinkedList is: " + elapsed);
        
        //13. Print the count of teamArray and teamLinkedList on the output window
        System.out.println("The teamArray count is: " + teamArray.getCurrentSize());
        System.out.println("The teamLinkedList count is: " + teamArray.getCurrentSize());
        
        //14. Reuse the start variable and set it's value to System.currentMilliseconds()
        start = System.currentTimeMillis();
        
        //15. Retrieve the Player object in the index position 0 of teamArray
        Player retrieved = teamArray.get(0);
        
        //16. Remove the Player object retrieved in the earlier step
        teamArray.remove(retrieved);
        
        //17. Reuse the end variable and set it's value to System.currentMilliseconds()
        end = System.currentTimeMillis();
    
        //18. Calculate elapsed time using the difference between start and end
        elapsed = end - start;
        
        //19. Print the elapsed time for teamArray using verbose output
        System.out.println("The time it took to remove 1 Player entry from index 0 in teamArray is: " + elapsed);
        
        //20. Repeat steps 14 to 19 for teamLinkedList
        //Start time
        start = System.currentTimeMillis();

        //Retrieve Player
        retrieved = teamLinkedList.getItem(0);

        //Remove Player
        teamLinkedList.remove(retrieved);
        
        //End time
        end = System.currentTimeMillis();
    
        //Calculate elapsed time using the difference between start and end
        elapsed = end - start;
        
        //Print the elapsed time for teamArray using verbose output
        System.out.println("The time it took to remove 1 Player entry from index 0 in teamLinkedList is: " + elapsed); 
    }
}

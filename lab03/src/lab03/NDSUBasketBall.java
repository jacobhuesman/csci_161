/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab03;

import java.util.Scanner;

/**
 * The NDSU-BasketBall class tests the functionality of the Bag, ArrayBag and Player classes/interfaces. 
 * @author jacob.huesman
 */
public class NDSUBasketBall {

    //Doesn't need a public constructor.
    private NDSUBasketBall(){}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner object for input.
        Scanner scan = new Scanner(System.in);
        
        //Array Bag to hold the Player objects.
        ArrayBag<Player> team = new ArrayBag<>();
        
        //Prompt user to enter each Player's information.
        System.out.println("Please enter team info one player at a time: ");
        for(int i=0; i<team.capacity(); i++){
            //Temp information holders.
            String[] info = new String[2];
            int jersey = 0;
            
            //Prompt user for info.
            System.out.print("Please enter the player's name: ");
            info[0] = scan.nextLine();
            
            System.out.print("Please enter the player's position: ");
            info[1] = scan.nextLine();
            
            System.out.print("Please enter the player's jersey number: ");
            while(!scan.hasNextInt()){ //Ensure input is an integer.
                scan.nextLine();
                System.out.print("Please enter an integer: ");
            }
            jersey = scan.nextInt();
            
            //Clears buffer
            scan.nextLine();
            
            //Add Player to team with collected info.
            team.add(new Player(info[0], info[1], jersey));
            System.out.println("Added " + info[0] + " to the team.");
            
            //Break loop if all Players have been added.
            System.out.print("Do you have additional players to enter? (y/n): ");
            if(!scan.nextLine().equalsIgnoreCase("y")){break;};
        }
        System.out.println("All players added.");
        System.out.println("");
        
        //Remove a random Player from the Team.
        if(!team.isEmpty()){
            System.out.println("Randomly removing the following Player: " + team.remove().getName());
        } else {
            System.out.println("No players to remove!");
        }
        
        //Add a player with made up information.
        Player madeUp = new Player("Jake Huesman", "Running back", 1);
        team.add(madeUp);
        System.out.println("Added the following player to the team: " + team.get(team.getCurrentSize()-1).getName());
        
        //Display the current count of players in the team.
        System.out.println("The current count of players on the team is: " + team.getCurrentSize());
        
        //Remove Player added earlier with made up info.
        System.out.println("Removing the following player from the team: " + madeUp.getName());
        team.remove(madeUp);
        
        //Display the current count of players in the team again.
        System.out.println("The current count of players on the team is: " + team.getCurrentSize());
        
        //Use a for loop to print the information of the Players in the team.
        System.out.println("The current Players on the team are: ");
        for(int i=0; i<team.getCurrentSize(); i++){
            System.out.format("%-2s%30s%30s", (i+1) + ") Name: " + team.get(i).getName(), "| Postion: " + team.get(i).getPosition(), "| Jersey Number: " + team.get(i).getJerseyNumber() + "\n");
        }
        
        //Create an object of ArrayBag called courses to store the course ids of the courses taken this semester as Strings.
        ArrayBag<String> courses = new ArrayBag<>(4);
        
        //Populate the bag with the course ids.
        System.out.println("\nPopulating courses with course ids.");
        courses.add("Math 265");
        courses.add("ECE 111");
        courses.add("CSci 161");
        courses.add("Math 129");
        
        //Remove a random course id from the bag.
        System.out.println("Randomly removing " + courses.remove() + " from the courses");
    
        //Print the course ids from the bag.
        System.out.println("Course ids in bag:");
        for(int i=0; i<courses.getCurrentSize(); i++){
            System.out.println((i+1) + ") " + courses.get(i));
        }
    }    
}

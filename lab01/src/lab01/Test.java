/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab01;

import java.util.ArrayList;

/**
 *
 * @author jacob.huesman
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        //Creates an ArrayList to store players in a "Basketball Team.
        ArrayList<Player> basketballTeam = new ArrayList<>(13);
        
        //Populates the team with NDSU men's basketball players.
        basketballTeam.add(new Player("Brian Ishola", "G/F", true, 0));
        basketballTeam.add(new Player("Paul Miller", "G", false, 2));
        basketballTeam.add(new Player("Jake Showalter", "G", true, 3));
        basketballTeam.add(new Player("Zach Checkal", "G", false, 4));
        basketballTeam.add(new Player("Lawrence Alexander", "G", false, 12));
        basketballTeam.add(new Player("Carlin Dupree", "G", true, 13));
        basketballTeam.add(new Player("A.J. Jacobson", "G/F", false, 21));
        basketballTeam.add(new Player("Kory Brown", "G", true, 22));
        basketballTeam.add(new Player("Trey Miller", "F", false, 24));
        basketballTeam.add(new Player("Spencer Eliason", "F", true, 30));
        basketballTeam.add(new Player("Evan Wesenberg", "F", false, 32));
        basketballTeam.add(new Player("Chris Kading", "F", true, 34));
        basketballTeam.add(new Player("Dexter Werner", "F", false, 40));
        basketballTeam.add(new Player("Matt Kourouma", "G/F", false, 44));
        
        //Loops through the Basketball Team, printing player information.
        for(Player player : basketballTeam){
            System.out.println("Name: " + player.getName() + ", Position: " + player.getPosition() + ", Starter: " + player.getStarter() + ", Jersey Number: " + player.getJerseyNumber());
        }
    }
}

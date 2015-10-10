/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab5;

/**
 * Simple representation of a basketball player.
 * @author jacob.huesman
 */
public class Player {
    /**
     * Declare instance variables.
     */
    private String name, position;
    private int jerseyNumber;
    
    /**
     * Construct a new Player instance.
     * @param name          the name of the Player (e.g. "John Doe")
     * @param position      the position played (e.g. "F")
     * @param jerseyNumber  the jersey number of the player? (e.g. 1)
     */
    public Player(String name, String position, int jerseyNumber){
        this.name = name;
        this.position = position;
        this.jerseyNumber = jerseyNumber;
    }
    
    /**
     * Returns the name of the player.
     * @return name - current name of the player
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns position of the player.
     * @return position - current position of the player
     */
    public String getPosition(){
        return position;
    }
    
    /**
     * Returns the jersey number of the player.
     * @return jerseyNumber - current jersey number
     */
    public int getJerseyNumber(){
        return jerseyNumber;
    }
    
    /**
     * Changes the name of the player.
     * @param name the new player name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Changes the position of the player.
     * @param position the new position
     */
    public void setPosition(String position){
        this.position = position;
    }
    
    /**
     * Changes the jerseyNumber of the player.
     * @param jerseyNumber the new jersey number
     */
    public void setJerseyNumber(int jerseyNumber){
        this.jerseyNumber = jerseyNumber;
    }
    
    /**
     * Checks to see if the two Player objects are equal.
     * @param player2 The Player object to compare.
     * @return true - if they are equal; false - otherwise
     */
    public boolean equals(Player player2){
        return !(this.getJerseyNumber() != player2.getJerseyNumber() || (this.getName() == null ? player2.getName() != null : !this.getName().equals(player2.getName())) || (this.getPosition() == null ? player2.getPosition() != null : !this.getPosition().equals(player2.getPosition())));
    }
}


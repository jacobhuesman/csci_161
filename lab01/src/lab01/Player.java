/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab01;

/**
 *A simple representation of a basketball player.
 * 
 * @author jacob.huesman
 */
public class Player {
    /**
     * Declares instance variables.
     */
    private String name, position;
    private boolean starter;
    private int jerseyNumber;
    
    /**
     * Constructs a new Player instance.
     * @param name          the name of the Player (e.g. "John Doe")
     * @param position      the position played (e.g. "F")
     * @param starter       is the the player a starter? (e.g. true)
     * @param jerseyNumber  the jersey number of the player? (e.g. 1)
     */
    public Player(String name, String position, boolean starter, int jerseyNumber){
        this.name = name;
        this.position = position;
        this.starter = starter;
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
     * Returns if the player is a starter.
     * @return true if player is a starter; false if otherwise.
     */
    public boolean getStarter(){
        return starter;
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
     * Changes if the player is a starter.
     * @param starter true if the player is a starter; false otherwise
     */
    public void setStarter(boolean starter){
        this.starter = starter;
    }
    
    /**
     * Changes the jerseyNumber of the player.
     * @param jerseyNumber the new jersey number
     */
    public void setJerseyNumber(int jerseyNumber){
        this.jerseyNumber = jerseyNumber;
    }
}

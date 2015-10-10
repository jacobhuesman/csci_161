/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09_jacob_huesman;

/**
 * Key class designed to satisfy the requirements of the lab09 assignment.
 * @author Jacob Huesman
 */
public class Key implements Comparable {
    private final int key;
    
    /**
     * Constructor for a key object
     * @param key desired key value
     */
    public Key(int key){
        this.key = key;
    }
    
    /**
     * Accessor for the key object value
     * @return integer key
     */
    public int getKey(){
        return key;
    }
    
    public String toString(){
        return String.valueOf(key);
    }

    @Override
    public int compareTo(Object o) {
        return key - ((Key) o).getKey();
    }
}

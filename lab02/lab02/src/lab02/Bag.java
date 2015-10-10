/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab02;

/**
 *A simple interface that can store a certain number of whole numbers in it.
 * 
 * @author jacob.huesman
 */
public interface Bag {
    
    
    /**
     * Returns a count of numbers in the bag.
     * @return A count of numbers in bag.
     */
    public int getCurrentSize();
    
    /**
     * Checks if the bag is empty.
     * @return true - if empty; false - otherwise
     */
    public boolean isEmpty();
    
    /**
     * Adds a new number num to the bag.
     * @param num Number to be added to bag.
     */
    public void add(int num);
    
    /**
     * Removes the first occurrence of the number num from the bag.
     * @param n Number to be removed.
     */
    public void remove(int n);
    
    /**
     * Removes randomly a number from the bag.
     */
    public void remove();
    
    /**
     * Creates a new list with the same array size as the old list.
     */
    public void clear();
    
    /**
     * Counts the number of times the number num exists in the bag.
     * @param num The number to check for.
     * @return Number of times that integer occurs in bag.
     */
    public int getFrequencyOf(int num);
    
    /**
     * Tests whether the bag contains the number num.
     * @param num The number to check for.
     * @return true - if bag contains num;  false - otherwise
     */
    public boolean contains(int num);
}

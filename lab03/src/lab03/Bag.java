/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab03;

/**
 * A generic Bag interface.
 * @author jacob.huesman
 */
public interface Bag<T> {
    /**
     * Returns a count of the items in the bag.
     * @return A count of items in bag.
     */
    public int getCurrentSize();
    
    /**
     * Checks if the bag is empty.
     * @return true - if empty; false - otherwise
     */
    public boolean isEmpty();
    
    /**
     * Checks if the bag is full.
     * @return true - if full; false - otherwise
     */
    public boolean isFull();
    
    /**
     * Adds a new item to the bag.
     * @param item Item to be added to bag.
     * @return true - if the item was added successfully; false - otherwise
     */
    public boolean add(T item);
    
    /**
     * Removes randomly an item from the bag as long as the bag is not empty.
     * @return The item removed from bag.
     */
    public T remove();
    
    /**
     * Removes the first occurrence of the item from the bag.
     * @param item Item to be removed.
     * @return true - if item was successfully removed; false - if the item isn't in the bag
     */
    public boolean remove(T item);
    
    /**
     * Creates an empty bag and replaces the old one.
     */
    public void clear();
    
    /**
     * Counts the number of times the item exists in the bag.
     * @param item The item to check for.
     * @return Number of times that item occurs in the bag.
     */
    public int getFrequencyOf(T item);
    
    /**
     * Tests whether the bag contains the item.
     * @param item The item to check for.
     * @return true - if bag contains item;  false - otherwise
     */
    public boolean contains(T item);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.Random;

/**
 * Generic class that implements the generic Bag interface. 
 * @author Jacob Huesman
 * @param <T> bag type
 */
public class ArrayBag<T> implements Bag<T> {

    private T[] bag;
    private int count;
    
    /**
     * Default constructor initiates bag to a capacity of 50.
     */
    public ArrayBag(){
        bag = (T[]) new Object[10];
    }
    
    /**
     * Overloaded constructor initiates bag to capacity specified.
     * @param size Initial capacity of the bag.
     */
    public ArrayBag(int size){
        bag = (T[]) new Object[size];
    }
    
    /**
     * Returns a count of the items in the bag.
     * @return A count of items in bag.
     */
    @Override
    public int getCurrentSize() {
        return count;
    }

    /**
     * Checks if the bag is empty.
     * @return true - if empty; false - otherwise
     */
    @Override
    public boolean isEmpty() {
        return count <= 0;
    }

    /**
     * Checks if the bag is full.
     * @return true - if full; false - otherwise
     */
    @Override
    public boolean isFull() {
        return count >= bag.length;
    }

    /**
     * Adds a new item to the bag.
     * @param item Item to be added to bag.
     * @return true - if the item was added successfully; false - otherwise
     */
    @Override
    public boolean add(T item) {
        try{
            if(bag.length <= count){
                T[] temp = (T[]) new Object[bag.length*2];
                for(int i=0; i<bag.length; i++){
                    temp[i] = bag[i];
                }
                bag = temp;
                bag[count++] = item;
            } else {
                bag[count++] = item;
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }

    /**
     * Removes the first occurrence of the item from the bag.
     * @param item Item to be removed.
     * @return true - if item was successfully removed; false - if the item isn't in the bag
     */
    @Override
    public boolean remove(T item) {
        int loop = 0;
        for(int i=0; i<count; i++){
            if(bag[i].equals(item)){
                for(int a=i; a<count; a++){
                    if(bag.length == (a+1)){
                        bag[a] = null;
                    } else {
                        bag[a] = bag[a+1];
                    }
                }
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes randomly an item from the bag as long as the bag is not empty.
     * @return The item removed from bag.
     */
    @Override
    public T remove() {
        Random rand = new Random();
        if(count > 0){
            int i = rand.nextInt(count);
            T item = bag[i];
            for(int a=i; a<count; a++){
                if(bag.length == (a+1)){
                    bag[a] = null;
                } else {
                    bag[a] = bag[a+1];
                }
            }
            count--;
            return item;
        }
        return null;
    }

    /**
     * Creates an empty bag and replaces the old one.
     */
    @Override
    public void clear() {
        bag = (T[]) new Object[50];
    }

    /**
     * Counts the number of times the item exists in the bag.
     * @param item The item to check for.
     * @return Number of times that item occurs in the bag.
     */
    @Override
    public int getFrequencyOf(T item) {
        int freq = 0;
        for(int i=0; i<count; i++){
            if(bag[i].equals(item)){
                freq++;
            }
        }
        return freq;
    }

    /**
     * Tests whether the bag contains the item.
     * @param item The item to check for.
     * @return true - if bag contains item;  false - otherwise
     */
    @Override
    public boolean contains(T item) {
        return this.getFrequencyOf(item) > 0;
    }
    
    /**
     * Finds the item at index i and returns it.
     * @param i Index of the item desired.
     * @return The item desired.
     * @throws ArrayIndexOutOfBoundsException Throws if index specified is out of bounds. 
     */
    public T get(int i) throws ArrayIndexOutOfBoundsException {
        if(i >= bag.length){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return bag[i];
        }
    }
    
    /**
     * Returns the current capacity of the bag.
     * @return The capacity of the bag.
     */
    public int capacity(){
        return bag.length;
    }
    
    /**
     * Returns a copy of the bag array instance variable.
     * @param bag Bag array instance variable to be copied.
     * @return A copy of the bag array instance variable.
     */
    public ArrayBag copy(ArrayBag bag){
        ArrayBag temp = new ArrayBag(bag.getCurrentSize());
        for(int i=0; i<temp.getCurrentSize(); i++){
            temp.add(bag.get(i));
        }
        return temp;
    }
    
}

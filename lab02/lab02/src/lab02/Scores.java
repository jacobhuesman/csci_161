/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab02;

import java.util.Random;

/**
 *Implements bag interface, storing scores.
 * 
 * @author jacob.huesman
 */
public class Scores implements Bag {

    private int[] list;
    private int count;
    
    /**
     * Initializes a "Scores" list of size 50.
     */
    public Scores(){
        list = new int[50];
        count = 0;
    }
      
    /**
     * Initializes a "Scores" list of a given size.
     * @param listSize Size desired for list.
     */
    public Scores(int listSize){
        list = new int[listSize];
        count = 0;
    }
    
    /**
     * Returns a count of numbers in the bag.
     * @return A count of numbers in bag.
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
        if(count <= 0){
            return true;
        }
        return false;
    }

    /**
     * Adds a new number num to the bag.
     * @param num Number to be added to bag.
     */
    @Override
    public void add(int num) {
        if(list.length <= count){
            int[] temp = new int[list.length*2];
            for(int i=0; i<list.length; i++){
                temp[i] = list[i];
            }
            list = temp;
            temp = null;
            list[count++] = num;
        } else {
            list[count++] = num;
        }
    }

    /**
     * Removes the first occurrence of the number num from the bag.
     * @param n Number to be removed.
     */
    @Override
    public void remove(int n) {
        for(int i=0; i<count; i++){
            if(list[i] == n){
                for(int a=i; a<count; a++){
                    if(list.length == (a+1)){
                        list[a] = 0;
                    } else {
                        list[a] = list[a+1];
                    }
                }
                count--;
                return;
            }
        }
    }

    /**
     * Removes randomly a number from the bag.
     */
    @Override
    public void remove() {
        Random rand = new Random();
        for(int a=rand.nextInt(count); a<count; a++){
            if(list.length == (a+1)){
                list[a] = 0;
            } else {
                list[a] = list[a+1];
            }
        }
        count--;
        return;
    }

    /**
     * Creates a new list with the same array size as the old list.
     */
    @Override
    public void clear() {
        list = new int[list.length];
    }

    /**
     * Counts the number of times the number num exists in the bag.
     * @param num The number to check for.
     * @return Number of times that integer occurs in bag.
     */
    @Override
    public int getFrequencyOf(int num) {
        int freq = 0;
        for(int i=0; i<count; i++){
            if(list[i] == num){
                freq++;
            }
        }
        return freq;
    }

    /**
     * Tests whether the bag contains the number num.
     * @param num The number to check for.
     * @return true - if bag contains num;  false - otherwise
     */
    @Override
    public boolean contains(int num) {
        if(this.getFrequencyOf(num) > 0){
            return true;
        }
        return false;
    }
    
    /**
     * Returns a number at the ith index position in the list.
     * @param i The index position desired.
     * @return The number contained in the ith position of the list.
     * @throws ArrayIndexOutOfBoundsException If index given is out of bounds.
     */
    public int get(int i) throws ArrayIndexOutOfBoundsException {
        if(i >= list.length){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return list[i];
        }
    }
    
}

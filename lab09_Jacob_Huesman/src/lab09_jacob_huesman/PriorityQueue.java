/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09_jacob_huesman;

/**
 * PriorityQueue Interface ADT based on the the one presented in Data Structures and Algorithms by Goodrich, Tamassia, & Goldwasser. 
 * @author Jacob Huesman
 * @param <K>
 * @param <V>
 */
public interface PriorityQueue<K,V> {
    /**
     * Returns the size of the priority queue.
     * @return size of queue
     */
    int size();
    
    /**
     * Returns if the priority queue is empty.
     * @return true - if empty; false - otherwise
     */
    boolean isEmpty();
    
    /**
     * Inserts a key-value pair and returns the entry created.
     * @param key the key of the new entry
     * @param value the associated value of the new entry
     * @return the entry storing the new key-value pair
     * @throws IllegalArgumentException if the key is unacceptable for this queue 
     */
    Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
    
    /**
     * Returns without removing an entry with the minimal key.
     * @return entry having the minimal key (or null if empty)
     */
    Entry<K,V> min();
    
    /**
     * Removes and returns an entry with the minimal key.
     * @return the removed entry (or null if empty)
     */
    Entry<K,V> removeMin();
}

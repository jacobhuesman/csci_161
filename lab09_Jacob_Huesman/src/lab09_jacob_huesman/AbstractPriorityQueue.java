/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09_jacob_huesman;

import java.util.Comparator;

/**
 * Abstract base class for a PriorityQueue that is based off of the class of the same name presented in Data Structures & Algorithms by Goodrich, Tamassia, & Goldwasser
 * @author Jacob Huesman
 * @param <K>
 * @param <V>
 */
public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {
    /* Priority Queue Entry Class (PQEntry) */
    protected static class PQEntry<K,V> implements Entry<K,V> {
        private K k;
        private V v;
        
        /**
         * Constructor
         * @param key desired key
         * @param value desired value
         */
        public PQEntry(K key, V value){
            k = key;
            v = value;
        }

        /**
        * Returns the key stored in this entry object.
        * @return the entry's key
        */
        @Override
        public K getKey() {
            return k;
        }

        /**
        * Returns the value stored in this entry object.
        * @return the entry's value
        */
        @Override
        public V getValue() {
            return v;
        }
        
        /**
         * Set the key.
         * @param key desired key
         */
        protected void setKey(K key){
            k = key;
        }
        
        /**
         * Set the value.
         * @param value desired value
         */
        protected void setValue(V value){
            v = value;
        }
        
    }
    /* End of Priority Queue Entry class */
    
    /**
     * Defines the ordering of keys 
     */
    private Comparator<K> comp;
    
    /**
     * Creates an empty priority queue using the given comparator to order keys.
     * @param c comparator defining the order of keys in the priority queue
     */
    protected AbstractPriorityQueue(Comparator<K> c){
        comp = c;
    }

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    protected AbstractPriorityQueue(){
        this(new DefaultComparator<>());
    }
    
    /**
     * Method that compares two entries according to their key values
     * @param a Entry 1
     * @param b Entry 2
     * @return the result of the comparison
     */
    protected int compare(Entry<K,V> a, Entry<K,V> b){
        return comp.compare(a.getKey(), b.getKey());
    }
    
    /**
     * Determines if this given key is valid
     * @param key key to be checked
     * @return true - if valid; false - otherwise
     * @throws IllegalArgumentException -  
     */
    protected boolean checkKey(K key) throws IllegalArgumentException{
        try {
            return (comp.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatable key");
        }
    }
    
    /**
     * Tests whether the priority queue is empty.
     * @return true - if the priority queue is empty, false - otherwise
     */
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }
}

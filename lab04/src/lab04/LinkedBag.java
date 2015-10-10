/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04;

/**
 * Generic Singularly Linked List implementation of the generic interface Bag.
 * @author Jacob
 */
public class LinkedBag<T> implements Bag<T> {
    /**
     * The objects of this class form the nodes of the singly linked list.
     * @param <T> Type of the object the node will hold.
     */
    private static class Node<T> {
        private T element;
        private Node<T> next;
        public Node(T e, Node<T> n){
            element = e;
            next = n;
        }
        public T getElement(){ return element; }
        public Node<T> getNext() { return next; }
        public void setNext( Node<T> n ){ next = n; }
    }
    
    private Node<T> bagHead;
    private Node<T> bagTail;
    int count;
    
    public LinkedBag(){
        bagHead = null;
        bagTail = null;
        count = 0;
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
        if(count <= 0){
            return true;
        }
        return false;
    }

    /**
     * The bag will never be full.
     * @return false - always
     */
    @Override
    public boolean isFull() {
        return false;
    }

    /**
     * Adds an element to the beginning of the list.
     * @param item The item the node will point to.
     * @return true - When the operation is successful.
     */
    @Override
    public boolean add(T item) {
       bagHead = new Node(item, bagHead);
       count++;
       return true;
    }

    /**
     * Removes and returns the first node in the list.
     * @return The element, or null if the list is empty.
     */
    @Override
    public T remove() {
        if(bagHead == null){
            return null;
        }
        T element = bagHead.getElement();
        bagHead = bagHead.getNext();
        count--;
        return element;
    }
       
    /**
     * Removes a given item and returns true or false according to the success of the operation.
     * @param item Item to check the list for.
     * @return true - if item was found and removed; false - otherwise
     */
    @Override
    public boolean remove(T item) {
        //Priming
        Node<T> previous;
        Node<T> current;
        if(bagHead != null && bagHead.getElement().equals(item)){
            bagHead = bagHead.getNext();
            count--;
            return true;
        }
        if(bagHead != null && bagHead.next != null){
            previous = bagHead;
            current = bagHead.next;
        } else {
            return false;
        }
        //Loop through SLL, looking for item.
        while(current.next != null){
            if(current.getElement().equals(item)){
                previous.setNext(current.getNext());
                current.setNext(null);
                count--;
                return true;
            }
            previous = current;
            current = previous.getNext();
        }
        //Return false if the item was not found.
        return false;
    }
    
    /**
     * Clears the current bag.
     */
    @Override
    public void clear() {
        bagHead = null;
        bagTail = null;
        count = 0;
    }

    /**
     * Checks for the frequency of a particular item.
     * @param item Item to check the frequency of.
     * @return Amount of times the object occurs in the list.
     */
    @Override
    public int getFrequencyOf(T item) {
        //primer
        Node<T> previous;
        Node<T> current;
        int freq = 0;
        if(bagHead != null && bagHead.getElement().equals(item)){
            freq++;
        }
        if(bagHead != null && bagHead.next != null){
            previous = bagHead;
            current = bagHead.next;
        } else {
            return freq;
        }
        //Loop through SLL and count the frequency of the item.
        do {
            if(current.getElement().equals(item)){
                previous.setNext(current.getNext());
                current = current.getNext();
                freq++;
            }
            previous = current;
            current = previous.getNext();
        } while(current.next != null);
        //Return false if the item was not found.
        return freq;
    }

    /**
     * Checks to see if the LinkedBag contains the item.
     * @param item Item to check for.
     * @return true - if the bag contains the item; false - otherwise
     */
    @Override
    public boolean contains(T item) {
        //primer
        Node<T> previous;
        Node<T> current;
        if(bagHead != null && bagHead.getElement().equals(item)){
            return true;
        }
        if(bagHead != null && bagHead.next != null){
            previous = bagHead;
            current = bagHead.next;
        } else {
            return false;
        }
        //Loop through SLL and count the frequency of the item.
        do {
            if(current.getElement().equals(item)){
                return true;
            }
            previous = current;
            current = previous.getNext();
        } while(current.next != null);
        //Return false if the item was not found.
        return false;
    }
    
    /**
     * Returns an item at a specific index position in the bag.
     * @param i Index to grab item from.
     * @return Item collected form specified index.
     */
    public T getItem(int i){
        //primer
        Node<T> current;
        int step = 0;
        if (bagHead!= null && step == i){
            return bagHead.getElement();
        } else if(bagHead != null && bagHead.getNext() != null){
            current = bagHead;
        } else {
            return null;
        }
        //Loop through SLL until the specified index is hit.
        do {
            step++;
            if(step == i){
                return current.getElement();
            }
            current = current.getNext();
        } while(current.next != null);
        return null;
    }
    
    /**
     * Returns an array containing the copy of the items in the list.
     * @return Array of items.
     */
    public T[] toArray(){
        T[] array = (T[]) new Object[count];
        Node<T> current = bagHead;
        
        for(int i=0; i<count; i++){
            array[i] = current.getElement();
            current = current.getNext();
        }
        return array;
    }
}

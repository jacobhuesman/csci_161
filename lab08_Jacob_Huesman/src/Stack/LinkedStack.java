/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 * SLL implementation of the stack data structure.
 * @author Jacob Huesman
 * @param <T> Type of objects to be contained in the stack
 */
public class LinkedStack <T> {
    /**
     * The objects of this class form the nodes of the singly linked list.
     * @param <T> Type of the object the node will hold
     */
    private static class Node<T> {
        private final T element;
        private Node<T> next;
        public Node(T e, Node<T> n){
            element = e;
            next = n;
        }
        public T getElement(){ return element; }
        public Node<T> getNext() { return next; }
        public void setNext( Node<T> n ){ next = n; }
    }
    
    private Node<T> stackHead;
    int count;
    
    /**
     * Default constructor.
     */
    public LinkedStack(){
        stackHead = null;
        count = 0;
    }
    
    /**
     * Returns a count of the items in the stack.
     * @return A count of items in stack
     */
    public int getCurrentSize() {
        return count;
    }

    /**
     * Checks if the stack is empty.
     * @return true - if empty; false - otherwise
     */
    public boolean isEmpty() {
        return count <= 0;
    }

    /**
     * Adds an element to the beginning of the list.
     * @param item The item the node will point to
     * @return true - when the operation is successful
     */
    public boolean push(T item) {
       stackHead = new Node(item, stackHead);
       count++;
       return true;
    }

    /**
     * Removes and returns the first node in the list.
     * @return The element, or null if the list is empty
     */
    public T pop() {
        if(stackHead == null){
            return null;
        }
        T element = stackHead.getElement();
        stackHead = stackHead.getNext();
        count--;
        return element;
    }
    
    /**
     * Clears the stack.
     */
    public void clear() {
        stackHead = null;
        count = 0;
    }
    
    /**
     * Returns the first item in the stack.
     * @return First item in the stack
     */
    public T first(){
        if (stackHead!= null){
            return stackHead.getElement();
        } 
        return null;
    }
}

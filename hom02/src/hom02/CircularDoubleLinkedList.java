/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom02;

/**
 * Circular version of double linked list discussed in Chapter 2.
 * @author Jacob Huesman
 */
public class CircularDoubleLinkedList<E> implements Cloneable {
    //-----------nested Node class ------------------
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement(){ return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    //----------end of nested Node class-------------
    
    //instance variables of the CircularDoubleLinkedList
    private Node<E> trailer;
    private int size;
    
    /**
     * Constructs a new empty list.
     */
    public CircularDoubleLinkedList(){
        trailer = null;
        size = 0;
    }
    
    /**
     * Returns the number of elements in the linked list.
     * @return int
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns if the List is empty.
     * @return true - if empty, false - otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Returns the current first element in the list.
     * @return E
     */
    public E first() {
        if(isEmpty()) {
            return null;
        }
        return trailer.getNext().getElement();
    }
    
    /**
     * Returns the current last element in the list.
     * @return E
     */
    public E last() {
        if(isEmpty()) {
            return null;
        }
        return trailer.getElement();
    }
    
    //public update methods
    /**
     * Adds element e to the front of the list.
     * @param e element to be added
     */
    public void addFirst(E e) {
        if(isEmpty()) {
            trailer = new Node<E>(e,null,null);
            trailer.setNext(trailer);
            trailer.setPrev(trailer);
        } else {
            addBetween(e, trailer, trailer.getNext());
        }
        size++;
    }
    
    /**
     * Adds element e to the end of the list.
     * @param e element to be added
     */
    public void addLast(E e) {
        addFirst(e);
        trailer = trailer.getNext();
    }
    
    /**
     * Removes and returns the first element of the list.
     * @return first element
     */
    public E removeFirst() {
        if(isEmpty()) {
            return null;
        }
        return remove(trailer.getNext());
    }
    
    /**
     * Removes and returns the last element of the list.
     * @return last element
     */
    public E removeLast() {
        if(isEmpty()) {
            return null;
        }
        trailer = trailer.getPrev();
        return remove(trailer.getNext());
    }
    
    /**
     * Rotate list forwards one
     */
    public void rotate() {
        trailer = trailer.getNext();
    }
    
    /**
     * Rotates list backwards one
     */
    public void rotateBackward() {
        trailer = trailer.getPrev();
    }
    
    /**
     * Implements shallow cloning
     * @return shallow clone of the object
     * @throws CloneNotSupportedException 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    /**
     * Checks to see if the elements of the list passed as an argument match the elements of the current list.
     * @param list2 list to check against
     * @return true - if they are equal; false otherwise
     */
    public boolean equals(CircularDoubleLinkedList list2) {
        if(this.size() != list2.size()) {
            return false;
        } else {
            try {
                //Don't want to mess up current order of list2.
                CircularDoubleLinkedList list = (CircularDoubleLinkedList) list2.clone();
                Node<E> current = trailer;
                for(int i=0; i<size; i++) {
                    //Check to see if current element corresponds to the current last element of list.
                    //If yes continue checking the rest of the elements.
                    //If no proceed to the element after current.
                    if(current.getElement().equals(list.last())){ 
                        Node<E> current2 = current;
                        for(int a=0; a<size; a++){
                            list.rotate();
                            current2 = current2.getNext();
                            if(!current2.getElement().equals(list.last())){
                                list = (CircularDoubleLinkedList) list2.clone();
                                break;
                            } else if(a == size-1) {
                                return true;
                            }
                        }
                    }
                    current = current.getNext();
                }
                return false;
            } catch(CloneNotSupportedException e){
                return false;
            }
            
        }
    }
    
    //private update methods
    /**
     * Adds element e to the linked list in between the given nodes.
     * @param e element to be added
     * @param predecessor previous node
     * @param successor next node
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
    }
    
    /**
     * Removes the given node from the list and returns its element.
     * @param node node to be removed
     * @return node that was removed
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}

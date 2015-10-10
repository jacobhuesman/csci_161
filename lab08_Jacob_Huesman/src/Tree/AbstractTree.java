/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Iterator;

/**
 * AbstractTree class outlined in Data Structures & Algorithms by Michael T Goodrich, Roberto Tamassia, and Michael H Goldwasser.
 * @author Jacob Huesman
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {
    /**
     * Returns if the node is Internal
     * @param p the position of the node
     * @return true - if the node is internal; false - otherwise
     * @throws IllegalArgumentException 
     */
    @Override
    public boolean isInternal(Position<E> p){
        return numChildren(p) > 0;
    }
    
    /**
     * Returns if the node is External 
     * @param p the position of the node
     * @return true - if the node is external; false - otherwise
     * @throws IllegalArgumentException 
     */
    @Override
    public boolean isExternal(Position<E> p){
        return numChildren(p) == 0;
    }
    
    /**
     * Returns if the node is the root of the tree
     * @param p the position of the node
     * @return true - if the node is the root; false - otherwise
     * @throws IllegalArgumentException 
     */
    @Override
    public boolean isRoot(Position<E> p){
        return p == root();
    }
    
    /**
     * Returns if the tree is empty
     * @return true - if the tree is empty; false - otherwise
     */
    @Override
    public boolean isEmpty(){
        return size() == 0;
    }
    
    /**
     * Returns the number of levels separating Position p from the root
     * @param p A valid Position within the tree 
     * @return the number of levels separating Position p from the root
     */
    public int depth(Position<E> p){
        if(isRoot(p)){
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }
    
    /**
     * Returns the height of the subtree rooted at Position p
     * @param p A valid Position within the tree
     * @return the height of the subtree rooted at Position p
     */
    public int height(Position<E> p){
        int h = 0;
        for(Position<E> c : children(p)){
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }
    
    /* ElementIterator class */
    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();
        @Override
        public boolean hasNext(){
            return posIterator.hasNext();
        }
        @Override
        public E next(){
            return posIterator.next().getElement();
        }
        @Override
        public void remove(){
            posIterator.remove();
        }
    }
    
    /**
     * Returns an iterator for the tree
     * @return Iterator
     */
    @Override
    public Iterator<E> iterator(){
        return new ElementIterator();
    }
}

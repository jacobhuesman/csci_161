package Tree;

import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Tree class outlined in Data Structures & Algorithms by Michael T Goodrich, Roberto Tamassia, and Michael H Goldwasser.
 * @author Jacob Huesman
 * @param <E>
 */
public interface Tree<E> extends Iterable<E> {
    /**
     * Returns position of the root node
     * @return  Position of root node
     */
    Position<E> root();
    
    /**
     * Returns the position of the node's parent
     * @param p position object of the node
     * @return position object of the parent to the node
     * @throws IllegalArgumentException
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns an iterator containing the positions of the children of the node
     * @param p the node
     * @return iterator containing positions of the node's children
     * @throws IllegalArgumentException 
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns the number of children of a given node
     * @param p the node
     * @return number of children of the node
     * @throws IllegalArgumentException 
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns if the node is Internal
     * @param p the position of the node
     * @return true - if the node is internal; false - otherwise
     * @throws IllegalArgumentException 
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns if the node is External 
     * @param p the position of the node
     * @return true - if the node is external; false - otherwise
     * @throws IllegalArgumentException 
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns if the node is the root of the tree
     * @param p the position of the node
     * @return true - if the node is the root; false - otherwise
     * @throws IllegalArgumentException 
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns the size of the tree
     * @return size of the tree
     */
    int size();
    
    /**
     * Returns if the tree is empty
     * @return true - if the tree is empty; false - otherwise
     */
    boolean isEmpty();
    
    /**
     * Returns an iterator of the elements stored in the tree
     * @return iterator of tree's elements
     */
    @Override
    Iterator<E> iterator();
    
    /**
     * Returns an iterable collection of the positions of the tree
     * @return iterable collection of the tree's positions
     */
    Iterable<Position<E>> positions();
}

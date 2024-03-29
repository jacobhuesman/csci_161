/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 * Binary tree class outlined in Data Structures & Algorithms by Michael T Goodrich, Roberto Tamassia, and Michael H Goldwasser.
 * @author Jacob Huesman
 */
public interface BinaryTree<E> extends Tree<E> {
    /**
     * Returns the positions left child (or null if no child exists)
     * @param p A position within the tree
     * @return the Positions of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns the Position of p's right child (or null if no child exists)
     * @param p A position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns the Position of p's sibling (or null if no sibling exists)
     * @param p A valid Position within the tree
     * @return the Position of the sibling (or null if no sibling exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}

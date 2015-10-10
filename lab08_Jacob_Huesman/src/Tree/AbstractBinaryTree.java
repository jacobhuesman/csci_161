/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractBinaryTree class outlined in Data Structures & Algorithms by Michael T Goodrich, Roberto Tamassia, and Michael H Goldwasser.
 * @author Jacob Huesman
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
/**
     * Returns the Position of p's sibling (or null if no sibling exists)
     * @param p A valid Position within the tree
     * @return the Position of the sibling (or null if no sibling exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if(parent == null){
            return null;
        } else if(parent == left(parent)){
            return right(parent);
        } else {
            return left(parent);
        }
    }
    
    /**
     * Returns the number of children of a given node
     * @param p the node
     * @return number of children of the node
     * @throws IllegalArgumentException 
     */
    @Override
    public int numChildren(Position<E> p){
        int count = 0;
        if(left(p) != null){
            count++;
        }
        if(right(p) != null){
            count++;
        }
        return count;
    }
    
    /**
     * Returns an iterator containing the positions of the children of the node
     * @param p the node
     * @return iterator containing positions of the node's children
     * @throws IllegalArgumentException 
     */
    @Override
    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p) != null){
            snapshot.add(left(p));
        }
        if(right(p) != null){
            snapshot.add(right(p));
        }
        return snapshot;
    }
    
    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot using an inorder traversal
     * @param p Position at the root of a subtree
     * @param snapshot list where the results are added
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){
        if(left(p) != null){
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if(right(p) != null){
            inorderSubtree(right(p), snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions of the tree in order.
     * @return iterable collection of the tree's positions
     */
    public Iterable<Position<E>> inorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()){
            inorderSubtree(root(), snapshot);   // fill the snapshot recursively
        }
        return snapshot;
    }

    /**
     * Returns an iterable collection of the positions of the tree using inorder traversal
     * @return iterable collection of the tree's positions
     */
    @Override
    public Iterable<Position<E>> positions(){
        return inorder();
    }
    
    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     * @param p Position at the root of the subtree
     * @param snapshot List of the positions
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for(Position<E> c : children(p)){
            preorderSubtree(c, snapshot);
        }
    }
    
    /**
     * Returns an iterable collection of positions of the tree, reported in preorder
     * @return iterable collection of positions of the tree
     */
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            preorderSubtree(root(), snapshot);
        }
        return snapshot;
    }
    
    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot
     * @param p Position at the root of the subtree
     * @param snapshot List of the positions
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c : children(p)){
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p);
    }
    
    /**
     * Returns an iterable collection of positions of the tree, reported in postOrder
     * @return iterable collection of positions of the tree
     */
    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            postorderSubtree(root(), snapshot);
        }
        return snapshot;
    }
    
    /**
     * Recursively prints the positions of a tree in preOrder.
     * @param <E> Type of tree
     * @param T The tree to be printed in preOrder
     * @param p The starting position in the tree
     * @param d The current depth
     */
    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d){
        System.out.println(spaces(2*d) + p.getElement());
        for(Position<E> c : T.children(p)){
            printPreorderIndent(T, c, d+1);
        }
    }
    
    /**
     * Recursively prints the positions of a tree in postOrder.
     * @param <E> Type of tree
     * @param T The tree to be printed in preOrder
     * @param p The starting position in the tree
     * @param d The current depth
     */
    public static <E> void printPostorderIndent(Tree<E> T, Position<E> p, int d){
        for(Position<E> c : T.children(p)){
            printPostorderIndent(T, c, d+1);
        }
        System.out.println(spaces(2*d) + p.getElement());
    }
    
    /**
     * Recursively prints the positions of a tree in inOrder.
     * @param p The starting position in the tree
     * @param d The current depth
     */
    public void printInorderIndentSubtree(Position<E> p, int d){
        if(left(p) != null){
            printInorderIndentSubtree(left(p), (d+1));
        }
        System.out.println(spaces(2*d) + p.getElement());
        if(right(p) != null){
            printInorderIndentSubtree(right(p), (d+1));
        }
    }
    
    /**
     * Simple function to return a string of a desired number of spaces
     * @param n Desired number of spaces
     * @return String of the desired number of spaces
     */
    private static String spaces(int n){
        char[] spaces = new char[n];
        StringBuilder space = new StringBuilder();
        
        for(int i=0; i<spaces.length; i++){
            spaces[i] = ' ';
        }
        space.append(spaces);
        
        return space.toString();
    }
}

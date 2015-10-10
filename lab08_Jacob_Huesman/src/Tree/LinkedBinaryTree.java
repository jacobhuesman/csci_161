/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author Jacob Huesman
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    
    /* Nested Node Class */
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild){
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        
        // accessor methods
        @Override
        public E getElement(){ return element; }
        public Node<E> getParent(){ return parent; }
        public Node<E> getLeft(){ return left; }
        public Node<E> getRight(){ return right; }
        
        // update methods
        public void setElement(E e){ element = e; }
        public void setParent(Node<E> parentNode){ parent = parentNode; }
        public void setLeft(Node<E> leftChild){ left = leftChild; }
        public void setRight(Node<E> rightChild){ right = rightChild; }
    }
    /* End of Nested Node Class */
    
    /**
     * Factory function to create a new node storing element e
     * @param e element e to be stored by node
     * @param parent parent node
     * @param left left child node
     * @param right right child node
     * @return new node for storing element e
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right){
        return new Node<>(e, parent, left, right);
    }
    
    //LinkedBinaryTree instance variables
    protected Node<E> root = null;
    private int size = 0;
    
    /**
     * Default constructor that constructs an empty binary tree
     */
    public LinkedBinaryTree(){}
    
    /**
     * Non-public utility that validates that the position is an instance of the nested Node class and returns it as a node
     * @param p position to validate
     * @return p casted as a node
     * @throws IllegalArgumentException if p is not an instance of Node or is no longer in the tree 
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if(!(p instanceof Node)){
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node){
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }
    
    
    /* Accessor Methods
    /**
     * Returns the size of the tree
     * @return size of tree
     */
    @Override
    public int size(){
        return size;
    }
    
    /**
     * Returns the root Position of the tree (or null if tree is empty)
     * @return root Position of the tree
     */
    @Override
    public Position<E> root(){
        return root;
    }
    
    /**
     * Returns the position of the node's parent
     * @param p position object of the node
     * @return position object of the parent to the node
     * @throws IllegalArgumentException
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    
    /**
     * Returns the positions left child (or null if no child exists)
     * @param p A position within the tree
     * @return the Positions of the left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    
    /**
     * Returns the Position of p's right child (or null if no child exists)
     * @param p A position within the tree
     * @return the Position of the right child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }
    
    /* Update methods supported by this class */
    /**
     * Places element e at the root of an empty tree and returns its new Position
     * @param e element
     * @return Position of the root of the tree containing element e
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if(!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }
    
    /**
     * Creates a new left child of Position p storing element e
     * @param p Position p in the tree
     * @param e element to be stored
     * @return Position of the left child of Position p
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if(parent.getLeft() != null){
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }
    
    /**
     * Creates a new right child of Position p storing element e
     * @param p Position p in the tree
     * @param e element to be stored
     * @return Position of the right child of Position p
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null){
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }
    
    /**
     * Replaces the element at Position p with e and returns the replaced element
     * @param p Position p to replace element at
     * @param e element to place in p
     * @return the Position of the element was stored in
     * @throws IllegalArgumentException 
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }
    
    /**
     * Attaches trees t1 and t2 as left and right subtrees of external p
     * @param p a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException  
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if(isInternal(p)){
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if(!t1.isEmpty()){
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if(!t2.isEmpty()){
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }
    
    /**
     * Removes the node at Position p and replaces it with its child, if any.
     * @param p Node to be removed
     * @return the Element held in Position p
     * @throws IllegalArgumentException if p has two children
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2){
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null){
            child.setParent(node.getParent());
        }
        if (node == root){
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()){
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(null);
        return temp;
    }
}

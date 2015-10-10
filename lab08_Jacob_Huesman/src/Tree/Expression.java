/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Tree.LinkedBinaryTree.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Takes a List of String tokens and creates a binary expression tree from them
 * @author Jacob Huesman
 */
public class Expression {
    /**
     * Using a combination of looping and recursion this method takes a List of String tokens and creates a binary expression tree from them
     * @param tokens A List of Strings that represent an arithmetic expression
     * @return A LinkedBinaryTree representation of the expression
     * @throws Exception If the expression is invalid or unbalanced
     */
    public static LinkedBinaryTree<String> makeTree(List<String> tokens) throws Exception{
        ArrayList<Node<String>> nodes = new ArrayList<>();
        /* Recursively evaluate functions in parentheses */
        for(int i=0; i<tokens.size(); i++){
            if(tokens.get(i).contains("(")){
                int parentheses = 0;
                for(int j=i+1; j<tokens.size(); j++){
                    if((tokens.get(j).equals(")")) && (parentheses == 0)){
                        nodes.add(makeTree(tokens.subList(i+1, j)).root);
                        i=j;
                        break;
                    } else if(tokens.get(j).equals("(")){
                        parentheses++;
                    } else if(tokens.get(j).equals(")")){
                        parentheses--;
                    }
                }
            } else {
                nodes.add(new Node<>(tokens.get(i), null, null, null));
            }
        }
        /* Check for *,x,/ operators */
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).getLeft() == null && nodes.get(i).getRight() == null && (nodes.get(i).getElement().equals("*") || nodes.get(i).getElement().equals("x") || nodes.get(i).getElement().equals("/"))){
                Node<String> root = nodes.get(i);
                root.setLeft(nodes.get(i-1));
                root.setRight(nodes.get(i+1));
                nodes.remove(i-1);
                nodes.remove(i);
                i--;
            }
        }
        /* Check for +, - operators */
        for(int i=0; i<nodes.size(); i++){
            if(nodes.get(i).getLeft() == null && nodes.get(i).getRight() == null && (nodes.get(i).getElement().equals("+") || nodes.get(i).getElement().equals("-"))){
                Node<String> root = nodes.get(i);
                root.setLeft(nodes.get(i-1));
                root.setRight(nodes.get(i+1));
                nodes.remove(i-1);
                nodes.remove(i);
                i--;
            }
        }
        
        /* Their should only be one root node left after this process, if the expression is balanced */
        if(nodes.size()>1){
            throw new Exception("Expression is not valid");
        }
        
        /* Return the tree */
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        tree.root = nodes.get(0);
        return tree;
    }
    
    /**
     * Using a combination of looping and recursion this method creates a List of String tokens and creates a binary expression tree from them
     * @param expression The expression to be evaluated
     * @return A LinkedBinaryTree representation of the expression
     * @throws Exception If the expression is invalid or unbalanced
     */
    public static LinkedBinaryTree<String> makeTree(String expression) throws Exception{
        ArrayList<String> tokens = new ArrayList<>();
        String[] sTokens = expression.split(" ");
        for(int i=0; i<sTokens.length; i++){
            tokens.add(sTokens[i]);
        }
        return makeTree(tokens);
    }
}

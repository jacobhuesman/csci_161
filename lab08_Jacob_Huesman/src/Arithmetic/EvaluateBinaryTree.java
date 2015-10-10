/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arithmetic;

import Tree.Position;
import Tree.Tree;
import java.util.Iterator;

/**
 * Evaluates a binary expression tree
 * @author Jacob Huesman
 */
public class EvaluateBinaryTree {
    public static int evaluate(Tree<String> T, Position<String> p){
        if(isExpression(p.getElement())){
            Iterator children = T.children(p).iterator();
            Position<String> left = (Position) children.next();
            Position<String> right = (Position) children.next();
            
            switch(p.getElement().charAt(0)){
                case '*' :
                case 'x' :
                    return evaluate(T, left) * evaluate(T, right);
                case '/' :
                    return evaluate(T, left) / evaluate(T, right);
                case '+' :
                    return evaluate(T, left) + evaluate(T, right);
                case '-' :
                    return evaluate(T, left) - evaluate(T, right);
            }
        }
        return Integer.parseInt(p.getElement());
    }
    
    /**
     * Checks a String to see if it represents a simple Arithmetic expression
     * @param exp String to be evaluated
     * @return true - If exp is an expression; false - otherwise
     */
    private static boolean isExpression(String exp){
        String[] exps = {"*","x","+","-","/"};
        for(String tExp : exps){
            if(tExp.equals(exp)){
                return true;
            }
        }
        return false;
        
    }
}

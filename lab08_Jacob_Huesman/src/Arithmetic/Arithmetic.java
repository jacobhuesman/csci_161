/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arithmetic;

import GFile.*;
import Stack.LinkedStack;
import Tree.Expression;
import Tree.LinkedBinaryTree;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Client class that tests the functionality of the Tree package and EvaluateBinaryTree class
 * @author Jacob Huesman
 */
public class Arithmetic {
    
    
    public static void main(String args[]) throws Exception{
        /* Instance Variables */
        Scanner scan = new Scanner(System.in);
        Scanner file;
        String[] files;
        ArrayList<LinkedBinaryTree> trees = new ArrayList<>(); 
        LinkedStack<String> temp = new LinkedStack<>();

        /* Get files from user */
        try {
            System.out.println("Please enter your files...");  
            files = GFile.getFiles();
            System.out.println("List of files selected:");
            for (String file1 : files) {
                System.out.println(file1);
            }

            /* Loop through files */
            for (String filePath : files) {
                file = new Scanner(new File(filePath));
                String line;
                
                System.out.println("\nCurrent file: " + filePath);
                
                /* Process each line of the file as an expression */
                int exp = 1;
                while(file.hasNextLine()){
                    try {
                        line = file.nextLine();
                        System.out.println("\n" + exp + ") Current Expression: " + line);
                        LinkedBinaryTree tree = Expression.makeTree(line);   
                        printOrders(tree);
                    } catch (Exception e) {
                        System.out.println("Invalid expression");
                    }
                    exp++; 
                }
            }      
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * Print the tree in preorder, inorder and postorder notation. This method also prints the value of the evaluated expression.
     * @param tree Tree to be evaluated
     */
    private static void printOrders(LinkedBinaryTree tree){
        System.out.println("Preorder:");
        LinkedBinaryTree.printPreorderIndent(tree, tree.root(), 0);
        System.out.println("Inorder:");
        tree.printInorderIndentSubtree(tree.root(), 0);
        System.out.println("Postorder:");
        LinkedBinaryTree.printPostorderIndent(tree, tree.root(), 0);
        System.out.println("Value: " + EvaluateBinaryTree.evaluate(tree, tree.root()));
    }
}


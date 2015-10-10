/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom02;

import java.util.Random;

/**
 * Test class to demonstrate the various methods of the Circularly Linked List
 * @author Jacob Huesman
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularDoubleLinkedList<Integer> list = new CircularDoubleLinkedList<>();
        Random random = new Random();
        
        System.out.println("Creating a CircularDoubleLinkedList of 10 random integers between 10-50...");
        for(int i=0; i<10; i++){
            list.addLast(random.nextInt(40)+11);
        }
        
        //demonstrate size()
        System.out.println("Current size: " + list.size());
        
        //demonstrate isEmpty()
        System.out.println("Empty?: " + list.isEmpty());
        System.out.println("Creating an empty list...");
        CircularDoubleLinkedList<Integer> empty = new CircularDoubleLinkedList<>();
        System.out.println("Empty?: " + empty.isEmpty());
        
        System.out.println("Back to the original list...");
        //demonstrate first()
        System.out.println("The first element is: " + list.first());
        
        //demonstrate last()
        System.out.println("The last element is: " + list.last());
        
        //demonstrate addFirst()
        System.out.println("Adding the number 98 to the front of the list...");
        list.addFirst(98);
        System.out.println("The first element is: " + list.first());
        
        //demonstrate addLast()
        System.out.println("Addding the number 56 to the back of the list...");
        list.addLast(56);
        System.out.println("The last element is: " + list.last());
        
        //demonstrate removeFirst()
        System.out.println("Removing " + list.removeFirst() + " from the front of the list...");
        System.out.println("The new first element is: " + list.first());
        
        //demonstrate removeLast()
        System.out.println("Removing " + list.removeLast() + " from the back of the list...");
        System.out.println("The new last element is: " + list.last());
        
        //demonstrate rotate()
        System.out.println("After rotating once the first element should be the last element.");
        System.out.println("Current first element: " + list.first());
        System.out.println("Rotating...");
        list.rotate();
        System.out.println("New last element: " + list.last());
        
        //demonstrate rotateBackward()
        System.out.println("After rotating once backwards the last element should be the first element.");
        System.out.println("Current last element: " + list.last());
        System.out.println("Rotating backwards...");
        list.rotateBackward();
        System.out.println("New first element: " + list.first());
        
        //demonstrate clone()
        System.out.println("After a shallow clone the elements of the cloned list should point to the same elements of the original array.");
        try {
            CircularDoubleLinkedList copy = (CircularDoubleLinkedList<Integer>) list.clone();
            String[][] array = new String[list.size()+1][2];
            array[0][0] = "Original";
            array[0][1] = "Cloned";
            for(int i=1; i<list.size()+1; i++){
                array[i][0] = list.first().toString();
                list.rotate();
                array[i][1] = copy.first().toString();
                copy.rotate();
            }
            System.out.println(ConsoleTable.makeTable("Element Comparison", 50, array));
            
            //demonstrate equals()
            System.out.println("Using the equals method the original list should equal the cloned list.");
            if(list.equals(copy)){
                System.out.println("They are equal!");
            } else {
                System.out.println("They are not equal.");
            }
            System.out.println("");
            
            //demonstrate equals method on rotated copy
            System.out.println("Note: The equals method will work even when the lists are rotated.");
            copy.rotateBackward();
            array = new String[list.size()+1][2];
            array[0][0] = "Original";
            array[0][1] = "Cloned";
            for(int i=1; i<list.size()+1; i++){
                array[i][0] = list.first().toString();
                list.rotate();
                array[i][1] = copy.first().toString();
                copy.rotate();
            }
            System.out.println(ConsoleTable.makeTable("Element Comparison", 50, array));
            
            //demonstrate equals()
            copy.rotateBackward();
            System.out.println("Using the equals method the original array should equal the cloned array.");
            if(list.equals(copy)){
                System.out.println("They are equal!");
            } else {
                System.out.println("They are not equal.");
            }
            
        } catch (Exception e) {
            System.out.println("Clone operation failed!");
        }
    }
}

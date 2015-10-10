/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09_jacob_huesman;

/**
 * Client to test code functionality.
 * @author Jacob Huesman
 */
public class Client {
   public static void main(String[] args){
       Key[] keys = new Key[25];
       Value[] values = new Value[25];
       for(int i=0; i<25; i++){
           values[i] = new Value(i+1);
           keys[i] = new Key(values[i].getPriority());
       }
       
       HeapPriorityQueue queue = new HeapPriorityQueue(keys, values);
       
       System.out.println("Insert 25 Entries into the priority queue.");
       queue.printBreadthFirst();
       queue.printPrioritizedList();
       System.out.println("");       
       
       for(int i=0; i<10; i++){
           Value value = new Value(i+26);
           queue.insert(new Key(value.getPriority()), value);
       }
       
       System.out.println("Insert 10 additional Entries into the priority queue.");
       queue.printBreadthFirst();
       queue.printPrioritizedList();
   } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import DataStructures.LinkedQueue;
import Sort.*;
import java.util.Comparator;

/**
 * Client that will sort a sequence of items as specified in the part 1 of the assignment.
 * @author Jacob Huesman
 */
public class Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Create Arrays and Queues */
        String[][] seq = genSeq();
        LinkedQueue queue = new LinkedQueue();
        
        /* Generate Comparators */
        Compare1 comp1 = new Compare1();
        Compare2 comp2 = new Compare2();
        Compare3 comp3 = new Compare3();
        
        /* Add all of the Strings to a queue and print out current ordering */
        System.out.println("Initial Unsorted List:");
        for(int i=0; i<seq.length; i++){
            System.out.println(seq[i][0] + ", " + seq[i][1] + ", " + seq[i][2]);
            queue.enqueue(seq[i]);
        }
        
        /* Sort the first column using MergeSort */
        Sort.mergeSort(queue, comp1);
        

        /* Sort the second columns using quickSort */
        /* Break the sequence into groups to be sorted */
        LinkedQueue tempQueue1 = new LinkedQueue();
        LinkedQueue tempQueue2 = new LinkedQueue();
        LinkedQueue sortedQueue = new LinkedQueue();
        while(!queue.isEmpty()){
            String[] current = (String[]) queue.dequeue();          
            tempQueue1.enqueue(current);
            while(!queue.isEmpty() && current[0].equals(((String[])queue.first())[0])){
                current = (String[]) queue.dequeue();
                tempQueue1.enqueue(current);
            }
            Sort.quickSort(tempQueue1, comp2);
            
            /* Nested bubbleSort sorts the third columns */
            while(!tempQueue1.isEmpty()){
                String[] current2 = (String[]) tempQueue1.dequeue();          
                tempQueue2.enqueue(current2);
                while(!tempQueue1.isEmpty() && current2[1].equals(((String[])tempQueue1.first())[1])){
                    current2 = (String[]) tempQueue1.dequeue();
                    tempQueue2.enqueue(current2);
                }
                /* Convert Queue to an ArrayList */
                String[][] array = new String[tempQueue2.size()][];
                int i = 0;
                while(!tempQueue2.isEmpty()){
                    array[i] = (String[]) tempQueue2.dequeue();
                    i++;
                }
                
                /* Sort */
                Sort.bubbleSort(array, comp3);
                
                /* Covert back to an ArrayList */
                for(i=0; i<array.length; i++){
                    sortedQueue.enqueue(array[i]);
                }
                
                /* Add full sorted portion to sortedQueue */
                while(!tempQueue2.isEmpty()){
                    sortedQueue.enqueue(tempQueue2.dequeue());
                }
            }
            
        }
        queue = sortedQueue;
        
        /* Print out sorted list */
        System.out.println("\nSorted List:");
        for(int i=0; i<seq.length; i++){
            String[] str = (String[]) queue.dequeue();
            System.out.println(str[0] + ", " + str[1] + ", " + str[2]);
        }
        
    }
    
    /* Method was created to reduce clutter in the main method */
    private static String[][] genSeq(){
        String[][] seq = {{"Freshman","Computer-Science","Emily"},
                            {"Sophomore","MIS","John"},
                            {"Freshman","Math","Ayushi"},
                            {"Sophomore","MIS","Miranda"},
                            {"Freshman","Computer-Science","Jacob"},
                            {"Freshman","Electrical-Engineering","Jacob"},
                            {"Junior","Math","Loran"},
                            {"Junior","Computer-Science","Ryan"},
                            {"Freshman","Computer-Science","Amy"},
                            {"Masters","Psychology","Jack"},
                            {"Freshman","Math","Emily"},
                            {"Freshman","Computer-Science","Chengyao"},
                            {"PhD","Math","Loran"},
                            {"Masters","History","James"},
                            {"PhD","Computer-Science","Emily"},
                            {"Masters","Biology","James"},
        };
        return seq;
    }
    
    private static String[] year = {"Freshman", "Sophomore", "Junior", "Senior", "Masters", "PhD"};
    
    /* Simple Comparison Classes */
    private static class Compare1 implements Comparator<String[]> {
        @Override
        public int compare(String[] o1, String[] o2) {
            int j=0,k=0;
            for(int i=0; i<year.length; i++){
                if(year[i].equals(o1[0])){
                    j = i;
                } if (year[i].equals(o2[0])){
                    k = i;
                }
            }
            return j - k;
        }
    }
    private static class Compare2 implements Comparator<String[]> {
        @Override
        public int compare(String[] o1, String[] o2) {
            return o1[1].compareTo(o2[1]);
        }
    }
    private static class Compare3 implements Comparator<String[]> {
        @Override
        public int compare(String[] o1, String[] o2) {
            return o1[2].compareTo(o2[2]);
        }
    }
}

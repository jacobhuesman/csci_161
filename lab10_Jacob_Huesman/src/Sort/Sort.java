/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

import DataStructures.*;
import java.util.Comparator;

/**
 * A collection of sorting algorithms based off of algorithms presented in Data Structures & Algorithms by Goodrich, Tamassia and Goldwasser.
 * @author Jacob Huesman
 */
public class Sort {
    /**
     * Merge the contents of sorted queues S1 and S2 into an empty queue S
     * @param <K> Class of the object contained in the queues
     * @param S1 First queue
     * @param S2 Second queue
     * @param S Queue to have the queues S1 and S2 merged into
     * @param comp Comparator to use
     */
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp){
        while(!S1.isEmpty() && !S2.isEmpty()){
            if(comp.compare(S1.first(), S2.first()) < 0){
                S.enqueue(S1.dequeue());
            } else {
                S.enqueue(S2.dequeue());
            }
        }
        while(!S1.isEmpty()){
            S.enqueue(S1.dequeue());
        }
        while(!S2.isEmpty()){
            S.enqueue(S2.dequeue());
        }
    }
    
    /**
     * Sorts a Queue S using a recursive mergeSort technique
     * @param <K> Class of the objects contained in the Queue
     * @param S Queue to be sorted
     * @param comp Comparator to be used
     */
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp){
        int n = S.size();
        if(n < 2){
            return;
        }
        Queue<K> S1 = new LinkedQueue<>();
        Queue<K> S2 = new LinkedQueue<>();
        while(S1.size() < n/2){
            S1.enqueue(S.dequeue());
        }
        while(!S.isEmpty()){
            S2.enqueue(S.dequeue());
        }
        mergeSort(S1, comp);
        mergeSort(S2, comp);
        
        merge(S1, S2, S, comp);
    }
    
    /**
     * Sorts a Queue S using a recursive quickSort technique
     * @param <K> Class of the objects contained in the Queue
     * @param S Queue to be sorted
     * @param comp Comparator to be used
     */
    public static <K> void quickSort(Queue<K> S, Comparator<K> comp){
        int n = S.size();
        if(n < 2){
            return;
        }
        K pivot = S.first();
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        
        while(!S.isEmpty()){
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if(c < 0){
                L.enqueue(element);
            } else if(c == 0){
                E.enqueue(element);
            } else{
                G.enqueue(element);
            }
        }
        quickSort(L, comp);
        quickSort(G, comp);
        
        while(!L.isEmpty()){
            S.enqueue(L.dequeue());
        } 
        while(!E.isEmpty()){
            S.enqueue(E.dequeue());
        }
        while(!G.isEmpty()){
            S.enqueue(G.dequeue());
        }
    }
    
    /**
     * Sorts a generic array of objects using the bubbleSort technique
     * @param <K> Class of the objects contained in the Queue
     * @param S Array of objects to be sorted
     * @param comp Comparator to be used
     */
    public static <K> void bubbleSort(K[] S, Comparator<K> comp){
        int i, j;
        K temp;
        for(i = (S.length - 1); i >= 0; i--){
            for(j = 1; j <= i; j++){
                if(comp.compare(S[j-1], S[j]) > 0){
                    temp = S[j-1];
                    S[j-1] = S[j];
                    S[j] = temp;
                }
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom02;

import java.util.ArrayList;
import java.util.Random;

/**
 * Static class that implements and tests a simple bubble sort techniques.
 * @author Jacob Huesman
 */
public class SimpleBubbleSort {
    //Static Class
    private SimpleBubbleSort(){}
    
    /**
     * Creates an int array containing all the test data.
     * @return the int array
     */
    public static int[][] bubbleSortTest() {
        Random rand = new Random();
        int[][] stats = new int[20][2];
        for( int i=100, j=0; i<=1000000; i = i*10, j++ ){
            for( int k=0; k<3; k++){
                stats[j*4+k][0] = i;
                ArrayList<Integer> list = new ArrayList<>(i);
                for( int l=0; l<i; l++ ){
                    list.add(rand.nextInt());
                }
                long start = System.currentTimeMillis();
                sort(list);
                long end = System.currentTimeMillis();
                long dur = end - start;
                stats[j*4+k][1] = (int) dur;
                if( k==2 ){
                    stats[j*4+3][0] = i;
                    stats[j*4+3][1] = (( stats[j*4+2][1] + stats[j*4+1][1] + stats[j*4][1]) / 3);
                }
            }
        }
        return stats;
    }
    
    /**
     * Sorts an array list using simple bubble sort technique
     * @param array array to be sorted
     * @return the sorted array
     */
    public static ArrayList<Integer> sort( ArrayList<Integer> array ) {
        boolean swap = true;
        for( int i=0; i<array.size()-1; i++ )
            if(!swap){
                break;
            } else {
                swap = false;
                for( int j=1, temp=0; j<array.size(); j++ ){
                    if( array.get(j-1) > array.get(j) ){
                        swap = true;
                        temp = array.get(j-1);
                        array.set(j, array.get(j-1));
                        array.set(j-1, temp);
                    }
                }
            }
        return array;
    }
}

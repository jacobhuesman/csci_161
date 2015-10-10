/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom02;

/**
 * Tests the SimpleBubbleSort class and prints the results using the ConsoleTable class.
 * @author Jacob Huesman
 */
public class Client {
    public static void main( String args[] ) {
        int[][] array = SimpleBubbleSort.bubbleSortTest();
        
        String[] colNames = { "Run", "Length", "Time" };
        String[][] data = new String[array.length][3];
        for ( int i=0; i<array.length; i++ ) {
            if( (i+1)%4 == 0 ){
                data[i][0] = "AVG";
            } else {
                data[i][0] = "" + ((i)%4+1);
            }
            data[i][1] = "" + array[i][0];
            data[i][2] = "" + array[i][1];
        }
        
        System.out.println(ConsoleTable.makeTable("Simple Bubble Sort", 80, colNames, data));
    }
}

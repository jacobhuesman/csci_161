/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;

import java.util.Random;

/**
 * Isabel Technique for summing an array of integers.
 * @author Jacob Huesman
 */
public class IsabelTechnique {
    private IsabelTechnique(){}
    
    /**
     * Method that sums the values of an array using the Isabel Technique. Note the size of the array must be a power of 2.
     * @param A array to be summed
     * @return sum of the array
     * @throws Exception if the array is not a power of 2
     */
    public static int sumValues( int[] A ) throws Exception {
        if( (A.length & (A.length-1)) != 0 ) {
            throw new Exception("Not a power of 2!");
        }
        int[] B = new int[ A.length/2 ];
        for( int i=0; i<B.length; i++ ){
            B[i] = A[2*i] + A[2*i+1];
        }
        if( B.length == 1 ){
            return B[0];
        } else {
            return sumValues( B );
        }
    }
    
    public static void main( String args[] ) {
        Random rand = new Random();
        //Create an int array of appropriate size greater than 10 as defined in the algorithm. 
        int[] test = new int[256];
        
        //Populate the array with random values between 1 and 10
        int total = 0;
        for( int i=0; i<test.length; i++ ) {
            test[i] = rand.nextInt(10)+1;
            total += test[i];
        }  
        
        //Call sumValues() method to display total.
        try {
            System.out.print("Sum using Isabel Technique: ");
            System.out.println(sumValues(test));
            System.out.print("Sum using a standard loop: ");
            System.out.println(total);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

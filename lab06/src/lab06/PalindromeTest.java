/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab06;

import java.util.Scanner;

/**
 * Class developed to test if a String is a palindrome.
 * @author Jacob Huesman
 */
public class PalindromeTest {
    private PalindromeTest(){}
    
    /**
     * Tests to see if a given string is a palindrome.
     * @param par string to be checked
     * @return true - if palindrome; false - otherwise
     */
    public static boolean isPalindrome( String par ) {
        char[] palin = par.toCharArray();
        for( int i=(palin.length - palin.length/2), a=(palin.length/2-1); a>=0; i++, a-- ){
            if( palin[i] != palin[a] ){
                return false;
            }
        }
        return true;
    }
    
    public static void main( String ars[] ){
        Scanner scan = new Scanner( System.in );
        
        //Prompt the user to input a String and call the isPalindrome() mehtod to asnwer the question if the input string is a palindrome.
        System.out.print("Please enter a string: ");
        if( isPalindrome(scan.next()) ){
            System.out.println("Checking to see if palindrome...");
            System.out.println("The string entered is a palindrome!");
        } else {
            System.out.println("Checking to see if palindrome...");
            System.out.println("The string entered is not a palindrome.");
        }
        
        //Use the examples of palindromes provided to check whether they are aplindromes and also test for some non-palindrome strings. Print the results.
        String[] examples = { "bob", "dad", "deed", "malayalam", "not a palindrome", "jake", "string" };
        for( int i=0; i<examples.length; i++ ){
            System.out.println("Checking to see if \"" + examples[i] + "\" is a palindrome.");
            if( isPalindrome(examples[i]) ){
                System.out.println("\"" + examples[i] + "\" is a palindrome!");
            } else {
                System.out.println("\"" + examples[i] + "\" is not a palindrome.");
            }
        }
    }
}

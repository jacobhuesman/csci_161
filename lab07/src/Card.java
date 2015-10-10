/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Simple class to represent a playing card as an object
 * @author Jacob Huesman
 */
public class Card {
    private String suit, rank;
    private int value;
    
    /**
     * Creates a new card object of a certain rank and suit
     * @param r rank
     * @param s suit
     * @throws Exception if rank or suit do not match that of a standard deck of playing cards
     */
    public Card(String r, String s) throws Exception{
        switch(r.toUpperCase().trim().charAt(0)){
            case '2':
                rank = "2";
                value = 2;
                break;
            case '3':
                rank = "3";
                value = 3;
                break;
            case '4':
                rank = "4";
                value = 4;
                break;
            case '5':
                rank = "5";
                value = 5;
                break;
            case '6':
                rank = "6";
                value = 6;
                break;
            case '7':
                rank = "7";
                value = 7;
                break;
            case '8':
                rank = "8";
                value = 8;
                break;
            case '9':
                rank = "9";
                value = 9;
                break;
            case '1':
                rank = "10";
                value = 10;
                break;
            case 'J':
                rank = "J";
                value = 11;
                break;
            case 'Q':
                rank = "Q";
                value = 12;
                break;
            case 'K':
                rank = "K";
                value = 13;
                break;
            case 'A':
                rank = "A";
                value = 14;
                break;
            default:
                throw new Exception("Invalid Rank");
        }
        switch(s.toUpperCase().trim().charAt(0)){
            case 'H':
                suit = "H";
                break;
            case 'C':
                suit = "C";
                break;
            case 'S':
                suit = "S";
                break;
            case 'D':
                suit = "D";
                break;
            default:
                throw new Exception("Invalid Suit");
        }
    }
    
    /**
     * Returns the integer value used in comparisons of the rank of two cards
     * @return integer value of the card
     */
    public int getValue(){
        return value;
    }
    
    /**
     * Returns the rank of the card
     * @return rank
     */
    public String getRank(){
        return rank;
    }
    
    /**
     * Returns the suit of the card
     * @return suit
     */
    public String getSuit(){
        return suit;
    }
}

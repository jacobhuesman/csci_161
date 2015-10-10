
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Huesman
 */
public class Deck {
    private CircularlyLinkedList<Card> deck;
    private final String[] rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    private final String[] suit = {"H","C","S","D"};
    private Random random = new Random();
    private int cards;
    
    public Deck(){
        deck = new CircularlyLinkedList<>();
        cards = 52;
        for(int i=0; i<suit.length; i++){
            for(int j=0; j<rank.length; j++){
                try {
                   deck.addLast(new Card(rank[j],suit[i])); 
                } catch(Exception e){System.out.println("Not Working " + i + j);}
            }
        }
    }
    
    public Card card(){
        for(int i=0; i<random.nextInt(cards); i++){
            deck.rotate();
        }
        cards--;
        return deck.last();
    }
}

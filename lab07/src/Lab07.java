
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * A client class that tests the classes by dealing a card game
 * @author Jacob Huesman
 */
public class Lab07 {
    public static void main(String args[]){
        //Create a new game
        Game game = new Game(4,13);
        
        
        Card card;
        Iterator iterate;
        //Deal a hand and output the cards in each player's hand
        for(int i=0; i<game.maxCards; i++){
            game.getCard();
            System.out.format("Card %02d:\n", i+1);
            for(int j=0; j<game.hands.length; j++){
                System.out.format("Player %d:  ", j+1);
                iterate = game.hands[j].iterator();
                while(iterate.hasNext()){
                    card = (Card) iterate.next();
                    System.out.format("%2S%S  ", card.getRank(), card.getSuit());
                }
                System.out.println("");
            }
        }
    }
}

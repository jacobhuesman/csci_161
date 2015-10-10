/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class that represents a card game
 * @author Jacob Huesman
 */
public class Game {
    private final int players;
    public final int maxCards;
    private final Deck deck;
    public final CardHand[] hands;
    
    /**
     * Creates a new game with a specified number of players and a max number of cards a player can hold
     * @param players number of players in this game
     * @param maxCards max number of cards a player can hold
     */
    public Game(int players, int maxCards){
        this.players = players;
        this.maxCards = maxCards;
        deck = new Deck();
        hands = new CardHand[players];
        for(int i=0; i<players; i++){
            hands[i] = new CardHand();
        }
    }
    
    /**
     * Deals a card to each player
     */
    public void getCard(){
        for(int i=0; i<players; i++){
            hands[i].addCard(deck.card());
        }
    }
    
}

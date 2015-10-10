
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class to represent a person arranging a group of cards in his or her hand
 * @author Jacob Huesman
 */
public class CardHand implements Iterable {
    private Position<Card> hearts, clubs, spades, diamonds;
    private final LinkedPositionalList<Card> hand;
    /**
     * Creates a new hand object ready to have cards added
     */
    public CardHand(){
        hand = new LinkedPositionalList<>();
    }
    
    /**
     * Adds a card to the hand, given a specific rank and suit
     * @param r rank of card
     * @param s suit of the card
     * @throws java.lang.Exception if the specified rank and suit do not correspond to the rank and suit of a standard deck of cards
     */
    public void addCard(String r, String s) throws Exception{
        Card card = new Card(r,s);
        switch(card.getSuit()){
            case "H":
                if(hearts == null){
                    hearts = hand.addLast(card);
                } else {
                    hearts = sort(hearts, card);
                }
                break;
            case "C":
                if(clubs == null){
                    clubs = hand.addLast(card);
                } else {
                    clubs = sort(clubs, card);
                }
                break;
            case "S":
                if(spades == null){
                    spades = hand.addLast(card);
                } else {
                    spades = sort(spades, card);
                }
                break;
            case "D":
                if(diamonds == null){
                    diamonds = hand.addLast(card);
                } else {
                    diamonds = sort(diamonds, card);
                }
                break;
        }           
    }
    
    /**
     * Adds an already existing card object to the hand
     * @param card card object
     */
    public void addCard(Card card){
        switch(card.getSuit()){
            case "H":
                if(hearts == null){
                    hearts = hand.addLast(card);
                } else {
                    hearts = sort(hearts, card);
                }
                break;
            case "C":
                if(clubs == null){
                    clubs = hand.addLast(card);
                } else {
                    clubs = sort(clubs, card);
                }
                break;
            case "S":
                if(spades == null){
                    spades = hand.addLast(card);
                } else {
                    spades = sort(spades, card);
                }
                break;
            case "D":
                if(diamonds == null){
                    diamonds = hand.addLast(card);
                } else {
                    diamonds = sort(diamonds, card);
                }
                break;
        }           
    }
    
    /**
     * Adds a card to the hand so the the suit of cards is arranged in descending order with the higher valued cards first and lower value cards to the right
     * @param start first card in the suit
     * @param card card to be added
     * @return 
     */
    private Position sort(Position<Card> start, Card card){
        Position<Card> current = start;
        do {
            if(current.getElement().getValue() < card.getValue()){
                if(current == start){
                    return hand.addBefore(start, card);
                } else {
                    hand.addBefore(current, card);
                }
               return start;
            } else if(hand.after(current) == null){
                hand.addAfter(current, card);
                return start;
            } else if(! hand.after(current).getElement().getSuit().equals(card.getSuit())){
                hand.addAfter(current, card);
                return start;
            } else {
                current = hand.after(current);
            }
        } while(true);
    }
    
    /**
     * Removes the highest card of a specified suit from the player's hand
     * @param s String representation of the suit to be removed
     * @return highest card of the specified suit
     * @throws Exception if the String representation of the suit doesn't start with the letter of any particular suit
     */
    public Card play(String s) throws Exception{
        Card card = new Card("2", s);
        switch(card.getSuit()){
            case "H":
                hearts = hand.after(hearts);
                return hand.remove(hand.before(hearts));
            case "C":
                clubs = hand.after(clubs);
                return hand.remove(hand.before(clubs));
            case "S":
                spades = hand.after(spades);
                return hand.remove(hand.before(spades));
            case "D":
                diamonds = hand.after(diamonds);
                return hand.remove(hand.before(diamonds));
        }
        return card;
    }
    
    /**
     * Returns an iterator of all the cards in the hand
     * @return iterator of all the cards in the hand
     */
    @Override
    public Iterator<Card> iterator(){
        return hand.iterator();
    }
    
    /**
     * Returns an iterator for all the cards of a specific suit in the hand
     * @param s String representation of the suit to be removed
     * @return Iterator of all the cards of the specified suit in the hand
     * @throws Exception if the String representation of the suit doesn't start with the letter of any particular suit
     */
    public Iterator<Card> suitIterator(String s) throws Exception{
        return new SuitIterator(s);
    }
    
    /**
     * Defines an Iterator that can be used to iterate through all the cards of a specific suit in a hand
     */
    private class SuitIterator implements Iterator<Card> {

        private Position<Card> next;
        private boolean hasNext;
        
        /**
         * Creates an iterator for a specified suit
         * @param s suit to be iterated
         * @throws Exception if the String representation of the suit doesn't start with the letter of any particular suit
         */
        public SuitIterator(String s) throws Exception{
            Card card = new Card("2", s);
            switch(card.getSuit()){
                case "H":
                    next = hearts;
                    break;
                case "C":
                    next = clubs;
                    break;
                case "S":
                    next = spades;
                    break;
                case "D":
                    next = diamonds;
                    break;
            }
            hasNext = next != null;
        }

        /**
         * Returns if there is another card of the specified suit
         * @return true - if there is a card; false - otherwise
         */
        @Override
        public boolean hasNext() {
            return hasNext;
        }

        /**
         * Returns the next card of the specified suit
         * @return Card of the specified suit
         */
        @Override
        public Card next() {
            if(hasNext){
                if(hand.after(next) == null){
                    hasNext = false;
                    return next.getElement();
                } else if(!hand.after(next).getElement().getSuit().equals(next.getElement().getSuit())){
                    hasNext = false;
                    return next.getElement();
                } else {
                    next = hand.after(next);
                    return hand.before(next).getElement();
                }
            } else {
                throw new NoSuchElementException("No next element");
            }
        }   
    }
}

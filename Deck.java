package com.mo.Cards;

import java.util.ArrayList;
import java.util.Collections;




public class Deck {
	
private ArrayList<Card> remainingCards;
private Card CurrentCard;
ArrayList<Card> deck = new ArrayList<Card>();	
	//constructs a deck of 52 cards
	public Deck() {
	

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card currentCard = new Card(j, i);
				deck.add(currentCard);

			}

		}//end of outer for loop
		
		//CurrentCard =  deck.get(0);
		

	}//end of deck
	
	public ArrayList<Card> getRemaining() {
		remainingCards = this.deck;
		return remainingCards;
	}
    
	//returns the first card in the current deck
	public Card getCurrentCard() {
		CurrentCard = deck.get(0);
		this.removeCard(CurrentCard);
		return this.CurrentCard;
	}

	//draw a card from the deck
	Card Draw(){
		return CurrentCard;
	}
    
	public void removeCard(Card selectedCard) {
	    deck.remove(selectedCard);
	}
	
	//a removes NumberOfCards from the current deck and returns them
	//CHANGE return type
	int Deal(int NumberOfCards){
		return 0;
	}
	
	//shuffle all the cards in the deck 
	public void Shuffle(){
		Collections.shuffle(this.deck);
		System.out.println("deck has been shuffled!");
	}
	
	int CardsRemaining(){
		return this.deck.size();  
	}
	

}

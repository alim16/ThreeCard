package com.mo.Cards;

import java.util.ArrayList;
import java.util.ListIterator;

public class ThreeCard {
	//--------------------------------------------------
	static final int NumberOfDecks = 6;
	static ArrayList<Deck> DeckSet;
	static Deck CurrentDeck;
	static final int HANDSIZE = 3;
	static int numberOfPlayers = 2;
	//-------------------------------------------------
	
	public static void main(String[] args) {
		ArrayList<Card> CurrentHand = null; //delete later
    //set up the decks and start the game
	InitDeckSet();	
	
	//***CONSIDER USING GAME STATES
	//Round();
	
	/////////////////////////////////////////////////////////
	CurrentDeck = DeckSet.get(0);	
	CurrentDeck.Shuffle();
	
	//***CONSIDER USING GAME STATES
	ArrayList<Player> playerList = new ArrayList<Player>();
	Dealer Dealer = new Dealer();
	Dealer.setName("dealersName");
	System.out.println(Dealer.getName());
	//playerList.add(Dealer);
	for (int i = 0; i < (numberOfPlayers+1);i++) {
		Player player = new Player();
		player.playerIndex = i+1;
		playerList.add(player);
		System.out.println("player "+ player.playerIndex + " added");
	}
	
	ListIterator<Player> LI =  playerList.listIterator();
	while (LI.hasNext()) {
		Player currentPlayer;
		currentPlayer = null;
		if (LI.hasNext()){
		 currentPlayer = LI.next();
		 DealHand(currentPlayer);
		 Hands.HandDetector(currentPlayer.hand);
		 Hands.HandName();
		}
		 //Hands.HandDetector(currentPlayer.hand);
		// System.out.println("player"+LI.nextIndex() + " has: "+currentPlayer.hand);

		
		//System.out.println("player"+LI.nextIndex() + " has: "+currentPlayer.hand);

	}
	///////////////////////////////////////////////////////////
	
	/*Player Dealer = new Player();
	Player player1 = new Player();

	 */
	 //include method to count the number of garbage hand
	}
  
	//draw a new hand from the current deck and assign it to the player
	 static ArrayList<Card> DealHand(Player player){
	    ArrayList<Card> hand1 = new Hands().GetHand(CurrentDeck, HANDSIZE);
		player.hand = hand1;
	
			System.out.println("player " +player.playerIndex+ " has: "+player.hand);
			return player.hand;
	}

	//
	private void Round(){
		//create arrayList of type Player and iterate through list to deal hands, set up bets, 
		//compare hands and pay out players
		
		CurrentDeck = DeckSet.get(0);	
		CurrentDeck.Shuffle();
		
		//***CONSIDER USING GAME STATES
		ArrayList<Player> playerList = new ArrayList<Player>();
		Player Dealer = new Player();
		playerList.add(Dealer);
		for (int i = 0; i < 3; i++) {
			Player player = new Player();
			playerList.add(player);
		}
		
		ListIterator<Player> LI =  playerList.listIterator();
		while (LI.hasNext()) {
			 Player currentPlayer = LI.next();
	
			   //Hands.HandDetector(currentPlayer.hand);
			 Hands.HandDetector(currentPlayer.hand);
			 System.out.println("player"+LI.nextIndex() + " has: "+currentPlayer.hand);
	
		}
		
	}
	
	//create a few instances of the Deck class.
	//in this game a new deck should be used after each round
	static ArrayList<Deck> InitDeckSet(){
		for (int i = 0; i < NumberOfDecks; i++) {
			DeckSet = new ArrayList<Deck>();
			Deck newDeck = new Deck();
			DeckSet.add(newDeck);
		} 
		return DeckSet;
	}
	
}

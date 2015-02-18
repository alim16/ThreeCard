package com.mo.Cards;

import java.util.*;

import java.util.ArrayList;


public class Hands {
	// variables to set when a winning hand is found
	 static private boolean Pair =false;
	 static private boolean Flush =false;
     static private boolean Straight =false;
	 static private boolean ThreeOfaKind =false;
	 static private boolean Straightflush = false;
	 static String HighCard = null;
	 static String PairName = null;
	

	public Hands() {

	}

	public ArrayList<Card> GetHand(Deck deck, int HandSize) {
		ArrayList<Card> hand = new ArrayList<Card>();

		for (int i = 0; i < HandSize; i++) {
			if(deck.CardsRemaining() > 2){
			Card newCard = deck.getCurrentCard();
			hand.add(newCard);
			Collections.sort(hand);
		
			
			//remove the card that has been drawn from the list of cards
			deck.removeCard(newCard);
			}
			else
			{
				//****might have to add throw exception
				System.out.println("Error: DECK IS EMPTY!!!");
				return hand;
			}

		}
		
		return hand;
	}

	 public static void HandDetector(ArrayList<Card> hand) {
	
		// card 1
		String cardNameA = hand.get(0).toString();
		String[] cardA = cardNameA.split(" of ");
		String rankA = cardA[0];
		String suitA = cardA[1];

		// card 2
		String cardNameB = hand.get(1).toString();
		String[] cardB = cardNameB.split(" of ");
		String rankB = cardB[0];
		String suitB = cardB[1];

		// card 3
		String cardNameC = hand.get(2).toString();
		String[] cardC = cardNameC.split(" of ");
		String rankC = cardC[0];
		String suitC = cardC[1];
		
		//set the last card to be the HighCard
		HighCard = rankC;
		
        //check for pair or three of kind
		if (rankA.equals(rankB) & rankA.equals(rankC) & rankB.equals(rankC)) {
			//System.out.println("THREE OF A KIND!!!!");
            ThreeOfaKind = true;	
		}
		else if(rankA.equals(rankB) | rankA.equals(rankC) | rankB.equals(rankC)){
			//System.out.println("PAIR FOUND!!");
		       Pair = true;
			if(rankA.equals(rankB)|rankA.equals(rankC)){
				PairName = rankA;
			}
			else{
				PairName = rankC;
			}
		}
        
		//check for flush
		if (suitA.equals(suitB) & suitA.equals(suitC) & suitB.equals(suitC)) {
			//System.out.println("FLUSH!!");
			Flush = true;

		}
		
		
		//check for straight using the rank's position in the card array
		//add one because array starts from 0
		int intA = hand.get(0).getRank()+1;
		int intB = hand.get(1).getRank()+1;
		int intC = hand.get(2).getRank()+1;
		
		System.out.println("#" + intA+" #" +intB +"#" + intC);
		if (AreNeighbours(intA,intB)&AreNeighbours(intB,intC)){
		  // System.out.println("STRAIGHT!!!");
		/*three and jack queen king
		 * 
		 * */
		   Straight =true;
		}
		
		
		//check for straightFlush
		if((Straight==true) & (Flush ==true)){
			Straight = false;
			Flush = false;
		  Straightflush = true;
					
			//System.out.println("STRAIGHTFLUSH!!!!!!!");
		}
		
		
		

	}
	 
	 public static void HandName(){
		//test HAND ****consider placing this in a separate method
	       if (Straightflush == true) {
	    	   System.out.println("STRAIGHTFLUSH!!!!!!!");
	    	   Straight = false;
	    	   Flush = false;
	        } else if(ThreeOfaKind == true) {
	     	   System.out.println("Three of a kind!!!");
	     	  ThreeOfaKind = false;
	        } else if (Straight == true) {
	        	System.out.println("STRAIGHT! ###WARNING: DOES NOT WORK YET");
	        	Straight = false;
	        } else if (Flush == true) {
	        	System.out.println("flush");
	        	Flush = false;
	        } else if (Pair == true) {
	        	System.out.println("Pair of " + PairName + "'s");
	        	Pair = false;
	        } else {
	        	System.out.println(HighCard+" High");
	        }
	 }
	
	///use this to check for straight
	///
	static public boolean AreNeighbours(int A, int B){
		boolean state = false;
		 if ((B-A == 1)&(A-B== -1)){
			 state = true;
		 }
		 else {
			 state = false;
		 }
		 return state;
	 }
	 
}

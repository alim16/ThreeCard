package com.mo.Cards;

public class Card implements Comparable<Card>{
	private String suits[] = {"Diamonds","Hearts","Spades","Clubs"};
	private String ranks[] = {"Ace","2","3","4","5","6","7",
								"8","9","10","Jack","Queen","King"};
	
	private int suit; 
	private int rank;
	String colour = null;
    

	public Card(int rank, int suit)
    {
		this.suit = suit;
		this.rank = rank;
		this.colour = colour; //**for later use 
    }

	public int getSuit() {
		return suit;
	}
	public int getRank() {
		return rank;
	}
	public String getColour() {
		return colour;
	}
	
	  public @Override String toString()
      {
            return ranks[rank] + " of " + suits[suit];
      }

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.rank, o.rank);
	}


	

}

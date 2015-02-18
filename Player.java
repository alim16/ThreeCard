package com.mo.Cards;

import java.util.ArrayList;

public class Player {
  int playerIndex = 0;
  int HandRank = 0;
  String name = null;
  ArrayList<Card> hand = null;
  int Balance = 1000;
  int PpBet = 5;
  int anti = 10;
  
 public int getHandRank() {
	return HandRank;
}
  //might have to delete setHandRank
public void setHandRank(int handRank) {
	HandRank = handRank;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ArrayList<Card> getHand() {
	return hand;
}
public void setHand(ArrayList<Card> hand) {
	this.hand = hand;
}
public int getBalance() {
	return Balance;
}
public void setBalance(int balance) {
	Balance = balance;
}
public int getPpBet() {
	return PpBet;
}
public void setPpBet(int ppBet) {
	PpBet = ppBet;
}
public int getAnti() {
	return anti;
}
public void setAnti(int anti) {
	this.anti = anti;
}

}

//add a constructor for dealer, with just a Balance and a HandRank
//add getters and setters
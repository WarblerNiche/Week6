package week06;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	//set parameters for the class
	String name;
	List<Card> hand = new ArrayList<Card>();
	int score;
	
	// constructor with player name
	Player(String name) {
		this.name = name;
		score = 0;
	}
	
	// flip method takes the first card out and returns it
	public Card flip() {
		Card card = this.hand.remove(0);
		return card;
	}
	
	// adds one point to the player's score
	public void incrementScore() {
		this.score++;
	}
	
	// prints out information about the player and calls the describe method for each card in the hand list
	public void describe() {
		System.out.println(this.name + "'s cards: ");
		for (Card card : this.hand) {
			card.describe();
		}
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

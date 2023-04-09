package week06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
	
	public static void main(String[] args) {
		//initialize deck
	    Deck deck = new Deck();
		// shuffle deck
		deck.shuffle();
		//instantiate 2 players;
		Player P1 = new Player("Player 1");
		Player P2 = new Player("Player 2");
		// deal both hands
		for (int i = 0; i<26; i++) {
			P1.hand.add(deck.draw());
			P2.hand.add(deck.draw());
		}
		// check the hands
		//P1.describe();
		//P2.describe();
		//play the game
		//gonna use some Card variables to keep track of my card values
		Card p1;
		Card p2;
		for (int i = 0; i<26; i++) {
			p1 = P1.flip();
			p2 = P2.flip();
			System.out.print("Player 1 ");
			p1.describe();
			System.out.print("Player 2 ");
			p2.describe();
			if (p1.value>p2.value) {
				P1.incrementScore();
				System.out.println("Player 1 wins this round.");
			}
			else if (p1.value<p2.value) {
				P2.incrementScore();
				System.out.println("Player 2 wins this round.");
			}
		}
		
		System.out.println(P1.name + " score: " + P1.score);
		System.out.println(P2.name + " score: " + P2.score);
		System.out.println("-------------------------");
		if (P1.score > P2.score)
			System.out.println(P1.name + " Wins!");
		else if (P1.score < P2.score)
			System.out.println(P2.name + " Wins!");
		else
			System.out.println("Draw!");
		
	} 
	
	// Method 5
	
	public static Map<String, List<Card>> method5(int playerCount) {
		Map<String, List<Card>> finalGameBoard = new HashMap<>();
		Deck deck = new Deck();
		deck.shuffle();
		
		for (int i = 1; i <= playerCount; i++) {
			List<Card> playerList = new ArrayList<>();
			String playerName = "Player " + i;
			finalGameBoard.put(playerName, playerList);
		}
		
		for (int i = 0; i< 52/playerCount; i++) {
			for (int j = 1; j<= playerCount; j++) {
				String playerName = "Player " + j;
				List<Card> playerList = finalGameBoard.get(playerName);
				playerList.add(deck.draw());
				finalGameBoard.replace(playerName, playerList);
			}
		}
		
		
		return finalGameBoard;
	}
	
}
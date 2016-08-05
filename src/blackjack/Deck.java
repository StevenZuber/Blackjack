package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//consider making deck extend ArrayList<Card>...
public class Deck {
	public static void main(String[] args) {
		List<Card> deck = new ArrayList<>(52);

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}

		Collections.shuffle(deck);
	
		for (Card card : deck) {
			System.out.println(card);
		}
		
	}

}

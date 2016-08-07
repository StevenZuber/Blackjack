package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//consider making deck extend ArrayList<Card>...
public class Deck {

	List<Card> deck = new ArrayList<>(52);

	public void createDeck() {

		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public String toString() {
		String fullDeck = "";
		for (Card card : deck) {
			fullDeck += "\n" + card.toString();

		}
		return fullDeck;
	}

	public void removeCard(int i) {
		this.deck.remove(i);
	}

	public Card getCard(int i) {
		return this.deck.get(i);
	}

	public void addCard(Card addCard) {
		this.deck.add(addCard);
	}

	// Draws from the deck
	public void draw(Deck startDeck) {
		this.deck.add(startDeck.getCard(0));
		startDeck.removeCard(0);
	}

	public int handValue() {
		int totalValue = 0;
		int aces = 0;

		for (Card card : deck) {
			switch (card.getRank()) {
			case Two:
				totalValue += 2;
				break;
			case Three:
				totalValue += 3;
				break;
			case Four:
				totalValue += 4;
				break;
			case Five:
				totalValue += 5;
				break;
			case Six:
				totalValue += 6;
				break;
			case Seven:
				totalValue += 7;
				break;
			case Eight:
				totalValue += 8;
				break;
			case Nine:
				totalValue += 9;
				break;
			case Ten:
				totalValue += 10;
				break;
			case Jack:
				totalValue += 10;
				break;
			case Queen:
				totalValue += 10;
				break;
			case King:
				totalValue += 10;
				break;
			case Ace:
				aces += 1;
				break;
			}
		}
		for (int i = 0; i < aces; i++) {
			if (totalValue > 10) {
				totalValue += 1;
			} else {
				totalValue += 11;
			}
		}
		return totalValue;
		}
	public int deckSize(){
		return this.deck.size();
	
	}
	public void restoreDeck(Deck newGame){
		int thisDeckSize = this.deck.size();
		
		for (int i = 0; i < thisDeckSize; i++) {
			newGame.addCard(this.getCard(i));
		}
		for (int i = 0; i < thisDeckSize; i++) {
			this.removeCard(0);
		}
	}
}

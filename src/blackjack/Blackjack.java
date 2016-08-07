package blackjack;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {

		System.out.println("Welcome to our casino! Have a seat at the Blackjack table!");
		System.out.println();

		Deck playingDeck = new Deck();
		playingDeck.createDeck();
		playingDeck.shuffle();

		Deck playerHand = new Deck();
		Deck dealerHand = new Deck();

		int chips = 100;

		Scanner keyboard = new Scanner(System.in);

		while (chips > 0) {
			System.out.println("You have " + chips + " chips. How much would you like to bet?");
			int bet = keyboard.nextInt();
			boolean endGame = false;
			if (bet > chips) {
				System.out.println("You don't have that many chips.");
				break;
			}
			System.out.println("Dealing...");

			playerHand.draw(playingDeck);
			playerHand.draw(playingDeck);

			dealerHand.draw(playingDeck);
			dealerHand.draw(playingDeck);

			while (true) {
				System.out.println("Your current hand is " + playerHand.toString());
				System.out.println("Your current hand is valued at: " + playerHand.handValue());
				System.out.println();
				System.out.println("The dealer currently has " + dealerHand.getCard(0).toString() + " visible.");
				System.out.println();
				System.out.println("Would you like to (1)hit or (2)stay?");
				int response = keyboard.nextInt();

				// hit
				if (response == 1) {
					playerHand.draw(playingDeck);
					System.out.println("You were dealt " + playerHand.getCard(playerHand.deckSize() - 1).toString());
					if (playerHand.deckSize() >= 5){
						System.out.println("You got five cards without busting! You win!");
						chips += (bet * 2);
					}
					
					if (playerHand.handValue() > 21) {
						System.out.println("Your hand is worth " + playerHand.handValue() + " You busted.");
						chips -= bet;
						endGame = true;
						break;
					}
				}
				if (response == 2) {
					System.out.println("You chose to stay.");
					break;
				}
			}
			System.out.println();
			System.out.println("The dealer has " + dealerHand.toString());

			if ((dealerHand.handValue() > playerHand.handValue()) && endGame == false) {
				System.out.println("The dealer won. Sorry about that");
				chips -= bet;
				endGame = true;
			}
			while ((dealerHand.handValue() < 17) && endGame == false) {
				dealerHand.draw(playingDeck);
				System.out.println("The dealer drew " + dealerHand.getCard(dealerHand.deckSize() - 1).toString());
			}
			System.out.println("The dealer's hand is worth " + dealerHand.handValue());
			if ((dealerHand.handValue() > 21 && endGame == false)) {
				System.out.println("The dealer busted. You win!");
				chips += (bet * 2);
				endGame = true;
			}
			if ((playerHand.handValue() == dealerHand.handValue()) && endGame == false) {
				System.out.println("It's a tie!");
				endGame = true;
			}
			if ((playerHand.handValue() > dealerHand.handValue()) && endGame == false) {
				System.out.println("You win!! Congratulations!!");
				chips += (bet * 2);
				endGame = true;
			} else if (endGame == false) {
				System.out.println("The dealer wins. ");
				chips -= bet;
			}

			playerHand.restoreDeck(playingDeck);
			dealerHand.restoreDeck(playingDeck);

			

		}
	}
}
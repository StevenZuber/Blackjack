package blackjack;

import java.awt.List;
import java.util.ArrayList;

//probably make this one extend the ArrayList<Card>...
public class PlayerHand extends ArrayList<Card>{
	
	public void testmethod(){
	PlayerHand ph = new PlayerHand();
	//making a test card below
	Card a = new Card(Rank.Ten, Suit.Diamonds);
	ph.add(a);
	//System.out.println(ph);
	
	}


	
}

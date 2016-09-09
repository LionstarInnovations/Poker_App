package comp2541.coursework2;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Perform tests on the Deck class.
 * 
 * @author Marcus McFarlane
 */
public class DeckTest extends CardCollection{

	/**
	 * Testing the creation of a deck of cards.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testCreation() {
		
		Deck deck = new Deck();
			
		assertEquals("Number of cards: ", 52, deck.size());		
		assertNotSame("Number of cards: ", 51, deck.size());
		assertNotSame("Number of cards: ", 53, deck.size());
	}
	
	/**
	 * Testing the 'contains' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testContains(){
		
		Deck deck = new Deck();
		
	    Card kingHearts = new Card("KH");
	    Card sevenDiamonds = new Card("7D");
		
	    assertTrue("Card contained: ", deck.contains(kingHearts));
	    assertTrue("Card contained: ", deck.contains(sevenDiamonds));
	}
	
	/**
	 * Testing the 'deal' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testDeal(){
		
		Deck deck = new Deck();
		Card aceClubs = new Card("AC");

		assertTrue(deck.size() == 52);
	    assertTrue("Card contained: ", deck.contains(aceClubs));
		
		deck.deal();
		
		assertTrue(deck.size() == 51);
	    assertFalse("Card contained: ", deck.contains(aceClubs));
	}
	
	/**
	 * Testing the 'add' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testAdd(){
		
		Deck deck = new Deck();
		Card aceClubs = new Card("AC");
		
	    assertTrue("Card contained: ", deck.contains(aceClubs));

		deck.deal();
		
	    assertFalse("Card contained: ", deck.contains(aceClubs));

	    deck.add(aceClubs);
	    
	    assertTrue("Card contained: ", deck.contains(aceClubs));
	}
	
	/**
	 * Testing the 'add' method for failure.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testFailedAdd(){
		
		Deck deck = new Deck();
		Card aceClubs = new Card("AC");
		
	    assertTrue("Card contained: ", deck.contains(aceClubs));
	    
	    deck.add(aceClubs);
	}
}
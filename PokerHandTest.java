package comp2541.coursework2;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Perform tests on the PokerHand class.
 * 
 * @author Marcus McFarlane
 */
public class PokerHandTest {

	/**
	 * Testing the 'add' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test	
	public void testAdd(){
		
		PokerHand poker = new PokerHand();
		
		Card aceClubs = new Card("AC");
		Card kingHearts = new Card("KH");
		Card queenDiamonds = new Card("QD");
		Card sevenDiamonds = new Card("7D");
		Card eightHearts = new Card("8H");
		Card kingDiamonds = new Card("KD");
		
		poker.add(aceClubs);
		assertTrue("Card contained: ", poker.contains(aceClubs));
		poker.add(kingHearts);
		assertTrue("Card contained: ", poker.contains(kingHearts));
		poker.add(queenDiamonds);
		assertTrue("Card contained: ", poker.contains(queenDiamonds));
		poker.add(sevenDiamonds);
		assertTrue("Card contained: ", poker.contains(sevenDiamonds));
		poker.add(eightHearts);
		assertTrue("Card contained: ", poker.contains(eightHearts));
		assertFalse("Card contained: ", poker.contains(kingDiamonds));		
	}	
	
	/**
	 * Testing the 'add' method for failure.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test(expected=IllegalArgumentException.class)	
	public void testFailedAdd(){
		
		PokerHand poker = new PokerHand();
		
		Card aceClubs = new Card("AC");
		Card kingHearts = new Card("KH");
		Card queenDiamonds = new Card("QD");
		Card sevenDiamonds = new Card("7D");
		Card eightHearts = new Card("8H");
		Card kingDiamonds = new Card("KD");
		
		poker.add(aceClubs);
		assertTrue("Card contained: ", poker.contains(aceClubs));
		poker.add(kingHearts);
		assertTrue("Card contained: ", poker.contains(kingHearts));
		poker.add(queenDiamonds);
		assertTrue("Card contained: ", poker.contains(queenDiamonds));
		poker.add(sevenDiamonds);
		assertTrue("Card contained: ", poker.contains(sevenDiamonds));
		poker.add(eightHearts);
		assertTrue("Card contained: ", poker.contains(eightHearts));
		poker.add(kingDiamonds);
		assertTrue("Card contained: ", poker.contains(kingDiamonds));	
	}
	
	/**
	 * Testing 'toString' method for an empty hand.
	 * 
	 * Expected to return the string "<empty>" if the hand is empty.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testEmptyHandToString(){
		
		PokerHand poker = new PokerHand();
				
		String expected = "<empty>";
		
		assertEquals("Card Expected: ", expected, poker.toString());		
	}
	
	/**
	 * Testing 'toString' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test 
	public void testToString()
	{
		PokerHand poker = new PokerHand();
		
		Card aceDiamonds = new Card("AD");
	    Card kingHearts = new Card("KH");
	    Card queenDiamonds = new Card("QD");
	  
	    poker.add(aceDiamonds);
	    poker.add(kingHearts);
	    poker.add(queenDiamonds);
	    
	    assertThat(aceDiamonds.toString(), equalTo("AD"));
	    assertThat(kingHearts.toString(), equalTo("KH"));
	    assertThat(queenDiamonds.toString(), equalTo("QD"));

	    String expected = "[AD, KH, QD]";
	    	   
		assertEquals("Number of cards: ", expected, poker.cards.toString());
	}
	
	/**
	 * Testing 'isFlush' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testIsFlush(){
		
		PokerHand poker = new PokerHand();
		
		Card aceDiamonds = new Card("AD");
	    Card kingDiamonds = new Card("KD");
	    Card queenDiamonds = new Card("QD");
	    Card sevenDiamonds = new Card("7D");
	    Card eightDiamonds = new Card("AD");
	  
	    poker.add(aceDiamonds);
	    poker.add(kingDiamonds);
	    poker.add(queenDiamonds);
		poker.add(sevenDiamonds);
		poker.add(eightDiamonds);
		
		boolean flush = poker.isFlush();
		
		boolean expected = true;
	 	   
		assertEquals("Card hand is flush: ", expected, flush);
	}
	
	/**
	 * Testing 'isFlush' method for returning false.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testFalseIsFlush(){
		
		PokerHand poker = new PokerHand();
		
		Card aceDiamonds = new Card("AD");
	    Card kingHearts = new Card("KH");
	    Card queenDiamonds = new Card("QD");
	    Card sevenDiamonds = new Card("7D");
	    Card aceSpades = new Card("AC");
	  
	    poker.add(aceDiamonds);
	    poker.add(kingHearts);
	    poker.add(queenDiamonds);
		poker.add(sevenDiamonds);
		poker.add(aceSpades);
		
		boolean flush = poker.isFlush();
		
		boolean expected = false;
 	   
		assertEquals("Card hand flush false: ", expected, flush);
	}
	
	/**
	 * Testing 'twoPair' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testTwoPair(){
		
		PokerHand poker = new PokerHand();
		
		Card aceHearts = new Card("AH");
	    Card kingHearts = new Card("KH");
	    Card aceDiamonds = new Card("AD");
	    Card kingDiamonds = new Card("KD");
	    Card sevenHearts = new Card("7H");
	    
	    poker.add(aceHearts);
	    poker.add(kingHearts);
	    poker.add(aceDiamonds);
	    poker.add(kingDiamonds);
	    poker.add(sevenHearts);
	    
	    boolean pair = poker.twoPair();
	    
	    assertTrue(pair == true);
	    assertFalse(pair == false);
	}
	
	/**
	 * Testing 'threeOfAKind' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testThreeOfAKind(){
		
		PokerHand poker = new PokerHand();
		
		Card aceHearts = new Card("AH");
	    Card kingHearts = new Card("KH");
	    Card aceDiamonds = new Card("AD");
	    Card sevenDiamonds = new Card("7D");
	    Card aceSpades = new Card("AS");
	    
	    poker.add(aceHearts);
	    poker.add(kingHearts);
	    poker.add(aceDiamonds);
	    poker.add(sevenDiamonds);
	    poker.add(aceSpades);
	    
	    boolean threeOfAKind = poker.threeOfAKind();
	    
	    System.out.println(threeOfAKind);
	    
	    assertTrue(threeOfAKind == true);
	    assertFalse(threeOfAKind == false);
	    
	}
	
	/**
	 * Testing 'fullHouse' method.
	 * 
	 * @author Marcus McFarlane
	 */
	@Test
	public void testFullHouse(){
		
		PokerHand poker = new PokerHand();
		
		Card aceHearts = new Card("AH");
	    Card kingHearts = new Card("KH");
	    Card aceDiamonds = new Card("AD");
	    Card sevenDiamonds = new Card("KD");
	    Card aceSpades = new Card("AS");
	    
	    poker.add(aceHearts);
	    poker.add(kingHearts);
	    poker.add(aceDiamonds);
	    poker.add(sevenDiamonds);
	    poker.add(aceSpades);
	    
	    boolean fullHouse = poker.fullHouse();
	   
	    assertTrue(fullHouse == true);
	    assertFalse(fullHouse == false);
	}
}
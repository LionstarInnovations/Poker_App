package comp2541.coursework2;

import java.util.LinkedList;
import java.util.List;

/**
 * Finding the probabilities of a number of occurrences for different poker hands.
 * 
 * @author Marcus McFarlane
 */
public class Probabilities {

	public static void main(String[]args){

		
		//------------------------- Part 1
		// Creating a deck of cards a large number of times.
		
		List<Deck> deckList = new LinkedList<Deck>();
		
		for(int i = 0; i < 10000; i++){
						
			deckList.add(new Deck());				
		}	
		
		//-- Output
		
		System.out.println(deckList.size() + " decks of cards.");
		System.out.println(deckList.get(0).size() + " cards contained per deck");
		
		
		//-------------------- Part 2
		// Dealing ten hands of five cards from each of those decks.

		List<PokerHand> handList = new LinkedList<PokerHand>();
		
		for(int m = 0; m < deckList.size(); m++){
										
			for(int a = 0; a < 10; a++){
					
				int countStart = handList.size();
				int countFinish = handList.size() + 1;
				
				while (countStart < countFinish){
					
					handList.add(new PokerHand());
					
					deckList.get(m).shuffle();
					
					for(int j = 0; j < 4; j++){
						
						Card currentCard = deckList.get(m).cards.get(j);
										
						handList.get(countStart).add(currentCard);
										
						deckList.get(m).deal();
					}
					
					Card currentCard = deckList.get(m).cards.get(0);
					
					handList.get(countStart).add(currentCard);
					
					countStart++;						
				}
			}
		}
				
		//-- Output
		
		System.out.println(handList.size() + " hands dealt.");
					
		
		//------------------------ Part 3 - No of poker hand occurrences.

		//--------------- Flush
		
		int countFlush = 0;
	
		for( int i = 0; i < handList.size(); i++){
					
			if (handList.get(i).isFlush() == true){
					
				countFlush += 1;
			}
		}
		
		//-- Output
		System.out.println("Flush occured " + countFlush + " times,");
		
		//-------------- Two Pair
		
		int countTwoPair = 0;
		
		for( int i = 0; i < handList.size(); i++){
			
			if (handList.get(i).twoPair() == true){
				
				countTwoPair += 1;
			}
		}
		
		//-- Output
		
		System.out.println("Two Pair occured " + countTwoPair + " times,");
		
		//-------------- Three Of A Kind
		
		int countThreeKind = 0;
		
		for( int i = 0; i < handList.size(); i++){
			
			if (handList.get(i).threeOfAKind() == true){
				
				countThreeKind += 1;
			}
		}
		
		//-- Output
		
		System.out.println("Three Of A Kind occured " + countThreeKind + " times,");
				
		//-------------- Full House
		
		int countFullHouse = 0;
		
		for( int i = 0; i < handList.size(); i++){
			
			if (handList.get(i).fullHouse() == true){
				
				countFullHouse += 1;
			}
		}
		
		//-- Output
		
		System.out.println("Full House occurred " + countFullHouse + " times.");
						
		
		//------------------------ Part 4		
		//------------------------ Probabilities
				
		//-- Flush
		
		double flushP = ((double) countFlush / handList.size());

		double percentFlush = flushP * 100;
		
	    System.out.printf("Estimated P(Flush) = %.3f%%%n", percentFlush);

		//-- Two Pair
		
	    double twoPairP = ((double) countTwoPair / handList.size());

		double percentTwoPair = twoPairP * 100;
		
	    System.out.printf("Estimated P(Two Pair) = %.3f%%%n", percentTwoPair);
	   
		//-- Three of A Kind
		
	    double threeKindP = ((double) countThreeKind / handList.size());

		double percentThreeKind = threeKindP * 100;
		
	    System.out.printf("Estimated P(Three of a Kind) = %.3f%%%n", percentThreeKind);
	    
		//-- Full House
				
	    double fullHouseP = ((double) countFullHouse / handList.size());

		double percentFullHouse = fullHouseP * 100;
		
	    System.out.printf("Estimated P(Full House) = %.3f%%%n", percentFullHouse);	
	}
}
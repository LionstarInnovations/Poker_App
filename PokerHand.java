package comp2541.coursework2;

import java.util.LinkedList;
import java.util.List;


/**
 * Poker hands for playing Five Card Poker.
 * 
 * @author Marcus McFarlane
 */
public class PokerHand extends CardCollection{
    
    private char rank;
    private char suit;
	
	public PokerHand(){
	
		for(Card p : cards){			

			p.toString();
			
			cards.add(p);
		}	
	}

	
	/** 
	 * Adding a card to a Poker Hand.
	 * 
	 * @param card
	 * 
	 * @author Marcus McFarlane
	 */
	@Override
	public void add(Card card)
	{
		if (cards.size() > 4){
	        throw new IllegalArgumentException("Already 5 cards present");			
		}

		cards.add(card);		
	}
	
	
	/**
	 * Converts the string to the card string format
	 * 
	 * @author Marcus McFarlane
	 */
	@Override
	public String toString(){
		
		if(cards.size() == 0){
			return String.format("<empty>");
		}
		else{
		    return String.format("%c%c", rank, suit);
		}
	}
	
	/**
	 * Returns true if a Hand of cards contains a flush poker hand.
	 * 
	 * @return boolean
	 * 
	 * @author Marcus McFarlane
	 */
	public boolean isFlush(){
				
		boolean flush = true;
		
		Card current = cards.get(0);
		
		// Comparing the current element to the previous element.
		for (Card counter : cards){
			if ( current.getSuit() != counter.getSuit() ){	
				flush = false;
			}
			
			current = counter;
		}
		
		if (flush == true){
			return true;
		}
		else{
			return false;
		}		
	}
	
	/**
	 * Returns true if a Hand of cards contains a One Pair poker hand.
	 * 
	 * @return boolean
	 * 
	 * @author Marcus McFarlane
	 */
	public boolean onePair(){
		
		int count = 0;
		
		boolean result = false;
		
		boolean resultFinal = false;
		
		for (int i = 0; i < 4; i++){
			
			for( int j = i+1; j < 4; j++){
				
				if (cards.get(i).getRank() == cards.get(j).getRank()){
					
					result = true;
					
					if (result==true){
						count+=1;						
					}
				}
			}
		}
		
		if (cards.get(3).getRank() == cards.get(4).getRank()){
			
			count += 1;
		}
		if(count == 1){
			
			resultFinal = true;
		}
		return resultFinal;
	}

	/**
	 * Returns true if a Hand of cards contains a Two pair poker hand.
	 * 
	 * @return boolean
	 * 
	 * @author Marcus McFarlane
	 */
	public boolean twoPair(){
				
		int count = 0;
		
		boolean result = false;
		
		boolean resultFinal = false;
		
		for (int i = 0; i < 4; i++){
			
			for( int j = i+1; j < 4; j++){
				
				if (cards.get(i).getRank() == cards.get(j).getRank()){
					
					result = true;
					
					if (result==true){
						
						count+=1;			
					}
				}
			}
		}
		
		if (cards.get(3).getRank() == cards.get(4).getRank()){
			
			count += 1;
		}
		if(count == 2){
			
			resultFinal = true;
		}
		return resultFinal;
	}
	
	/**
	 * Returns true if a Hand of cards contains a Three of A Kind poker hand.
	 * 
	 * @return boolean
	 * 
	 * @author Marcus McFarlane
	 */
	public boolean threeOfAKind(){
		
		boolean threeOfAKind = false;
				
		List<Character> valList = new LinkedList<Character>();
				
		for( int i = 0; i < cards.size(); i++ ){
			
			Card myCard = cards.get(i);	
			
			valList.add(myCard.getRank());						
		}
		
		int count = 0;
		
		for(int i = 0; i < cards.size(); i++){
			
			for( int j = i+1; j < cards.size(); j++){
				
				if(valList.get(i) == valList.get(j)){
					
					count ++;					
				}
				if ( j == cards.size() - 1 && count != 2){
					
					count = 0;
				}
				else if(j == cards.size() - 1 && count >= 2){	
					
					threeOfAKind = true;
				}
			}
		}
		return threeOfAKind;
	}

	/**
	 * Returns true if a Hand of cards contains a Full House poker hand.
	 * 
	 * @return boolean
	 * 
	 * @author Marcus McFarlane
	 */
	public boolean fullHouse(){
		
		boolean fullHouse = false;
				
		List<Character> valList = new LinkedList<Character>();
				
		List<Character> newHand = new LinkedList<Character>();
		
		
		for( int i = 0; i < cards.size(); i++ ){
			
			Card myCard = cards.get(i);	
			
			valList.add(myCard.getRank());						
		}
		
		int count = 0;
		
		for(int i = 0; i < cards.size(); i++){
			
			for( int j = i+1; j < cards.size(); j++){
				
				if(valList.get(i) == valList.get(j)){
					
					count ++;	
					
					newHand.add(valList.get(i));				
				}
				if ( j == cards.size() - 1 && count != 2){
					
					count = 0;
				}
				else if(j == cards.size() - 1 && count >= 2){	
										
					for(int k = 0; k < 4; k++){
						
						if (newHand.get(0) == valList.get(k)){
													
							valList.remove(k);
							valList.add('z');
						}
					}

					if (valList.get(0) == valList.get(1)){
						
						fullHouse = true;
					}
				}
			}
		}		
		return fullHouse;
	}
}
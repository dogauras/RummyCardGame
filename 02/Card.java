// Public class that represents a Card
public class Card {
	private int suit;
	private int rank;

	// declares four constants
	protected static final int DIAMOND = 0;
	protected static final int CLUB = 1;
	protected static final int HEART = 2;
	protected static final int SPADE = 3;

	// constructor
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	//getters
	
	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	// returns true if and only if the object designated by other is a Card that has
	// the same suit and the same rank
	public boolean equals(Object object) {

		if (object.getClass() != Card.class) {
			return false;
		} else {
			Card other;
			other = (Card) object;
			if (other.rank == rank && other.suit == suit) {
				return true;
			}
		}
		return false;

	}

	// String representation of an object of type Card
	public String toString() {
		return "{" + suit + "," + rank + "}";
	}
}

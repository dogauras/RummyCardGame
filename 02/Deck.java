import java.util.ArrayList;
import java.util.Collections;

// Public class that represents an object of type Deck
public class Deck {
	private ArrayList<Card> deck;

	/**
	 * A constructor for the class <code>Deck</code>. It creates the initial
	 * <code>ArrayList</code> that will be used to store the cards of Otherwise
	 * deck.
	 */
	public Deck() {
		deck = new ArrayList<Card>();
	}

	/**
	 * A constructor for the class <code>Deck</code>. It creates the initial
	 * <code>ArrayList</code> that will be used to store the cards of Otherwise
	 * deck. The parameter specifies the number of ranks for the cards. Finally, it
	 * also initializes this deck to contain 4 x n cards, where n is the value of
	 * the parameter.
	 *
	 * @param range the number of ranks for the cards
	 */
	public Deck(int range) {
		deck = new ArrayList<Card>(4 * range);
		makeDeck(range);
	}

	// fills the array list (this deck) with cards
	public void makeDeck(int ranks) {
		for (int i = 1; i < ranks + 1; i++) {
			for (int j = 0; j < 4; j++) {
				Card a = new Card(j, i);
				deck.add(a);
			}
		}
	}

	// returns the number of cards in the deck
	public int size() {
		return deck.size();
	}

	// returns true if the deck has one or more cards, false otherwise
	public boolean hasCards() {
		if (deck.size() >= 1) {
			return true;
		}
		return false;
	}

	// returns the card at the speciﬁed position in the deck
	public Card get(int pos) {
		return deck.get(pos);
	}

	// adds the speciﬁed card at the end of this deck
	public void add(Card card) {
		deck.add(card);
	}

	// appends all the cards from other at the end of this deck, while also removing
	// them from other.
	public void addAll(Deck other) {
		for (int i = 0; i < other.size(); i++) {
			deck.add(other.get(i));
		}
		for (int i = other.size() - 1; i >= 0; i--) {
			other.remove(other.get(i));
		}

	}

	// removes and returns the last card of this deck
	// Precondition: deck is not empty
	public Card removeLast() {
		Card remove = deck.get(deck.size() - 1);
		deck.remove(remove);
		return remove;
	}

	// removes and returns the first card of this deck
	// Precondition: deck is not empty
	public Card removeFirst() {
		Card remove = deck.get(0);
		deck.remove(deck.get(0));
		return remove;
	}

	// removes the ﬁrst occurrence of the speciﬁed card from this deck, if it is
	// present.
	// Returns true if and only if this deck contains the speciﬁed card.
	public boolean remove(Card card) {
		if (deck.contains(card)) {
			deck.remove(deck.indexOf(card));
			return true;
		}
		return false;
	}

	// removes cards that are contained in the deck 'other' from the deck. The cards
	// are not removed from the deck designated by other.
	public void removeAll(Deck other) {
		for (int i = 0; i < other.size(); i++) {
			if (deck.contains(other.get(i))) {
				deck.remove(other.get(i));
			}
		}
	}

	// shuffles all the cards in this deck
	public void shuﬄe() {
		Collections.shuffle(deck);

	}

	// removes a maximum of n cards from the end of this deck. The cards are
	// returned in a new deck.
	public Deck deal(int n) {
		Deck newDeck = new Deck();
		for (int i = 0; i < n; i++) {
			newDeck.add(removeLast());
		}
		return newDeck;
	}

	// returns true if and only if this deck contains the speciﬁed card.
	public boolean contains(Card card) {
		return deck.contains(card);

	}

	// returns true if and only if this deck contains all the cards in the speciﬁed
	// deck.
	public boolean containsAll(Deck other) {
		boolean good = true;
		for (int i = 0; i < other.size(); i++) {
			if (!deck.contains(other.get(i))) {
				good = false;
			}
		}
		return good;
	}

	/*
	 * returns true if and only if this deck is a discardable kind. Speciﬁcally, the
	 * method returns true if this deck has at least two cards and all the cards
	 * have the same rank. Otherwise, the method returns false.
	 */
	public boolean isKind() {
		boolean good = true;
		if (deck.size() <= 1) {
			System.out.println("Invalid input. Discardable set needs to have at least 2 cards.");
			good = false;
		} else {
			for (int i = 0; i < deck.size() - 1; i++) {
				if (deck.get(i).getRank() != this.deck.get(i + 1).getRank()) {
					good = false;
				}
			}
		}
		return good;
	}

	/*
	 * returns true if and only if this deck is a discardable sequence. Speciﬁcally,
	 * the method returns true if this deck has at least three cards, the cards all
	 * have the same suit, the cards form a sequence of consecutive ranks.
	 * Otherwise, the method returns false.
	 */
	public boolean isSeq() {
		boolean good = true;
		if (deck.size() < 3) {
			System.out.println("Invalid sequence. Discardable sequence needs to have at least 3 cards.");
			good = false;
		} else {
			for (int i = 0; i < deck.size() - 1; i++) {
				if (deck.get(i).getSuit() != deck.get(i + 1).getSuit()) {
					good = false;
				}
			}
			if (!good) {
				System.out.println("Invalid sequence. Cards are not of same suit.");
			} else {
				sortByRank();
				for (int i = 0; i < this.deck.size() - 1; i++) {
					if (deck.get(i).getRank() != deck.get(i + 1).getRank() - 1) {
						System.out.println(
								"Invalid sequence. While the cards are of the same suit, the ranks are not consecutive integers.");
						good = false;
					}
				}
			}
		}
		return good;

	}

	// sorts the cards of this deck by rank.
	public void sortByRank() {
		// insertion sort
		Card small;
		for (int i = 1; i < deck.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (deck.get(j).getRank() < deck.get(j - 1).getRank()) {
					small = deck.get(j);
					deck.set(j, deck.get(j - 1));
					deck.set(j - 1, small);
				}
			}
		}

	}

	// sorts the cards of this deck by suit.
	public void sortBySuit() {
		sortByRank();
		// insertion sort
		Card small;
		for (int i = 1; i < deck.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (deck.get(j).getSuit() < deck.get(j - 1).getSuit()) {
					small = deck.get(j);
					deck.set(j, deck.get(j - 1));
					deck.set(j - 1, small);
				}
			}
		}
	}

	/*
	 * prints the content of this deck in two ways. First, the content is printed by
	 * suit. Next, the content is printed by rank. Please note that this method has
	 * a side eﬀect, the order of the cards is not preserved. Consequently, the
	 * method should not be called on the main deck during a game!
	 */
	public void print() {
		System.out.println("Here is your new deck printed in two ways:");
		sortBySuit();
		System.out.println(deck);
		sortByRank();
		System.out.println(deck);
	}

	// returns a string representation that contains all the cards in this deck.
	public String toString() {
		String a = " ";
		a = "Deck [";
		if (!deck.isEmpty()) {
			for (int i = 0; i < deck.size(); i++) {
				if (i == deck.size() - 1) {
					a = a + deck.get(i).toString() + "]";
				} else {
					a = a + deck.get(i).toString() + ", ";
				}
			}
		} else {
			a = a + "]";
		}

		return a;
	}

}

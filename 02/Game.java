
// Public class Game implements the logic of Rummy Card Game
public class Game {
	private Deck main; // the main deck
	private Deck hand; // player's hand
	private Die dice;
	private int round = 0;

	// constructor that creates the main deck and the die
	public Game(int rank) {
		main = new Deck(rank);
		dice = new Die();
	}

	public void play() {
		Card card;
		boolean done = true;

		main.shuﬄe(); // shuffles the main deck
		hand = main.deal(7); // the player is dealt 7 cards at the start of the game
		hand.print();

		// main while loop - while the player still has cards in his/her deck
		while (hand.hasCards()) {
			round++;
			if (main.size() != 0) { // non-empty deck phase
				System.out.println("Rolling the die!");
				dice.roll();
				System.out.println("The die has value " + Integer.toString(dice.getValue()));

				if (dice.getValue() == 1) { // when die is 1
					while (done) {
						System.out.println("Discard any card of your choosing");
						System.out.println("Which card would you like to discard?");
						card = Utils.readCard();
						if (hand.contains(card)) {
							hand.remove(card);
							hand.print();
							done = false;
						} else {
							System.out.println("No such card in your hand. Try again.");
						}
					}
				} else { // when die is a number other than 1
					System.out.println("Since you rolled " + Integer.toString(dice.getValue()) + ", the following "
							+ Integer.toString(dice.getValue()) + " or " + Integer.toString(main.size())
							+ " (if the deck has less than " + Integer.toString(dice.getValue()) + " cards) "
							+ "will be added to your hand from the top of the deck.\n");
					if (main.size() < dice.getValue()) { // main deck has less cards than the number of cards that are
															// supposed to be dealt
						hand.addAll(main);
					} else { // main deck has enough cards to deal "dice" number of cards
						Deck a = main.deal(dice.getValue());
						hand.addAll(a);
					}
					hand.print();
					while (Utils.readYesOrNo(
							"Yes or no, do you have a sequences of three or more cards of the same suit or two or more of a kind? ")) {
						Deck discardable = Utils
								.readCards("Which 3+ sequence or 2+ of a kind would you like to discard?");

						// cards are removed from the player's hand if they exist in the deck and form
						// either a sequence or of a kind
						if (hand.containsAll(discardable) && (discardable.isKind() || discardable.isSeq())) {
							hand.removeAll(discardable);
							hand.print();
						} else {
							System.out.println("Cannot discard those cards!");
						}
					}
				}
			} else { // the main deck has no cards, hence the game is in emtpy deck phase
				System.out.println("The game is in empty deck phase.");
				boolean done2 = true;
				while (done2) {
					System.out.println("Which card would you like to discard");
					card = Utils.readCard();
					if (hand.contains(card)) {
						hand.remove(card);
						done2 = false;
						if (hand.size() != 0) {
							hand.print();
						}

					} else {
						System.out.println("No such card in your hand. Try again.");
					}
				}
			}

		}
		System.out.println("\nGAME IS OVER");
		System.out.println("You completed the game in " + Integer.toString(round) + " rounds!");
	}
}

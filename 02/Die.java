import java.util.Random;

// Public class that represents a Die
public class Die {
	private int dice;
	public static final int MAXVALUE = 6;
	Random rand = new Random();

	// constructor
	public Die() {
		dice = rand.nextInt(6) + 1; //stores a random int between 1 and 6
	}

	// getter
	public int getValue() {
		return dice;
	}

	// randomly assigns a number between 1 and MAXVALUE(which is initialized as 6) to dice
	public void roll() {
		dice = rand.nextInt(MAXVALUE) + 1;
	}

	// String representation of an object of type Die
	public String toString() {
		return "Die{value:" + Integer.toString(dice) + "}";
	}
}

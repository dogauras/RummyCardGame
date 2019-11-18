public class Utils {

	// Function to display an array of doubles
	public static void displayArray(double[] xs) {

		System.out.print("[");
		for (int i = 0; i < xs.length; i++) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(xs[i]);
		}
		System.out.println("]");

	}

	// Function to display an array of Strings
	public static void displayArray(String[] xs) {

		System.out.print("[");
		for (int i = 0; i < xs.length; i++) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(xs[i]);
		}
		System.out.println("]");

	}

	// The method prints "success" on the standard output if <code>result</code> and
	// <code>expected</code> are equals, and error message otherwise.
	public static void assertEquals(int result, int expected) {

		if (result == expected) {
			System.out.println("Success!");
		} else {
			System.out.println("Fail: expected value = " + expected + ", actual value = " + result);
		}

	}

	// The method prints "success" on the standard output if <code>result</code> and
	// <code>expected</code> are equals, and error message otherwise.
	public static void assertEquals(boolean result, boolean expected) {

		if (result == expected) {
			System.out.println("Success!");
		} else {
			System.out.println("Fail: expected value = " + expected + ", actual value = " + result);
		}

	}
}

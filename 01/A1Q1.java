// Question 1 of Assignment 1
public class A1Q1 {

	// takes as input the reference of an array of numbers (all of type double) and
	// returns the number
	// of elements of the designated array that are positive (i.e. > 0).
	public static int countPositive(double[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) { // checks if the element at index i is positive
				counter++; // increments the counter by one
			}
		}
		return counter; // counter is returned
	}

}

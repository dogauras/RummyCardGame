// Question 2 of Assignment 1
public class A1Q2 {
	// takes as input the reference of an array of numbers (all of type double) and returns true
	// if the given array has at least one run (of length at least two) of repeated
	// and consecutive values, and false otherwise.
	public static boolean hasLengthTwoRun(double[] num) {
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] == num[i + 1]) {
				return true; // true is returned as soon as two elements of the array are the same
			}
		}
		return false; // returns false if ever this line is reached
	}
}

// Question 3 of Assignment 1
public class A1Q3 {
	
	//takes as input the reference of an array of numbers (all of type double) and returns the length of the longest run.
	public static int getLongestRun(double[] num) {
		if (num.length == 0) { // empty array situation
			return 0;
		}

		int i = 0;
		int max_length = 1;
		while (i < num.length - 1) {
			int length = 1;
			while (i < num.length - 1 && num[i] == num[i + 1]) { // checks if two consecutive elements of the array are the same
				length++; // if yes, increments length by one
				i++; // increments index by one
			}
			if (length > max_length) { 
				max_length = length; //sets the max lenght to current length obtained
			}
			i++; // increments the index in case the while loop isn't entered
		}
		return max_length;
	}
	
	//takes as input the reference of an array of strings (objects of the class String) and returns the length of the longest run.
	public static int getLongestRun(String[] words) {
		if (words.length == 0) {
			return 0;
		}

		int i = 0;
		int max_length = 1;
		while (i < words.length - 1) {
			int length = 1;
			while (i < words.length - 1 && (words[i].compareTo(words[i + 1])) == 0) {
				length++;
				i++;
			}
			if (length > max_length) {
				max_length = length;
			}
			i++;
		}
		return max_length;
	}

}


public class A1Q2Test {
	public static void main(String[] args) {

		double[] a;

		// StudentInfo.display();

		System.out.println("Testing A1Q2.hasLengthTwoRun:");
		System.out.println();

		a = new double[] { 1.0, 4.0, 3.0, 3.0, 4.0 };

		System.out.print("Test case: ");
		Utils.displayArray(a);

		Utils.assertEquals(A1Q2.hasLengthTwoRun(a), true);

		System.out.println();

		a = new double[] { 1.0, 2.0, 3.0, 3.0, 3.0, 4.5, 6.0, 5.0 };

		System.out.print("Test case: ");
		Utils.displayArray(a);

		Utils.assertEquals(A1Q2.hasLengthTwoRun(a), true);

		System.out.println();

		a = new double[] { 1.0, 2.0, 3.7, 4.0, 3.0, 2.0 };

		System.out.print("Test case: ");
		Utils.displayArray(a);

		Utils.assertEquals(A1Q2.hasLengthTwoRun(a), false);

		System.out.println();

		a = new double[] { 7.7 };

		System.out.print("Test case: ");
		Utils.displayArray(a);

		Utils.assertEquals(A1Q2.hasLengthTwoRun(a), false);

		System.out.println();

		a = new double[] { 2.7, 1.0, 1.0, 0.5, 3.0, 1.0 };

		System.out.print("Test case: ");
		Utils.displayArray(a);

		Utils.assertEquals(A1Q2.hasLengthTwoRun(a), true);

	}
}

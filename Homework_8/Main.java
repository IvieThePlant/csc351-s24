public class Main {
	public static void main(String[] args) {
		// Makes A, and sort using Counting sort
		Integer[] A = { 3, 2, 5, 8, 0, 1, 7, 4, 2, 10, 3, 9 };
		Counting.sort(A);

		// prints the values and makes sure they are sorted!
		for (Integer x : A) {
			System.out.print(x);
		}

		System.out.println();

		Integer[] B = { 3, 2, 5, 8, 0, 1, 7, 4, 2, 10, 3, 9 };
		Merge.sort(B, 0, B.length - 1);

		// prints the values and makes sure they are sorted!
		for (Integer x : B) {
			System.out.print(x);
		}
	}
}

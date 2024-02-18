public class Main {
	public static void main(String[] args) {
		// Makes A, and sort using Counting sort
		Integer[] A = { 3, 2, 5, 8, 0, 1, 7, 4, 2, 10, 3, 9 };
		Counting.sort(A);

		// prints the values and makes sure they are sorted!
		System.out.print(A.toString());

		Integer[] B = { 3, 2, 5, 8, 0, 1, 7, 4, 2, 10, 3, 9 };
		Merge.sort(B, 0, B.length - 1);
		// print the values and make sure they are sorted!
	}
}

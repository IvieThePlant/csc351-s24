public class Counting {
	public static void sort(Integer[] A) {
		// Find the Max Value
		int k = A[0];
		for (int val : A) {
			if (val > k) {
				k = val;
			}
		}

		// Declare 2 empty arrays
		Integer[] B = new Integer[A.length];
		Integer[] C = new Integer[k + 1];

		// Initilizing 0 values in C
		for (int i = 0; i < C.length; i++) {
			C[i] = 0;
		}

		// Create Histogram of A in C
		for (int j = 0; j < A.length; j++) {
			C[A[j]] = C[A[j]] + 1;
		}

		// Sum values preceding each index of C (values' spots in sorted array)
		for (int i = 1; i < C.length; i++) {
			C[i] = C[i] + C[i - 1];
		}

		// Using addresses from C, place values sorted into B
		for (int j = A.length - 1; j >= 0; j--) {
			B[C[A[j]] - 1] = A[j];
			C[A[j]] = C[A[j]] - 1;
		}

		// Copy sorted B back onto A
		for (int i = 0; i < A.length; i++) {
			A[i] = B[i];
		}
	}
}

public class Merge {
    // Recurivly splits array in half
    public static void sort(Integer[] A, int p, int r) {
        if (p < r) {
            // Finds where to bisect subarray from p to r
            int q = (p + r) / 2;

            sort(A, p, q);
            sort(A, q + 1, r);
            squish(A, p, q, r);
        }
    }

    // Sorts two half lists back together.
    public static void squish(Integer[] A, int p, int q, int r) {
        // Find the lengths of each half
        int nOne = q - p + 1;
        int nTwo = r - q;

        // Create empty arrays to store each half
        Integer[] Left = new Integer[nOne + 1];
        Integer[] Right = new Integer[nTwo + 1];

        // Copy halves into subarrays
        for (int i = 0; i < nOne; i++) {
            Left[i] = A[p + i];
        }
        for (int j = 0; j < nTwo; j++) {
            Right[j] = A[q + j + 1];
        }

        // Set the last value of each half to infinity
        Left[nOne] = 999999;
        Right[nTwo] = 999999;

        // Initialize two pointers starting at each half
        int i = 0;
        int j = 0;

        // Merge two halves at each index
        for (int k = p; k <= r; k++) {
            // Take the next lowest value from either half
            if (Left[i] <= Right[j]) {
                A[k] = Left[i];
                i++;
            } else {
                A[k] = Right[j];
                j = j + 1;
            }
        }
    }
}

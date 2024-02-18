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
        int none = q - p + 1;
        int ntwo = r - q;

        // Create empty arrays to store each half
        Integer[] Left  = new Integer[none+1];
        Integer[] Right = new Integer[ntwo+1];

        // Copy halves into subarrays
        for (int i = 0; i <= none; i++) {
            Left[i]  = A[p+i];
        }
        for (int j = 0; j <= ntwo; j++) {
            Right[j] = A[q+j];
        }

        // Set the last value of each half to infinity
        Left[none]  = 999999999;
        Right[ntwo] = 999999999;

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

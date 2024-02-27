import java.util.Comparator;

/** Merge Sort divide-and-conquer recursive algorithm */
public class Merge<T> implements Sorter<T> {

    /** Establishes ordering of type T */
    private Comparator<T> orderBy;

    /** Counter of compare operations */
    long count = 0;

    /**
     * Constructor for Merge Sort to set comparator
     *
     * @param order Comparator to establish ordering of array elements.
     */
    public Merge(Comparator<T> order) {
        orderBy = order;
    }

    /**
     * Sorts specified array using Merge Sort
     *
     * @param array Array to be sorted.
     */
    @Override
    public void sort(T[] array) {

        // Reset count back to 0
        count = 0;

        reSort(array, 0, array.length);

    } // end sort(T[])

    // Recurivly splits array in half
    public void reSort(T[] A, int p, int r) {
        if (p < r) {
            // Finds where to bisect subarray from p to r
            int q = (p + r) / 2;

            reSort(A, p, q);
            reSort(A, q + 1, r);
            squish(A, p, q, r);
        }
        count++;
    }

    // Sorts two half lists back together.
    public void squish(T[] A, int p, int q, int r) {
        // Find the lengths of each half
        int nOne = q - p + 1;
        int nTwo = r - q;

        // Create empty arrays to store each half
        @SuppressWarnings("Unchecked")
        T[] Left = (T[]) new Object[nOne];
        @SuppressWarnings("Unchecked")
        T[] Right = (T[]) new Object[nTwo];

        // Copy halves into subarrays
        for (int i = 0; i < nOne; i++) {
            Left[i] = A[p + i];
        }
        for (int j = 0; j < nTwo; j++) {
            Right[j] = A[q + j + 1];
        }

        // Initialize two pointers starting at each half
        int i = 0;
        int j = 0;

        // Merge two halves at each index
        for (int k = p; k <= r; k++) {
            if (i == Left.length) {
                System.arraycopy(Right, j, A, k, Right.length - j);
                break;
            } else if (j == Right.length) {
                System.arraycopy(Left, i, A, k, Left.length - i);
                break;
            } else if (0 > orderBy.compare(Left[i], Right[j])) { // Take the next lowest value from either half
                A[k] = Left[i];
                i++;
            } else {
                A[k] = Right[j];
                j++;
            }
            count++;
        }
    }

    @Override
    public void setComparator(Comparator<T> order) {
        orderBy = order;
    }

    @Override
    public long getCount() {
        return count;
    }
} // end class Merge

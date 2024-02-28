import java.util.Comparator;

/** Insertion sort - an in-place sorting algorithm */
public class Insertion<T> implements Sorter<T> {

    /** Establishes ordering of type T */
    private Comparator<T> orderBy;

    /** Counter of compare operations */
    long count = 0;

    /**
     * Constructor for Insertion Sort to set comparator
     *
     * @param order Comparator to establish ordering of array elements.
     */
    public Insertion(Comparator<T> order) {
        orderBy = order;
    }

    /**
     * Sorts specified array using Insertion Sort. Inplace sorter.
     *
     * @param array Array to be sorted.
     */
    public void sort(T[] array) {

        // Reset count back to 0
        count = 0;

        for (int j = 1; j < array.length; j++) {
            // Insert A[j] into the sorted sequence A[0...j-1]
            T key = array[j];
            int i = j - 1;
            while (i >= 0 && 0 < orderBy.compare(array[i], key)) {
                count++;
                array[i + 1] = array[i];
                i--;
            }
            count++;
            array[i + 1] = key;
        }
    } // end sort(T[])

    @Override
    public void setComparator(Comparator<T> order) {
        orderBy = order;
    }

    @Override
    public long getCount() {
        return count;
    }
} // end class Insertion

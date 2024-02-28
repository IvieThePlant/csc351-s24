import java.util.function.Function;
import java.util.*;

/** Counting Sort assumes key of type Integer */
public class Counting<T> implements Sorter<T> {

    /** Extracts the key from an object in the array */
    Function<T, Integer> keyGetter = null;

    /** Max Value in the array to be sorted */
    Integer maxValue = null;

    /** Counter of loop iterations */
    long count = 0;

    /** Default empty constructor. */
    public Counting() {
    }

    /**
     * Constructor for Counting
     *
     * @param order Comparator to establish ordering of array elements.
     */
    public Counting(Function<T, Integer> getter) {
        keyGetter = getter;
    }

    /**
     * Constructor for Counting with known max value
     *
     * @param order Comparator to establish ordering of array elements.
     */
    public Counting(Function<T, Integer> getter, Integer maximum) {
        keyGetter = getter;
        this.maxValue = maximum;
    }

    /**
     * Sorts specified array using Counting Sort. Inplace version of the sorter.
     *
     * @param array Array to be sorted.
     */
    @Override
    public void sort(T[] array) {
        /*
         * Counting sort is not an in-place sorting algorithm.
         * To work around this, first the contents of array are copied
         * into another array called "unsorted", which is the "A" array.
         * When it is time to place the contents into the "B" array,
         * copy them from the unsorted "A" array into "array".
         */
        @SuppressWarnings("unchecked")
        T[] unsorted = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            unsorted[i] = array[i];
        }

        // Find the Max Value
        int k = findMax(unsorted);

        // Declare an empty array
        Integer[] C = new Integer[k + 1];

        // Initilizing 0 values in C
        for (int i = 0; i < C.length; i++) {
            C[i] = 0;
        }

        // Create Histogram of A in C
        for (int j = 0; j < unsorted.length; j++) {
            C[keyGetter.apply(unsorted[j])] = C[keyGetter.apply(unsorted[j])] + 1;
            count++;
        }

        // Sum values preceding each index of C (values' spots in sorted array)
        for (int i = 1; i < C.length; i++) {
            C[i] = C[i] + C[i - 1];
            count++;
        }

        // Using addresses from C, place values sorted into B
        for (int j = unsorted.length - 1; j >= 0; j--) {
            array[C[keyGetter.apply(unsorted[j])] - 1] = unsorted[j];
            C[keyGetter.apply(unsorted[j])] = C[keyGetter.apply(unsorted[j])] - 1;
            count++;
        }

    } // end sort(T[])

    private Integer findMax(T[] array) {
        Integer max = keyGetter.apply(array[0]);
        for (T element : array) {
            Integer valueOf = keyGetter.apply(element);
            if (valueOf > max) {
                max = valueOf;
            }
            count++;
        }
        return max;
    } // end findMax()

    public void setKeyGetter(Function<T, Integer> getter) {
        keyGetter = getter;
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void setComparator(Comparator<T> c) {
        // not relevant for counting sort
    }
} // end class Countin

import java.util.Comparator;

public class TimSort<T> implements Sorter<T> {

    /** Establishes ordering of type T */
    private Comparator<T> orderBy;

    /** Counter of compare operations */
    long count = 0;

    /** Minimum # of values to merge */
    int MIN_MERGE = 32;

    /**
     * Constructor for TimSort to set comparator
     *
     * @param order Comparator to establish ordering of array elements.
     */
    public TimSort(Comparator<T> order) {
        orderBy = order;
    }

    public int minRunLength(int n) {

        // Checks length to make sure valid
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    // Generic sorting method
    public void sort(T[] array) {
        sort(array, array.length);
    }

    // Iterative TimSort function to sort the
    // array[0...n-1] (similar to merge sort)
    public void sort(T[] array, int n) {

        // Reset count
        count = 0;

        // Create objects to reuse
        Insertion<T> algoInsert = new Insertion<>(orderBy);
        Merge<T> algoMerge = new Merge<>(orderBy);

        int minRun = minRunLength(MIN_MERGE);

        // Sort individual subarrays of size RUN
        for (int i = 0; i < n; i += minRun) {
            int r = Math.min((i + MIN_MERGE - 1), (n - 1));
            algoInsert.sort(array, i, r);
        }

        // Start merging from size RUN (or 32).
        // It will merge to the form size 64,
        // then 128, 256, and so on...

        for (int size = minRun; size < n; size = 2 * size) {

            // Pick starting point of left sub array.
            // We are going to merge array[left...left+size-1]
            // and array[left+size, left+2*size-1]
            // After every merge, we increase left by 2*size
            for (int left = 0; left < n; left += 2 * size) {

                // Find ending point of left subarray
                // mid+1 is starting point of right subarray
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // Merge subarray array[left...mid] & array[mid+1...right]
                if (mid < right) {
                    algoMerge.squish(array, left, mid, right);
                }
            }
        }

        // Tally total operations from Insertion and Merge
        count += algoInsert.getCount() + algoMerge.getCount();
    }

    @Override
    public void setComparator(Comparator<T> order) {
        orderBy = order;
    }

    @Override
    public long getCount() {
        return count;
    }

}

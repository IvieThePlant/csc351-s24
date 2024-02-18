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

    }
}

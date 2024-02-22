import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

public class List<T> {

    /** Basic data structure for holding list items */
    private T[] items;

    /** Current count of items in the list */
    private int count = 0;

    /** Size of all lists created (not dynamic) */
    private final int DEFAULT_SIZE = 50;

    /** Constructor to create new array of T items */
    public List() {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[DEFAULT_SIZE];
        items = temp;
    }

    /** Is it empty? */
    public boolean empty() {
        return count==0;
    }

    /** Is it full? */
    public boolean full() {
        return count==items.length;
    }

    @Override
    public String toString() {
        String astring = "";
        for (int i=0; i<count; i++) {
            astring += items[i];
        }
        return astring;
    }

    /** Add specified item to the end of the List (if not full)
     * @param item to be added
     */
    public void add(T item) {
        if (full()) {
            return;
        }
        // Add to the end. Maintain the count
        items[count] = item;
        count++;
    }

    /** Find all items that are a match (as determined by the function)
     * @param fn Function used to extract a field and compare to a field value
     * @return list of times (in List) whose field value is a match
     */
    public ArrayList<T> query(Function<T,Boolean> fn) {
        ArrayList<T> found = new ArrayList<T>();
        
        // TODO -- fill the ArrayList with elements that meet the criteria of fn
        // Remember to iterate up to count, not the length of items

        return found;
    }
}
public class Queue<T> implements QueueInterface<T> {

    T[] queue;

    /* Index of the first element in the Queue */
    private int head;

    /* Index of the location to place the next added value */
    private int tail;

    /**
     * Default Constuctor
     * Creates a circular array with a capacity of 10
     */
    public Queue() {
        this(10);
    } // end Queue()

    /**
     * Creates a circular array of the given size,
     * as well as an additional spot for the tail sentinel
     * 
     * @param capacity Max number of elements allowed to be stored in circular array
     */
    public Queue(int capacity) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[capacity + 1];
        queue = temp;
    } // end Queue(capacity)

    @Override
    /**
     * Converts the Queue to a string
     * 
     * @return String of each element, separated by commas
     */
    public String toString() {
        String asw = "";
        for (T el : queue) {
            asw += el.toString() + ", ";
        }
        return asw;
    } // end toString()

    /**
     * Returns the next index after the given
     * 
     * @param idx The starting index
     * @return Int index directly after given idx in the circular array
     */
    public int next(int idx) {
        return (idx + 1) % queue.length;
    } // end next()

    /*
     * Returns the first element in the Queue
     */
    public T peek() {
        return queue[head];
    }

    /**
     * Checks to see if Queue is full
     * 
     * @return True if tail sentinel is one away from head
     */
    public boolean isFull() {
        return (head == next(tail));
    } // end isFull()

    /**
     * Checks to see if Queue is empty
     * 
     * @return True if tail sentinel is at the head
     */
    public boolean isEmpty() {
        return head == tail;
    } // end isEmpty()

    /**
     * If the Queue isn't full, add element at tail,
     * then increments tail sentinel
     * 
     * @param value The value to be added to the Queue
     */
    public void push(T value) {
        if (isFull()) {
        } else {
            queue[tail] = value;
            tail = next(tail);
        }
    } // end push(value)

    // TODO: Write pop(), removes and returns first element in Queue
    /**
     * Removes the first element of the Queue, and returns it
     * 
     * @return First element of Queue, or null if empty
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T temp = queue[head];
            head = next(head);
            return temp;
        }
    } // end pop()

    // -----GETTERS-----
    public int head() {
        return head;
    }

    public int tail() {
        return tail;
    }
}

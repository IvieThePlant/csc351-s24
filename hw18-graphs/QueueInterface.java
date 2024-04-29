/** Defines the methods for any type of Queue - FIFO, LIFO, priority */
public interface QueueInterface<T> {

    /*
     * Add a value to the end of the Queue
     */
    public void push(T value);

    /*
     * Remove the next value form the queue
     */
    public T pop();

    /*
     * Look at the next value on the queue
     */
    public T peek();

    /*
     * True if Queue is empty
     */
    public boolean isEmpty();
}
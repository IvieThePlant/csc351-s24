public class Stack<T> implements QueueInterface<T> {
    /* Pointer to the top of the Stack */
    private Node head;

    /* Number of elements in the Stack */
    private int count;

    /**
     * Default Constuctor
     */
    public Stack() {
        count = 0;
    } // end Stack()

    /**
     * Constructor for one inital value
     * 
     * @param initValue T value to initalize Stack with
     */
    public Stack(T initValue) {
        this();
        head = new Node(initValue);
    } // end Stack(initValue)

    /**
     * Constructor for an array of inital values
     * 
     * @param initValues T values to add to stack
     */
    public Stack(T[] initValues) {
        for (T initValue : initValues) {
            push(initValue);
        }
    } // end Stack(initValues)

    /**
     * Converts Stack to String
     * 
     * @return String of all values in stack, from top to bottom
     */
    public String toString() {
        String asw = "";
        Node pointer = head;
        while (pointer != null) {
            asw += pointer.value;
            pointer = pointer.next;
        }
        return asw;
    } // end toString()

    /**
     * Checks to see if the Stack is empty
     * 
     * @return True if Stack empty
     */
    public boolean isEmpty() {
        return (peek() == null);
    } // end isEmpty()

    /**
     * Adds value to the top of the Stack
     * 
     * @param value T element to add to Stack
     */
    public void push(T value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        count++;
    } // end push(value)

    /**
     * Removes and returns the top value of the Stack
     * 
     * @return T value from top of Stack
     */
    public T pop() {
        Node temp = head;
        head = head.next;
        return temp.value;
    } // end pop()

    /**
     * Read top value of Stack without removing
     * 
     * @return T value on top of Stack
     */
    public T peek() {
        return head.value;
    } // end peek()

    private class Node {
        /* Stores Node's data */
        private T value;

        /* Points to the next Node in Stack */
        private Node next;

        /**
         * Constructor for Nodes
         * 
         * @param initValue Value to store in newly created Node
         */
        public Node(T initValue) {
            value = initValue;
        } // end Node(initValue)

    }

}

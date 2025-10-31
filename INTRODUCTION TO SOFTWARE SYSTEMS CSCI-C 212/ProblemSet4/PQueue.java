// Exercise 4.20

import java.util.Objects;

class PQueue<T> {

    private static class Node<T>{
        private T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value){
            this.value = value;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int elements;

    PQueue(){
        this.first = null;
        this.last = null;
        this.elements = 0;
    }

    /**
     * Overridden equals method to compare based on fields and not the memory location
     *
     * @param obj input object
     * @return true if the two PQueues are equal, false if not
     */
    @Override
    public boolean equals(Object obj) {
        if( !(obj instanceof PQueue)){
            return false;
        }
        PQueue othPQueue = (PQueue<T>) obj;

        Node<T> curr = this.first;
        Node<T> othCurr = othPQueue.first;
        while ( curr != null && othCurr != null) {
            if (!curr.value.equals(othCurr.value)) {
                return false;
            }
            curr = curr.next;
            othCurr = othCurr.next;
        }
        if((curr != null && othCurr == null) || (curr == null && othCurr != null)){
            return false;
        }
        return true;
    }

    /**
     *Overridden hashCode method to produce a code based on the fields and not the object
     *
     * @return hashCode from fields
     */
    @Override
    public int hashCode() {
        int hash = 1;
        Node<T> curr = this.first;

        while (curr != null) {
            //use 31, a prime number, to distribute the values of hash codes more evenly, according to online doccumentation
            hash = 31 * hash + (curr.value == null ? 0 : curr.value.hashCode());
            curr = curr.next;
        }

        return hash;
    }

    /**
     * Enqueues a value onto the end of a new queue containing all the old elements, in addition to the new value
     *
     * @param t input generic value node to add
     * @return PQueue with t added to the end
     */
    PQueue<T> enqueue(T t) {
        PQueue<T> newQueue = this.copy();
        Node<T> newNode = new Node<>(t);
        if(newQueue.first == null){
            newQueue.first = newNode;
        }
        else{
            newNode.prev = newQueue.last;
            newQueue.last.next = newNode;
        }
        newQueue.last = newNode;
        newQueue.elements++;
        return newQueue;
    }

    /**
     * Dequeues a value from the start of a new queue containing all the old elements
     *
     * @return PQueue with first node removed
     */
    PQueue<T> dequeue() {
        //add test for first element, cant set prev if no elements exist
        PQueue<T> newQueue = this.copy();
        if(newQueue.first == null){
            return newQueue;
        }
        if(this.size() == 1){
            newQueue.first = null;
            newQueue.last = newQueue.first;
        }
        else{
            newQueue.first = newQueue.first.next;
            newQueue.first.prev = null;
        }
        newQueue.elements --;
        return newQueue;
    }

    /**
     * Returns the first element in the queue
     *
     * @return first node in this queue
     */
    T peek() {
        if( this.size() ==0 ){
            return null;
        }
        return this.first.value;
    }

    /**
     * Creates a queue with the given vals
     *
     * @param vals input generic variadic element values
     * @return new queue containing the given values in nodes
     * @param <T> Generic type T of the queue and nodes within it
     */
    static <T> PQueue<T> of(T... vals) {
        PQueue<T> newQueue = new PQueue<>();

        for( T val : vals) {
            if( newQueue.first == null){
                newQueue.first = new Node<T>(val);
                newQueue.last = newQueue.first;
            }
            else{
                Node<T> newNode = new Node<>(val);

                newNode.prev = newQueue.last;
                newQueue.last.next = newNode;

                newQueue.last = newNode;
            }
            newQueue.elements++;
        }
        return newQueue;
    }

    /**
     * Size of the queue
     *
     * @return number of elements
     */
    int size() {
        return this.elements;
    }

    /**
     * Returns a new que with the same elements as the current PQueue
     *
     * @return copied PQueue
     */
    private PQueue<T> copy() {
        if(this.size() == 0){
            return new PQueue<>();
        }
        PQueue<T> copyQueue = new PQueue<>();
        copyQueue.first = new Node<>(this.first.value);
        copyQueue.last  = copyQueue.first;

        copyQueue.elements++;
        Node<T> curr = this.first.next;

        while(curr != null){
            Node<T> newNode = new Node<>(curr.value);

            newNode.prev = copyQueue.last;
            copyQueue.last.next = newNode;

            copyQueue.last = newNode;
            curr = curr.next;

            copyQueue.elements++;
        }

        return copyQueue;
    }
}

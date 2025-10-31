public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // Add to front
    public void addFirst(T val) {
        if (isEmpty()) {
            head = new Node<>(val);
            tail = head;
        } else {
            Node<T> newFirst = new Node<>(val);
            newFirst.next = head;
            head = newFirst;
        }
        size++;
    }

    // Remove first element
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return temp.data;
    }

    // Add to end
    public void addLast(T val) {
        if(isEmpty()){
            head = new Node<>(val);
            tail = head;
        }
        else{
            Node<T> newLast = new Node<>(val);
            tail.next = newLast;
            tail = newLast;
        }
        size++;
    }

    // Get value at index
    public T get(int index) {
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }
}
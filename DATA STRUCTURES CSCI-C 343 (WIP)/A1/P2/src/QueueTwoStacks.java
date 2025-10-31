import exceptions.EmptyQueueE;
import exceptions.EmptyStackE;
import interfaces.QueueI;
import org.jetbrains.annotations.NotNull;

/**
 * QueueTwoStacks is a class that implements a queue using two stacks.
 * The queue behavior requires insertions at one end and deletions at the other.
 * Here we use two stacks to simulate the queue behavior. The inbox stack is used
 * to enqueue elements and the outbox stack is used to dequeue elements. When the
 * outbox stack is empty, we pop all elements from the inbox stack and push them
 * onto the outbox stack. This way, the elements are reversed and we can pop them
 * in the correct order.
 * <p>
 * The implementation is correct and quite efficient.
 *
 * @param <E> the type of elements in the queue
 */
public class QueueTwoStacks<E> implements QueueI<E> {
    private final @NotNull StackPL<E> inbox;
    private final @NotNull StackPL<E> outbox;

    public QueueTwoStacks() {
        inbox = new StackPL<>();
        outbox = new StackPL<>();
    }

    /**
     * Check if the queue is empty.
     */
    public boolean isEmpty() {
        if(this.outbox.isEmpty()){
            while(!this.inbox.isEmpty()){
                try{
                    this.outbox.push(this.inbox.pop());
                } catch (EmptyStackE e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return this.outbox.isEmpty();
    }

    /**
     * Get the number of elements in the queue.
     */
    public int size() {
        return this.inbox.size() + this.outbox.size();
    }

    /**
     * Enqueue an element into the queue. Just use the inbox stack to push the element.
     */
    public void enqueue(@NotNull E e) {
        this.inbox.push(e);
    }

    /**
     * Dequeue an element from the queue. The default behavior is to pop from
     * the outbox stack. If the outbox stack is empty, pop all elements
     * from the inbox stack and push them onto the outbox stack. Then pop the
     * top element from the outbox stack.
     */
    public E dequeue() throws EmptyQueueE {
        if(this.outbox.isEmpty()){
            while(!this.inbox.isEmpty()){
                try{
                    this.outbox.push(this.inbox.pop());
                } catch (EmptyStackE e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(!this.outbox.isEmpty()){
            try{
                return this.outbox.pop();
            } catch (EmptyStackE e) {
                throw new RuntimeException(e);
            }

        }
        throw new EmptyQueueE();
    }

    /**
     * Peek at the element at the front of the queue. The default behavior is to peek
     * at the top element of the outbox stack. If the outbox stack is empty, pop all
     * elements from the inbox stack and push them onto the outbox stack.
     */
    public E peek() throws EmptyQueueE {
        if(this.outbox.isEmpty()){
            while(!this.inbox.isEmpty()){
                try{
                    this.outbox.push(this.inbox.pop());
                } catch (EmptyStackE e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if(!this.outbox.isEmpty()){
            try{
                return this.outbox.peek();
            } catch (EmptyStackE e) {
                throw new RuntimeException(e);
            }
        }
        throw new EmptyQueueE();
    }
}

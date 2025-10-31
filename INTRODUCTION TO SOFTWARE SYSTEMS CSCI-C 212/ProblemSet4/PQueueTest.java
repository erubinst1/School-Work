import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PQueueTest {

    @Test
    void testEnqueue() {
        PQueue<Integer> pq1 = new PQueue<>();
        pq1 = pq1.enqueue(1);
        Assertions.assertEquals(1, pq1.peek());

        pq1 = pq1.enqueue(3);
        pq1 = pq1.enqueue(2);
        Assertions.assertEquals(1, pq1.peek());

        PQueue<Integer> pq2 = new PQueue<>();
        Assertions.assertEquals( null, pq2.peek());
        pq2 = pq2.enqueue(7);
        Assertions.assertEquals(7, pq2.peek());
    }

    @Test
    void testDequeue() {
        PQueue<Integer> pq1 = new PQueue<>();
        pq1 = pq1.enqueue(1);
        Assertions.assertEquals(1, pq1.peek());
        pq1 = pq1.dequeue();
        Assertions.assertEquals(null, pq1.peek());

        PQueue<Integer> pq2 = new PQueue<>();
        pq2 = pq2.enqueue(1);
        pq2 = pq2.enqueue(2);
        pq2 = pq2.enqueue(3);
        pq2 = pq2.dequeue();
        pq2 = pq2.dequeue();

        Assertions.assertEquals(3, pq2.peek());

        PQueue<Integer> pq3 = new PQueue<>();
        Assertions.assertEquals( null, pq3.peek());

        pq3.dequeue();
        Assertions.assertEquals( null, pq3.peek());

        PQueue<Integer> pq4 = new PQueue<>();
        pq4 = pq4.enqueue(1);
        pq4 = pq4.dequeue();
        pq4 = pq4.enqueue(2);
        pq4 = pq4.enqueue(3);
        pq4 = pq4.dequeue();

        Assertions.assertEquals( 3, pq4.peek());
    }

    @Test
    void testPeek() {
        PQueue<Integer> pq1 = new PQueue<>();
        pq1 = pq1.enqueue(1);
        Assertions.assertEquals(1, pq1.peek());

        pq1 = pq1.dequeue();
        Assertions.assertEquals(null, pq1.peek());

        PQueue<String> pq2 = new PQueue<>();
        pq2 = pq2.enqueue("1");
        pq2 = pq2.enqueue("2");
        pq2 = pq2.enqueue("3");

        Assertions.assertEquals("1", pq2.peek());

        pq2 = pq2.dequeue();
        pq2 = pq2.dequeue();

        Assertions.assertEquals("3", pq2.peek());

        pq2 = pq2.dequeue();

        Assertions.assertEquals(null, pq2.peek());
    }

    @Test
    void testOf() {
        PQueue<Integer> pq1 = new PQueue<>();
        pq1 = pq1.of(1,2,3,4,5);
        Assertions.assertEquals(1, pq1.peek());
        pq1 = pq1.dequeue();
        Assertions.assertEquals(2, pq1.peek());
        pq1 = pq1.dequeue();
        Assertions.assertEquals(3, pq1.peek());
        pq1 = pq1.dequeue();
        Assertions.assertEquals(4, pq1.peek());
        pq1 = pq1.dequeue();
        Assertions.assertEquals(5, pq1.peek());
        pq1 = pq1.dequeue();
        Assertions.assertEquals(null, pq1.peek());

        pq1 = pq1.enqueue(6);
        Assertions.assertEquals(6, pq1.peek());

        PQueue<String> pq2 = new PQueue<>();
        pq2 = pq2.of("1","2","3","4","5");
        Assertions.assertEquals("1", pq2.peek());
        pq2 = pq2.dequeue();
        Assertions.assertEquals("2", pq2.peek());
        pq2 = pq2.dequeue();
        Assertions.assertEquals("3", pq2.peek());
        pq2 = pq2.dequeue();
        Assertions.assertEquals("4", pq2.peek());
        pq2 = pq2.dequeue();
        Assertions.assertEquals("5", pq2.peek());
        pq2 = pq2.dequeue();
        Assertions.assertEquals(null, pq2.peek());

        pq2 = pq2.enqueue("6");
        Assertions.assertEquals("6", pq2.peek());

        PQueue<Integer> pq3 = new PQueue<>();
        pq3 = pq3.of();

        Assertions.assertEquals(null, pq3.peek());
    }

    @Test
    void testEquals() {
        PQueue<Integer> pq1 = new PQueue<>();
        PQueue<Integer> pq2 = new PQueue<>();

        Assertions.assertEquals( pq1, pq2);

        pq1 = pq1.enqueue(1);
        pq1 = pq1.enqueue(2);
        pq1 = pq1.enqueue(3);

        pq2 = pq2.enqueue(1);
        pq2 = pq2.enqueue(2);
        pq2 = pq2.enqueue(3);

        Assertions.assertEquals( pq1, pq2);

        pq1 = pq1.dequeue();
        Assertions.assertNotEquals( pq1, pq2);

        PQueue<String> pq3 = new PQueue<>();
        PQueue<String> pq4 = new PQueue<>();

        Assertions.assertEquals( pq3, pq4);

        pq3 = pq3.enqueue("1");
        pq3 = pq3.enqueue("2");
        pq3 = pq3.enqueue("3");

        pq4 = pq4.enqueue("1");
        pq4 = pq4.enqueue("2");
        pq4 = pq4.enqueue("3");

        Assertions.assertEquals( pq3, pq4);

        pq3 = pq3.dequeue();
        Assertions.assertNotEquals( pq3, pq4);

        PQueue<String> pq5 = new PQueue<>();
        PQueue<Integer> pq6 = new PQueue<>();

        pq5 = pq5.enqueue("1");
        pq6 = pq6.enqueue(1);

        Assertions.assertNotEquals( pq5, pq6);

        PQueue<String> pq7 = new PQueue<>();
        String test = "";

        Assertions.assertNotEquals( test, pq7);
    }
}
import dynamicArray.DequeueA;
import exceptions.EmptyDequeueE;
import interfaces.DequeueI;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import pointers.DequeueP;

import static org.junit.jupiter.api.Assertions.*;

public class TODOTest {

    @Test
    void testMod () {
        int a = 10;
        int b = 12;
        System.out.println((10 + 5) % b);
        System.out.println((3 - 5) % b);
        System.out.println(Math.floorMod(10 + 5, b));
        System.out.println(Math.floorMod(3 - 5, b));
    }

    @Test
    void test1() throws EmptyDequeueE {
        // write a test for dynamic arrays without resizing
        // make sure that enqueue / dequeue works as expected
        // from both directions
        DequeueA<Integer> dq1 = new DequeueA<>(25);
        dq1.enqueueFront(1);
        dq1.enqueueBack(2);
        assertEquals(1, dq1.dequeueFront());
        assertEquals(2, dq1.dequeueBack());

        for(int i = 0; i < 10; i++) {
            dq1.enqueueFront(i);
        }
        assertEquals(9, dq1.peekFront());

        for(int i = 10; i >= 0; i--) {
            dq1.enqueueBack(i);
        }
        assertEquals(0, dq1.peekBack());

        for(int i = 9; i >= 0 ; i--) {
            assertEquals(i, dq1.dequeueFront());
        }
        for(int i = 0; i <= 10; i++) {
            assertEquals(i, dq1.dequeueBack());
        }

        assertThrows(EmptyDequeueE.class, () -> dq1.dequeueFront());
        assertThrows(EmptyDequeueE.class, () -> dq1.dequeueBack());
        assertTrue(dq1.isEmpty());
    }

    @Test
    void test2() throws EmptyDequeueE {
        // write a test for dynamic arrays with resizing
        DequeueA<String> dq2 = new DequeueA<>(5);
        dq2.enqueueFront("1");
        dq2.enqueueBack("2");
        assertEquals("1", dq2.dequeueFront());
        assertEquals("2", dq2.dequeueBack());

        for(int i = 0; i < 10; i++) {
            dq2.enqueueFront(""+i);
        }
        assertEquals("9", dq2.peekFront());

        for(int i = 10; i >= 0; i--) {
            dq2.enqueueBack(""+i);
        }
        assertEquals("0", dq2.peekBack());

        for(int i = 9; i >= 0 ; i--) {
            assertEquals(""+i, dq2.dequeueFront());
        }
        for(int i = 0; i <= 10; i++) {
            assertEquals(""+i, dq2.dequeueBack());
        }

        assertThrows(EmptyDequeueE.class, () -> dq2.dequeueFront());
        assertThrows(EmptyDequeueE.class, () -> dq2.dequeueBack());
        assertTrue(dq2.isEmpty());
    }

    @Test
    void test3() throws EmptyDequeueE {
        // write a test for linked list that checks that insertion and deletion from
        // both ends work as expected
        DequeueP<Integer> dq3 = new DequeueP<>();
        dq3.enqueueFront(1);
        dq3.enqueueBack(2);
        assertEquals(1, dq3.dequeueFront());
        assertEquals(2, dq3.dequeueBack());

        for(int i = 0; i < 10; i++) {
            dq3.enqueueFront(i);
        }
        assertEquals(9, dq3.peekFront());

        for(int i = 10; i >= 0; i--) {
            dq3.enqueueBack(i);
        }
        assertEquals(0, dq3.peekBack());

        for(int i = 9; i >= 0 ; i--) {
            assertEquals(i, dq3.dequeueFront());
        }
        for(int i = 0; i <= 10; i++) {
            assertEquals(i, dq3.dequeueBack());
        }

        assertThrows(EmptyDequeueE.class, () -> dq3.dequeueFront());
        assertThrows(EmptyDequeueE.class, () -> dq3.dequeueBack());
        assertTrue(dq3.isEmpty());

        DequeueP<String> dq4 = new DequeueP<>();
        dq4.enqueueFront("1");
        dq4.enqueueBack("2");
        assertEquals("1", dq4.dequeueFront());
        assertEquals("2", dq4.dequeueBack());

        for(int i = 0; i < 10; i++) {
            dq4.enqueueFront(""+i);
        }
        assertEquals("9", dq4.peekFront());

        for(int i = 10; i >= 0; i--) {
            dq4.enqueueBack(""+i);
        }
        assertEquals("0", dq4.peekBack());

        for(int i = 9; i >= 0 ; i--) {
            assertEquals(""+i, dq4.dequeueFront());
        }
        for(int i = 0; i <= 10; i++) {
            assertEquals(""+i, dq4.dequeueBack());
        }

        assertThrows(EmptyDequeueE.class, () -> dq4.dequeueFront());
        assertThrows(EmptyDequeueE.class, () -> dq4.dequeueBack());
        assertTrue(dq4.isEmpty());

    }

    private long timeIt(@NotNull Runnable r) {
        long startTime = System.nanoTime();
        r.run();
        return System.nanoTime() - startTime;
    }

    private @NotNull Runnable makeRunnable(@NotNull DequeueI<Integer> dequeue, int n) {
        return () -> {
            try {
                for (int i = 0; i < n; i++){
                    if(i%2 == 0)
                        dequeue.enqueueFront(i);
                    else
                        dequeue.enqueueBack(i);
                }
                for (int i = 0; i < n; i++){
                    if(i%2 == 0)
                        dequeue.dequeueFront();
                    else
                        dequeue.dequeueBack();
                }
            } catch (EmptyDequeueE ex) {
                throw new Error("Internal bug: EmptyDequeueE should not be thrown in this test");
            }
        };
    }

    @Test
    void test4() {
        // write a test case that compares the performance of dynamic arrays and linked lists
        // for a large number of insertions and deletions
        DequeueA<Integer> dqA = new DequeueA<>(25);
        DequeueP<Integer> dqP = new DequeueP<>();
        int n = 1000000;

        long timeA = timeIt(makeRunnable(dqA, n));
        long timeP = timeIt(makeRunnable(dqP, n));

        System.out.println("Time for DequeueA: " + timeA + " nanoseconds");
        System.out.println("Time for DequeueP: " + timeP + " nanoseconds");
    }



}

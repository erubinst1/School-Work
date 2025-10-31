import exceptions.EmptyQueueE;
import exceptions.EmptyStackE;
import interfaces.QueueI;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueueITest {

    private long timeIt(@NotNull Runnable r) {
        long startTime = System.currentTimeMillis();
        r.run();
        return System.currentTimeMillis() - startTime;
    }

    private @NotNull Runnable makeRunnable(@NotNull QueueI<Integer> queue, int n) {
        return () -> {
            try {
                for (int i = 0; i < n; i++) queue.enqueue(i);
                for (int i = 0; i < n; i++) queue.dequeue();
            } catch (EmptyQueueE ex) {
                throw new Error("Internal bug: EmptyQueueE should not be thrown in this test");
            }
        };
    }

    @Test
    void testSimple() throws EmptyQueueE, EmptyStackE {
        QueuePL<Integer> queuePL = new QueuePL<>();
        QueueTwoStacks<Integer> queueTwoStacks = new QueueTwoStacks<>();
        int n = 10;

        for (int i = 0; i < n; i++) {
            queuePL.enqueue(i);
            queueTwoStacks.enqueue(i);
        }

        for (int i = 0; i < n; i++) {
            try {
                assertEquals(i, queuePL.dequeue());
                assertEquals(i, queueTwoStacks.dequeue());
            } catch (EmptyQueueE ex) {
                throw new Error("Internal bug: EmptyQueueE should not be thrown in this test");
            }
        }

        QueuePL<String> stringQueuePL = new QueuePL<>();
        QueueTwoStacks<String> stringQueueTwoStacks = new QueueTwoStacks<>();
        int x = 100;
        String str = "";

        for (int i = 0; i < x; i++) {
            stringQueuePL.enqueue(str);
            assertEquals("", stringQueuePL.peek());

            stringQueueTwoStacks.enqueue(str);
            assertEquals("", stringQueueTwoStacks.peek());

            str = "" + i;
        }
        str = "";

        assertEquals(100, stringQueueTwoStacks.size());
        assertFalse(stringQueuePL.isEmpty());

        assertEquals(100, stringQueueTwoStacks.size());
        assertFalse(stringQueuePL.isEmpty());


        for (int i = 0; i < x; i++) {
            assertEquals(str, stringQueuePL.dequeue());

            assertEquals(str, stringQueueTwoStacks.dequeue());

            str = "" + i;
        }

        assertThrows(EmptyQueueE.class, () -> stringQueuePL.dequeue());
        assertThrows(EmptyQueueE.class, () -> stringQueueTwoStacks.dequeue());

        assertTrue(stringQueuePL.isEmpty());
        assertTrue(stringQueueTwoStacks.isEmpty());
    }

    @Test
    void testSpeed() {
        QueuePL<Integer> queuePL = new QueuePL<>();
        QueueTwoStacks<Integer> queueTwoStacks = new QueueTwoStacks<>();
        int n = 10000;

        long timePL = timeIt(makeRunnable(queuePL, n));
        long timeTwoStacks = timeIt(makeRunnable(queueTwoStacks, n));

        System.out.println("Time for QueuePL: " + timePL);
        System.out.println("Time for QueueTwoStacks: " + timeTwoStacks);
    }

}
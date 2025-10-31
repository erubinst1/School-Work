import dynamicArray.DequeueA;
import org.junit.jupiter.api.Test;
import pointers.DequeueP;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TODOTestP1 {
    @Test
    void testDequeueP() {
        DequeueP<String> p1 = new DequeueP<>();
        p1.enqueueBack("A");
        p1.enqueueBack("B");
        p1.enqueueFront("C");

        DequeueP<String> p2 = new DequeueP<>();
        p2.enqueueBack("A");
        p2.enqueueBack("B");
        p2.enqueueFront("C");

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());

        DequeueP<String> p3 = new DequeueP<>();
        p3.enqueueBack("A");
        p3.enqueueFront("B");

        assertNotEquals(p1, p3);

        DequeueP<String> p4 = new DequeueP<>();
        p4.enqueueBack("A");
        p4.enqueueBack("B");
        p4.enqueueFront("C");
        p4.enqueueBack("D");
        assertNotEquals(p1, p4);
    }

    @Test
    void testDequeueA() {
        DequeueA<String> a1 = new DequeueA<>(2);
        a1.enqueueBack("A");
        a1.enqueueBack("B");
        a1.enqueueFront("C");

        DequeueA<String> a2 = new DequeueA<>(8);
        a2.enqueueBack("A");
        a2.enqueueBack("B");
        a2.enqueueFront("C");

        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());

        a2.doubleCapacity();
        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());

        DequeueA<String> a3 = new DequeueA<>(2);
        a3.enqueueBack("A");
        a3.enqueueBack("B");
        a3.enqueueFront("X");
        assertNotEquals(a1, a3);

        DequeueA<String> a4 = new DequeueA<>(4);
        a4.enqueueBack("A");
        a4.enqueueBack("B");
        assertNotEquals(a1, a4);
    }
}

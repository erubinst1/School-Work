import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CyclicLazyListTest {

    @Test
    void testCyclicLazyList() {
        ILazyList<Integer> cl1 = new CyclicLazyList<>(1, 2, 3);
        assertAll(
                () -> assertEquals(1, cl1.next()),
                () -> assertEquals(2, cl1.next()),
                () -> assertEquals(3, cl1.next()),
                () -> assertEquals(1, cl1.next()),
                () -> assertEquals(2, cl1.next()));

        ILazyList<String[]> cl2 = new CyclicLazyList<>(new String[]{"1"}, new String[]{"1", "2"}, new String[]{"1", "2", "3"});
        assertAll(
                () -> assertEquals("[1]", Arrays.toString(cl2.next())),
                () -> assertEquals("[1, 2]", Arrays.toString(cl2.next())),
                () -> assertEquals("[1, 2, 3]", Arrays.toString(cl2.next())),
                () -> assertEquals("[1]", Arrays.toString(cl2.next())),
                () -> assertEquals("[1, 2]", Arrays.toString(cl2.next())),
                () -> assertEquals("[1, 2, 3]", Arrays.toString(cl2.next())));
    }
}

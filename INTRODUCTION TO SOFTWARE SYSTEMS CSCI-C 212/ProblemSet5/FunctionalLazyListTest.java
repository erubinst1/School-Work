import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionalLazyListTest {

    @Test
    void testFunctionalLazyList() {
        ILazyList<Integer> mtll1 = new FunctionalLazyList<>(x -> x + 3, 0);
        assertAll(
                () -> assertEquals(0, mtll1.next()),
                () -> assertEquals(3, mtll1.next()),
                () -> assertEquals(6, mtll1.next()),
                () -> assertEquals(9, mtll1.next()),
                () -> assertEquals(12, mtll1.next()));

        ILazyList<Integer> mtll2 = new FunctionalLazyList<>(x -> x * 2, 6);
        assertAll(
                () -> assertEquals(6, mtll2.next()),
                () -> assertEquals(12, mtll2.next()),
                () -> assertEquals(24, mtll2.next()),
                () -> assertEquals(48, mtll2.next()),
                () -> assertEquals(96, mtll2.next()));

        ILazyList<Integer> mtll3 = new FunctionalLazyList<>(x -> (int) Math.pow(x, 2), 2);
        assertAll(
                () -> assertEquals(2, mtll3.next()),
                () -> assertEquals(4, mtll3.next()),
                () -> assertEquals(16, mtll3.next()),
                () -> assertEquals(256, mtll3.next()),
                () -> assertEquals(65536, mtll3.next()));
    }
}

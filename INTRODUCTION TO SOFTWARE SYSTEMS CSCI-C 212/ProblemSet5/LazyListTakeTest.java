import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LazyListTakeTest {

    @Test
    void testLazyListTake() {
        LazyListTake llt1 = new LazyListTake(new FibonacciLazyList(), 10);
        assertAll(() -> assertEquals("[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]", llt1.getList().toString()));

        LazyListTake llt2 = new LazyListTake(new FunctionalLazyList<>( x -> x * 10, 1), 5);
        assertAll(() -> assertEquals("[1, 10, 100, 1000, 10000]", llt2.getList().toString()));

        LazyListTake llt3 = new LazyListTake(new CyclicLazyList<>( 1, 10, 100), 9);
        assertAll(() -> assertEquals("[1, 10, 100, 1, 10, 100, 1, 10, 100]", llt3.getList().toString()));
    }
}

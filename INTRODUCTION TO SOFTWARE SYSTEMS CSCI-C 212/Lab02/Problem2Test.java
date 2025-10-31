import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {

    @Test
    void testMax() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, Problem2.max(1,2,3)),
                () -> Assertions.assertEquals(3, Problem2.max(2,3,1)),
                () -> Assertions.assertEquals(-1, Problem2.max(-3,-1,-2)),
                () -> Assertions.assertEquals(6, Problem2.max(-10,6,-4))
        );
    }
}

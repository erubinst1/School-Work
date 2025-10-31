import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem9Test {

    @Test
    void testProblem9() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(true, Problem9.isEvenlySpaced(1,2,3)),
                () -> Assertions.assertEquals(true, Problem9.isEvenlySpaced(-1,-2,-3)),
                () -> Assertions.assertEquals(false, Problem9.isEvenlySpaced(1,3,4)),
                () -> Assertions.assertEquals(false, Problem9.isEvenlySpaced(-1,5,-4)),
                () -> Assertions.assertEquals(true, Problem9.isEvenlySpaced(0, 0,0)),
                () -> Assertions.assertEquals(false, Problem9.isEvenlySpaced(1,3,-2)),
                () -> Assertions.assertEquals(true, Problem9.isEvenlySpaced(-11,-9,-7))
        );
    }
}

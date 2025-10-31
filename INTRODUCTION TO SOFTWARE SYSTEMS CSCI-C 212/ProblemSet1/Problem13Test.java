import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem13Test {

    @Test
    void testProblem13() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( 4, Problem13.fitCandy(4, 1, 9)),
                () -> Assertions.assertEquals( 4, Problem13.fitCandy(4, 1, 4)),
                () -> Assertions.assertEquals( 1, Problem13.fitCandy(1, 2, 6)),
                () -> Assertions.assertEquals( -1, Problem13.fitCandy(6, 1, 13)),
                () -> Assertions.assertEquals( 50, Problem13.fitCandy(60, 100, 550)),
                () -> Assertions.assertEquals( 7, Problem13.fitCandy(7, 1, 12)),
                () -> Assertions.assertEquals( -1, Problem13.fitCandy(7, 1, 13))
        );
    }
}

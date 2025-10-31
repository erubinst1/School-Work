import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem6Test {

    @Test
    void testProblem6() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(1.5, Problem6.distanceTraveled( 1, 1, 1)),
                () -> Assertions.assertEquals( 120, Problem6.distanceTraveled( 12, 9, 4)),
                () -> Assertions.assertEquals( 390, Problem6.distanceTraveled( 73, 2, 5))
        );
    }
}

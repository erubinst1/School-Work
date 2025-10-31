import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem3Test {

    @Test
    void testProblem3() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(3.24, Problem3.pyramidSurfaceArea(1,1,1), 0.01),
                () -> Assertions.assertEquals( 0, Problem3.pyramidSurfaceArea(0,0,0)),
                () -> Assertions.assertEquals( 1993.3, Problem3.pyramidSurfaceArea(5,16,91), 0.1)

        );
    }
}

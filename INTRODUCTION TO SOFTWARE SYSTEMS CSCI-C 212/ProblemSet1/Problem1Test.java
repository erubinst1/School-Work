import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class Problem1Test {

    @Test
    void testProblem1() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(3.3356, Problem1.gigameterToLightsecond(1), 0.01),
                () -> Assertions.assertEquals(0, Problem1.gigameterToLightsecond(0), 0.01),
                () -> Assertions.assertEquals(50.0346, Problem1.gigameterToLightsecond(15), 0.01),
                () -> Assertions.assertEquals(-50.0346, Problem1.gigameterToLightsecond(-15), 0.01)
        );
    }
}

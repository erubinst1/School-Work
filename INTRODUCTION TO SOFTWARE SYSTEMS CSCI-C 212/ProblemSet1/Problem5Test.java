import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem5Test {

    @Test
    void testProblem5() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( 0.52, Problem5.lawOfCosines( 1, 1, 30), 0.01),
                () -> Assertions.assertEquals( 57.14, Problem5.lawOfCosines( 5, 61, 38), 0.01),
                () -> Assertions.assertEquals( 59, Problem5.lawOfCosines( 65, 6, 1), 0.01)

        );
    }
}

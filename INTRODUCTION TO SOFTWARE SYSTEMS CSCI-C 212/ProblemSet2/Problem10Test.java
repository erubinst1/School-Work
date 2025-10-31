import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem10Test {

    @Test
    void testProblem10() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( 12.91, Problem10.circleArea(2,0.1), 0.1),
                () -> Assertions.assertEquals( 28.56, Problem10.circleArea(3,0.05), 0.1),
                () -> Assertions.assertEquals( 268.95, Problem10.circleArea(9,1), 0.1)
        );
    }
}

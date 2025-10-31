import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class Problem2Test {

    @Test
    void testProblem2() {
         Assertions.assertAll(
                () -> Assertions.assertEquals(5.66, Problem2.grocery(1,1,1,1,1), 0.01),
                () -> Assertions.assertEquals( 0, Problem2.grocery(0,0,0,0,0), 0.01),
                () -> Assertions.assertEquals( 16.2, Problem2.grocery(5,6,2,3,1), 0.01)
        );
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem3Test {

    @Test
    void testProblem3() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( false, Problem3.canSum(new int[]{2, 4, 10, 8}, 9)),
                () -> Assertions.assertEquals( true, Problem3.canSum(new int[]{3, 7, 4, 5, 9}, 8)),
                () -> Assertions.assertEquals( true, Problem3.canSum(new int[]{2, 4, 2, 11, 5, 4}, 9)),
                () -> Assertions.assertEquals( true, Problem3.canSum(new int[]{2, 4, 10, 8}, 0)),
                () -> Assertions.assertEquals( true, Problem3.canSum(new int[]{3, 7, 4, 5, 9}, 28)),
                () -> Assertions.assertEquals( false, Problem3.canSum(new int[]{1}, 9))
        );
    }
}

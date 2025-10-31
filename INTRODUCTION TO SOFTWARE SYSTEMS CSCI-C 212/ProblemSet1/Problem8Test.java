import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem8Test {

    @Test
    void testProblem8() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(true, Problem8.lessThan20(1,2,3)),
                () -> Assertions.assertEquals(true, Problem8.lessThan20(19,2,412)),
                () -> Assertions.assertEquals( false, Problem8.lessThan20(999,888,777))
        );

    }
}

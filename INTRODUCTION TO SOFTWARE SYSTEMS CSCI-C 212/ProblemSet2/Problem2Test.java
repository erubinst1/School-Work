import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {

    @Test
    void testProblem2() {
        Assertions.assertAll(
                //Standard recursion
                () -> Assertions.assertEquals( 1, Problem2.hyperfactorial(0)),
                () -> Assertions.assertEquals( 108, Problem2.hyperfactorial(3)),
                () -> Assertions.assertEquals( 86400000, Problem2.hyperfactorial(5)),

                //tail recursion
                () -> Assertions.assertEquals( 1, Problem2.hyperfactorialTR(0)),
                () -> Assertions.assertEquals( 108, Problem2.hyperfactorialTR(3)),
                () -> Assertions.assertEquals( 86400000, Problem2.hyperfactorialTR(5)),

                //loop
                () -> Assertions.assertEquals( 1, Problem2.hyperfactorialLoop(0)),
                () -> Assertions.assertEquals( 108, Problem2.hyperfactorialLoop(3)),
                () -> Assertions.assertEquals( 86400000, Problem2.hyperfactorialLoop(5))
        );
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem3Test {

    @Test
    void testProblem3() {
        Assertions.assertAll(
                //Standard recursion
                () -> Assertions.assertEquals( 1, Problem3.subfactorial(0)),
                () -> Assertions.assertEquals( 0, Problem3.subfactorial(1)),
                () -> Assertions.assertEquals( 2, Problem3.subfactorial(3)),
                () -> Assertions.assertEquals( 133496, Problem3.subfactorial(9)),
                () -> Assertions.assertEquals( 176214841, Problem3.subfactorial(12)),

                //tail recursion
                () -> Assertions.assertEquals( 1, Problem3.subfactorialTR(0)),
                () -> Assertions.assertEquals( 0, Problem3.subfactorialTR(1)),
                () -> Assertions.assertEquals( 2, Problem3.subfactorialTR(3)),
                () -> Assertions.assertEquals( 133496, Problem3.subfactorialTR(9)),
                () -> Assertions.assertEquals( 176214841, Problem3.subfactorialTR(12)),

                //loop
                () -> Assertions.assertEquals( 1, Problem3.subfactorialLoop(0)),
                () -> Assertions.assertEquals( 0, Problem3.subfactorialLoop(1)),
                () -> Assertions.assertEquals( 2, Problem3.subfactorialLoop(3)),
                () -> Assertions.assertEquals( 133496, Problem3.subfactorialLoop(9)),
                () -> Assertions.assertEquals( 176214841, Problem3.subfactorialLoop(12))
        );
    }
}

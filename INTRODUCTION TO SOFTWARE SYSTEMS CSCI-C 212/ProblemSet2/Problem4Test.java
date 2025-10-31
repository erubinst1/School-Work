import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem4Test {

    @Test
    void testProblem4() {
        Assertions.assertAll(
                //Standard recursion
                () -> Assertions.assertEquals( "3,10,5,16,8,4,2,1", Problem4.collatz(3)),
                () -> Assertions.assertEquals( "5,16,8,4,2,1", Problem4.collatz(5)),
                () -> Assertions.assertEquals( "12,6,3,10,5,16,8,4,2,1", Problem4.collatz(12)),

                //tail recursion
                () -> Assertions.assertEquals( "3,10,5,16,8,4,2,1", Problem4.collatzTR(3)),
                () -> Assertions.assertEquals( "5,16,8,4,2,1", Problem4.collatzTR(5)),
                () -> Assertions.assertEquals( "12,6,3,10,5,16,8,4,2,1", Problem4.collatzTR(12)),

                //loop
                () -> Assertions.assertEquals( "3,10,5,16,8,4,2,1", Problem4.collatzLoop(3)),
                () -> Assertions.assertEquals( "5,16,8,4,2,1", Problem4.collatzLoop(5)),
                () -> Assertions.assertEquals( "12,6,3,10,5,16,8,4,2,1", Problem4.collatzLoop(12))
        );
    }
}

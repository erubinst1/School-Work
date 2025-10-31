import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem5Test {

    @Test
    void testProblem5() {
        Assertions.assertAll(
                //tail recursion
                () -> Assertions.assertEquals(65, Problem5.atoi("abs65")),
                () -> Assertions.assertEquals(0, Problem5.atoi("ABCD")),
                () -> Assertions.assertEquals(42, Problem5.atoi("42")),
                () -> Assertions.assertEquals(42, Problem5.atoi("000042")),
                () -> Assertions.assertEquals(4200, Problem5.atoi("004200")),
                () -> Assertions.assertEquals(42, Problem5.atoi("ABCD42ABCD")),
                () -> Assertions.assertEquals(42, Problem5.atoi("ABCD-+42ABCD")),
                () -> Assertions.assertEquals(-42, Problem5.atoi("ABCD+-42ABCD")),
                () -> Assertions.assertEquals(0, Problem5.atoi("9999999999999")),
                () -> Assertions.assertEquals(0, Problem5.atoi("-9999999999999")),
                () -> Assertions.assertEquals(-42000, Problem5.atoi("000-42000")),
                () -> Assertions.assertEquals(0, Problem5.atoi("000-ABCD")),
                () -> Assertions.assertEquals(42, Problem5.atoi("000+42ABCD")),
                () -> Assertions.assertEquals(8080, Problem5.atoi("8080*8080")),
                () -> Assertions.assertEquals( 0, Problem5.atoi("")),
                () -> Assertions.assertEquals( 3, Problem5.atoi("dada-+-+3"))
        );
    }
}

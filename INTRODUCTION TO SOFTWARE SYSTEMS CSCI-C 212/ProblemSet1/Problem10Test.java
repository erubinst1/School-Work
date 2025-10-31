import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem10Test {

    @Test
    void testProblem10() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( "test", Problem10.cutTry("testtry")),
                () -> Assertions.assertEquals( "testtrytest", Problem10.cutTry("testtrytest")),
                () -> Assertions.assertEquals( "", Problem10.cutTry("try")),
                () -> Assertions.assertEquals( "testtry", Problem10.cutTry("testtrytry"))
        );
    }
}

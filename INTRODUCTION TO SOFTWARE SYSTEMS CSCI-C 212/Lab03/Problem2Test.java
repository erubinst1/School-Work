import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {

    @Test
    void testIsNestedParenthesesTR() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( true, Problem2.isNestedParenthesesTR("(())")),
                () -> Assertions.assertEquals( true, Problem2.isNestedParenthesesTR("( ( ))")),
                () -> Assertions.assertEquals( false, Problem2.isNestedParenthesesTR("((())")),
                () -> Assertions.assertEquals( true, Problem2.isNestedParenthesesTR("(())"))
        );
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Problem8Test {

    @Test
    void testProblem8() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(17, Problem8.postfixEvaluator(List.of("5", "2", "*", "5", "+", "2", "+"))),
                () -> Assertions.assertEquals(10, Problem8.postfixEvaluator(List.of("1", "2", "3", "4", "+", "+", "+"))),
                () -> Assertions.assertEquals(5, Problem8.postfixEvaluator(List.of("10", "2", "/"))),
                () -> Assertions.assertEquals(2, Problem8.postfixEvaluator(List.of("3", "4", "+", "2", "*", "7", "/"))),
                () -> Assertions.assertEquals(-27, Problem8.postfixEvaluator(List.of("3", "10", "-", "-2", "10", "*", "+")))
        );
    }
}

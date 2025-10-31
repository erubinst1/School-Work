import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem4Test {

    @Test
    void testProblem4() {
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(new double[]{1,1}, Problem4.linearRegression(new double[]{1, 2}, new double[]{2, 3}), 0.01),
                () -> Assertions.assertArrayEquals(new double[]{0.75,0.25}, Problem4.linearRegression(new double[]{1, 5, 9, 13}, new double[]{1, 2, 3, 4}), 0.01),
                () -> Assertions.assertArrayEquals(new double[]{0, 1}, Problem4.linearRegression(new double[]{1, 2, 3, 4}, new double[]{1, 2, 3, 4}), 0.01),
                () -> Assertions.assertArrayEquals(null, Problem4.linearRegression(new double[]{0, 1}, new double[]{0}), 0.01)
        );
    }
}

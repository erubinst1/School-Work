import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {

    @Test
    void testProblem2() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( 2, Problem2.median( new int[]{1, 2}, new int[]{3, 4})),
                () -> Assertions.assertEquals( 2, Problem2.median( new int[]{1, 2}, new int[]{3})),
                () -> Assertions.assertEquals( 5, Problem2.median( new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9})),
                () -> Assertions.assertEquals( -3, Problem2.median( new int[]{-5, -4, -3}, new int[]{-2, -1})),
                () -> Assertions.assertEquals( -3, Problem2.median( new int[]{-6, -5, -4}, new int[]{-3, -2, -1})),
                () -> Assertions.assertEquals( 0, Problem2.median( new int[]{}, new int[]{})),
                () -> Assertions.assertEquals( -1, Problem2.median( new int[]{-1}, new int[]{})),
                () -> Assertions.assertEquals( 10, Problem2.median( new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20})),
                () -> Assertions.assertEquals( 10, Problem2.median( new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, new int[]{}))
        );
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem3Test {

    @Test
    void testCanBalanceArray() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( false, Problem3.canBalanceArray(new int[]{1, 1, 1, 1, 5})),
                () -> Assertions.assertEquals( true, Problem3.canBalanceArray(new int[]{2, 3, 5})),
                () -> Assertions.assertEquals( true, Problem3.canBalanceArray(new int[]{-10, 2, -58, 50})),
                () -> Assertions.assertEquals( true, Problem3.canBalanceArray(new int[]{3, -1, -1, -1, 0})),
                () -> Assertions.assertEquals( true, Problem3.canBalanceArray(new int[]{3, 2, 1, 0})),
                () -> Assertions.assertEquals( false, Problem3.canBalanceArray(new int[]{10})),
                () -> Assertions.assertEquals( true, Problem3.canBalanceArray(new int[]{3, 2, 1}))
        );
    }
}

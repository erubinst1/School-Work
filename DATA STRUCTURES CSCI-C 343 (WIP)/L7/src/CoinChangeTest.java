import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void testBottomUp() {
        int[] denominations = {1, 5, 10, 25};

        // Example:
        // assertEquals(expected, CoinChange.minChange(amount, denominations));

        assertEquals(0, CoinChange.minChange(0, denominations));

        assertEquals(1, CoinChange.minChange(1, denominations));
        assertEquals(2, CoinChange.minChange(2, denominations));
        assertEquals(1, CoinChange.minChange(5, denominations));
        assertEquals(2, CoinChange.minChange(6, denominations));
        assertEquals(2, CoinChange.minChange(11, denominations));
        assertEquals(1, CoinChange.minChange(25, denominations));
        assertEquals(2, CoinChange.minChange(30, denominations));
        assertEquals(6, CoinChange.minChange(63, denominations));

        int[] custom = {5, 10};
        assertEquals(-1, CoinChange.minChange(1, custom));

    }

    @Test
    void testTopDown() {
        int[] denominations = {1, 5, 10, 25};

        // Example:
        // assertEquals(expected, CoinChangeTopDown.minChangeMemo(amount, denominations));

        assertEquals(0, CoinChangeTopDown.minChangeMemo(0, denominations));

        assertEquals(1, CoinChangeTopDown.minChangeMemo(1, denominations));
        assertEquals(2, CoinChangeTopDown.minChangeMemo(2, denominations));
        assertEquals(1, CoinChangeTopDown.minChangeMemo(5, denominations));
        assertEquals(2, CoinChangeTopDown.minChangeMemo(6, denominations));
        assertEquals(2, CoinChangeTopDown.minChangeMemo(11, denominations));
        assertEquals(1, CoinChangeTopDown.minChangeMemo(25, denominations));
        assertEquals(2, CoinChangeTopDown.minChangeMemo(30, denominations));
        assertEquals(6, CoinChangeTopDown.minChangeMemo(63, denominations));

        int[] custom = {5, 10};
        CoinChangeTopDown.clearMemo();

        assertEquals(-1, CoinChangeTopDown.minChangeMemo(3, custom));
    }
}

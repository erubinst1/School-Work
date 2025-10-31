import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class P3StudentTest {
    @Test
    void baseCasesRows() {
        BinomialCoefficient rec = new RecursiveBinomial();
        BinomialCoefficient dp = new DPBinomial();

        // Check first few Pascal rows (edges & small internals)
        int[][] expected = {
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1},
                {1, 5, 10, 10, 5, 1}
        };
        for (int n = 0; n < expected.length; n++) {
            for (int k = 0; k <= n; k++) {
                assertEquals(expected[n][k], rec.binom(n, k));
                assertEquals(expected[n][k], dp.binom(n, k));
            }
        }
    }

    @Test
    void compareRecursiveVsDP_smallN() {
        // Keep recursion reasonable: n <= 15
        BinomialCoefficient rec = new RecursiveBinomial();
        BinomialCoefficient dp = new DPBinomial();
        for (int n = 0; n <= 15; n++) {
            for (int k = 0; k <= n; k++) {
                assertEquals(dp.binom(n, k), rec.binom(n, k));
            }
        }
    }

    @Test
    void pascalIdentityHolds_dp() {
        // C(n,k) = C(n-1,k-1) + C(n-1,k)
        BinomialCoefficient dp = new DPBinomial();
        for (int n = 2; n <= 20; n++) {
            for (int k = 1; k < n; k++) {
                long lhs = dp.binom(n, k);
                long rhs = dp.binom(n - 1, k - 1) + dp.binom(n - 1, k);
                assertEquals(rhs, lhs, "Pascal identity failed at n=" + n + ", k=" + k);
            }
        }
    }

    @Test
    void rowSumsArePowersOfTwo_dp() {
        // Sum_k C(n,k) = 2^n
        BinomialCoefficient dp = new DPBinomial();
        for (int n = 0; n <= 20; n++) {
            long sum = 0;
            for (int k = 0; k <= n; k++) sum += dp.binom(n, k);
            assertEquals(1L << n, sum, "Row sum should be 2^n for n=" + n);
        }
    }

    @Test
    void knownLargerValues_dpOnly() {
        // A few larger-but-safe values within long range
        BinomialCoefficient dp = new DPBinomial();
        assertEquals(2_118_760L, dp.binom(50, 5));
        assertEquals(20_358_520L, dp.binom(52, 6));
        assertEquals(76_904_685L, dp.binom(40, 8));
        assertEquals(155_117_520L, dp.binom(30, 15));
        assertEquals(5_200_300L, dp.binom(25, 12));
        assertEquals(184_756L, dp.binom(20, 10));
        assertEquals(2_333_606_220L, dp.binom(34, 17));
        assertEquals(3_381_098_545L, dp.binom(62, 8));
    }

    @Test
    void symmetry_dp_again() {
        // Reinforce symmetry over a wider band than the original test
        BinomialCoefficient dp = new DPBinomial();
        for (int n = 0; n <= 30; n++) {
            for (int k = 0; k <= n; k++) {
                assertEquals(dp.binom(n, k), dp.binom(n, n - k));
            }
        }
    }

    @Test
    void invalidInputs_throw() {
        // Assumes AbstractBinomial.validate(...) throws IllegalArgumentException
        BinomialCoefficient dp = new DPBinomial();
        BinomialCoefficient rec = new RecursiveBinomial();

        assertThrows(IllegalArgumentException.class, () -> dp.binom(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> dp.binom(5, -1));
        assertThrows(IllegalArgumentException.class, () -> dp.binom(5, 6));

        assertThrows(IllegalArgumentException.class, () -> rec.binom(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> rec.binom(5, -1));
        assertThrows(IllegalArgumentException.class, () -> rec.binom(5, 6));
    }
}

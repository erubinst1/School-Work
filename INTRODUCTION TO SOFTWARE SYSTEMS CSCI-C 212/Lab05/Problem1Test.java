import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1Test {

    @Test
    void testAccSum() {
        int[] t1in = new int[]{1, 7, 2, 9};
        int[] t1out = new int[]{1, 8, 10, 19};

        int[] t2in = new int[]{1, 3, 3, 4, 5, 5, 6, 6, 2};
        int[] t2out = new int[]{1, 4, 7, 11, 16, 21, 27, 33, 35};

        int[] t3in = new int[]{5, 5, 5, 5, 5, 5, 5, 1, 5};
        int[] t3out = new int[]{5, 10, 15, 20, 25, 30, 35, 36, 41};

        int[] t4in = new int[]{};
        int[] t4out = new int[]{};

        int[] t5in = new int[]{1};
        int[] t5out = new int[]{1};

        int[] t6in = new int[]{1, 1};
        int[] t6out = new int[]{1, 2};

        int[] t7in = new int[]{-5, -5, -5, -5, -5, -5, -5, -1, -5};
        int[] t7out = new int[]{-5, -10, -15, -20, -25, -30, -35, -36, -41};

        int[] t8in = new int[]{-5, 5, -5, 5, -5, 5, -5, -1, -5};
        int[] t8out = new int[]{-5, 0, -5, 0, -5, -0, -5, -6, -11};


        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(t1out, Problem1.accSum(t1in)),
                () -> Assertions.assertArrayEquals(t2out, Problem1.accSum(t2in)),
                () -> Assertions.assertArrayEquals(t3out, Problem1.accSum(t3in)),
                () -> Assertions.assertArrayEquals(t4out, Problem1.accSum(t4in)),
                () -> Assertions.assertArrayEquals(t5out, Problem1.accSum(t5in)),
                () -> Assertions.assertArrayEquals(t6out, Problem1.accSum(t6in)),
                () -> Assertions.assertArrayEquals(t7out, Problem1.accSum(t7in)),
                () -> Assertions.assertArrayEquals(t8out, Problem1.accSum(t8in))
        );
    }
}

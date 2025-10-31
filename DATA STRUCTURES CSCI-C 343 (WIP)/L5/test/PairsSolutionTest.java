import java.util.Set;

import org.junit.jupiter.api.Test;
import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the PairsSolution methods using a couple of example arrays.
 * It demonstrates how each method (HashSet, Two-Pointer, Brute Force) finds
 * pairs that sum to a specific target. It also highlights time complexity differences.
 */
public class PairsSolutionTest {

    /**
     * Utility method to compare all 3 algorithms given:
     *
     * @param arr      the array
     * @param target   the target
     * @param expected the expected Set of all possible pairs found
     * @param solver   the solver that holds all 3 algorithms
     */
    private void assertAllAlgorithmsEqual(
            int[] arr,
            int target,
            Set<String> expected,
            PairsSolution solver) {
        assertEquals(expected, solver.findPairsHashSet(arr.clone(), target));
        assertEquals(expected, solver.findPairsTwoPointer(arr.clone(), target));
        assertEquals(expected, solver.findPairsBruteForce(arr.clone(), target));
    }

    /**
     * Utility method to print the contents of an int array.
     *
     * @param arr the array to print
     */
    private static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }


    // used to time a runnable
    private long timeIt(@NotNull Runnable r) {
        long startTime = System.currentTimeMillis();
        r.run();
        return System.currentTimeMillis() - startTime;
    }

    // runnable for findPairsHashSet
    private @NotNull Runnable runHashSet(
            int[] arr,
            int target,
            @NotNull PairsSolution solver) {
        return () -> {
            solver.findPairsHashSet(arr, target);
        };
    }

    // runnable for findPairsTwoPointer
    private @NotNull Runnable runTwoPointer(
            int[] arr,
            int target,
            @NotNull PairsSolution solver) {
        return () -> {
            solver.findPairsTwoPointer(arr, target);
        };
    }

    // runnable for findPairsBruteForce
    private @NotNull Runnable runBruteForce(
            int[] arr,
            int target,
            @NotNull PairsSolution solver) {
        return () -> {
            solver.findPairsBruteForce(arr, target);
        };
    }


    @Test
    void test0() {
        PairsSolution solver = new PairsSolution();
        int[] arr = {2, 4, 3, 5, 7, 8, 9};
        int target = 9;
        Set<String> expected = Set.of("(2, 7)", "(4, 5)");
        assertAllAlgorithmsEqual(arr, target, expected, solver);
    }

    @Test
    void test1() {
        PairsSolution solver = new PairsSolution();
        int[] arr = {1, 1, 2, 3, 4, 5};
        int target = 6;
        Set<String> expected = Set.of("(1, 5)", "(2, 4)");
        assertAllAlgorithmsEqual(arr, target, expected, solver);
    }

    @Test
    void testNoValidPairs() {
        // create a test where no valid pair found given (arr, target)
        PairsSolution solver = new PairsSolution();
        int[] arr = {0, 0, -6, 0, 0, 9};
        int target = 6;
        Set<String> expected = Set.of();
        assertAllAlgorithmsEqual(arr, target, expected, solver);
    }

    @Test
    void testWithNegatives() {
        // create a test where there are negative integers involved
        PairsSolution solver = new PairsSolution();
        int[] arr = {-70, -30, -10, -20, 0, 27, 30, 40};
        int target = -30;
        Set<String> expectedH1 = Set.of("(-10, -20)", "(-30, 0)", "(-70, 40)");
        Set<String> expectedP1 = Set.of("(-70, 40)", "(-30, 0)", "(-20, -10)");
        Set<String> expectedB1 = Set.of("(-10, -20)", "(-30, 0)", "(-70, 40)");

        assertEquals(expectedH1, solver.findPairsHashSet(arr.clone(), target));
        assertEquals(expectedP1, solver.findPairsTwoPointer(arr.clone(), target));
        assertEquals(expectedB1, solver.findPairsBruteForce(arr.clone(), target));

        PairsSolution solver2 = new PairsSolution();
        int[] arr2 = {-70, -40, 0, 20, 55, 70};
        int target2 = 0;
        Set<String> expectedH2 = Set.of("(-70, 70)");
        Set<String> expectedP2 = Set.of("(-70, 70)");
        Set<String> expectedB2 = Set.of("(-70, 70)");

        assertEquals(expectedH2, solver2.findPairsHashSet(arr2.clone(), target2));
        assertEquals(expectedP2, solver2.findPairsTwoPointer(arr2.clone(), target2));
        assertEquals(expectedB2, solver2.findPairsBruteForce(arr2.clone(), target2));

        PairsSolution solver3 = new PairsSolution();
        int[] arr3 = {-120, -70, -40, 0, 20, 55, 70, 150, 200};
        int target3 = 80;
        Set<String> expectedH3 = Set.of("(-70, 150)", "(-120, 200)");
        Set<String> expectedP3 = Set.of("(-70, 150)", "(-120, 200)");
        Set<String> expectedB3 = Set.of("(-70, 150)", "(-120, 200)");

        assertEquals(expectedH3, solver3.findPairsHashSet(arr3.clone(), target3));
        assertEquals(expectedP3, solver3.findPairsTwoPointer(arr3.clone(), target3));
        assertEquals(expectedB3, solver3.findPairsBruteForce(arr3.clone(), target3));
    }

    @Test
    void testLargeNumbers() {
        // create a test where several large numbers are involved
        PairsSolution solver = new PairsSolution();
        int[] arr = {-1000, 0, 1880, 9000, 9300, 10000, 1112223433, 1112223435};
        int target = 9000;
        Set<String> expectedH1 = Set.of("(-1000, 10000)", "(0, 9000)");
        Set<String> expectedP1 = Set.of("(0, 9000)", "(-1000, 10000)");
        Set<String> expectedB1 = Set.of("(0, 9000)", "(-1000, 10000)");

        assertEquals(expectedH1, solver.findPairsHashSet(arr.clone(), target));
        assertEquals(expectedP1, solver.findPairsTwoPointer(arr.clone(), target));
        assertEquals(expectedB1, solver.findPairsBruteForce(arr.clone(), target));

    }

    @Test
    void testVeryLongArray() {
        // create a test where the array is extremely long
        // so that you can feel the BruteForce algorithm running much slower
        PairsSolution solver = new PairsSolution();
        int[] arr = {-1000, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 1880, 9000, 9300, 10000, 1112223433, 1112223435};
        int target = 9000;
        Set<String> expectedH1 = Set.of("(-1000, 10000)", "(0, 9000)");
        Set<String> expectedP1 = Set.of("(0, 9000)", "(-1000, 10000)");
        Set<String> expectedB1 = Set.of("(0, 9000)", "(-1000, 10000)");

        assertEquals(expectedH1, solver.findPairsHashSet(arr.clone(), target));
        assertEquals(expectedP1, solver.findPairsTwoPointer(arr.clone(), target));
        assertEquals(expectedB1, solver.findPairsBruteForce(arr.clone(), target));
    }

    @Test
    void compare() {
        // use timeIt and 3 runnable, provide proper input (arr, target)
        // compare the time complexity of 3 algorithms
        // hint: array needs to be long enough

        int[] arr = java.util.stream.IntStream.rangeClosed(1, 5000).toArray();
        int target = 5001;
        PairsSolution solver = new PairsSolution();

        long hashSetTime = timeIt(runHashSet(arr.clone(), target, solver));
        long twoPointerTime = timeIt(runTwoPointer(arr.clone(), target, solver));
        long bruteForceTime = timeIt(runBruteForce(arr.clone(), target, solver));

        System.out.println("HashSet time    5000: " + hashSetTime + " ms");
        System.out.println("TwoPointer time 5000: " + twoPointerTime + " ms");
        System.out.println("BruteForce time 5000: " + bruteForceTime + " ms");

        int[] arr2 = java.util.stream.IntStream.rangeClosed(1, 10000).toArray();
        int target2 = 5001;
        PairsSolution solver2 = new PairsSolution();

        long hashSetTime2 = timeIt(runHashSet(arr2.clone(), target2, solver2));
        long twoPointerTime2 = timeIt(runTwoPointer(arr2.clone(), target2, solver2));
        long bruteForceTime2 = timeIt(runBruteForce(arr2.clone(), target2, solver2));

        System.out.println("HashSet time    10000: " + hashSetTime2 + " ms");
        System.out.println("TwoPointer time 10000: " + twoPointerTime2 + " ms");
        System.out.println("BruteForce time 10000: " + bruteForceTime2 + " ms");
    }

}
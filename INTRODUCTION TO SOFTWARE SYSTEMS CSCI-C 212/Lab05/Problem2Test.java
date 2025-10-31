import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {

    @Test
    void testCountEvenOdds() {
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(new int[]{1,1}, Problem2.countEvenOdds(new int[]{1,2})),
                () -> Assertions.assertArrayEquals(new int[]{0,0}, Problem2.countEvenOdds(new int[]{})),
                () -> Assertions.assertArrayEquals(new int[]{4,4}, Problem2.countEvenOdds(new int[]{11,9,2,3,7,10,12,114})),
                () -> Assertions.assertArrayEquals(new int[]{0,4}, Problem2.countEvenOdds(new int[]{11,13,15,17})),
                () -> Assertions.assertArrayEquals(new int[]{0,4}, Problem2.countEvenOdds(new int[]{-11,-13,-15,-17})),
                () -> Assertions.assertArrayEquals(new int[]{4,4}, Problem2.countEvenOdds(new int[]{-11,9,2,-3,7,10,-12,114}))
        );
    }
}

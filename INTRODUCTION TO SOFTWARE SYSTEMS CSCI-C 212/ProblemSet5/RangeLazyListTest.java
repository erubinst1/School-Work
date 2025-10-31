import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeLazyListTest {

    @Test
    void testRangeLazyList(){
        RangeLazyList range1 = RangeLazyList.range(5);
        int[] results1 = new int[5];
        int[] expected1 = {0, 1, 2, 3, 4};
        for (int i = 0; i < 5; i++) {
            results1[i] = (int) range1.next();
        }
        Assertions.assertArrayEquals(expected1, results1);


        RangeLazyList range2 = RangeLazyList.range(0, 10, x -> x + 2);
        int[] results2 = new int[5];
        int[] expected2 = {0, 2, 4, 6, 8};
        for (int i = 0; i < 5; i++) {
            results2[i] = (int) range2.next();
        }
        Assertions.assertArrayEquals(expected2, results2);


        RangeLazyList range3 = RangeLazyList.range(5, 5, x -> x + 1);
        Assertions.assertFalse(range3.hasNext());

        RangeLazyList range4 = RangeLazyList.range(3);
        int[] results4 = new int[3];
        int[] expected4 = {0, 1, 2};
        int index = 0;
        for (Object value : range4) {
            results4[index++] = (int) value;
        }
        Assertions.assertArrayEquals(expected4, results4);
    }
}

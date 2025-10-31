import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class StreamMethodsTest {

    @Test
    void testContainsHigh() {
        List<int[]> l1 = List.of(new int[]{1110, 449}, new int[]{1110, 450}, new int[]{1110, 451});
        List<int[]> l2 = List.of(new int[]{1110, 451}, new int[]{1110, 452}, new int[]{1110, 453});
        List<int[]> l3 = List.of(new int[]{1110, 450}, new int[]{1110, 449}, new int[]{1110, 448});

        Assertions.assertAll(
                () -> Assertions.assertTrue(StreamMethods.containsHigh(List.of(new int[]{0, 451}))),
                () -> Assertions.assertFalse(StreamMethods.containsHigh(List.of(new int[]{451, 0}))),
                () -> Assertions.assertFalse(StreamMethods.containsHigh(List.of())),
                () -> Assertions.assertTrue(StreamMethods.containsHigh(l1)),
                () -> Assertions.assertTrue(StreamMethods.containsHigh(l2)),
                () -> Assertions.assertFalse(StreamMethods.containsHigh(l3))
        );
    }

    @Test
    void testSqAddFiveOmit() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(List.of(9), StreamMethods.sqAddFiveOmit(List.of(0, 1, 2))),
                () -> Assertions.assertEquals(List.of(), StreamMethods.sqAddFiveOmit(List.of())),
                () -> Assertions.assertEquals(List.of(21, 30), StreamMethods.sqAddFiveOmit(List.of(4, 5))),
                () -> Assertions.assertEquals(List.of(9, 14), StreamMethods.sqAddFiveOmit(List.of(1, 2, 3))),
                () -> Assertions.assertEquals(List.of(30, 41), StreamMethods.sqAddFiveOmit(List.of(5, 6)))
        );
    }

    @Test
    void testRemoveLongerThan() {
        Assertions.assertAll(
                ()-> Assertions.assertEquals(List.of(), StreamMethods.removeLonger(List.of("a", "b", "c"), 0)),
                ()-> Assertions.assertEquals(List.of(), StreamMethods.removeLonger(List.of(), 0)),
                ()-> Assertions.assertEquals(List.of("a", "b", "c"), StreamMethods.removeLonger(List.of("a", "b", "c"), 1)),
                () -> Assertions.assertEquals(List.of("a"), StreamMethods.removeLonger(List.of("a", "bb", "ccc"), 1)),
                () -> Assertions.assertEquals(List.of("a", "b"), StreamMethods.removeLonger(List.of("a", "b", "ccc"), 1)),
                () -> Assertions.assertEquals(List.of("a", "bb"), StreamMethods.removeLonger(List.of("a", "bb", "ccc"), 2))
        );
    }

    @Test
    void testFilterSumChars() {
        Assertions.assertAll(
                ()-> Assertions.assertEquals(378, StreamMethods.filterSumChars("Hello123")),
                ()-> Assertions.assertEquals(0, StreamMethods.filterSumChars("")),
                ()-> Assertions.assertEquals(15, StreamMethods.filterSumChars("12345")),
                () -> Assertions.assertEquals(65, StreamMethods.filterSumChars("a")),
                () -> Assertions.assertEquals(0, StreamMethods.filterSumChars("!@#")),
                () -> Assertions.assertEquals(130, StreamMethods.filterSumChars("Aa")),
                () -> Assertions.assertEquals(0, StreamMethods.filterSumChars("     ")),
                () -> Assertions.assertEquals(684, StreamMethods.filterSumChars("Java8Rocks!")),
                () -> Assertions.assertEquals(466, StreamMethods.filterSumChars("Stream#123"))
        );
    }
}
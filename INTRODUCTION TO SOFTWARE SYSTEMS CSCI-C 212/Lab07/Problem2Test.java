import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem2Test {

    @Test
    void testFilterThenSquare() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(List.of(1.0), Problem2.filterThenSquare(List.of(1.0, 7.0, 49.0))),
                () -> Assertions.assertEquals(List.of(1.0, 4.0, 361.0), Problem2.filterThenSquare(List.of(1.0, 2.0, 19.0, -7.0, -49.0))),
                () -> Assertions.assertEquals(List.of(1.0, 4.0, 361.0, 2470.09), Problem2.filterThenSquare(List.of(1.0, 2.0, 19.0, -49.7))),
                () -> Assertions.assertEquals(List.of(), Problem2.filterThenSquare(List.of(7.0, 700.0, 777770.0))),
                () -> Assertions.assertEquals(List.of(), Problem2.filterThenSquare(List.of()))
        );
    }
}

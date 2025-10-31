import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Problem10Test {

    @Test
    void testProblem10() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( true, Problem10.areParallelLists(List.of(5, 10, 15, 20), List.of(20, 40, 60, 80))),
                () -> Assertions.assertEquals( true, Problem10.areParallelLists(List.of(100, 200, 300, 200), List.of(10, 20, 30, 20))),
                () -> Assertions.assertEquals( false, Problem10.areParallelLists(List.of(100, 200, 300, 200), List.of(10, 20, 30, 21))),
                () -> Assertions.assertEquals( true, Problem10.areParallelLists(List.of(0, 0, 0, 0), List.of(20, 40, 60, 80))),
                () -> Assertions.assertEquals( true, Problem10.areParallelLists(List.of(100, 200, 300, 200), List.of(0, 0, 0, 0))),
                () -> Assertions.assertEquals( false, Problem10.areParallelLists(List.of(100, 200, 300, 200), List.of(0, 0, 0)))
        );
    }
}

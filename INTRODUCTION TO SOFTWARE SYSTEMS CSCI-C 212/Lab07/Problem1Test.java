import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem1Test {

    @Test
    void testRemvDups() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(List.of(1,2,3,4,5), Problem1.remvDups(List.of(1,1,2,3,4,5,5))),
                () -> Assertions.assertEquals(List.of(1,-1,-2,3,4,5,-5), Problem1.remvDups(List.of(1,-1,-2,3,4,5,-5))),
                () -> Assertions.assertEquals(List.of(1,1111,2,3,4,5), Problem1.remvDups(List.of(1,1111,2,3,4,5,5))),
                () -> Assertions.assertEquals(List.of(), Problem1.remvDups(List.of())),
                () -> Assertions.assertEquals(List.of(1), Problem1.remvDups(List.of(1,1,1,1,1,1,1,1,1)))
        );
    }
}

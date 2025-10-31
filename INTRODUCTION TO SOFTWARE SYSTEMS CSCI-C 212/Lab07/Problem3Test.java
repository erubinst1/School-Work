import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem3Test {

    @Test
    void testMaximum() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(Optional.of(4), Problem3.maximum(List.of(1, 2, 3, 4))),
                () -> Assertions.assertEquals(Optional.of(4), Problem3.maximum(List.of(4, 3, 2, 1))),
                () -> Assertions.assertEquals(Optional.empty(), Problem3.maximum(List.of()))
        );
    }
}

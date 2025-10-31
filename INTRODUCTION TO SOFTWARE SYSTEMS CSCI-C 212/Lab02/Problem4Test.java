import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem4Test {

    @Test
    void testMiddleString() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("b", Problem4.middleString("a","b","c")),
                () -> Assertions.assertEquals("b", Problem4.middleString("b","c","a")),
                () -> Assertions.assertEquals("b", Problem4.middleString("c","a","b"))
        );
    }
}

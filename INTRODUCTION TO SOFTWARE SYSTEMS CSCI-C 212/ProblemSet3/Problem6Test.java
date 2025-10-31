import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Problem6Test {

    @Test
    void testProblem6() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(List.of("he", "he"), Problem6.tokenize("he he", ' ')),
                () -> Assertions.assertEquals(List.of("1", "2", "3"), Problem6.tokenize("1d2d3", 'd')),
                () -> Assertions.assertEquals(List.of("1", "2", "3"), Problem6.tokenize("1,2,3", ',')),
                () -> Assertions.assertEquals(List.of("1     ", "2,3     ", "    "), Problem6.tokenize("1     d2,3     d    ", 'd')),
                () -> Assertions.assertEquals(List.of(), Problem6.tokenize("     ", ' ')),
                () -> Assertions.assertEquals(List.of(), Problem6.tokenize("", ' '))
        );
    }
}

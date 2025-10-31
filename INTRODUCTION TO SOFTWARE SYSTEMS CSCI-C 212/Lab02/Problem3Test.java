import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem3Test {

    @Test
    void testPopChars() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( "cdefg", Problem3.popChars("abcdefg", 'a', 'b')),
                () -> Assertions.assertEquals("abcdefg", Problem3.popChars("abcdefg",'g','f')),
                () -> Assertions.assertEquals("", Problem3.popChars("ab", 'a', 'b')),
                () -> Assertions.assertEquals("acdefg", Problem3.popChars("abcdefg", 'c', 'b')),
                () -> Assertions.assertEquals("bcdefg", Problem3.popChars("abcdefg", 'a', 'c')),
                () -> Assertions.assertEquals("", Problem3.popChars("", 'a', 'b')),
                () -> Assertions.assertEquals("", Problem3.popChars("a", 'a', 'b'))
        );
    }
}

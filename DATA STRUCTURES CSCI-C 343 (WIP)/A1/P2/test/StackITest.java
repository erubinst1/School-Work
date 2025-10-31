import exceptions.EmptyStackE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackITest {
    @Test
    void testSimple () throws EmptyStackE {
        StackPL<Integer> stackPL = new StackPL<>();
        int n = 10;

        for (int i = 0; i < n; i++) {
            stackPL.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            try {
                assertEquals(i, stackPL.pop());
            }
            catch (EmptyStackE ex) {
                throw new Error("Internal bug: EmptyStackE should not be thrown in this test");
            }
        }

        StackPL<String> stringStackPL = new StackPL<>();
        int x = 100;
        String str = "";

        for (int i = 0; i < x; i++) {
            stringStackPL.push(str);
            if(i == 6)
                assertEquals("5", stringStackPL.peek());
            str = "" + i;
        }
        str = "" + (Integer.parseInt(str) - 1);

        assertEquals(100, stringStackPL.size());
        assertFalse(stringStackPL.isEmpty());


        for (int i = x - 1; i > 0; i--) {
            try {
                assertEquals(str, stringStackPL.pop());
                str = "" + (Integer.parseInt(str) - 1);
            }
            catch (EmptyStackE ex) {
                throw new Error("Internal bug: EmptyStackE should not be thrown in this test");
            }
        }
        try {
            assertEquals("", stringStackPL.pop());
        }
        catch (EmptyStackE ex) {
            throw new Error("Internal bug: EmptyStackE should not be thrown in this test");
        }

        assertThrows(EmptyStackE.class, () -> stringStackPL.pop());

        assertTrue(stringStackPL.isEmpty());

    }
}

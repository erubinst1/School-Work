import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Password and Attack classes.
 */

class PasswordTest {

    /**
     * Tests the checkPassword method of the Password class.
     * Ensures the correct password matches and incorrect passwords do not.
     */

    @Test
    void checkPassword() throws NoSuchAlgorithmException {
        Password password = new Password("password");
        assertTrue(password.checkPassword("password"));
        assertFalse(password.checkPassword("password2"));
    }

    /**
     * Tests the brute-force attack logic of the Attack class.
     * Ensures it can correctly guess passwords of different lengths.
     */

    @Test
    void guesses() throws NoSuchAlgorithmException {
        Password password = new Password("ab");
        Attack attack = new Attack(password, 2);
        String cracked = attack.crack();
        assertEquals("ab", cracked);

        password = new Password("abcdefg");
        attack = new Attack(password, 7);
        cracked = attack.crack();
        assertEquals("abcdefg", cracked);

    }

    @Test
    void additionalTestCases() throws NoSuchAlgorithmException {
        /**
         * -----------------------------
         * Examples of what you can test:
         * 1. Check if very short passwords (e.g., "a", "1") work correctly.
         * Works as expected
         * 2. Check if the `Attack` class can guess passwords containing numbers or special characters.
         * cant do this, "alphabet" doesnt contain any special chars
         * 3. Try passwords longer than 7 characters and observe performance.
         * Takes multiple minutes
         * 4. Use passwords with mixed cases (e.g., "AbC123") and test if they are guessed correctly.
         * cant do this, "alphabet" doesnt contain any Uppercase chars
         */

        Password password = new Password("a");
        Attack attack = new Attack(password, 1);
        String cracked = attack.crack();
        assertEquals("a", cracked);

        password = new Password("g");
        attack = new Attack(password, 1);
        cracked = attack.crack();
        assertEquals("g", cracked);

        password = new Password("1");
        attack = new Attack(password, 1);
        cracked = attack.crack();
        assertEquals("1", cracked);

        password = new Password("9");
        attack = new Attack(password, 1);
        cracked = attack.crack();
        assertEquals("9", cracked);

        password = new Password("");
        attack = new Attack(password, 0);
        cracked = attack.crack();
        assertEquals("", cracked);

        password = new Password("!");
        attack = new Attack(password, 1);
        assertThrows(java.util.NoSuchElementException.class, attack::crack);

        password = new Password("A");
        attack = new Attack(password, 1);
        assertThrows(java.util.NoSuchElementException.class, attack::crack);

        password = new Password("8983akb");
        attack = new Attack(password, 7);
        cracked = attack.crack();
        assertEquals("8983akb", cracked);
        System.out.println("Len 7");
        //~2 hrs

        password = new Password("8983akbs");
        attack = new Attack(password, 8);
        cracked = attack.crack();
        assertEquals("8983akbs", cracked);
        System.out.println("Len 8");
        //8 hrs +

        //takes exponentially longer as k increases
        password = new Password("8983akbs6");
        attack = new Attack(password, 9);
        cracked = attack.crack();
        assertEquals("8983akbs6", cracked);
        System.out.println("Len 9");
    }
}

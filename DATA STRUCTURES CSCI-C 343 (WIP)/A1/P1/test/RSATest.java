import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RSATest {

    /**
     * Here we have some very simple tests that all work. The first
     * test is just to show that we can convert a string to a BigInteger
     * and back.
     * <p>
     * The second test is a simple encryption and decryption with small keys
     * so that can see the logic.
     * <p>
     * The third test is a more realistic test with a 1024-bit key.
     * <p> 
     * Your job is to write more tests. You should be able to break
     * the code by providing bad input. You should also test the
     * performance of the code.
     */

    @Test
    void bigInt () {
        String chars = "abc";

        BigInteger a = RSA.str2int(chars);
        String s = RSA.int2str(a);

        System.out.println("a: " + a);
        assertEquals(chars, s);
    }

    @Test
    void rsa0 () {
        RSA rsa = new RSA(5,17);

        String message = "A";
        BigInteger encrypted = rsa.encrypt(message);
        String decrypted = rsa.decrypt(encrypted);

        System.out.println("Encrypted message: " + encrypted);
        assertEquals(message, decrypted);
    }

    @Test
    void rsa1 () {
        RSA rsa = new RSA(1024);

        String message = "Hello, world!";
        BigInteger encrypted = rsa.encrypt(message);
        String decrypted = rsa.decrypt(encrypted);

        System.out.println("Encrypted message: " + encrypted);
        assertEquals(message, decrypted);
    }

    @Test
    void addedTests () {
        //breaking test
        RSA rsa = new RSA(1024);
        assertThrows(NumberFormatException.class, () -> rsa.encrypt(""));

        //breaking test,causes round tripping where M >= n and n = p*q which means M is outside the allowed range, M < n and will not decrypt properly
        RSA rsa2 = new RSA(256);
        String message = "A".repeat(8 * 1024);
        BigInteger encrypted = rsa2.encrypt(message);
        String decrypted = rsa2.decrypt(encrypted);

        assertNotEquals(message, decrypted);

        //I would suggest trying some tests that test when RSA(a, b) where a
        // and b are BigInt and that test RSA.str2int() and RSA.int2str()

        BigInteger p = new BigInteger("52549031727158910641106242621");
        BigInteger q = new BigInteger("77218182719230453779959776271");
        RSA rsa3 = new RSA(p, q);

        message = "Hello, world!!!";
        encrypted = rsa3.encrypt(message);
        decrypted = rsa3.decrypt(encrypted);

        assertEquals(message, decrypted);

        p = new BigInteger("52549031727158910641106242621");
        q = new BigInteger("77218182719230453779959776271");

        RSA rsa5 = new RSA(p, q);

        message = "Hello, world!!!";
        encrypted = rsa5.encrypt(message);
        decrypted = rsa5.decrypt(encrypted);

        assertEquals(message, decrypted);

        //performance
        RSA rsa6 = new RSA(1024);
        String message2 = "A".repeat(250);
        BigInteger encrypted2 = rsa6.encrypt(message2);
        String decrypted2 = rsa6.decrypt(encrypted2);

        assertEquals(message2, decrypted2);
    }
}

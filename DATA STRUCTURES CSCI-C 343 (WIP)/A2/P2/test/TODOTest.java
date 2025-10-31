import hash.chains.Chained;
import hash.exceptions.KeyNotFoundE;
import hash.extendible.Extendible;
import hash.probing.DoubleHashing;
import hash.probing.Linear;
import hash.probing.Quadratic;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class TODOTest {

    @Test
    void testChains() throws KeyNotFoundE {
        Chained<Integer, String> ht = new Chained<>(5, k -> k);
        ht.put(1, "A");
        ht.put(6, "B");
        ht.put(11, "C");
        ht.put(16, "D");
        ht.put(21, "E");
        assertEquals(5, ht.size());
        assertEquals("A", ht.get(1));
        assertEquals("B", ht.get(6));
        assertEquals("C", ht.get(11));
        assertEquals("D", ht.get(16));
        assertEquals("E", ht.get(21));
        assertTrue(ht.containsKey(6));
        assertTrue(ht.containsValue("C"));
        ht.remove(1);
        assertEquals(4, ht.size());
        assertThrows(KeyNotFoundE.class, () -> ht.get(1));
        assertFalse(ht.containsKey(1));
        assertFalse(ht.containsValue("A"));
        ht.rehash();
        assertEquals(4, ht.size());
        assertEquals(Set.of(6, 11, 16, 21), ht.keySet());
        assertEquals(Set.of("B", "C", "D", "E"), ht.values());
    }

    @Test
    void testLinear() throws KeyNotFoundE {
        Function<Integer, Integer> h = k -> k;
        Linear<Integer, String> ht = new Linear<>(5, h);
        ht.put(1, "A");
        ht.put(6, "B");
        ht.put(11, "C");
        ht.put(2, "D");
        assertEquals(4, ht.size());
        assertEquals("A", ht.get(1));
        assertEquals("B", ht.get(6));
        assertEquals("C", ht.get(11));
        assertEquals("D", ht.get(2));
        assertTrue(ht.containsKey(11));
        assertTrue(ht.containsValue("D"));
        ht.remove(6);
        assertEquals(3, ht.size());
        assertThrows(KeyNotFoundE.class, () -> ht.get(6));
    }

    @Test
    void testQuadratic() throws KeyNotFoundE {
        Function<Integer, Integer> h = k -> k;
        Quadratic<Integer, String> ht = new Quadratic<>(5, h);
        ht.put(1, "A");
        ht.put(6, "B");
        ht.put(11, "C");
        ht.put(2, "D");
        assertEquals(4, ht.size());
        assertEquals("A", ht.get(1));
        assertEquals("B", ht.get(6));
        assertEquals("C", ht.get(11));
        assertEquals("D", ht.get(2));
        assertTrue(ht.containsKey(11));
        assertTrue(ht.containsValue("D"));
        ht.remove(6);
        assertEquals(3, ht.size());
        assertThrows(KeyNotFoundE.class, () -> ht.get(6));
    }

    @Test
    void testDoubleHash() throws KeyNotFoundE {
        Function<Integer, Integer> h1 = k -> k;
        Function<Integer, Integer> h2 = k -> k + 7;
        DoubleHashing<Integer, String> ht = new DoubleHashing<>(5, h1, h2);
        ht.put(1, "A");
        ht.put(6, "B");
        ht.put(11, "C");
        ht.put(2, "D");
        assertEquals(4, ht.size());
        assertEquals("A", ht.get(1));
        assertEquals("B", ht.get(6));
        assertEquals("C", ht.get(11));
        assertEquals("D", ht.get(2));
        assertTrue(ht.containsKey(11));
        assertTrue(ht.containsValue("D"));
        ht.remove(6);
        assertEquals(3, ht.size());
        assertThrows(KeyNotFoundE.class, () -> ht.get(6));
    }

    @Test
    void testExtendible() throws KeyNotFoundE {
        Extendible<Integer, String> ht = new Extendible<>();
        assertTrue(ht.isEmpty());
        ht.put(1, "A");
        ht.put(6, "B");
        ht.put(11, "C");
        ht.put(16, "D");
        ht.put(21, "E");
        assertEquals(5, ht.size());
        assertEquals("A", ht.get(1));
        assertEquals("B", ht.get(6));
        assertEquals("C", ht.get(11));
        assertEquals("D", ht.get(16));
        assertEquals("E", ht.get(21));
        assertEquals(Set.of(1, 6, 11, 16, 21), ht.keySet());
        assertEquals(Set.of("A", "B", "C", "D", "E"), ht.values());
        ht.remove(1);
        assertEquals(4, ht.size());
        assertThrows(KeyNotFoundE.class, () -> ht.get(1));
        assertFalse(ht.containsKey(1));
        assertFalse(ht.containsValue("A"));
        ht.rehash();
        assertEquals(4, ht.size());
        assertEquals("B", ht.get(6));
        assertEquals("C", ht.get(11));
        assertEquals("D", ht.get(16));
        assertEquals("E", ht.get(21));
    }

    @Test
    void speed() throws KeyNotFoundE {
        int capacity = 2048;
        int size = 1500;
        int bound = 100_000;
        long seed = 42L;
        Function<Integer, Integer> h1 = k -> k;
        Function<Integer, Integer> h2 = k -> k + 7;

        Chained<Integer, String> chained = new Chained<>(capacity, h1);
        Linear<Integer, String> linear = new Linear<>(capacity, h1);
        Quadratic<Integer, String> quadratic = new Quadratic<>(capacity, h1);
        DoubleHashing<Integer, String> doubleHashing = new DoubleHashing<>(capacity, h1, h2);

        Random random = new Random(seed);
        for (int i = 0; i < size; i++) {
            int k = random.nextInt(bound);
            String v = Integer.toString(k);
            chained.put(k, v);
            linear.put(k, v);
            quadratic.put(k, v);
            doubleHashing.put(k, v);
        }

        random = new Random(seed);
        long start = System.nanoTime();
        for (int i = 0; i < size; i++) chained.get(random.nextInt(bound));
        long chainT = System.nanoTime() - start;
        System.out.println("chainT: " + chainT);

        random = new Random(seed);
        start = System.nanoTime();
        for (int i = 0; i < size; i++) linear.get(random.nextInt(bound));
        long linearT = System.nanoTime() - start;
        System.out.println("linearT: " + linearT);

        random = new Random(seed);
        start = System.nanoTime();
        for (int i = 0; i < size; i++) quadratic.get(random.nextInt(bound));
        long quadraticT = System.nanoTime() - start;
        System.out.println("quadraticT: " + quadraticT);

        random = new Random(seed);
        start = System.nanoTime();
        for (int i = 0; i < size; i++) doubleHashing.get(random.nextInt(bound));
        long doubleHashingT = System.nanoTime() - start;
        System.out.println("DoubleHashingT: " + doubleHashingT);
    }
}

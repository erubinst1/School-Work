import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

public class TrieTest {

    @Test
    public void testAdd() {
        Trie t1 = new Trie();
        t1.add("preen");
        t1.add("prune");
        t1.add("plane");
        t1.add("plane");
        t1.add("plane");
        t1.add("BOO");
        t1.add("!!@#$$");
        t1.add("");
        t1.add(" ");

        StringBuilder result = new StringBuilder();
        result.append(", 1\n").append(" , 1\n").append("!!@#$$, 1\n").append("BOO, 1\n").append("plane, 3\n").append("preen, 1\n").append("prune, 1\n");

        Assertions.assertEquals( result.toString(), t1.toString());
    }

    @Test
    public void testCount() {
        Trie t1 = new Trie();
        t1.add("Plane");
        t1.add("Plane");
        t1.add("plane");
        t1.add("!!@#$$");

        Assertions.assertEquals( 1, t1.count("plane"));
        Assertions.assertEquals( 1, t1.count("!!@#$$"));
        Assertions.assertEquals( 0, t1.count(""));
    }

    @Test
    public void testContains(){
        Trie t1 = new Trie();
        t1.add("Plane");
        t1.add("!!@#$$");

        Assertions.assertEquals( true, t1.contains("Plane"));
        Assertions.assertEquals( true, t1.contains("!!@#$$"));
        Assertions.assertEquals( false, t1.contains(""));
    }

    @Test
    public void testDelete() {
        Trie t1 = new Trie();
        t1.add("Plane");
        t1.add("Plane");
        t1.add("Plane");
        t1.add("!!@#$$");
        t1.add("!!@#$$");

        Assertions.assertEquals( 3, t1.count("Plane"));
        t1.delete("Plane");
        Assertions.assertEquals( 0, t1.count("Plane"));

        Assertions.assertEquals( 2, t1.count("!!@#$$"));
        t1.delete("!!@#$$");
        Assertions.assertEquals( 0, t1.count("!!@#$$"));
        t1.delete("");
    }

    @Test
    public void testRemove() {
        Trie t1 = new Trie();
        t1.add("plane");
        t1.add("plane");
        t1.add("plane");
        t1.add("!!@#$$");
        t1.add("!!@#$$");
        t1.add("bang");
        t1.add("Bang");

        Assertions.assertEquals( 3, t1.count("plane"));
        t1.remove("plane", 1);
        Assertions.assertEquals( 2, t1.count("plane"));

        Assertions.assertEquals( 2, t1.count("!!@#$$"));
        t1.remove("!!@#$$", 11111111);
        Assertions.assertEquals( 0, t1.count("!!@#$$"));

        Assertions.assertEquals( 1, t1.count("Bang"));
        t1.remove("Bang", 1);
        Assertions.assertEquals( 1, t1.count("bang"));
    }

    @Test
    public void testAddAll() {
        Trie t1 = new Trie();
        t1.addAll("preen", "prune", "plane", "plane", "plane", "BOO", "!!@#$$", "", " ");

        StringBuilder result = new StringBuilder();
        result.append(", 1\n").append(" , 1\n").append("!!@#$$, 1\n").append("BOO, 1\n").append("plane, 3\n").append("preen, 1\n").append("prune, 1\n");

        Assertions.assertEquals( result.toString(), t1.toString());
    }

    @Test
    public void testCountMap() {
        Trie t1 = new Trie();
        t1.addAll("preen", "prune", "plane", "plane", "plane", "BOO", "!!@#$$", "", " ");

        Assertions.assertEquals(Map.of("", 1, " ", 1, "!!@#$$", 1, "BOO", 1, "plane", 3, "preen", 1, "prune", 1)
                , t1.countMap());
    }

    @Test
    public void testToString() {
        Trie t1 = new Trie();
        t1.addAll("preen", "prune", "plane", "plane", "plane", "BOO", "!!@#$$", "", " ");

        StringBuilder result = new StringBuilder();
        result.append(", 1\n").append(" , 1\n").append("!!@#$$, 1\n").append("BOO, 1\n").append("plane, 3\n").append("preen, 1\n").append("prune, 1\n");

        Assertions.assertEquals( result.toString(), t1.toString());
    }

    @Test
    public void testCollectPrefix() {
        Trie t1 = new Trie();
        t1.addAll("preen", "prune", "plane", "plane", "plane", "BOO", "!!@#$$", "boo");

        Assertions.assertEquals( Set.of("preen", "prune", "plane"), t1.collectPrefix("p"));
        Assertions.assertEquals( Set.of("preen", "prune"), t1.collectPrefix("pr"));
        Assertions.assertEquals( Set.of("boo"), t1.collectPrefix("b"));
        Assertions.assertEquals( Set.of("!!@#$$"), t1.collectPrefix("!!@#"));
        Assertions.assertEquals( Set.of("preen", "prune", "plane", "BOO", "!!@#$$", "boo"), t1.collectPrefix(""));

    }

    @Test
    public void testKthWord() {
        Trie t1 = new Trie();
        t1.addAll("preen", "prune", "plane", "plane", "plane", "BOO", "!!@#$$", "boo");

        //??
        Assertions.assertEquals("!!@#$$", t1.kthWord(0));
        Assertions.assertEquals("!!@#$$", t1.kthWord(1));
        Assertions.assertEquals("BOO", t1.kthWord(2));
        Assertions.assertEquals("plane", t1.kthWord(5));
        Assertions.assertEquals("preen", t1.kthWord(7));
        Assertions.assertEquals("prune", t1.kthWord(8));
    }
}

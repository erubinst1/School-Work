import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Problem7Test {

    @Test
    void testProblem7() {
        Map< String, Integer> t1o = new HashMap<>();
        t1o.put("hello", 1);
        t1o.put("world", 3);
        t1o.put("the", 2);
        t1o.put("is", 3);
        t1o.put("healthy", 2);
        t1o.put("it", 1);
        t1o.put("i", 1);
        t1o.put("certainly", 1);
        t1o.put("agree", 1);
        t1o.put("that", 1);
        t1o.put("1", 1);
        t1o.put("and", 1);
        t1o.put("not", 1);

        Assertions.assertAll(
                () -> Assertions.assertEquals( t1o, Problem7.wordCount(
                        "Hello world, the world is healthy, is it not? I certainly agree that the world is #1 and healthy.")),
                () -> Assertions.assertEquals( Map.of("1", 9), Problem7.wordCount("1 1 1 1 1 1 1 1 1")),
                () -> Assertions.assertEquals( Map.of("p", 1), Problem7.wordCount("~`!@#$%^&*()_+-={}[]|:',.<>/?p")),
                () -> Assertions.assertEquals( Map.of("a", 1, "b", 1, "c", 1, "d", 1, "e", 1), Problem7.wordCount("A B C D E"))
        );
    }

}
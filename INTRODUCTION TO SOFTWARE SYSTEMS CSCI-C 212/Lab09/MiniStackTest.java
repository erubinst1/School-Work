
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MiniStackTest {

    @Test
    void testAdd() {
        MiniStack<Integer> s1 = new MiniStack<>();
        s1.add(1);
        Assertions.assertEquals( 1, s1.peek());
        s1.add(2);
        Assertions.assertEquals( 2, s1.peek());
        s1.add(3);
        Assertions.assertEquals( 3, s1.peek());
    }

    @Test
    void testPeek() {
        MiniStack<Integer> s1 = new MiniStack<>();
        Assertions.assertEquals( null, s1.peek());
        s1.add(1);
        s1.add(2);
        Assertions.assertEquals( 2, s1.peek());
        s1.pop();
        Assertions.assertEquals( 1, s1.peek());
    }

    @Test
    void testPop() {
        MiniStack<Integer> s1 = new MiniStack<>();
        s1.add(1);
        Assertions.assertEquals( 1, s1.pop());
        Assertions.assertEquals( null, s1.peek());
        Assertions.assertEquals( null, s1.pop());
    }

    @Test
    void testToString() {
        MiniStack<Integer> s1 = new MiniStack<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Assertions.assertEquals( "3, 2, 1", s1.toString());

        MiniStack<String> s2 = new MiniStack<>();
        s2.add("Hello ");
        s2.add("World");
        s2.add("!");
        Assertions.assertEquals( "!, World, Hello ", s2.toString());
    }
}

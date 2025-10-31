import exceptions.EmptyListE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersistentLLTest {
    @Test
    void test1 () throws EmptyListE {
        PersistentLL<Integer> list = PersistentLL.makeList(1, 2, 3, 4, 5);
        assertEquals(5, list.length());
        assertTrue(list.find(3));
        assertFalse(list.find(6));
        assertEquals("1 , 2 , 3 , 4 , 5 , *", list.toString());
        list = list.insert(6, 2);
        assertEquals("1 , 2 , 6 , 3 , 4 , 5 , *", list.toString());
        list = list.delete(2);
        assertEquals("1 , 2 , 3 , 4 , 5 , *", list.toString());

        PersistentLL<Integer> list2 = PersistentLL.makeList();
        assertEquals("*", list2.toString());

        Integer[] arr = new Integer[100];
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            expected.append(i).append(" , ");
        }
        PersistentLL<Integer> list3 = PersistentLL.makeList(arr);
        assertEquals(expected + "*", list3.toString());

        PersistentLL<String> list4 = PersistentLL.makeList("a", "b", "c", "d", "rest of the alphabet");
        assertEquals("a , b , c , d , rest of the alphabet , *", list4.toString());
        list4 = list4.delete(0);
        list4 = list4.delete(0);
        assertEquals("c , d , rest of the alphabet , *", list4.toString());
        list4 = list4.insert("b", 0);
        list4 = list4.insert("a", 0);
        assertEquals("a , b , c , d , rest of the alphabet , *", list4.toString());
    }
}
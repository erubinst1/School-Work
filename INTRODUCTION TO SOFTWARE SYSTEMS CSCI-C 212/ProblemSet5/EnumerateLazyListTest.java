import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EnumerateLazyListTest {
    @Test
    void testRangeLazyList(){
        List<String> inputList1 = List.of("apple", "banana", "cherry");
        EnumerateLazyList<String> enumerateLazyList1 = EnumerateLazyList.enumerate(inputList1);
        int index1 = 0;
        for (EnumerateLazyList.EnumerateItem<String> item : enumerateLazyList1) {
            Assertions.assertEquals(index1, item.getIndex());
            Assertions.assertEquals(inputList1.get(index1), item.getItem());
            Assertions.assertEquals("(" + index1 + ", " + inputList1.get(index1) + ")", item.toString());
            index1++;
        }

        List<String> inputList2 = List.of();
        EnumerateLazyList<String> enumerateLazyList2 = EnumerateLazyList.enumerate(inputList2);
        Assertions.assertEquals( false, enumerateLazyList2.iterator().hasNext());

        List<String> inputList3 = new ArrayList<>();
        inputList3.add("apple");
        inputList3.add(null);
        inputList3.add("cherry");
        EnumerateLazyList<String> enumerateLazyList3 = EnumerateLazyList.enumerate(inputList3);
        int index3 = 0;
        for (EnumerateLazyList.EnumerateItem<String> item : enumerateLazyList3) {
            Assertions.assertEquals(index3, item.getIndex());
            Assertions.assertEquals(inputList3.get(index3), item.getItem());
            Assertions.assertEquals("(" + index3 + ", " + inputList3.get(index3) + ")", item.toString());
            index3++;
        }

        List<String> inputList4 = List.of("apple", "banana", "apple");
        EnumerateLazyList<String> enumerateLazyList4 = EnumerateLazyList.enumerate(inputList4);
        int index4 = 0;
        for (EnumerateLazyList.EnumerateItem<String> item : enumerateLazyList4) {
            Assertions.assertEquals(index4, item.getIndex());
            Assertions.assertEquals(inputList4.get(index4), item.getItem());
            Assertions.assertEquals("(" + index4 + ", " + inputList4.get(index4) + ")", item.toString());
            index4++;
        }

        List<String> inputList5 = List.of("one", "two", "three");
        EnumerateLazyList<String> enumerateLazyList5 = EnumerateLazyList.enumerate(inputList5);
        Iterator<EnumerateLazyList.EnumerateItem<String>> iterator = enumerateLazyList5.iterator();
        int index5 = 0;
        while (iterator.hasNext()) {
            EnumerateLazyList.EnumerateItem<String> item = iterator.next();
            Assertions.assertEquals(index5, item.getIndex());
            Assertions.assertEquals(inputList5.get(index5), item.getItem());
            index5++;
        }
        Assertions.assertEquals(inputList5.size(), index5);
    }
}
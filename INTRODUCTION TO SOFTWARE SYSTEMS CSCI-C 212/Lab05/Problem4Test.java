import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class Problem4Test {

    @Test
    void testWisest() {
        ArrayList<Integer> t1in = new ArrayList<>(Arrays.asList(31, 42, 43, 35, 21, 27, 24, 44));
        ArrayList<Integer> t1out = new ArrayList<>(Arrays.asList(43, 35));

        ArrayList<Integer> t2in = new ArrayList<>(Arrays.asList(47, 51, 52, 48, 33, 67, 45, 35));
        ArrayList<Integer> t2out = new ArrayList<>(Arrays.asList(33, 67));

        ArrayList<Integer> t3in = new ArrayList<>(Arrays.asList());
        ArrayList<Integer> t3out = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));

        ArrayList<Integer> t4in = new ArrayList<>(Arrays.asList(47, 51, 52, 48, 45, 35, 33, 67));
        ArrayList<Integer> t4out = new ArrayList<>(Arrays.asList(33, 67));

        ArrayList<Integer> t5in = new ArrayList<>(Arrays.asList(33, 67, 47, 51, 45, 35));
        ArrayList<Integer> t5out = new ArrayList<>(Arrays.asList(33, 67));

        Assertions.assertAll(
                () -> Assertions.assertEquals( t1out, (Problem4.wisest(t1in))),
                () -> Assertions.assertEquals( t2out, (Problem4.wisest(t2in))),
                () -> Assertions.assertEquals( t3out, (Problem4.wisest(t3in))),
                () -> Assertions.assertEquals( t4out, (Problem4.wisest(t4in))),
                () -> Assertions.assertEquals( t5out, (Problem4.wisest(t5in)))
        );
    }
}

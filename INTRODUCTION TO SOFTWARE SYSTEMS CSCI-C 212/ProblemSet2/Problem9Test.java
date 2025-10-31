import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem9Test {

    @Test
    void testProblem9() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(100, Problem9.strSumNums("hello50how20are30you?")),
                () -> Assertions.assertEquals(10, Problem9.strSumNums("t1h1i1s1i1s1e1a1s1y1!")),
                () -> Assertions.assertEquals(0, Problem9.strSumNums("there are no numbers :()?")),
                () -> Assertions.assertEquals(0, Problem9.strSumNums("still 0 just 0 zero0!")),
                () -> Assertions.assertEquals(500000, Problem9.strSumNums("500000")),
                () -> Assertions.assertEquals(4, Problem9.strSumNums("2afiufajifakjfakj2")),
                () -> Assertions.assertEquals(240, Problem9.strSumNums("240afiufajifakjfakj")),
                () -> Assertions.assertEquals(224, Problem9.strSumNums("2afiufajifakjfakj222"))
        );
    }
}

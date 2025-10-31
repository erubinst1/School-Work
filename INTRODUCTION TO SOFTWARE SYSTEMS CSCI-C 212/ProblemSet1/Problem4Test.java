import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem4Test {

    @Test
    void testProblem4() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(3,0,1)),
                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(-3,0,1)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(3.1,0,1)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(-3.1,0,1)),

                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(2,0,1)),
                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(-2,0,1)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(5,0,1)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(5,0,1)),

                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(50,8,14)),
                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(-34,8,14)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(50.1,8,14)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(-34.1,8,14)),

                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(45,8,14)),
                () -> Assertions.assertEquals( false, Problem4.isExtremeOutlier(-29,8,14)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(59,8,14)),
                () -> Assertions.assertEquals( true, Problem4.isExtremeOutlier(-40,8,14))
        );
    }
}

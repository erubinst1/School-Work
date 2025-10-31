import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem12Test {

    @Test
    void testProblem12() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( true, Problem12.isInsideRectangle(0,0,5,5,0,0)),
                () -> Assertions.assertEquals( false, Problem12.isInsideRectangle(0,0,5,5,10,10)),
                () -> Assertions.assertEquals( false, Problem12.isInsideRectangle(0,0,5,5,2.5,2.5)),
                () -> Assertions.assertEquals( true, Problem12.isInsideRectangle(55,55,51,51,55,55)),
                () -> Assertions.assertEquals( false, Problem12.isInsideRectangle(55,55,51,51,0,0)),
                () -> Assertions.assertEquals( false, Problem12.isInsideRectangle(55,55,51,51,80.5,80.5))
        );
    }
}

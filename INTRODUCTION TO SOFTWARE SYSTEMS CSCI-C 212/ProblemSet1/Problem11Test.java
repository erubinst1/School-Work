import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem11Test {

    @Test
    void testProblem11() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( false, Problem11.not(true)),
                () -> Assertions.assertEquals( true, Problem11.not(false)),

                () -> Assertions.assertEquals( true, Problem11.and(true, true)),
                () -> Assertions.assertEquals( false, Problem11.and(true, false)),
                () -> Assertions.assertEquals( false, Problem11.and(false, true)),
                () -> Assertions.assertEquals( false, Problem11.and(false, false)),

                () -> Assertions.assertEquals( true, Problem11.cond(true, true)),
                () -> Assertions.assertEquals( false, Problem11.cond( true, false)),
                () -> Assertions.assertEquals( true, Problem11.cond( false, true)),
                () -> Assertions.assertEquals( true, Problem11.cond( false, false)),

                () -> Assertions.assertEquals( true, Problem11.or( true, true)),
                () -> Assertions.assertEquals( true, Problem11.or( true, false)),
                () -> Assertions.assertEquals( true, Problem11.or( false, true)),
                () -> Assertions.assertEquals( false, Problem11.or( false, false)),


                () -> Assertions.assertEquals( true, Problem11.bicond( true, true)),
                () -> Assertions.assertEquals( false, Problem11.bicond( true, false)),
                () -> Assertions.assertEquals( false, Problem11.bicond( false, true)),
                () -> Assertions.assertEquals( true, Problem11.bicond( false, false))
        );
    }
}

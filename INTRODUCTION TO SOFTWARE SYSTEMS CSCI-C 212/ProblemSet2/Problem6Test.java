import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem6Test {

    @Test
    void testProblem6() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( null, Problem6.guessWord("PLANS", "TRAP")),
                () -> Assertions.assertEquals( "--A-*", Problem6.guessWord("PLANS", "TRAIN")),
                () -> Assertions.assertEquals( "PLAN-", Problem6.guessWord("PLANS", "PLANE")),
                () -> Assertions.assertEquals( "PLANS", Problem6.guessWord("PLANS", "PLANS")),
                () -> Assertions.assertEquals( "*****", Problem6.guessWord("PLANS", "SNLPA")),
                () -> Assertions.assertEquals( "*-----", Problem6.guessWord("Crooks", "SnAelA")),
                () -> Assertions.assertEquals( null, Problem6.guessWord("las", "sksnksnk")),
                () -> Assertions.assertEquals( null, Problem6.guessWord("", "SnAelA")),
                () -> Assertions.assertEquals( null, Problem6.guessWord("afafaf", "")),
                () -> Assertions.assertEquals( "", Problem6.guessWord("", ""))
        );
    }
}

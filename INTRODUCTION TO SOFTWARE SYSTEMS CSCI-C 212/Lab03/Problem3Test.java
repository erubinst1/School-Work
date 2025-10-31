import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem3Test {

    @Test
    void testIsFactorion() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( true, Problem3.isFactorion(145)),
                () -> Assertions.assertEquals( true, Problem3.isFactorion(40585)),
                () -> Assertions.assertEquals( true, Problem3.isFactorion(2)),
                () -> Assertions.assertEquals( true, Problem3.isFactorion(1)),
                () -> Assertions.assertEquals( false, Problem3.isFactorion(4234553))
        );
    }



    @Test
    void testIsFactorionTR() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( true, Problem3.isFactorionTR(145)),
                () -> Assertions.assertEquals( true, Problem3.isFactorionTR(40585)),
                () -> Assertions.assertEquals( true, Problem3.isFactorionTR(2)),
                () -> Assertions.assertEquals( true, Problem3.isFactorionTR(1)),
                () -> Assertions.assertEquals( false, Problem3.isFactorionTR(4234553))
        );
    }
}

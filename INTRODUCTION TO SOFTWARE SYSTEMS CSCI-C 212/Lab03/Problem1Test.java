import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1Test {

    @Test
    void testReplaceAB() {
        Assertions.assertAll(
                //Standard recursion
                () -> Assertions.assertEquals( "BDCBDC", Problem1.replaceAB("ADCADC")),
                () -> Assertions.assertEquals( "", Problem1.replaceAB("")),
                () -> Assertions.assertEquals( "BBBBB", Problem1.replaceAB("AAAAA")),
                () -> Assertions.assertEquals( "DDDD", Problem1.replaceAB("DDDD")),
                () -> Assertions.assertEquals( "BDC BDC", Problem1.replaceAB("ADC ADC"))
        );
    }

    @Test
    void testReplaceABTR() {
        Assertions.assertAll(
                //Standard recursion
                () -> Assertions.assertEquals( "BDCBDC", Problem1.replaceABTR("ADCADC")),
                () -> Assertions.assertEquals( "", Problem1.replaceABTR("")),
                () -> Assertions.assertEquals( "BBBBB", Problem1.replaceABTR("AAAAA")),
                () -> Assertions.assertEquals( "DDDD", Problem1.replaceABTR("DDDD")),
                () -> Assertions.assertEquals( "BDC BDC", Problem1.replaceABTR("ADC ADC"))
        );
    }
}


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
userId("Joshua", "Crotts", 1999) => "CrottJ99"
userId("Katherine", "Johnson", 1918) => "JohnsK18"
userId("Fred", "Fu", 1957) => "FuF57"
 */
class Problem1Test {

    @Test
    void testUserId() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("CrottJ99", Problem1.userId("Joshua","Crotts",1999)),
                () -> Assertions.assertEquals("JohnsK18", Problem1.userId("Katherine","Johnson",1918)),
                () -> Assertions.assertEquals("FuF57", Problem1.userId("Fred","Fu",1957)),
                () -> Assertions.assertEquals("AE1", Problem1.userId("E","A",1))
        );
    }
}

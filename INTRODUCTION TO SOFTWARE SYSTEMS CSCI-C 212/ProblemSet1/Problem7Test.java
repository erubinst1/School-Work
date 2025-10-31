import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem7Test {

    @Test
    void testProblem7() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("ejrubins", Problem7.cutUsername("ejrubins@iu.edu")),
                () -> Assertions.assertEquals("kskjskjsjdjfnna1223", Problem7.cutUsername("kskjskjsjdjfnna1223@iu.edu"))
        );
    }
}

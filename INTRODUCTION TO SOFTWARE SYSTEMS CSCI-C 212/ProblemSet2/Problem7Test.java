import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem7Test {

    @Test
    void testProblem7() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( null , Problem7.substring("ABCDE", 0, 10)),
                () -> Assertions.assertEquals( null , Problem7.substring("ABCDE", -3, 1)),
                () -> Assertions.assertEquals( "ABCDE".substring(0,1), Problem7.substring("ABCDE", 0, 1)),
                () -> Assertions.assertEquals( "ABC  DDE".substring(0,7) , Problem7.substring("ABC  DDE", 0, 7)),
                () -> Assertions.assertEquals( "ASf218ghadf%$".substring(3,3) , Problem7.substring("ASf218ghadf%$", 3, 3)),
                () -> Assertions.assertEquals( " ".substring(0,1) , Problem7.substring(" ", 0, 1)),
                () -> Assertions.assertEquals( " ".substring(0,0) , Problem7.substring(" ", 0, 0)),
                () -> Assertions.assertEquals( "".substring(0,0) , Problem7.substring("", 0, 0))
        );
    }
}

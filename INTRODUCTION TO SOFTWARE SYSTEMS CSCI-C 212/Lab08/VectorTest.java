import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VectorTest {

    @Test
    void testUnitVector(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(new Vector(0.6, 0.8, 0.0), new Vector(3, 4, 0).unitVector()),
                () -> Assertions.assertEquals(new Vector(0.3, 0.7, 0.7), new Vector(1, 2, 2).unitVector()),
                () -> Assertions.assertEquals(new Vector(0.0, 0.0, 1.0), new Vector(0, 0, 5).unitVector()),
                () -> Assertions.assertEquals(new Vector(-1.0, 0.0, 0.0), new Vector(-7, 0, 0).unitVector()),
                () -> Assertions.assertEquals(new Vector(0.4, 0.6, 0.7), new Vector(30, 40, 50).unitVector()),
                () -> Assertions.assertEquals(new Vector(0.4, 0.6, 0.7), new Vector(6, 8, 10).unitVector())
        );
    }

    @Test
    void testDotProduct(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(0.0, new Vector(1, 0, 0).dotProduct(new Vector(0, 1, 0))),
                () -> Assertions.assertEquals(12.0, new Vector(2, 2, 2).dotProduct(new Vector(2, 2, 2))),
                () -> Assertions.assertEquals(-1.0, new Vector(1, 0, 0).dotProduct(new Vector(-1, 0, 0))),
                () -> Assertions.assertEquals(3.0, new Vector(1, 3, -5).dotProduct(new Vector(4, -2, -1))),
                () -> Assertions.assertEquals(0.0, new Vector(0, 0, 0).dotProduct(new Vector(1, 2, 3))),
                () -> Assertions.assertEquals(32000000.0, new Vector(1000, 2000, 3000).dotProduct(new Vector(4000, 5000, 6000)))
        );
    }

    @Test
    void testCrossProduct(){
        Assertions.assertAll(
                () -> Assertions.assertEquals(new Vector(0, 0, 1), new Vector(1, 0, 0).crossProduct(new Vector(0, 1, 0))),
                () -> Assertions.assertEquals(new Vector(0, 0, 0), new Vector(1, 0, 0).crossProduct(new Vector(1, 0, 0))),
                () -> Assertions.assertEquals(new Vector(-4, 8, -4), new Vector(1, 2, 3).crossProduct(new Vector(3, 2, 1))),
                () -> Assertions.assertEquals(new Vector(-2, 4, -2), new Vector(2, 3, 4).crossProduct(new Vector(4, 5, 6))),
                () -> Assertions.assertEquals(new Vector(0, 0, 0), new Vector(0, 0, 0).crossProduct(new Vector(1, 2, 3))),
                () -> Assertions.assertEquals(new Vector(-20000, 40000, -20000), new Vector(100, 200, 300).crossProduct(new Vector(300, 400, 500)))
        );
    }


}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class P4StudentTest {
    private static double sep(double a, double b) {
        // horizontal separation between centers when both touch the baseline
        return 2.0 * Math.sqrt(a * b);
    }

    @Test
    void emptyArray() {
        CirclePacker packer = new OrderedCirclePacker();
        assertEquals(0.0, packer.packWidth(new double[]{}), 1e-12);
    }

    @Test
    void twoEqualRadii() {
        CirclePacker packer = new OrderedCirclePacker();
        double r = 2.5;
        // x0 = r; x1 = max(r, x0 + sep(r,r)) = r + 2r = 3r
        // width = max(x0 + r, x1 + r) = 4r
        double expected = 4.0 * r;
        double w = packer.packWidth(new double[]{r, r});
        assertEquals(expected, w, 1e-9);
    }

    @Test
    void twoDifferentRadii_ordered() {
        CirclePacker packer = new OrderedCirclePacker();
        double r1 = 3.0, r2 = 1.0;
        // x0 = r1
        // x1 = max(r2, x0 + sep(r2, r1)) = r1 + 2*sqrt(r1*r2)  (this dominates for these values)
        double x1 = r1 + sep(r1, r2);
        double expected = Math.max(r1 + r1, x1 + r2);
        double w = packer.packWidth(new double[]{r1, r2});
        assertEquals(expected, w, 1e-9);
    }

    @Test
    void threeEqualRadii_chain() {
        CirclePacker packer = new OrderedCirclePacker();
        double r = 1.0;
        // x0 = 1, x1 = 3, x2 = 5; width = x2 + r = 6
        double w = packer.packWidth(new double[]{r, r, r});
        assertEquals(6.0, w, 1e-9);
    }

    @Test
    void alternatingLargeSmall() {
        CirclePacker packer = new OrderedCirclePacker();
        double[] r = {3, 1, 3, 1};

        // Manual placement using sep:
        // i=0: x0 = 3
        // i=1: x1 = max(1, x0 + sep(1,3)) = 3 + 2*sqrt(3) ≈ 6.4641
        // i=2: x2 = max(3, x0 + sep(3,3)=3+6=9, x1 + sep(3,1)=x1+2*sqrt(3)≈9.9282) = 9.9282
        // i=3: x3 = max(1, x0+sep(1,3)=3+2*sqrt(3)≈6.4641, x1+sep(1,1)=x1+2=8.4641, x2+sep(1,3)=x2+2*sqrt(3)≈13.3923) = 13.3923
        double x0 = 3.0;
        double x1 = x0 + sep(1, 3);
        double x2 = Math.max(x0 + sep(3, 3), x1 + sep(3, 1));
        double x3 = Math.max(Math.max(x0 + sep(1, 3), x1 + sep(1, 1)), x2 + sep(1, 3));
        double expected = Math.max(Math.max(x0 + 3, x1 + 1), Math.max(x2 + 3, x3 + 1));

        double w = packer.packWidth(r);
        assertEquals(expected, w, 1e-6);
    }

    @Test
    void nonIntegerRadii() {
        CirclePacker packer = new OrderedCirclePacker();
        double[] r = {1.2, 0.7, 2.3};
        double w = packer.packWidth(r);
        assertTrue(w > 0.0);
        assertTrue(w >= 2.0 * 2.3, "Width must be at least diameter of largest circle");
    }

    @Test
    void decreasingRadii() {
        CirclePacker packer = new OrderedCirclePacker();
        double[] r = {4, 3, 2, 1};
        double w = packer.packWidth(r);
        assertTrue(w >= 8.0, "At least the first diameter");
        assertTrue(w >= 2.0 * 4, "Width cannot be less than largest diameter");
    }

    @Test
    void monotonicityAddingCircle() {
        CirclePacker packer = new OrderedCirclePacker();
        double[] r1 = {2, 1, 2};
        double[] r2 = {2, 1, 2, 1};
        double w1 = packer.packWidth(r1);
        double w2 = packer.packWidth(r2);
        assertTrue(w2 >= w1, "Adding a circle cannot reduce total width");
    }

    @Test
    void matchesPdfExampleAgain() {
        CirclePacker packer = new OrderedCirclePacker();
        // From the PDF: radii 2,1,2 -> width = 4 + 4*sqrt(2)
        double expected = 4.0 + 4.0 * Math.sqrt(2.0);
        double w = packer.packWidth(new double[]{2, 1, 2});
        assertEquals(expected, w, 1e-6);
    }
}

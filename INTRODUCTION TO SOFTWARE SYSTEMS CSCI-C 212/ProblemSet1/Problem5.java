// Exercise 1.15

class Problem5 {


    /**
     * Computes the third side length of a triangle, given two sides and the angle between
     *
     * @param a length of side a
     * @param b length of side b
     * @param th angle between side a and b
     * @return length of side c
     */
    static double lawOfCosines(double a, double b, double th) {
        return Math.sqrt( a*a + b*b - 2*a*b*Math.cos(Math.toRadians(th)));
    }
}

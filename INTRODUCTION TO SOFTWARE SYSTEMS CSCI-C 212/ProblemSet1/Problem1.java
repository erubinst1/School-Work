// Exercise 1.4

class Problem1 {

    /**
     * Converts a distance in gigameters to light seconds
     *
     * @param gm distance in gigameters
     * @return distance in light seconds.
     */
    static double gigameterToLightsecond(double gm) {
         double lightSpeed = 299792458;
        return (gm * 1000000000)/lightSpeed;
    }
}

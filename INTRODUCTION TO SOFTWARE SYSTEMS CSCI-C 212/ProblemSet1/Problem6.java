// Exercise 1.17

class Problem6 {

    /**
     * Computes object displacement using a formula
     *
     * @param vi initial velocity in meters
     * @param a acceleration in meters per second
     * @param t time in seconds
     * @return distance traveled in meters
     */
    static double distanceTraveled(double vi, double a, double t) {
        return vi*t + 0.5*a*t*t;
    }
}

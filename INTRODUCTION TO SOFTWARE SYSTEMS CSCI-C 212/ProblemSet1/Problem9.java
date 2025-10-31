// Exercise 2.8

class Problem9 {

    /**
     * Returns a boolean related to if the three input integers are evenly spaced
     *
     * @param a integer one
     * @param b integer two
     * @param c integer three
     * @return true if the three integers are evenly spaced, false if not
     */
    static boolean isEvenlySpaced(int a, int b, int c) {
        int max = Math.max(c,Math.max(a,b));
        int min = Math.min(c,Math.min(a,b));
        int mid = a + b + c - max - min;

        return (Math.abs(max-mid) == Math.abs(mid-min));
    }
}

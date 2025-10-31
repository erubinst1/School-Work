// Exercise 2.6

class Problem8 {

    /**
     * Returns a boolean depending on if the difference between any of the given values is less than 20
     *
     * @param x integer one
     * @param y integer two
     * @param z integer three
     * @return true if the difference between any of the given values is less than 20, false if not
     */
    static boolean lessThan20(int x, int y, int z) {
        return Math.abs(x-y) < 20 || Math.abs(x-z) < 20 || Math.abs(y-z) < 20;
    }

}

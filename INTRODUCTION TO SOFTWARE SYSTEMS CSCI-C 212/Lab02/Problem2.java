class Problem2 {

    /**
     * Computes the largest of the three input integers
     * @param x integer one
     * @param y integer two
     * @param z integer three
     * @return largest integer
     */
    static int max(int x, int y, int z) {
        if(x > y && x > z)
            return x;
        if( y > x && y > z)
            return y;
        return z;
    }
}

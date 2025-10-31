// Exercise 1.10

class Problem3 {

    /**
     * Computes the surface area of a pyramid with a base, width, and height
     *
     * @param l base length of the pyramid
     * @param w base width of the pyramid
     * @param h pyramid height
     * @return surface area of the pyramid
     */
    static double pyramidSurfaceArea(double l, double w, double h) {
        return l*w + l*Math.sqrt( (w/2)*(w/2) + h*h) + w*Math.sqrt( (l/2)*(l/2) + h*h);
    }
}

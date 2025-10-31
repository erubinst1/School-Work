// Exercise 2.14

class Problem12 {

    /**
     * Returns a boolean indicating if the given point falls inside the rectangle
     *
     * @param rx x value of the rectangles center
     * @param ry y value of the rectangles center
     * @param w width of the rectangle
     * @param h height of the rectangle
     * @param px x value of the point
     * @param py y value of the point
     * @return true if the point falls strictly inside the rectangle, false if not
     */
    static boolean isInsideRectangle(double rx, double ry, double w, double h, double px, double py) {
        return (px > (rx - w/2) && px < (rx + w/2)) && (py > (ry - h/2) && py < (ry + h/2));
    }
}

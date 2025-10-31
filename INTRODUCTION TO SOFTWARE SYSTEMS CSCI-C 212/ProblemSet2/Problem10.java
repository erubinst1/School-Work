class Problem10 {

    /**
     * Computes a left/right Riemann approximation of the area of a circle
     *
     * @param r radius of the circle
     * @param p width of rectangles used to approximate
     * @return approximate area of the circle
     */
    static double circleArea(double r, double p) {
        //for height, either use left or right edge
        return middleSum(r, p) * 4;
    }

    /** Computes the middle Riemann approximation of the area of the top right quadrant of a circle
     *
     * @param r radius of the circle
     * @param p width of rectangles used to approximate
     * @return middle Riemann approximation of the top right quadrant of the circle
     */
    static double middleSum(double r, double p){
        //for height, either use left or right edge
        double area = 0;
        for( double i = 0 ; i <= r; i+=p){
            area += p * (circleFunction(r, i));
        }
        return area;
    }

    /**Computes the y cordinate of a point on a circle
     *
     * @param r radius of the circle
     * @param x x value of the point
     * @return y value of the point
     */
    static double circleFunction(double r, double x){
        return Math.sqrt( r*r - x*x);
    }
}

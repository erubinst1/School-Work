// Exercise 3.25

import java.util.Arrays;

class Problem4 {

    /**
     * Computes the line of best-fit for a collection of points
     *
     * @param x array of x coordinates
     * @param y array of y coordinates
     * @return array containing the y intercept at index 0 and the slope at index 1 of the line of best-fit
     */
    static double[] linearRegression(double[] x, double[] y) {
        if( x.length != y.length){
            return null;
        }
        return new double[]{computeAlpha(x,y), computeBeta(x,y)};
    }

    /**
     * Computes the y intercept for the line of best-fit
     *
     * @param x array of x coordinates
     * @param y array of y coordinates
     * @return y intercept of the line of best-fit
     */
    private static double computeAlpha(double[] x, double [] y){
        double sumY = 0;
        double sumXSquared = 0;
        double sumX = 0;
        double sumXY = 0;


        for( int i = 0; i < x.length; i++){
            sumY += y[i];
            sumXSquared += Math.pow(x[i],2);
            sumX += x[i];
            sumXY += x[i] * y[i];
        }

        return (sumY*sumXSquared - sumX*sumXY) / (x.length * sumXSquared - Math.pow(sumX,2));
    }

    /**
     * Computes the slope for the line of best-fit
     *
     * @param x array of x coordinates
     * @param y array of y coordinates
     * @return slope of the line of best-fit
     */
    private static double computeBeta(double[] x, double [] y){
        double sumY = 0;
        double sumXSquared = 0;
        double sumX = 0;
        double sumXY = 0;


        for( int i = 0; i < x.length; i++){
            sumY += y[i];
            sumXSquared += Math.pow(x[i],2);
            sumX += x[i];
            sumXY += x[i] * y[i];
        }

        return (x.length * sumXY - sumX * sumY) / (x.length * sumXSquared - Math.pow(sumX,2));
    }
}

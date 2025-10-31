// Exercise 1.13

class Problem4 {

    /**
     * Returns a boolean indicating if the data point is an extreme outlier
     *
     * @param x data point to be checked
     * @param avg mean of the normal distribution
     * @param stddev standard deviation of the normal distribution
     * @return true if the datapoint is an extreme outlier, false if noy
     */
    static boolean isExtremeOutlier(double x, double avg, double stddev) {
        return (x - avg) / stddev > 3 || (x - avg) / stddev < -3;
    }
}

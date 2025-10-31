class Problem2 {

    /**
     * Computes the hyperfactorial of an input
     *
     * @param n long input
     * @return computed hyperfactorial value
     */
    static long hyperfactorial(long n) {
        if( n == 0){
            return 1;
        }
        else{
            return (long) Math.pow(n,n) * hyperfactorial(n-1);
        }
    }

    /**
     * Computes the hyperfactorial of an input
     *
     * @param n long input
     * @return computed hyperfactorial value
     */
    static long hyperfactorialTR(long n) {
        return hyperfactorialTRH(n, 1);
    }

    /**
     *  Helper method for calculating hyperfactorials
     *
     * @param n long input
     * @param acc accumulator of the hyperfactorial value
     * @return hyperfactorial of n
     */
    private static long hyperfactorialTRH(long n, long acc) {
        if( n == 0){
            return acc;
        }
        else{
            acc = (long) (acc * Math.pow(n,n));
            return hyperfactorialTRH( n-1, acc);
        }
    }

    /**
     * Computes the hyperfactorial of an input
     *
     * @param n long input
     * @return hyperfactorial of n
     */
    static long hyperfactorialLoop(long n) {
        long sum = 1;
        while( n > 0){
            sum = (long) (sum * Math.pow(n,n));
            n--;
        }
        return sum;
    }
}

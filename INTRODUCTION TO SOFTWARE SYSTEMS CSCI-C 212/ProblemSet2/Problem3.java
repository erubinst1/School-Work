class Problem3 {

    /**
     * Computes the subfactorial of the input
     *
     * @param n long input
     * @return subfactorial of n
     */
    static long subfactorial(long n) {
        if( n == 0){
            return 1;
        }
       if( n == 1){
           return 0;
       }
       else{
           return (n-1) * (subfactorial( n-1 ) + subfactorial( n-2 ));
       }
    }

    /**
     * Computes the subfactorial of the input
     *
     * @param n long input
     * @return subfactorial of n
     */
    static long subfactorialTR(long n) {
        return subfactorialTRH(n, 1);
    }

    /**
     * Helper method for computing the subfactorial of a number
     *
     * @param n long input
     * @param acc accumulator of the subfactorial value
     * @return acc
     */
    private static long subfactorialTRH(long n, long acc) {
        if( n == 0){
            return 1;
        }
        if( n == 1){
            return 0;
        }
        acc = acc * ((n-1) * (subfactorialTRH( n-1, acc ) + subfactorialTRH( n-2, acc )));
        return acc;
    }

    /**
     * Computes the subfactorial of the input
     *
     * @param n long input
     * @return subfactorial of n
     */
    static long subfactorialLoop(long n) {
        if( n == 0){
            return 1;
        }
        if( n == 1){
            return 0;
        }

        //!0
        long subfactPrevious = 1;
        //!1
        long subfactCurrent = 0;
        long subfactValue = 0;

        //i = 2 since n = 0 || 1 is handled
        for( int i = 2; i <= n; i++){
            subfactValue = (i-1) * (subfactCurrent + subfactPrevious);
            //shifts to next subfact value
            subfactPrevious = subfactCurrent;
            subfactCurrent = subfactValue;
        }

        return subfactValue;
    }
}

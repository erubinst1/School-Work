class Problem4 {

    /**
     * Computes the collatz sequence for an input integer
     *
     * @param n integer input
     * @return string containing the collatz sequence for n
     */
    static String collatz(int n) {
        if( n == 1){
            return "1";
        }
        else if( n % 2 != 0){
            return n + "," + collatz( 3 * n + 1);
        }
        else{
            return n + "," + collatz( n/2 );
        }
    }

    /**
     * Computes the collatz sequence for an input integer
     *
     * @param n integer input
     * @return string containing the collatz sequence for n
     */
    static String collatzTR(int n) {
        return collatzTRH(n,"");
    }

    /**
     * Computes the collatz sequence for an input integer
     *
     * @param n integer input
     * @param acc accumulated collatz sequence
     * @return acc
     */
    private static String collatzTRH(int n, String acc) {
        if( n == 1){
            return acc + "1";
        }
        else if( n % 2 != 0){
            acc = acc + n + ",";
            return  collatzTRH( 3 * n + 1, acc);
        }
        else{
            acc = acc + n + ",";
            return collatzTRH( n/2, acc );
        }
    }

    /** Computes the collatz sequence for an input integer
     *
     * @param n integer input
     * @return string containing the collatz sequence for n
     */
    static String collatzLoop(int n) {
        String acc = "";
        while( n != 1){
            if(  n % 2 != 0 ){
                acc = acc + n + ",";
                n = 3 * n + 1;
            }
            else {
                acc = acc + n + ",";
                n = n/2;
            }
        }
        return acc + "1";
    }
}

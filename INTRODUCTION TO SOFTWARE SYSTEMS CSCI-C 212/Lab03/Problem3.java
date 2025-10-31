class Problem3 {

    /**
     * Standard recursive method that returns a boolean indicating whether the input is a factorion
     * @param n integer input
     * @return true if the input is a factorion, false if not
     */
    static boolean isFactorion(int n){
        return n == sumOfFactorials(n);
    }

    /**
     * Standard Recursive method that calculates the factorial of an input
     * @param n input number
     * @return factorial of the input
     */
    private static int factorial(int n){
        if(n == 0){
            return 1;
        }
        else{
            return n * factorial( n-1);
        }
    }

    /**
     * helper method that calculates the sum of the factorial of each of the digits of an input
     * @param n input number
     * @return factorial of the input
     */
    private static int sumOfFactorials(int n){
        if( n == 0){
            return 0;
        }
        else{
            return factorial(n%10) + sumOfFactorials(n/10);
        }
    }

    /**
     * Tail recursive method to return a boolean indicating if the input is a factorion
     * @param n input int
     * @return true if the input is a factorion, false if not
     */
    static boolean isFactorionTR(int n) {
        return n == isFactorionLoop(n, 0);
    }

    /**
     * Helper to returns a boolean indicating if the input is a factorion
     * @param n input number
     * @param acc accumulated factorial values
     * @return acc
     */
    private static int isFactorionLoop(int n, int acc) {
        if( n == 0){
            return acc;
        }
        else{
            acc += factorial(n%10);
            return isFactorionLoop( n / 10, acc);
        }
    }
}

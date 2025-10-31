// Exercise 3.24

class Problem3 {

    /**
     * Returns a boolean indicating if any integers in the input array can sum to the target input
     *
     * @param A array of integers to check
     * @param t target to sum to
     * @return true if any integers from A can sum to t, and false if not
     */
    static boolean canSum(int[] A, int t) {
        return canSumH(A,t,0);
    }

    /**
     * Helper method to canSum
     *
     * @param A array of integers to check
     * @param t target sum to check against
     * @param i index
     * @return true if any integers from A can sum to t, and false if not
     */
    private static boolean canSumH(int[] A, int t, int i){
     if(t == 0){
         return true;
     }
     if(i >= A.length){
         return false;
     }

     boolean include = canSumH(A, t-A[i], i+1);

     boolean exclude = canSumH(A, t, i+1);

     return include||exclude;
    }
}

class Problem1 {

    /**
     * Computes the accumulated sum from an array
     *
     * @param A Array of integers
     * @return Array of integers containing thee accumulated sum
     */
    static int[] accSum(int[] A) {
        int[] acc = new int[A.length];
        for( int i = 0; i < A.length; i++){
            for( int e = 0; e <= i; e++){
                acc[i] += A[e];
            }
        }
        return acc;
    }
}

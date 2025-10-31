class Problem3 {

    /**
     * Determines whether an array of integers can be split in a way that results in the two sides having the same sum
     *
     * @param A integer array input
     * @return true if the array can be split, false if not
     */
    static boolean canBalanceArray(int[] A) {
        for( int i = 0; i < A.length; i++){
            int frontSum = 0;
            int backSum = 0;
            for( int f = 0; f <= i; f++){
                frontSum += A[f];
            }
            for( int b = i+1; b < A.length; b++){
                backSum += A[b];
            }
            if( frontSum == backSum){
                return true;
            }
        }
        return false;
    }
}

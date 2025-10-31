class Problem2 {

    /**
     * Counts the number of evens and odds in a given array
     *
     * @param vals integer array input
     * @return An integer array containing the number of evens in index zero and number of odds in index one
     */
    static int[] countEvenOdds(int[] vals) {
        int[] count = new int[2];
        for( int e: vals){
            if(Math.abs(e)%2 == 0){
                count[0] ++;
            }
            else{
                count[1] ++;
            }
        }
        return count;
    }
}

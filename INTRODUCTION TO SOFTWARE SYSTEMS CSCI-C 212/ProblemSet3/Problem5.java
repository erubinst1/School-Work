// Exercise 3.33

import java.util.LinkedHashSet;
import java.util.Set;

class Problem5 {

    /**
     * Computes the peaks from a given list of mountain heights
     *
     * @param peaks array of mountain heights
     * @return array of (local) mountain peeks
     */
    static int[] peakFinder(int[] peaks) {
        Set<Integer> peaksPrime = new LinkedHashSet<>();

        for(int i = 1; i < peaks.length-1; i++){
            if( peaks[i-1] < peaks[i] && peaks[i] > peaks[i+1]){
                peaksPrime.add(peaks[i]);
            }
        }

        int[] peaksPrimeArray = new int[peaksPrime.size()];
        int i = 0;
        for( int p: peaksPrime){
            peaksPrimeArray[i++] = p;
        }
        return peaksPrimeArray;
    }
}

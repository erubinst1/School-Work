// Exercise 3.9
import java.util.Arrays;

class Problem2 {

    /**
     * Computes the median of two arrays
     *
     * @param A sorted array one
     * @param B sorted array two
     * @return median of the combined array from A and B
     */
    static int median(int[] A, int[] B) {
        if(A.length == 0 && B.length == 0){
            return 0;
        }

        int[] combined = new int[A.length + B.length];

        int indexA = 0;
        int indexB = 0;
        while( indexA < A.length && indexB < B.length){
            combined[indexA+indexB] = Math.min(A[indexA], B[indexB]);
            if(Math.min(A[indexA], B[indexB]) == A[indexA]){
                indexA+=1;
            }
            else{
                indexB+=1;
            }
        }

        while(indexA < A.length){
            combined[indexA+indexB] = A[indexA];
            indexA+= 1;
        }

        while(indexB < B.length){
            combined[indexA+indexB] = B[indexB];
            indexB+= 1;
        }

        if(combined.length % 2 == 1){
            int mid = combined.length/2+1;
            return combined[mid-1];
        }
        else{
            int mid = combined.length/2;
            return (combined[mid-1] + combined[mid])/2;
        }
    }

}

import java.util.ArrayList;
import java.util.Arrays;

class Problem4 {

    /**
     * Finds the wisest pair out of an array list
     *
     * @param A input integer array list
     * @return integer array list containing the pair with the largest combined age
     */
    static ArrayList<Integer> wisest(ArrayList<Integer> A) {
        ArrayList<Integer> pair = new ArrayList<Integer>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));
        for( int i = 0; i < A.size()-1; i +=2 ){
            if( A.get(i) + A.get(i+1) >= pair.get(0) + pair.get(1)){
                pair.set(0,A.get(i));
                pair.set(1,A.get(i+1));
            }
        }
        return pair;
    }
}

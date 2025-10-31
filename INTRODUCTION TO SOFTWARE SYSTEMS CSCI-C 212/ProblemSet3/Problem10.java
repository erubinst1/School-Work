// Exercise 3.84

import java.util.Arrays;
import java.util.List;

class Problem10 {

    /**
     * Determines if two lists are parallel
     *
     * @param t list extends Integer one
     * @param u list extends Integer two
     * @return true if the lists are parallel, false if not
     * @param <T> the type parameter that extends List<Integer>
     */
    static <T extends List<Integer>> boolean areParallelLists(T t, T u) {
        if(t.size() != u.size()){
            return false;
        }

        boolean allZerot = true;
        boolean allZerou = true;

        for( Integer num: t){
            if( num != 0){
                allZerot = false;
            }
        }
        for( Integer num: u){
            if( num != 0){
                allZerou = false;
            }
        }

        if(allZerot || allZerou){
            return true;
        }


        double factor = (double) t.getFirst() / u.getFirst();

        for(int i = 0; i < t.size(); i++){
            if( (double) t.get(i) / u.get(i) != factor){
                return false;
            }
        }

        return true;
    }
}

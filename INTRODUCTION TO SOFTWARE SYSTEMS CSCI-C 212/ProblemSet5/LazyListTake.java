import java.util.ArrayList;
import java.util.List;
class LazyListTake<T>{

    private final ILazyList<T> LIST;
    private final int NUMELEMENTS;

    LazyListTake(ILazyList<T> ls, int n){
        this.LIST = ls;
        this.NUMELEMENTS = n;
    }

    /**
     * Returns a list of n elements from the given list
     * @return n elements from the given list
     */
    List<T> getList(){
        List<T> results = new ArrayList<>();
        for( int i = 0; i < this.NUMELEMENTS; i++){
            results.add(this.LIST.next());
        }
        return results;
    }
}

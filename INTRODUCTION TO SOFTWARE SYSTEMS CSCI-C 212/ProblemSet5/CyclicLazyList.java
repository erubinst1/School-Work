import java.util.ArrayList;
import java.util.List;

class CyclicLazyList<T> implements ILazyList{

    private List<T> list;
    private int count;

    CyclicLazyList(T... vals){
        this.list = new ArrayList<>();
        for(T val : vals){
            this.list.add(val);
        }
        this.count = -1;
    }

    /**Overridden next method to cycle back to the front of the list after returning all existing elements
     * @return next element in the list
     */
    @Override
    public Object next() {
        if(this.count == list.size()-1){
            count = -1;
        }
        count++;
        return this.list.get(count);

    }
}

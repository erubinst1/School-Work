import java.util.Iterator;
import java.util.function.Function;

class RangeLazyList implements  ILazyList, Iterator, Iterable{

    private int curr;
    private int end;
    private final Function<Integer, Integer> FUNC;

    private RangeLazyList(int s, int e, Function<Integer, Integer> f){
        this.curr = s;
        this.end = e;
        this.FUNC = f;
    }

    private RangeLazyList(int n){
        this(0, n, x -> x+1);
    }

    /**
     * returns an instance of a new RangeLazyList containing the provided fields
     * @param s int start value input
     * @param e int end value input
     * @param f function to be applied input
     * @return an instance of a new RangeLazyList containing the provided fields
     */
    static RangeLazyList range(int s, int e, Function<Integer, Integer> f){
        return new RangeLazyList( s, e, f);
    }

    /**
     * returns an instance of a new RangeLazyList containing the provided field
     * @param n int end value input
     * @return an instance of a new RangeLazyList containing the provided field
     */
    static RangeLazyList range(int n){
        return new RangeLazyList( n);
    }

    /**
     * Returns true if the iteration has more elements.
     *
     * @return true if the iteration has more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        return this.curr < this.end;
    }

    /**
     * Overridden next method to invoke f on the current element and return the previous element
     * @return previous element
     */
    @Override
    public Object next() {
        int temp = this.curr;
        this.curr = this.FUNC.apply(this.curr);
        return temp;
    }

    /**
     * Returns an iterator over elements of type int
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return this;
    }
}

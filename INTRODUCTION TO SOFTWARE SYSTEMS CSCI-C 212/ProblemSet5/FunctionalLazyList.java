import java.util.function.Function;

class FunctionalLazyList<T> implements ILazyList{

    private T curr;
    private final Function<T, T> FUNC;

    FunctionalLazyList(Function<T, T> f, T t){
        this.curr = t;
        this.FUNC = f;
    }

    /**
     * Overridden next method to invoke f on the current element and return the previous element
     * @return previous element
     */
    @Override
    public Object next() {
        T temp = this.curr;
        this.curr = this.FUNC.apply(this.curr);
        return temp;
    }
}

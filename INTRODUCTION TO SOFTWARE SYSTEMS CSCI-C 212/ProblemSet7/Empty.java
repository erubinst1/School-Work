import java.util.function.Function;

class Empty<T> implements ITree<T>{

    Empty() {}

    @Override
    public ITree<T> left() {
        return null;
    }

    @Override
    public ITree<T> right() {
        return null;
    }

    @Override
    public ITree<T> value() {
        return null;
    }

    @Override
    public <R> IFunctor<R> fmap(Function<T, R> f) {
        return new Empty<>();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Empty;
    }

    @Override
    public String toString() { return "Empty"; }
}
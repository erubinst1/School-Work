import java.util.Objects;
import java.util.function.Function;

class Node<T> implements ITree<T>{

    private T value;
    private ITree<T> left;
    private ITree<T> right;

    Node( T value, ITree<T> left, ITree<T> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public ITree<T> left() {
        return this.left;
    }

    @Override
    public ITree<T> right() {
        return this.right;
    }

    @Override
    public ITree<T> value() {
        return this;
    }

    @Override
    public <R> IFunctor<R> fmap(Function<T, R> f) {
        return new Node<>( f.apply(this.value),
                (ITree<R>) this.left.fmap(f),
                (ITree<R>) this.right.fmap(f)
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Node)) return false;

        Node<?> othNode = (Node<?>) obj;

        return Objects.equals(this.value, othNode.value) && Objects.equals(this.left, othNode.left) && Objects.equals(this.right, othNode.right);
    }

    @Override
    public String toString() { return "Node(" + this.value+", " + this.left.toString() + ", " + this.right.toString() + ")"; }
}

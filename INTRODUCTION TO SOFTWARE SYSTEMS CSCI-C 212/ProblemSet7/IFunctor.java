import java.util.function.Function;

interface IFunctor<T> {

    <R> IFunctor<R> fmap(Function<T, R> f);
}

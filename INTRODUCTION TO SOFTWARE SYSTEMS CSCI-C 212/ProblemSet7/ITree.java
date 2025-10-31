interface ITree<T> extends IFunctor<T>{
    ITree<T>left();
    ITree<T>right();
    ITree<T>value();
}

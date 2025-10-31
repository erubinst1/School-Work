import java.util.Iterator;
import java.util.List;

class EnumerateLazyList<T> implements ILazyList<EnumerateLazyList.EnumerateItem<T>>, Iterator<EnumerateLazyList.EnumerateItem<T>>, Iterable<EnumerateLazyList.EnumerateItem<T>>{

    public static class EnumerateItem<T> {
        private final int index;
        private final T item;

        public EnumerateItem(int index, T item) {
            this.index = index;
            this.item = item;
        }

        //accessors

        public int getIndex() {
            return index;
        }

        public T getItem() {
            return item;
        }

        /**
         * Overridden toString to return a stringified representation of the form "(index, item)"
         * @return stringified representation of the form "(index, item)"
         */
        @Override
        public String toString() {
            return "(" + index + ", " + item + ")";
        }
    }

    private final List<T> list;
    private int currentIndex;

    EnumerateLazyList(List<T> ls){
        this.list = ls;
        this.currentIndex = 0;
    }

    /**
     *  returns an enumeration that iterates over the given list
     * @param ls list of items
     * @return an enumeration that iterates over the given list
     * @param <T> generic object type T
     */
    public static <T> EnumerateLazyList<T> enumerate(List<T> ls) {
        return new EnumerateLazyList<>(ls);
    }

    /**
     * Returns true if the iteration has more elements.
     * @return true if the iteration has more elements, false otherwise
     */
    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }

    /**
     * Overridden next to return a new instance of EnumerateItem with the current index and the value at that index
     * @return new instance of EnumerateItem with the current index and the value at that index
     */
    @Override
    public EnumerateItem<T> next() {
        EnumerateItem<T> item = new EnumerateItem<>(currentIndex, list.get(currentIndex));
        currentIndex++;
        return item;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<EnumerateLazyList.EnumerateItem<T>> iterator() {
        return this;
    }
}

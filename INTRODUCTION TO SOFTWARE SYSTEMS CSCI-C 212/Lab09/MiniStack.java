class MiniStack<T> {

    private static final int INITIAL_CAPACITY = 10;
    private T[] elements;
    private int size;

    MiniStack(){
        this.elements= (T[]) new Object[INITIAL_CAPACITY];
        this.size=0;
    }
    /*
    *This method adds an element to the top of the stack
    *
    * @param T given element
    */
    void add(T t){
        if(this.size==this.elements.length)
            resize();
        this.elements[this.size]=t;
        size++;
    }
    /*
     *This method returns but does not remove the top element of the stack
     *
     * @return the top element of the stack
     */
    T peek(){
        if(this.size==0){
            return null;
        }
        return this.elements[size-1];
    }
    /*
     *This method returns and removes the top element of the stack
     *
     * @return the top element of the stack
     */
    T pop(){
        if(size==0)
            return null;
        T elem = elements[size-1];
        elements[size-1]=null;
        size--;
        return elem;
    }
    int size() {
        return this.size;
    }
    /*
     *This method returns a String representation of the elements array
     *
     * @return String representation of the elements array
     */
    public String toString(){
        String result = "";
        for( int i = this.size-1; i >= 0; i--){
            if( i == 0){
                result += this.elements[i];
                continue;
            }
            result += this.elements[i] + ", ";
        }
        return result;
    }
    /*
     *This method resizes the elements array
     */
    private void resize(){
        T[] arr = (T[]) new Object[this.size*2];
        if (this.size >= 0) System.arraycopy(this.elements, 0, arr, 0, this.size);
        this.elements= arr;
    }
}

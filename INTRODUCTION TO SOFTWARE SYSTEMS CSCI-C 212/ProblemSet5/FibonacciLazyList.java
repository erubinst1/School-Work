class FibonacciLazyList implements ILazyList{

    private int prev;
    private int curr;
    private int count;

    FibonacciLazyList() {
        this.prev = 0;
        this.curr = 1;
        this.count = 0;
    }

    /**
     * Overridden method to produce the fibonacci sequence
     * @return the next number in the fibonacci sequence
     */
    @Override
    public Object next() {
        if(this.count == 0){
            count++;
            return 0;
        }
        if(this.count == 1){
            count++;
            return 1;
        }
        else{
            int temp = this.prev + this.curr;
            this.prev = this.curr;
            this.curr = temp;
            return this.curr;
        }
    }
}

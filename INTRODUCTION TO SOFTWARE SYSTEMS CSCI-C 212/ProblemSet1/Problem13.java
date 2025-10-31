// Exercise 2.15

class Problem13 {

    /**
     * Calculates the number of small candy bars that can fit in the box after all the large are added, returns -1 if the box cant be filled
     *
     * @param s number of small candy bars
     * @param l number of large candy bars
     * @param w max weight of the box
     * @return number of small candy bars that can fit or -1 if the box cant be filled
     */
    static int fitCandy(int s, int l, int w) {
        int fill = w;
        if( fill < l*5)
            fill = fill%5;
        else
            fill -= l*5;

        if( fill <= s)
            return fill;
        return -1;

    }
}

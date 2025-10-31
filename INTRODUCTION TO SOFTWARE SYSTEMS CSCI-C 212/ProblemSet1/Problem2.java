// Exercise 1.6

class Problem2 {

    /**
     * Calculates the purchase cost in USD from a list of five fruits
     *
     * @param a number of Apples
     * @param b number of Bananas
     * @param o number of Oranges
     * @param g number of Bunches of Grapes
     * @param p number of Pineapples
     * @return purchase price in USD
     */
    static double grocery(int a, int b, int o, int g, int p) {
        return a*0.59 + b*0.99 + o* 0.45 + g*1.39 + p*2.24;
    }
}

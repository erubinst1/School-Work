// Exercise 3.7

class Problem1 {

    /**
     * Iterates over the interval given and returns an array of strings with additions depending on the divisors of the numbers in the interval
     *
     * @param min minimum of the interval
     * @param max maximum of the interval
     * @return array of strings modified based on the divisors over min, max
     */
    static String[] fizzBuzz(int min, int max) {
        String[] arr = new String[max-min+1];
        for( int i = min; i <= max; i++){
            if( i%3 == 0 && i%5 == 0){
                arr[i-min] = "FizzBuzz";
            }
            else if( i%3 == 0){
                arr[i-min] = "Fizz";
            }
            else if( i%5 == 0){
                arr[i-min] = "Buzz";
            }
            else{
                arr[i-min] = ""+i;
            }
        }
        return arr;
    }
}

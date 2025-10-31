class Problem5 {

    /**
     * Checks a string for integers and returns the integers if they exist
     *
     * @param s input string
     * @return integers from the string, if they exist
     */
    static int atoi(String s) {
        return atoiH(s, 0, false);
}

/**
 * Helper method for checking a string for integers and returning the integers if they exist
 *
 * @param s input string
 * @param acc accumulator of the integers
 * @return acc
 */
private static int atoiH(String s, int acc, boolean isNegative) {
    if(s.isEmpty()){
        if(isNegative){
            acc = acc * (-1);
        }
        return acc;
    }

    //if the strings first char is a digit or a minus
    if(Character.isDigit(s.charAt(0)) || s.charAt(0) == '-'){
        //checks if the string starts with 0s
        if(acc == 0 && Character.getNumericValue(s.charAt(0)) == 0){
            return atoiH( s.substring(1), acc, isNegative);
        }

        //either adds the digit or sets is negative to true
        if(s.charAt(0) == '-' && (Character.isDigit(s.charAt(1)))){
                isNegative = true;
        }
        else{
            //added check since - has a numeric value of -1
            if(Character.getNumericValue(s.charAt(0)) >= 0){
                //returns 0 if there is overflow
                if( acc*10 + Character.getNumericValue(s.charAt(0)) > Integer.MAX_VALUE - acc){
                    return 0;
                }
                //adds the next digit to acc
                acc = acc*10 + Character.getNumericValue(s.charAt(0));
            }
        }

        //if the string still has non-digit characters and acc isnt 0, return the current acc
        if( s.length() > 1 && (acc != 0 && !Character.isDigit(s.charAt(1))) ){
            if(isNegative){
                acc = acc* (-1);
            }
            return acc;
        }
    }
    return atoiH( s.substring(1), acc, isNegative);
}
}

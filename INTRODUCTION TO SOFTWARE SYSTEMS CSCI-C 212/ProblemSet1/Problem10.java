// Exercise 2.9

class Problem10 {

    /**
     * Removes "try" from the input string if it ends in "try"
     *
     * @param s string to be checked and or relieved of its "try"
     * @return string unchanged or with "try" removed
     */
    static String cutTry(String s) {
        if( s.lastIndexOf("try") == s.length() - 3)
            s = s.substring(0, s.length()-3);
        return s;
    }
}

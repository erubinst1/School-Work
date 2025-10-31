class Problem3 {

    /**
     * Removes the first and/or second characters of the string if they match the inputs
     * @param s string to be checked
     * @param c character checked in the 0 index
     * @param d character checked in the 1 index
     * @return string with/without some characters popped off
     */
    static String popChars(String s, char c, char d) {
        if (s.length() > 1) {
            if( s.charAt(1) == d)
                s = s.charAt(0) + s.substring(2);
            if( s.charAt(0) == c)
                s = s.substring(1);
            return s;
        }
        else if(s.length() == 1){
            if( s.charAt(0) == c)
                s = s.substring(1);
            return s;
        }
        return s;

    }
}

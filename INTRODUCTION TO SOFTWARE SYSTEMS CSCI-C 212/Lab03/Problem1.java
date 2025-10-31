class Problem1 {

    /**
     * Standard recursive method that replaces the character "A" with "B" in a input string
     * @param s input string
     * @return the string with "A" changed to "B"
     */
    static String replaceAB(String s) {
        if( s.contains("A")){
            return replaceAB(s.substring(0,s.indexOf("A"))+"B" + s.substring(s.indexOf("A")+1));
        }
        else{
            return s;
        }
    }

    /**
     * Tail Recursive method that replaces the character "A" with "B" in a input string
     * @param s input string
     * @return the string with "A" changed to "B"
     */
    static String replaceABTR(String s) {
        return replaceLoop(s, "");
    }

    /**
     * Helper method for replaces the character "A" with "B" in a input string
     * @param s input string
     * @param acc accumulated string
     * @return acc
     */
    private static String replaceLoop(String s, String acc) {
        if(s.isEmpty()){
            return acc;
        }
        else if( s.substring(0,1).equals("A")){
            acc = acc + "B";
            return replaceLoop( s.substring(1), acc);
        }
        else{
            acc = acc + s.substring(0,1);
            return replaceLoop( s.substring(1), acc);
        }
    }
}

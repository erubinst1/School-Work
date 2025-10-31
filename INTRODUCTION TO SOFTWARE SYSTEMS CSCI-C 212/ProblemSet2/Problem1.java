class Problem1 {

    /**
     * Determines if a string has a palindrome
     *
     * @param s string to check
     * @return true if the string is a palindrome, false if not
     */
    static boolean isPalindromeTR(String s) {
        return isPalindromeTRH( s, s, "");
    }

    /**
     * Helper method for determining if a string has a palindrome
     *
     * @param s string to check
     * @param initS initial string to check
     * @param acc accumulator for the reverse string
     * @return true if the string is equal to acc, false if not
     */
     private static boolean isPalindromeTRH(String s, String initS, String acc) {
        if(s.isEmpty()){
            return initS.equals(acc);
        }
        else{
            acc = acc + s.substring(s.length()-1);
            s = s.substring(0, s.length()-1);
            return isPalindromeTRH(s, initS, acc);
        }
    }

    /**
     * Determines if a string has a palindrome
     *
     * @param s input string
     * @return true if the string is a palindrome, false if not
     */
    static boolean isPalindromeLoop(String s) {
        String reverse = "";
        for(int i = 0; i < s.length(); i++){
            reverse =  s.charAt(i) + reverse;
        }
        return reverse.equals(s);
    }
}

class Problem7 {

    /**
     * Recreates the substring method using an input string, lower bound, and upper bound
     *
     * @param s    input string
     * @param low  lower bound of the substring, inclusive
     * @param high upper bound of the substring, exclusive
     * @return substring from low to high
     */
    static String substring(String s, int low, int high) {
        String acc = "";
        if( (low < 0 || high > s.length()) || low > high){
            return null;
        }
        for(int i = low; i < high; i++){
            acc += s.charAt(i);
        }
        return acc;
    }
}

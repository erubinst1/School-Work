class Problem4 {

    /**
     * Computes the middle string by lexicographical value
     * @param a string one
     * @param b string two
     * @param c string three
     * @return middle string
     */
    static String middleString(String a, String b, String c) {
        if((a.compareTo(b) > 0 && a.compareTo(c) < 0 ) || (a.compareTo(b) < 0 && a.compareTo(c) > 0 ))
            return a;
        if((b.compareTo(a) > 0 && b.compareTo(c) < 0 ) || (b.compareTo(a) < 0 && b.compareTo(c) > 0 ))
            return b;
        return c;
    }
}

// Exercise 2.16

class Problem14 {

    /**
     * Determines whether we can convert a given string into an integer datatype.
     * @param s the string to check.
     * @return true if s can be represented as an int, false otherwise.
     */
    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Returns a boolean indicating if the ip address is valid
     *
     * @param s input ip address
     * @return true if the ip address is valid, false if not
     */
    static boolean isValidIpv4(String s) {
        if(s.contains(".") && isNumeric(s.substring(0,s.indexOf(".")))){
            if (Integer.parseInt(s.substring(0,s.indexOf("."))) >= 0 && Integer.parseInt(s.substring(0,s.indexOf("."))) < 256){
                s = s.substring(s.indexOf(".") + 1);
                if(s.contains(".") && isNumeric(s.substring(0,s.indexOf(".")))){
                    if (Integer.parseInt(s.substring(0,s.indexOf("."))) >= 0 && Integer.parseInt(s.substring(0,s.indexOf("."))) < 256){
                        s = s.substring(s.indexOf(".") + 1);
                        if(s.contains(".") && isNumeric(s.substring(0,s.indexOf(".")))){
                            if (Integer.parseInt(s.substring(0,s.indexOf("."))) >= 0 && Integer.parseInt(s.substring(0,s.indexOf("."))) < 256){
                                s = s.substring(s.indexOf(".") + 1);
                                if(isNumeric(s)){
                                    if ( Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 256) {
                                        return true;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return false;
    }
}

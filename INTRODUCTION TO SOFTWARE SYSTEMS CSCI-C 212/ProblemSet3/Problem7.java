// Exercise 3.43

import java.util.HashMap;
import java.util.Map;

class Problem7 {

    /**
     * Computes the frequency of each word used in a string
     *
     * @param s string to be checked for frequency
     * @return map containing each word and associated frequency from s
     */
    static Map<String, Integer> wordCount(String s) {
        String sPrime = cleaner(s);

        Map< String, Integer> frequency = new HashMap<>();
        tokenize(sPrime, ' ', frequency);

        return frequency;
    }

    /**
     * Cleans a string of punctuation
     *
     * @param s initial string
     * @return the cleaned string
     */
    private static String cleaner(String s){
        String cleaned = "";
        for(int i = 0; i < s.length(); i++){
            if( Character.isLetterOrDigit(s.charAt(i)) ||  Character.isWhitespace(s.charAt(i))){
                cleaned = cleaned + s.charAt(i);
            }
        }

        return cleaned.toLowerCase();
    }

    /**
     * Creates a list of tokens from a string by using a delimiter character and
     * adds the list of tokens and their respective frequencies in s to a map
     *
     * @param s initial string
     * @param d delimiter character
     * @param Map map containing each word and associated frequency from s
     */
    private static void tokenize(String s, char d, Map<String, Integer> Map) {
        String tempToken = "";

        if(s.length() == 0){
            return;
        }

        for( int i = 0; i < s.length(); i++){
            if(s.charAt(i) != d){
                tempToken = tempToken + s.charAt(i);
            }
            else if(s.charAt(i) == d && tempToken.length() != 0){
                Map.put(tempToken, Map.getOrDefault(tempToken, 0)+1);
                tempToken = "";
            }
        }

        if(s.charAt(s.length()-1) != d && tempToken.length() != 0){
            Map.put(tempToken, Map.getOrDefault(tempToken, 0)+1);
            tempToken = "";
        }

    }
}

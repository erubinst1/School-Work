// Exercise 3.42

import java.util.ArrayList;
import java.util.List;

class Problem6 {

    /**
     * Creates a list of tokens from a string by using a delimiter character
     *
     * @param s initial string
     * @param d delimiter character
     * @return list of tokens from the tokenized string
     */
    static List<String> tokenize(String s, char d) {
        List<String> tokens = new ArrayList<>();
        String tempToken = "";

        if(s.length() == 0){
            return tokens;
        }

        for( int i = 0; i < s.length(); i++){
            if(s.charAt(i) != d){
                tempToken = tempToken + s.charAt(i);
            }
            else if(s.charAt(i) == d && tempToken.length() != 0){
                tokens.add(tempToken);
                tempToken = "";
            }
        }

        if(s.charAt(s.length()-1) != d && tempToken.length() != 0){
            tokens.add(tempToken);
            tempToken = "";
        }

        return tokens;
    }
}

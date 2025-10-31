class Problem6 {

    /**
     * Creates a new string by comparing the characters in two strings, similar to "Worlde"
     *
     * @param W String to be guessed
     * @param G String of the guess
     * @return String indicating which characters from G exist on W
     */
    static String guessWord(String W, String G) {
        if(W.length() != G.length()){
            return null;
        }
        W = W.toUpperCase();
        G = G.toUpperCase();

        //creates output and makes it a string with length W filled with *
        String output = "";
        for(int i = 0; i < W.length(); i++) {
            output = output + "-";
        }

        for(int i = 0; i < W.length(); i++){

            //if the char exists in W, change the * to -
            if(W.indexOf(G.charAt(i)) != -1){
                //iterates to see if any char in g matches any char in w, sets the index to * if true
                for(int o = 0; o < W.length(); o++){
                    for(int p = 0; p < W.length(); p++) {
                        if(W.charAt(o) == G.charAt(p) && output.charAt(p) == '-'){
                            output = output.substring(0,p) + "*" + output.substring(p+1);
                        }
                    }

                }
            }

            //if the chars match, replace the * at that index with the char
            if (G.charAt(i) == W.charAt(i)){
                output = output.substring(0,i) + W.charAt(i) + output.substring(i+1);
            }
        }
        return output;
    }

}
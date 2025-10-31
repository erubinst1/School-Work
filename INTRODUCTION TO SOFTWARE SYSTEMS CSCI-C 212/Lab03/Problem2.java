class Problem2 {

    /**
     * Tail recursive method that determines if parentheses pairs are balanced
     * @param s Pair of parentheses
     * @return True if parenthesis are balanced, false otherwise
     */
    static boolean isNestedParenthesesTR(String s) {
        return isNestedParenthesesLoop(s ,0, 0 );
    }

    /**
     * Helper method for determining if parentheses pairs are balanced
     *
     * @param s   The String of parentheses
//     * @param open count of open parentheses
     * @param closed count of closed parentheses
     * @return True if parenthesis are balanced, false otherwise
     */



    private static boolean isNestedParenthesesLoop(String s, int open, int closed){
        if(s.isEmpty()){
            return open == closed;
        }
        else if(s.substring(0,1).equals("(") ){
            open ++;
            return isNestedParenthesesLoop( s.substring(1), open, closed);

        }
        else if(s.substring(0,1).equals(")")){
            closed ++;
            return isNestedParenthesesLoop( s.substring(1), open, closed);
        }
        else{
            return isNestedParenthesesLoop( s.substring(1), open, closed);
        }
    }
}



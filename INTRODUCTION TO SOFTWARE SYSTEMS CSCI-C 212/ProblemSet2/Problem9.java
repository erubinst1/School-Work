class Problem9 {

    /**
     * Computes the sum of each positive integer in an input string
     *
     * @param s input string
     * @return sum of all positive integers in the input string
     */
    static int strSumNums(String s) {
        int sum = 0;
        boolean flag = false;
        for( int i = 0; i < s.length(); i++){
            int temp = 0;
            int p;
            if(Character.isDigit(s.charAt(i))){
                for( p = i+1; p < s.length(); p++){
                    temp = Integer.parseInt(s.substring(i,p));
                    if(!Character.isDigit(s.charAt(p))){
                        break;
                    }
                    if( p == s.length()-1 && Character.isDigit(s.charAt(p))){
                        temp = Integer.parseInt(s.substring(i));
                        flag = true;
                    }
                }
                if(i == s.length()-1 && !flag){
                    if( Character.isDigit(s.charAt(i)) ){
                        temp += Integer.parseInt(s.substring(i));
                    }
                }
                i=p;
                sum += temp;
                temp = 0;
            }
        }
        return sum;
    }
}

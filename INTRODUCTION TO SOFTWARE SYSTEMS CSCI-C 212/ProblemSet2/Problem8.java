class Problem8 {

    /**
     * Compares the two files, and if their names are the same besides a number, returns a comparison integer
     *
     * @param f1 First file
     * @param f2 Second file
     * @return 1 if f1 is greater than f2, 0 if they are the same, and -1 if f1 is less than f2
     */
    static int compareFiles(String f1, String f2) {
        String nonIntf1 = "";
        int numf1 = 0;
        int tempf1 = 0;

        for(int i = 0; i < f1.length(); i++){

            String tempStr = "";
            tempf1 = i;
            while(Character.isDigit(f1.charAt(i))){
                tempStr += f1.charAt(i);

                nonIntf1 = f1.substring(0,tempf1) + f1.substring(i+1);
                numf1 = Integer.parseInt(tempStr);
                i++;
            }
        }

        String nonIntf2 = "";
        int numf2 = 0;
        int tempf2 = 0;

        for(int i = 0; i < f2.length(); i++){

            String tempStr = "";
            tempf2 = i;
            while(Character.isDigit(f2.charAt(i))){
                tempStr += f2.charAt(i);

                nonIntf2 = f2.substring(0,tempf2) + f2.substring(i+1);
                numf2 = Integer.parseInt(tempStr);
                i++;
            }
        }

        //check if all the string is the same, if so, check nums
        //else use compareTo
        if( nonIntf1.equals(nonIntf2) ){
            if(numf1 > numf2){
                return 1;
            }
            else if(numf1 < numf2){
                return -1;
            }
            else{
                return 0;
            }
        }
        else{
            if(f1.compareTo(f2) > 0){
                return 1;
            }
            else if(f1.compareTo(f2) < 0){
                return -1;
            }
            else{
                return 0;
            }
        }

    }
}

// Exercise 3.65

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Problem11 {

    /**
     * Queries a given database for the names of all people that satisfy given criteria
     *
     * @param db database to be checked
     * @param query rule to query the database with
     * @return list of names of all people that satisfy the criteria
     */
    static List<String> query(String[][] db, String query) {
        String count = query.substring(query.indexOf(" ")+1, query.indexOf("W")-1);
        String predicate = query.substring(query.indexOf("R")+3);

        String header = predicate.substring(0, predicate.indexOf(" "));
        String value = predicate.substring(predicate.indexOf("'")+1, predicate.lastIndexOf("'"));
        //cuts off any extra spaces in the value
        predicate = predicate.substring(0, predicate.indexOf("'"));
        String comparator = predicate.substring(predicate.indexOf(" ")+1, predicate.lastIndexOf(" "));


        if(count.length() == 1 && count.charAt(0) == '*'){
            return getResult(db, header, comparator, value, -1);
        }
        else{
            return getResult(db, header, comparator, value, Integer.parseInt(count));
        }
    }

    /**
     * Finds the index of a column given its header
     *
     * @param db database to be checked
     * @param header name of wanted header of the column of the db
     * @return index of the column with the matching header
     */
    private static int getCol(String[][] db, String header) {
        for( int i = 0; i < db[0].length; i++){
            if(db[0][i].equals(header)){
                return i;
            }
        }
        return 0;
    }

    /**
     * Returns the names of people meeting input criteria
     *
     * @param db database to be checked
     * @param header name of wanted header of the column of the db
     * @param value value to be checked against
     * @param n number of qualifying results returned
     * @return list of names that match search criteria
     */
    private static List<String> getResult(String[][] db, String header, String comparator, String value, int n) {
        List<String> result = new ArrayList<>();
        //LIKE comparators
        if( comparator.equals("LIKE")){
            //%s%
            //contains
            if( value.indexOf("%") == 0 && value.lastIndexOf("%") == value.length()-1){
                value = value.replace("%","");
                for( int i = 1; i < db.length; i++){
                    if(db[i][getCol(db, header)].contains(value)){
                        result.add(db[i][1]);
                    }
                    if( result.size() == n){
                        break;
                    }
                }
            }

            //%s
            //ends with
            else if(value.indexOf("%") == 0){
                value = value.replace("%","");
                for( int i = 1; i < db.length; i++){
                    if(db[i][getCol(db, header)].endsWith(value)){
                        result.add(db[i][1]);
                    }
                    if( result.size() == n){
                        break;
                    }
                }
            }
            //s%
            //starts with
            else if(value.indexOf("%") == value.length()-1){
                value = value.replace("%","");
                for( int i = 1; i < db.length; i++){
                    if(db[i][getCol(db, header)].startsWith(value)){
                        result.add(db[i][1]);
                    }
                    if( result.size() == n){
                        break;
                    }
                }
            }
            //s
            //equal to
            else{
                value = value.replace("%","");
                for( int i = 1; i < db.length; i++){
                    if(db[i][getCol(db, header)].equals(value)){
                        result.add(db[i][1]);
                    }
                    if( result.size() == n){
                        break;
                    }
                }
            }
        }
        //numeric comparators
        else {
            if(comparator.equals("=")) {
                for (int i = 1; i < db.length; i++) {
                    if (db[i][getCol(db, header)].equals(value)) {
                        result.add(db[i][1]);
                    }
                    if (result.size() == n) {
                        break;
                    }
                }
            }
            else if (comparator.equals("!=")) {
                for (int i = 1; i < db.length; i++) {
                    if (!db[i][getCol(db, header)].equals(value)) {
                        result.add(db[i][1]);
                    }
                    if (result.size() == n) {
                        break;
                    }
                }
            }
            else if (comparator.equals(">")) {
                for (int i = 1; i < db.length; i++) {
                    if (Integer.parseInt(db[i][getCol(db, header)]) > Integer.parseInt(value)) {
                        result.add(db[i][1]);
                    }
                    if (result.size() == n) {
                        break;
                    }
                }
            }
            else if (comparator.equals("<")) {
                for (int i = 1; i < db.length; i++) {
                    if (Integer.parseInt(db[i][getCol(db, header)]) < Integer.parseInt(value)) {
                        result.add(db[i][1]);
                    }
                    if (result.size() == n) {
                        break;
                    }
                }
            }
            else if (comparator.equals(">=")) {
                for (int i = 1; i < db.length; i++) {
                    if (Integer.parseInt(db[i][getCol(db, header)]) >= Integer.parseInt(value)) {
                        result.add(db[i][1]);
                    }
                    if (result.size() == n) {
                        break;
                    }
                }
            }
            else if (comparator.equals("<=")) {
                for (int i = 1; i < db.length; i++) {
                    if (Integer.parseInt(db[i][getCol(db, header)]) <= Integer.parseInt(value)) {
                        result.add(db[i][1]);
                    }
                    if (result.size() == n) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}


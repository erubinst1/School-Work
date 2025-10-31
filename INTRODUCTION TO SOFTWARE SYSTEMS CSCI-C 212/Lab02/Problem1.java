class Problem1 {

    /**
     * Converts a first name, last name, and birth year into a username
     * @param firstName first name
     * @param lastName last name
     * @param year birth year
     * @return returns a username containing the first 4 letters of the last name, first letter of the first name, and last 2 digits of the year
     */
    static String userId(String firstName, String lastName, int year) {
        if(lastName.length() < 4 )
            return lastName + firstName.substring(0,1) + year%100;
        return lastName.substring(0,5) + firstName.substring(0,1) + year%100;
    }
}

// Exercise 1.22

class Problem7 {

    /**
     * Parses the username, the string before the @, from a given email address
     *
     * @param email email address
     * @return the username
     */
    static String cutUsername(String email) {
        return email.substring(0, email.indexOf('@'));
    }
}

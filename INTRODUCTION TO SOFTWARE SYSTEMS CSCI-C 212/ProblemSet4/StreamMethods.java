// Exercises 3.68, 3.70, 3.72, and 3.80

import javax.xml.stream.events.Characters;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamMethods {

    /**
     * Checks if any of the y coordinates are greater than 450
     *
     * @param ls list of integer arrays with each array containing an x,y coordinate pair
     * @return true if any of the y coordinates are greater than 450, false otherwise
     */
    static boolean containsHigh(List<int[]> ls) {
        return ls.stream()
                .anyMatch(n -> n[1] > 450);
    }

    /**
     * Squares, adds 5, and filters out resulting numbers ending in 5 or 6 from a list of integers
     *
     * @param lon input list of integers
     * @return Resulting list of integers after squaring, adding 5, and filtering out resulting numbers ending in 5 or 6
     */
    static List<Integer> sqAddFiveOmit(List<Integer> lon) {
        return lon.stream().
                map(n -> n*n )
                .map(n -> n+5)
                .filter( n -> n % 10 != 5 && n % 10 != 6)
                .toList();
    }

    /**
     * Removes all strings that contain more characters than a given integer n from a list of strings
     *
     * @param los input list of strings
     * @param n input integer max string characters
     * @return input list of strings after removing strings that contain more characters than n
     */
    static List<String> removeLonger(List<String> los, int n) {
        return los.stream()
                .filter( s -> s.length()-1 < n)
                .toList();
    }

    /**
     * removes all non-alphanumeric characters, converts all letters to uppercase, and computes
     * the sum of the ASCII values of the letters from a given string
     *
     * @param s input string
     * @return sum of the ASCII values of the letters from s after removing non-alphanumeric
     * characters and converting all letters to uppercase
     */
    static int filterSumChars(String s) {
        return s.chars()
                .filter( c -> Character.isLetterOrDigit(c))
                .map( c -> Character.isDigit(c) ? Character.getNumericValue(c) : Character.toUpperCase(c))
                .reduce(0,
                        (acc, n) -> acc + n);
    }
}

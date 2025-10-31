import java.util.*;

class Problem1 {

    /**
     * Removes duplicate integers from a given list of integer
     * @param lon List to be rid of integers
     * @return List of Integers with duplicates removed
     */
    static List<Integer> remvDups(List<Integer> lon) {
        return lon.stream()
                .distinct()
                .toList();
    }
}

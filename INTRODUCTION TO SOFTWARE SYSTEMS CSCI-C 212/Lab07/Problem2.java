import java.util.List;

class Problem2 {

    /**
     * Removes all multiples of seven, squares the remaining values, and returns the result as a list
     * @param lon list to be filtered and squared
     * @return Result of removing multiples of 7 and squaring the remaining values
     */
    static List<Double> filterThenSquare(List<Double> lon) {
        return lon.stream()
                .filter( d -> d % 7 != 0)
                .map( d -> d*d)
                .toList();
    }
}

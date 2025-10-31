import java.util.List;
import java.util.Optional;

class Problem3 {

    /**
     * Returns the max value in the given list
     * @param lon given list
     * @return Optional.empty() if there are no elements in the list, else Optional<Integer> max value from the list
     */
    static Optional<Integer> maximum(List<Integer> lon) {
        if( lon.isEmpty()) return Optional.empty();
        else{
            int maximum = lon.stream()
                             .reduce(Integer.MIN_VALUE,
                                    (max,n) -> Math.max(max, n));
            return Optional.of(maximum);
        }
    }
}

import java.util.stream.Stream;

/**
 * A class that holds the hash of a password and generates guesses in an attempt to crack it.
 */

public class Attack {
    private final Stream<String> guesses;
    private final String[] alphabet; // [a-z0-9] - 36 possible characters
    private final Password password; // Contains SHA-256 hash to crack

    public Attack(Password password, int k) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz0123456789".split("");
        this.guesses = generateGuesses(k);
        this.password = password;
    }


    // Returns the stream string of all guesses. Allows the external access to the generated guesses.
    public Stream<String> getGuesses() {
        return guesses;
    }


    private Stream<String> generateGuesses(int k) {
        if (k == 0) return Stream.of("");
        else if (k == 1) { // handle k=1
            return Stream.of(alphabet); // Returns a-z0-9
        }

        /**
         * - Implement recursive password guess generator
         * - Should generate all possible combinations of length EXACTLY k
         * - Example: For k=2 → "aa", "ab", ..., "99" (1296 combinations)
         * - Current implementation only generates length 0/1 passwords
         * Hint: Use recursion with flatMap to combine character choices
         * Security Note: Length restriction demonstrates brute-force complexity
         */

        else
        {
            return generateGuesses(k - 1)
                    .flatMap(prefix -> java.util.Arrays.stream(alphabet)
                                    .map(ch -> prefix + ch));

        }
        //Stream<String> of all (k-1)-length prefixes since a char will be appeneded to it
        //for each prefix produce another Stream<String>
        //Stream<String> for every char in alphabet
        //Stream<String> of k-length strings by appending ch

    }

    // Attempts to "crack" the password by testing each guess against the Password object.
    public String crack() {
        return guesses.filter(password::checkPassword).findFirst().orElseThrow();
    }
}


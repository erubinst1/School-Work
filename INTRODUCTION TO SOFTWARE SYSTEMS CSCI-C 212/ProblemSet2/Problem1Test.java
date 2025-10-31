import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1Test {

    @Test
    void testProblem1() {
        Assertions.assertAll(
                //tail recursion
                () -> Assertions.assertEquals( true, Problem1.isPalindromeTR("racecar")),
                () -> Assertions.assertEquals( false, Problem1.isPalindromeTR("racecare")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeTR("loool")),
                () -> Assertions.assertEquals( false, Problem1.isPalindromeTR("race car")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeTR("rac e car")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeTR("")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeTR("a")),

                //loop
                () -> Assertions.assertEquals( true, Problem1.isPalindromeLoop("racecar")),
                () -> Assertions.assertEquals( false, Problem1.isPalindromeLoop("racecare")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeLoop("loool")),
                () -> Assertions.assertEquals( false, Problem1.isPalindromeLoop("race car")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeLoop("rac e car")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeLoop("")),
                () -> Assertions.assertEquals( true, Problem1.isPalindromeLoop("a"))
        );
    }
}

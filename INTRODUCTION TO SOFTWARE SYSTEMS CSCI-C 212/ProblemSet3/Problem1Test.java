import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class Problem1Test {

    @Test
    void testProblem1() {
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals( new String[]{"1", "2", "Fizz", "4", "Buzz","Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz"}, Problem1.fizzBuzz(1,12)),
                () -> Assertions.assertArrayEquals( new String[]{"FizzBuzz", "16", "17", "Fizz"}, Problem1.fizzBuzz(15,18)),
                () -> Assertions.assertArrayEquals( new String[]{"97", "98", "Fizz", "Buzz", "101","Fizz", "103", "104", "FizzBuzz", "106", "107", "Fizz", "109", "Buzz"}, Problem1.fizzBuzz(97,110)),
                () -> Assertions.assertArrayEquals( new String[]{"FizzBuzz"}, Problem1.fizzBuzz(0,0)),
                () -> Assertions.assertArrayEquals( new String[]{"FizzBuzz", "1"}, Problem1.fizzBuzz(0,1))
        );
    }
}


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    @Test
    void fibonacci() {
        assertEquals(0, Fibonacci.fibonacci(0));
        assertEquals(1, Fibonacci.fibonacci(1));
        assertEquals(5, Fibonacci.fibonacci(5));
    }

    @Test
    void fibonacci_iter() {
        assertEquals(0, Fibonacci.fibonacci_iter(0));
        assertEquals(1, Fibonacci.fibonacci_iter(1));
        assertEquals(5, Fibonacci.fibonacci_iter(5));
    }

    @Test
    void same_output_rec_and_iter() {
        assertEquals(Fibonacci.fibonacci_iter(0), Fibonacci.fibonacci_iter(0));
        assertEquals(Fibonacci.fibonacci_iter(1), Fibonacci.fibonacci_iter(1));
        assertEquals(Fibonacci.fibonacci_iter(5), Fibonacci.fibonacci_iter(5));
    }

    //Iterative version is more efficient. At large numbers, iteration is more efficient due to the lack of a very large call stack.
    //The iterative version uses constant space and avoids creating a large call stack
}
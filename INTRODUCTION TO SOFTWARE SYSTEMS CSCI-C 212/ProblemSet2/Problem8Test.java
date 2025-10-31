import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem8Test {

    @Test
    void testProblem8() {
        Assertions.assertAll(
                () -> Assertions.assertEquals( 1, Problem8.compareFiles("File12.txt", "File1.txt")),
                () -> Assertions.assertEquals( -1, Problem8.compareFiles("File10.txt", "File11.txt")),
                () -> Assertions.assertEquals( -1, Problem8.compareFiles("File1.txt", "File12.txt")),
                () -> Assertions.assertEquals( 0, Problem8.compareFiles("File1.txt", "File1.txt")),
                () -> Assertions.assertEquals( -1, Problem8.compareFiles("File1.1.txt", "File1.2.txt")),
                () -> Assertions.assertEquals( 0, Problem8.compareFiles("File1.111.txt", "File1.111.txt")),
                () -> Assertions.assertEquals( -1, Problem8.compareFiles("File1.1.txt", "File1.2.src")),
                () -> Assertions.assertEquals( -1, Problem8.compareFiles("File1.111.txt", "Fle1.111.csv")),
                () -> Assertions.assertEquals( 1, Problem8.compareFiles("Fle1.111.csv", "File1.111.txt")),
                () -> Assertions.assertEquals( 0, Problem8.compareFiles("afajfjafahj12.txt", "afajfjafahj12.txt")),
                () -> Assertions.assertEquals( 0, Problem8.compareFiles("File00001.txt", "File000001.txt"))
        );
    }
}

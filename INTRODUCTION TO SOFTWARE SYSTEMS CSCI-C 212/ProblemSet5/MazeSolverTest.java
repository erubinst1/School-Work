import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class MazeSolverTest {

    @Test
    void testMazeSolver() throws IOException {
        File tempInputFile1 = File.createTempFile("testMaze", ".in");
        String inputContent1 = "5 5\n" +
                               ".....\n" +
                               ".###.\n" +
                               "..#..\n" +
                               ".###.\n" +
                               ".....";

        try (FileWriter writer = new FileWriter(tempInputFile1)) {
            writer.write(inputContent1);
        }

        MazeSolver mazeSolver1 = new MazeSolver(tempInputFile1.getAbsolutePath());
        char[][] solution1 = mazeSolver1.solve();

        mazeSolver1.output(tempInputFile1.getAbsolutePath().replace(".in", ".out"), solution1);

        String outputFilePath1 = tempInputFile1.getAbsolutePath().replace(".in", ".out");
        String outputContent1 = new String(Files.readAllBytes(Paths.get(outputFilePath1)));
        outputContent1 = outputContent1.replace("\r\n", "\n");

        String expectedOutput1 = "*....\n" +
                                 "*###.\n" +
                                 "*.#..\n" +
                                 "*###.\n" +
                                 "*****";
        Assertions.assertEquals(expectedOutput1.trim(), outputContent1.trim());

        tempInputFile1.deleteOnExit();



        File tempInputFile2 = File.createTempFile("testMaze", ".in");
        String inputContent2 =
                "20 18\n" +
                "..................\n" +
                ".################.\n" +
                ".#..............#.\n" +
                ".#.############.#.\n" +
                ".#.#..........#.#.\n" +
                ".#.#.########.#.#.\n" +
                ".#.#.#......#.#.#.\n" +
                ".#.#.#.####.#.#.#.\n" +
                ".#.#.#.#..#.#.#.#.\n" +
                ".#.#.#.#.#.#.#.#.#\n" +
                ".#.#.#.#.#.#.#.#.#\n" +
                ".#.#.#.#..#.#.#.#.\n" +
                ".#.#.#.####.#.#.#.\n" +
                ".#.#........#.#.#.\n" +
                ".#.############.#.\n" +
                ".#..............#.\n" +
                ".################.\n" +
                "..................\n" +
                "..................\n" +
                "..................";

        try (FileWriter writer = new FileWriter(tempInputFile2)) {
            writer.write(inputContent2);
        }

        MazeSolver mazeSolver2 = new MazeSolver(tempInputFile2.getAbsolutePath());
        char[][] solution2 = mazeSolver2.solve();

        mazeSolver2.output(tempInputFile2.getAbsolutePath().replace(".in", ".out"), solution2);

        String outputFilePath2 = tempInputFile2.getAbsolutePath().replace(".in", ".out");
        String outputContent2 = new String(Files.readAllBytes(Paths.get(outputFilePath2)));
        outputContent2 = outputContent2.replace("\r\n", "\n");

        String expectedOutput2 =
                "*.................\n" +
                "*################.\n" +
                "*#..............#.\n" +
                "*#.############.#.\n" +
                "*#.#..........#.#.\n" +
                "*#.#.########.#.#.\n" +
                "*#.#.#......#.#.#.\n" +
                "*#.#.#.####.#.#.#.\n" +
                "*#.#.#.#..#.#.#.#.\n" +
                "*#.#.#.#.#.#.#.#.#\n" +
                "*#.#.#.#.#.#.#.#.#\n" +
                "*#.#.#.#..#.#.#.#.\n" +
                "*#.#.#.####.#.#.#.\n" +
                "*#.#........#.#.#.\n" +
                "*#.############.#.\n" +
                "*#..............#.\n" +
                "*################.\n" +
                "*.................\n" +
                "*.................\n" +
                "******************";
        Assertions.assertEquals(expectedOutput2.trim(), outputContent2.trim());

        tempInputFile2.deleteOnExit();


        File tempInputFile3 = File.createTempFile("testMaze", ".in");
        String inputContent3 =
                "18 20\n" +
                "....................\n" +
                ".##################.\n" +
                ".#................#.\n" +
                ".#.##############.#.\n" +
                ".#.#............#.#.\n" +
                ".#.#.##########.#.#.\n" +
                ".#.#.#........#.#.#.\n" +
                ".#.#.#.######.#.#.#.\n" +
                ".#.#.#.#....#.#.#.#.\n" +
                ".#.#.#.#.##.#.#.#.#.\n" +
                ".#.#.#.#.##.#.#.#.#.\n" +
                ".#.#.#.#....#.#.#.#.\n" +
                ".#.#.#.######.#.#.#.\n" +
                ".#.#............#.#.\n" +
                ".#.##############.#.\n" +
                ".#................#.\n" +
                ".##################.\n" +
                "....................";

        try (FileWriter writer = new FileWriter(tempInputFile3)) {
            writer.write(inputContent3);
        }

        MazeSolver mazeSolver3 = new MazeSolver(tempInputFile3.getAbsolutePath());
        char[][] solution3 = mazeSolver3.solve();

        mazeSolver3.output(tempInputFile3.getAbsolutePath().replace(".in", ".out"), solution3);

        String outputFilePath3 = tempInputFile3.getAbsolutePath().replace(".in", ".out");
        String outputContent3 = new String(Files.readAllBytes(Paths.get(outputFilePath3)));
        outputContent3 = outputContent3.replace("\r\n", "\n");

        String expectedOutput3 =
                "*...................\n" +
                "*##################.\n" +
                "*#................#.\n" +
                "*#.##############.#.\n" +
                "*#.#............#.#.\n" +
                "*#.#.##########.#.#.\n" +
                "*#.#.#........#.#.#.\n" +
                "*#.#.#.######.#.#.#.\n" +
                "*#.#.#.#....#.#.#.#.\n" +
                "*#.#.#.#.##.#.#.#.#.\n" +
                "*#.#.#.#.##.#.#.#.#.\n" +
                "*#.#.#.#....#.#.#.#.\n" +
                "*#.#.#.######.#.#.#.\n" +
                "*#.#............#.#.\n" +
                "*#.##############.#.\n" +
                "*#................#.\n" +
                "*##################.\n" +
                "********************";

        Assertions.assertEquals(expectedOutput3.trim(), outputContent3.trim());

        tempInputFile3.deleteOnExit();



        File tempInputFile4 = File.createTempFile("testMaze", ".in");
        String inputContent4 = "0 0";

        try (FileWriter writer = new FileWriter(tempInputFile4)) {
            writer.write(inputContent4);
        }

        MazeSolver mazeSolver4 = new MazeSolver(tempInputFile4.getAbsolutePath());

        Assertions.assertThrows( RuntimeException.class, mazeSolver4::solve);

        tempInputFile4.deleteOnExit();
    }
}

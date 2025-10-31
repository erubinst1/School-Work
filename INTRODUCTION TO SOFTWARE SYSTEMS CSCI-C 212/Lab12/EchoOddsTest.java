import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;

class EchoOddsTest {

    @Test
    void testEchoOdds() throws IOException {
        File tempInputFile1 = File.createTempFile("testFile1", ".in");
        String inputContent1 =
                "5\n" +
                "100\n" +
                "25\n" +
                "17\n" +
                "2\n" +
                "4\n" +
                "0\n" +
                "-3848\n" +
                "13";

        try (FileWriter writer = new FileWriter(tempInputFile1)) {
            writer.write(inputContent1);
        }

        String expectedOutput1 =
                "5\n" +
                "25\n" +
                "17\n" +
                "13";

        EchoOdds.echoOdds(tempInputFile1.getAbsolutePath());

        String outputFilePath1 = tempInputFile1.getAbsolutePath().replace(".in", ".out");

        String outputContent1 = new String(Files.readAllBytes(Paths.get(outputFilePath1)));

        Assertions.assertEquals(expectedOutput1, outputContent1);

        tempInputFile1.deleteOnExit();
        new File(outputFilePath1).deleteOnExit();



        File tempInputFile2 = File.createTempFile("testFile2", ".in");
        String inputContent2 =
                "5\n" +
                "100\n" +
                "25\n" +
                "17\n" +
                "THIS_IS_NOT_AN_INTEGER!\n" +
                "4\n" +
                "0\n" +
                "-3848\n" +
                "13";

        try (FileWriter writer = new FileWriter(tempInputFile2)) {
            writer.write(inputContent2);
        }

        Assertions.assertThrows(InputMismatchException.class, () -> { EchoOdds.echoOdds(tempInputFile2.getAbsolutePath());});

        String outputFilePath2 = tempInputFile2.getAbsolutePath().replace(".in", ".out");
        Assertions.assertFalse(new File(outputFilePath2).exists());

        tempInputFile2.deleteOnExit();



        File tempInputFile3 = File.createTempFile("testFile3", ".in");
        String inputContent3 = "";

        try (FileWriter writer = new FileWriter(tempInputFile3)) {
            writer.write(inputContent3);
        }

        String expectedOutput = "";

        EchoOdds.echoOdds(tempInputFile3.getAbsolutePath());

        String outputFilePath = tempInputFile3.getAbsolutePath().replace(".in", ".out");

        String outputContent = new String(Files.readAllBytes(Paths.get(outputFilePath)));

        Assertions.assertEquals(expectedOutput, outputContent);

        tempInputFile3.deleteOnExit();
        new File(outputFilePath).deleteOnExit();



        File tempInputFile4 = File.createTempFile("testFile4", ".in");
        String inputContent4 =
                        "2\n"+
                        "4\n"+
                        "6\n"+
                        "8\n"+
                        "10";

        try (FileWriter writer = new FileWriter(tempInputFile4)) {
            writer.write(inputContent4);
        }

        String expectedOutput4 = "";

        EchoOdds.echoOdds(tempInputFile4.getAbsolutePath());

        String outputFilePath4 = tempInputFile4.getAbsolutePath().replace(".in", ".out");

        String outputContent4 = new String(Files.readAllBytes(Paths.get(outputFilePath4)));

        Assertions.assertEquals(expectedOutput4, outputContent4);

        tempInputFile4.deleteOnExit();
        new File(outputFilePath4).deleteOnExit();



        File tempInputFile5 = File.createTempFile("testFile4", ".in");
        String inputContent5 =
                        "1\n"+
                        "3\n"+
                        "5\n"+
                        "7\n"+
                        "9";

        try (FileWriter writer = new FileWriter(tempInputFile5)) {
            writer.write(inputContent5);
        }

        String expectedOutput5 =
                        "1\n"+
                        "3\n"+
                        "5\n"+
                        "7\n"+
                        "9";

        EchoOdds.echoOdds(tempInputFile5.getAbsolutePath());

        String outputFilePath5 = tempInputFile5.getAbsolutePath().replace(".in", ".out");

        String outputContent5 = new String(Files.readAllBytes(Paths.get(outputFilePath5)));

        Assertions.assertEquals(expectedOutput5, outputContent5);

        tempInputFile5.deleteOnExit();
        new File(outputFilePath5).deleteOnExit();
    }
}

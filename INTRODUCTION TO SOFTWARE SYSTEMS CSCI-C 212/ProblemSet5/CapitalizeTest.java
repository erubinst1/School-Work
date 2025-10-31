import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class CapitalizeTest {

    @Test
    void testCapitalize() throws IOException{
        File tempInputFile1 = File.createTempFile("testFile", ".in");
        String inputContent1 = "hello world. test.";

        try (FileWriter writer = new FileWriter(tempInputFile1)) {
            writer.write(inputContent1);
        }

        String expectedOutput1 = "Hello world. Test.";

        Capitalize.capitalize(tempInputFile1.getAbsolutePath());

        String outputFilePath1 = tempInputFile1.getAbsolutePath().replace(".in", ".out");

        String outputContent1 = new String(Files.readAllBytes(Paths.get(outputFilePath1)));

        //issues with line spacing, had to add this to make it consistent
        outputContent1 = outputContent1.replace("\r\n", "\n");

        Assertions.assertEquals(expectedOutput1, outputContent1.trim());

        tempInputFile1.deleteOnExit();
        new File(outputFilePath1).deleteOnExit();



        File tempInputFile2 = File.createTempFile("file2a", ".in");
        String inputContent2 = "hi, its a wonderful day. i am doing great, how are you doing. its " +
                               "hopefully fairly obvious as to what you need to do to solve this problem.\n" +
                               "this is a sentence on another line.\n" +
                               "this sentence should also be capitalized.";

        try (FileWriter writer = new FileWriter(tempInputFile2)) {
            writer.write(inputContent2);
        }

        String expectedOutput2 = "Hi, its a wonderful day. I am doing great, how are you doing. Its " +
                                 "hopefully fairly obvious as to what you need to do to solve this problem.\n" +
                                 "This is a sentence on another line.\n" +
                                 "This sentence should also be capitalized.";

        Capitalize.capitalize(tempInputFile2.getAbsolutePath());

        String outputFilePath2 = tempInputFile2.getAbsolutePath().replace(".in", ".out");

        String outputContent2 = new String(Files.readAllBytes(Paths.get(outputFilePath2)));

        //issues with line spacing, added this to make it consistent
        outputContent2 = outputContent2.replace("\r\n", "\n");

        Assertions.assertEquals(expectedOutput2, outputContent2.trim());

        tempInputFile2.deleteOnExit();
        new File(outputFilePath2).deleteOnExit();



        File tempInputFile3 = File.createTempFile("file3a", ".in");
        String inputContent3 = "";

        try (FileWriter writer = new FileWriter(tempInputFile3)) {
            writer.write(inputContent3);
        }

        String expectedOutput3 = "";

        Capitalize.capitalize(tempInputFile3.getAbsolutePath());

        String outputFilePath3 = tempInputFile3.getAbsolutePath().replace(".in", ".out");

        String outputContent3 = new String(Files.readAllBytes(Paths.get(outputFilePath3)));

        //issues with line spacing, added this to make it consistent
        outputContent3 = outputContent3.replace("\r\n", "\n");

        Assertions.assertEquals(expectedOutput3, outputContent3.trim());

        tempInputFile3.deleteOnExit();
        new File(outputFilePath3).deleteOnExit();



        File tempInputFile4 = File.createTempFile("file3a", ".in");
        String inputContent4 = "a. b. c. d. e. f. g.";

        try (FileWriter writer = new FileWriter(tempInputFile4)) {
            writer.write(inputContent4);
        }

        String expectedOutput4 = "A. B. C. D. E. F. G.";

        Capitalize.capitalize(tempInputFile4.getAbsolutePath());

        String outputFilePath4 = tempInputFile4.getAbsolutePath().replace(".in", ".out");

        String outputContent4 = new String(Files.readAllBytes(Paths.get(outputFilePath4)));

        //issues with line spacing, added this to make it consistent
        outputContent4 = outputContent4.replace("\r\n", "\n");

        Assertions.assertEquals(expectedOutput4, outputContent4.trim());

        tempInputFile4.deleteOnExit();
        new File(outputFilePath4).deleteOnExit();
    }
}

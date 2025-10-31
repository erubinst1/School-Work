import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class SpellCheckerTest {

    @Test
    void testSpellChecker() throws IOException {
        File tempDict1 = File.createTempFile("testDict", ".dict");
        String Dictionary1 = "hi\n" +
                            "how\n" +
                            "are\n" +
                            "you\n" +
                            "doing\n" +
                            "i\n" +
                            "am\n" +
                            "just\n" +
                            "fine\n" +
                            "if\n" +
                            "say\n" +
                            "so\n" +
                            "myself\n" +
                            "but\n" +
                            "will\n" +
                            "also\n" +
                            "that\n" +
                            "throughly\n" +
                            "missing\n" +
                            "punctuation";

        try (FileWriter dictWriter = new FileWriter(tempDict1)) {
            dictWriter.write(Dictionary1);
        }

        File tempInputFile1 = File.createTempFile("testFile", ".in");
        String inputContent1 = "Hi hwo are you donig I am dioing jsut fine if I say so mysefl but I " +
                               "will aslo sya that I am throughlyy misssing puncutiation";

        try (FileWriter writer = new FileWriter(tempInputFile1)) {
            writer.write(inputContent1);
        }

        String expectedOutput1 = "Hi [hwo] are you [donig] I am [dioing] [jsut] fine if I say so " +
                                 "[mysefl] but I will [aslo] [sya] that I am [throughlyy] [misssing] " +
                                 "[puncutiation]";

        SpellChecker.spellCheck(tempDict1.getAbsolutePath(), tempInputFile1.getAbsolutePath());

        String outputFilePath1 = tempInputFile1.getAbsolutePath().replace(".in", ".out");
        String outputContent1 = new String(Files.readAllBytes(Paths.get(outputFilePath1)));

        //issues with line spacing, added this to make it consistent
        outputContent1 = outputContent1.replace("\r\n", "\n").trim();

        Assertions.assertEquals(expectedOutput1.trim(), outputContent1);

        tempInputFile1.deleteOnExit();
        tempDict1.deleteOnExit();
        new File(outputFilePath1).deleteOnExit();



        File tempDict2 = File.createTempFile("testDict", ".dict");
        String Dictionary2 = "One\n" +
                "Two\n" +
                "Three\n" +
                "Four\n" +
                "Five\n" +
                "Six\n" +
                "Seven\n" +
                "Eight\n" +
                "Nine\n" +
                "Ten";

        try (FileWriter dictWriter = new FileWriter(tempDict2)) {
            dictWriter.write(Dictionary2);
        }

        File tempInputFile2 = File.createTempFile("testFile", ".in");
        String inputContent2 = "One Two Three Forr Fve Six Seven Egt Nine Ten";

        try (FileWriter writer = new FileWriter(tempInputFile2)) {
            writer.write(inputContent2);
        }

        String expectedOutput2 = "One Two Three [Forr] [Fve] Six Seven [Egt] Nine Ten";

        SpellChecker.spellCheck(tempDict2.getAbsolutePath(), tempInputFile2.getAbsolutePath());

        String outputFilePath2 = tempInputFile2.getAbsolutePath().replace(".in", ".out");
        String outputContent2 = new String(Files.readAllBytes(Paths.get(outputFilePath2)));

        //issues with line spacing, added this to make it consistent
        outputContent2 = outputContent2.replace("\r\n", "\n").trim();

        Assertions.assertEquals(expectedOutput2.trim(), outputContent2);

        tempInputFile2.deleteOnExit();
        tempDict2.deleteOnExit();
        new File(outputFilePath2).deleteOnExit();



        File tempDict3 = File.createTempFile("testDict", ".dict");
        String Dictionary3 = "One\n" +
                "Two\n" +
                "Three\n" +
                "Four\n" +
                "Five\n" +
                "Six\n" +
                "Seven\n" +
                "Eight\n" +
                "Nine\n" +
                "Ten";

        try (FileWriter dictWriter = new FileWriter(tempDict3)) {
            dictWriter.write(Dictionary3);
        }

        File tempInputFile3 = File.createTempFile("testFile", ".in");
        String inputContent3 = "";

        try (FileWriter writer = new FileWriter(tempInputFile3)) {
            writer.write(inputContent3);
        }

        String expectedOutput3 = "";

        SpellChecker.spellCheck(tempDict3.getAbsolutePath(), tempInputFile3.getAbsolutePath());

        String outputFilePath3 = tempInputFile3.getAbsolutePath().replace(".in", ".out");
        String outputContent3 = new String(Files.readAllBytes(Paths.get(outputFilePath3)));

        //issues with line spacing, added this to make it consistent
        outputContent3 = outputContent3.replace("\r\n", "\n").trim();

        Assertions.assertEquals(expectedOutput3.trim(), outputContent3);

        tempInputFile3.deleteOnExit();
        tempDict3.deleteOnExit();
        new File(outputFilePath3).deleteOnExit();



        File tempDict4 = File.createTempFile("testDict", ".dict");
        String Dictionary4 = "g";

        try (FileWriter dictWriter = new FileWriter(tempDict4)) {
            dictWriter.write(Dictionary4);
        }

        File tempInputFile4 = File.createTempFile("testFile", ".in");
        String inputContent4 = "a b c d e f g";

        try (FileWriter writer = new FileWriter(tempInputFile4)) {
            writer.write(inputContent4);
        }

        String expectedOutput4 = "[a] [b] [c] [d] [e] [f] g";

        SpellChecker.spellCheck(tempDict4.getAbsolutePath(), tempInputFile4.getAbsolutePath());

        String outputFilePath4 = tempInputFile4.getAbsolutePath().replace(".in", ".out");
        String outputContent4 = new String(Files.readAllBytes(Paths.get(outputFilePath4)));

        //issues with line spacing, added this to make it consistent
        outputContent4 = outputContent4.replace("\r\n", "\n").trim();

        Assertions.assertEquals(expectedOutput4.trim(), outputContent4);

        tempInputFile4.deleteOnExit();
        tempDict4.deleteOnExit();
        new File(outputFilePath4).deleteOnExit();
    }
}
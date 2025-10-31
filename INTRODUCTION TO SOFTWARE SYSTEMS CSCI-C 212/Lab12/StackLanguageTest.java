import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

class StackLanguageTest {

    @Test
    void testStackLanguage() throws IOException {
        File tempInputFile1 = File.createTempFile("testFile1", ".in");
        String inputContent1 =
                "PUSH 0\n" +
                "ADD 42";

        try (FileWriter writer = new FileWriter(tempInputFile1)) {
            writer.write(inputContent1);
        }

        Double expectedOutput1 = 42.0;

        StackLanguage stack1 = new StackLanguage();
        stack1.readFile(tempInputFile1.getAbsolutePath());

        Assertions.assertEquals(expectedOutput1, stack1.interpret());

        tempInputFile1.deleteOnExit();



        File tempInputFile2 = File.createTempFile("testfile2", ".in");
        String inputContent2 =
                        "PUSH 0\n" +
                        "SUB 42";

        try (FileWriter writer = new FileWriter(tempInputFile2)) {
            writer.write(inputContent2);
        }

        Double expectedOutput2 = -42.0;

        StackLanguage stack2 = new StackLanguage();
        stack2.readFile(tempInputFile2.getAbsolutePath());

        Assertions.assertEquals(expectedOutput2, stack2.interpret());

        tempInputFile2.deleteOnExit();



        File tempInputFile3 = File.createTempFile("testfile3", ".in");
        String inputContent3 =
                        "PUSH 0\n" +
                        "SUB 42";

        try (FileWriter writer = new FileWriter(tempInputFile3)) {
            writer.write(inputContent3);
        }

        Double expectedOutput3 = -42.0;

        StackLanguage stack3 = new StackLanguage();
        stack3.readFile(tempInputFile3.getAbsolutePath());

        Assertions.assertEquals(expectedOutput3, stack3.interpret());

        tempInputFile3.deleteOnExit();



        File tempInputFile4 = File.createTempFile("testfile4", ".in");
        String inputContent4 =
                        "DECL X 1\n" +
                        "PUSH 0\n" +
                        "ADD 42\n" +
                        "XCHG X";

        try (FileWriter writer = new FileWriter(tempInputFile4)) {
            writer.write(inputContent4);
        }

        Double expectedOutput4 = 1.0;

        StackLanguage stack4 = new StackLanguage();
        stack4.readFile(tempInputFile4.getAbsolutePath());

        Assertions.assertEquals(expectedOutput4, stack4.interpret());

        tempInputFile4.deleteOnExit();



        File tempInputFile5 = File.createTempFile("testfile5", ".in");
        String inputContent5 =
                        "DECL X 1\n" +
                        "PUSH 0\n" +
                        "ADD 42\n" +
                        "POP X\n" +
                        "PUSH 0\n" +
                        "XCHG X";


        try (FileWriter writer = new FileWriter(tempInputFile5)) {
            writer.write(inputContent5);
        }

        Double expectedOutput5 = 42.0;

        StackLanguage stack5 = new StackLanguage();
        stack5.readFile(tempInputFile5.getAbsolutePath());

        Assertions.assertEquals(expectedOutput5, stack5.interpret());

        tempInputFile5.deleteOnExit();



        File tempInputFile6 = File.createTempFile("testfile6", ".in");
        String inputContent6 =
                        "DECL X 1\n" +
                        "DECL Y 2\n" +
                        "PUSH 0\n" +
                        "ADD 42\n" +
                        "POP X\n" +
                        "PUSH 0\n" +
                        "XCHG X\n" +
                        "ADD 1\n" +
                        "PEEK Y\n" +
                        "ADD 2\n" +
                        "SUB 1\n" +
                        "XCHG Y\n";


        try (FileWriter writer = new FileWriter(tempInputFile6)) {
            writer.write(inputContent6);
        }

        Double expectedOutput6 = 43.0;

        StackLanguage stack6 = new StackLanguage();
        stack6.readFile(tempInputFile6.getAbsolutePath());

        Assertions.assertEquals(expectedOutput6, stack6.interpret());

        tempInputFile6.deleteOnExit();



        File tempInputFile7 = File.createTempFile("testfile7", ".in");
        String inputContent7 =
                        "DECL X 1";

        try (FileWriter writer = new FileWriter(tempInputFile7)) {
            writer.write(inputContent7);
        }

        StackLanguage stack7 = new StackLanguage();
        stack7.readFile(tempInputFile7.getAbsolutePath());

        Assertions.assertThrows(NoSuchElementException.class, () -> {stack7.interpret();});

        tempInputFile7.deleteOnExit();



        File tempInputFile8 = File.createTempFile("testfile8", ".in");
        String inputContent8 =
                    "AFAF 1 3";

        try (FileWriter writer = new FileWriter(tempInputFile8)) {
            writer.write(inputContent8);
        }

        StackLanguage stack8 = new StackLanguage();
        stack8.readFile(tempInputFile8.getAbsolutePath());

        Assertions.assertThrows(UnsupportedOperationException .class, () -> {stack8.interpret();});

        tempInputFile8.deleteOnExit();



        File tempInputFile9 = File.createTempFile("testfile9", ".in");
        String inputContent9 =
                "PUSH 0\n" +
                "POP X";

        try (FileWriter writer = new FileWriter(tempInputFile9)) {
            writer.write(inputContent9);
        }

        StackLanguage stack9 = new StackLanguage();
        stack9.readFile(tempInputFile9.getAbsolutePath());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {stack9.interpret();});

        tempInputFile9.deleteOnExit();



        File tempInputFile10 = File.createTempFile("testfile10", ".in");
        String inputContent10 =
                        "PUSH 0\n" +
                        "PEEK X";

        try (FileWriter writer = new FileWriter(tempInputFile10)) {
            writer.write(inputContent10);
        }

        StackLanguage stack10 = new StackLanguage();
        stack10.readFile(tempInputFile10.getAbsolutePath());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {stack10.interpret();});

        tempInputFile10.deleteOnExit();



        File tempInputFile11 = File.createTempFile("testfile11", ".in");
        String inputContent11 =
                        "PUSH 0\n" +
                        "XCHG X";

        try (FileWriter writer = new FileWriter(tempInputFile11)) {
            writer.write(inputContent11);
        }

        StackLanguage stack11 = new StackLanguage();
        stack11.readFile(tempInputFile11.getAbsolutePath());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {stack11.interpret();});

        tempInputFile11.deleteOnExit();
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

class EchoOdds {

    /**
     * reads a file of line-separated integers specified by the
     * user, and writes only the odd numbers out to a file of the same name
     * with the .out extension
     *
     * @param fileName input file name
     */
    static void echoOdds(String fileName) {
        if (!fileName.endsWith(".in")) {
            throw new IllegalArgumentException("Input file must have a .in extension");
        }

        String outFileName = fileName.replace(".in", ".out");
        try (
                Scanner scanner = new Scanner(new File(fileName));
                PrintWriter writer = new PrintWriter(new File(outFileName))
        ){
            StringBuilder output = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                try {
                    int number = Integer.parseInt(line);
                    if (number % 2 != 0) {
                        output.append(number).append("\n");
                    }
                } catch (NumberFormatException e) {
                    throw new InputMismatchException("Error: Non-integer value encountered: '" + line + "'");
                }
            }
            if (!output.isEmpty()) {
                writer.print(output.toString().trim());
            }
        } catch (FileNotFoundException e){

        } catch (InputMismatchException e) {
        File outFile = new File(outFileName);
        if (outFile.exists() && !outFile.delete()) {
            System.err.println("Failed to delete the output file after exception.");
        }
        throw e;
    }

    }
}

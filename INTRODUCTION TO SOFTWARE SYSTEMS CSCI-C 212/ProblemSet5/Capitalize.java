import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Capitalize {

    /**
     * reads a file of sentences and outputs the capitalized versions of the sentences to a file of the same name
     *
     * @param in file of sentences
     */
    static void capitalize(String in) {
        String out = in.substring(0, in.lastIndexOf(".")) + ".out";

        try( Scanner f = new Scanner(new File(in));
             PrintWriter writer = new PrintWriter(new File(out))){
            while( f.hasNextLine()){
                String line = f.nextLine();

                String[] sentences = line.split("\\. ");
                StringBuilder capitalizedLine = new StringBuilder();

                for (String sentence : sentences) {
                    if (!sentence.isEmpty()) {
                        sentence = sentence.trim();
                        sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1);
                        capitalizedLine.append(sentence);
                        if (!sentence.endsWith(".")) {
                            capitalizedLine.append(".");
                        }
                        capitalizedLine.append(" ");
                    }
                }

                if (!capitalizedLine.isEmpty()) {
                    writer.println(capitalizedLine.toString().trim());
                }
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException("Input file not found: " + in, e);
        }
    }
}

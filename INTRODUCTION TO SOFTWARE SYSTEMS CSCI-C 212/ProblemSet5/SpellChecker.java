import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class SpellChecker {

    /**
     * reads two files: a “dictionary” and a content
     * file. Checks each word in the file and determine whether or not they are spelled correctly,
     * according to the dictionary. If a word is not spelled correctly, wrap it inside brackets [].
     *
     * @param dict dictionary file with correct word spellings
     * @param in input file to check for spelling errors
     */
    static void spellCheck(String dict, String in){
        Set<String> dictionary = new HashSet<>();
        StringBuilder output = new StringBuilder();
        
        try (Scanner dictScanner = new Scanner(new File(dict))) {
            while (dictScanner.hasNextLine()) {
                dictionary.add(dictScanner.nextLine().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Dictionary file not found: " + e);
        }

        try (Scanner fileScanner = new Scanner(new File(in))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    String cleanWord = word.toLowerCase();
                    if (!dictionary.contains(cleanWord)) {
                        output.append("[").append(word).append("] ");
                    } else {
                        output.append(word).append(" ");
                    }
                }
                output.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Input file not found: " + e);
        }

        String outFile = in.substring(0, in.lastIndexOf(".")) + ".out";
        try (FileWriter writer = new FileWriter(outFile)) {
            writer.write(output.toString().trim());
        } catch (IOException e) {
            throw new RuntimeException("Error writing to output file: " + e);
        }
    }
}

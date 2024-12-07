package lab4;

import java.util.Scanner;

/**
 * Main application class for transforming a text by swapping words in sentences.
 */
public class TextTransformerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a text:");
        String inputText = scanner.nextLine();  // Reads user input

        try {
            // Normalizes spaces in the input text
            inputText = inputText.replaceAll("\\s+", " ");

            // Appends a period if the text has no ending punctuation
            if (!inputText.matches(".*[.!?]$")) {
                inputText += ".";
            }

            // Parses and transforms the text
            Text originalText = Text.parse(inputText);
            Text transformedText = originalText.transform();

            // Displays the original and transformed texts
            System.out.println("Original text: " + originalText);
            System.out.println("Transformed text: " + transformedText);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());  // Handles invalid input errors
        } finally {
            scanner.close();  // Closes the scanner
        }
    }
}

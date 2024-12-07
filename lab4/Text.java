package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing a text consisting of multiple sentences.
 */
public class Text {
    private List<Sentence> sentences;  // List of sentences in the text

    /**
     * Default constructor initializing an empty text.
     */
    public Text() {
        sentences = new ArrayList<>();
    }

    /**
     * Adds a sentence to the text.
     * @param sentence The sentence to add
     */
    public void addSentence(Sentence sentence) {
        sentences.add(sentence);
    }

    /**
     * Parses a text string into a Text object by splitting it into sentences.
     * @param text The input string to parse
     * @return A parsed Text object
     */
    public static Text parse(String text) {
        Text parsedText = new Text();

        // Splits the text into sentence parts based on punctuation marks
        String[] sentenceParts = text.split("[.!?]");

        for (String sentencePart : sentenceParts) {
            if (!sentencePart.trim().isEmpty()) {
                // Finds the punctuation mark at the end of the text
                Matcher matcher = Pattern.compile("(.*?)([.!?])$").matcher(text);
                String punctSymbol = matcher.find() ? matcher.group(2) : ".";

                // Parses each sentence and adds it to the text
                Sentence sentence = Sentence.parse(sentencePart.trim() + punctSymbol);
                parsedText.addSentence(sentence);
            }
        }

        return parsedText;
    }

    /**
     * Converts the text to a string.
     * @return The text as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.size(); i++) {
            sb.append(sentences.get(i));  // Adds each sentence
            if (i < sentences.size() - 1) {
                sb.append(" ");  // Adds a space between sentences
            }
        }
        return sb.toString();
    }

    /**
     * Transforms each sentence in the text by swapping words.
     * @return A transformed Text object
     */
    public Text transform() {
        Text transformedText = new Text();

        // Transforms each sentence and adds it to the new text
        for (Sentence sentence : sentences) {
            transformedText.addSentence(sentence.transform());
        }

        return transformedText;
    }
}

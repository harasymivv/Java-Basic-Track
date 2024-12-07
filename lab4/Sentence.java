package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing a sentence composed of words and ending punctuation.
 */
public class Sentence {
    private List<Word> words;  // List of words in the sentence
    private Punctuation sentencePunctuation;  // Punctuation mark at the end

    /**
     * Default constructor initializing an empty sentence ending with a period.
     */
    public Sentence() {
        words = new ArrayList<>();
        sentencePunctuation = new Punctuation('.');  // Default punctuation is a period
    }

    /**
     * Adds a word to the sentence.
     * @param word The word to add
     */
    public void addWord(Word word) {
        words.add(word);
    }

    /**
     * Sets the sentence's punctuation mark.
     * @param punct The punctuation mark
     */
    public void setSentencePunctuation(Punctuation punct) {
        this.sentencePunctuation = punct;
    }

    /**
     * Parses a string into a Sentence object.
     * Extracts words and punctuation from the string.
     * @param sentence The input string to parse
     * @return A parsed Sentence object
     */
    public static Sentence parse(String sentence) {
        Sentence parsedSentence = new Sentence();

        // Extracts the last punctuation mark, if any
        Pattern punctPattern = Pattern.compile("(.*?)([.!?])$");
        Matcher punctMatcher = punctPattern.matcher(sentence.trim());

        String sentenceContent;
        String punctSymbol = ".";  // Default punctuation is a period

        if (punctMatcher.matches()) {
            sentenceContent = punctMatcher.group(1).trim();  // Sentence content without punctuation
            punctSymbol = punctMatcher.group(2);  // Extracted punctuation mark
        } else {
            sentenceContent = sentence.trim();  // No punctuation found
        }

        // Splits the sentence into words based on spaces
        String[] wordStrings = sentenceContent.split("\\s+");

        // Converts each word string into a Word object
        for (String wordStr : wordStrings) {
            Word word = new Word(wordStr);
            parsedSentence.addWord(word);
        }

        // Sets the extracted punctuation mark
        parsedSentence.setSentencePunctuation(new Punctuation(punctSymbol.charAt(0)));

        return parsedSentence;
    }

    /**
     * Converts the sentence to a string.
     * @return The sentence as a string with punctuation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));  // Adds each word
            if (i < words.size() - 1) {
                sb.append(" ");  // Adds a space between words
            }
        }
        sb.append(sentencePunctuation);  // Adds the ending punctuation mark
        return sb.toString();
    }

    /**
     * Transforms the sentence by swapping the first and last words.
     * Keeps the middle words unchanged.
     * @return A transformed Sentence object
     */
    public Sentence transform() {
        if (words.size() < 2) {
            return this;  // No transformation if less than two words
        }

        Sentence transformedSentence = new Sentence();

        // Swaps the first and last words
        Word firstWord = words.get(0);
        Word lastWord = words.get(words.size() - 1);

        // Extracts middle words
        List<Word> middleWords = words.subList(1, words.size() - 1);

        // Builds the transformed sentence
        transformedSentence.addWord(lastWord);  // Adds the last word first
        transformedSentence.words.addAll(middleWords);  // Adds middle words
        transformedSentence.addWord(firstWord);  // Adds the first word last

        // Copies the original punctuation
        transformedSentence.setSentencePunctuation(this.sentencePunctuation);

        return transformedSentence;
    }
}

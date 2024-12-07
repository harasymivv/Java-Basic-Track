package lab4;

/**
 * Class representing a word composed of letters.
 */
public class Word {
    private Letter[] letters;  // Array of letters forming the word

    /**
     * Constructor to initialize the word from a string.
     * @param word The word as a string
     */
    public Word(String word) {
        this.letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Constructor to initialize the word from an array of letters.
     * @param letters The array of letters
     */
    public Word(Letter[] letters) {
        this.letters = letters;
    }

    /**
     * Returns the array of letters in the word.
     * @return Array of Letter objects
     */
    public Letter[] getLetters() {
        return letters;
    }

    /**
     * Converts the word to a string.
     * @return The word as a string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }

    /**
     * Converts the word to uppercase.
     * @return A new Word object in uppercase
     */
    public Word toUpperCase() {
        Letter[] upperLetters = new Letter[letters.length];
        for (int i = 0; i < letters.length; i++) {
            upperLetters[i] = letters[i].toUpperCase();
        }
        return new Word(upperLetters);
    }

    /**
     * Converts the word to lowercase.
     * @return A new Word object in lowercase
     */
    public Word toLowerCase() {
        Letter[] lowerLetters = new Letter[letters.length];
        for (int i = 0; i < letters.length; i++) {
            lowerLetters[i] = letters[i].toLowerCase();
        }
        return new Word(lowerLetters);
    }
}

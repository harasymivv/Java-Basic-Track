package lab4;

/**
 * Class representing a punctuation mark.
 */
public class Punctuation {
    private char symbol;  // The punctuation symbol

    /**
     * Constructor to initialize the punctuation mark.
     * @param symbol The character representing the punctuation mark
     * @throws IllegalArgumentException if the symbol is not a valid punctuation mark
     */
    public Punctuation(char symbol) {
        if (isPunctuationMark(symbol)) {
            this.symbol = symbol;
        } else {
            throw new IllegalArgumentException("Invalid punctuation mark");
        }
    }

    /**
     * Checks if the character is a valid punctuation mark.
     * @param ch The character to check
     * @return true if the character is a valid punctuation mark, false otherwise
     */
    private boolean isPunctuationMark(char ch) {
        return ch == '.' || ch == '!' || ch == '?' || 
               ch == ',' || ch == ';' || ch == ':';
    }

    /**
     * Returns the punctuation symbol.
     * @return The punctuation symbol as a character
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Converts the punctuation mark to a string.
     * @return The punctuation symbol as a string
     */
    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
